/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.dto.EmployeesDTO;
import com.cusc.entities.Employees;
import com.cusc.entities.Roles;
import com.cusc.repositories.hql.EmployeesHQL;
import com.cusc.repositories.EmployeesRepository;
import com.cusc.repositories.RolesRepository;
import com.cusc.repositories.hql.CustomersHQL;
import com.cusc.service.EmployeeManageService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
@Service
public class EmployeeManageServiceimpl implements EmployeeManageService {
    
    @Autowired
    private EmployeesRepository employeesRepository;
    
    @Autowired
    private RolesRepository rolesRepository;
    
    @Autowired
    private EmployeesHQL employeesHQL;
    
    @Autowired
    private CustomersHQL customersHQL;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public String viewEmployee(Model model) {
        model.addAttribute("listEmp", employeesRepository.findAll());
        return "ad_view_employee";
    }
    
    @Override
    public String createEmployee(Model model) {
        EmployeesDTO employees = new EmployeesDTO();
        model.addAttribute("emp", employees);
        model.addAttribute("listRole", rolesRepository.findAll());
        return "ad_create_employee";
    }
    
    @Override
    public String createEmployee(EmployeesDTO dto, BindingResult br, Model model) {
        long checkUsernameExistEmployee;
        long checkUsernameExistCustomer;
        long checkEmailExistEmployee;
        long checkEmailExistCustomer;
        int statusCheck = 0;
        if (br.hasErrors()) {
            model.addAttribute("emp", dto);
            model.addAttribute("listRole", rolesRepository.findAll());
            return "ad_create_employee";
        } else {
            checkUsernameExistEmployee = employeesHQL.getCountByUsername(dto.getUsername());
            checkUsernameExistCustomer = customersHQL.getCountByUsername(dto.getUsername());
            checkEmailExistCustomer = customersHQL.getCountByEmail(dto.getEmail());
            checkEmailExistEmployee = employeesHQL.getCountByEmail(dto.getEmail());
            if (checkUsernameExistEmployee > 0 || checkUsernameExistCustomer > 0) {
                br.rejectValue("username", "500", "Username exist ");
                statusCheck++;
            }
            if (checkEmailExistCustomer > 0 || checkEmailExistEmployee > 0) {
                br.rejectValue("email", "500", "Email exist ");
                statusCheck++;
            }
            if (statusCheck > 0) {
                model.addAttribute("emp", dto);
                model.addAttribute("listRole", rolesRepository.findAll());
                return "ad_create_employee";
            }
        }
        Employees employees = dto.tranferToEntities();
        Roles roles = rolesRepository.findById(dto.getRoleTemp()).get();
        employees.setPassword(passwordEncoder.encode(employees.getPassword()));
        employees.setRoleID(roles);
        employees.setAddress("None");
        employees.setAvatar("https://res.cloudinary.com/dqbzth4fo/image/upload/v1679810212/istockphoto-1223671392-612x612_yalp5s.jpg");
        employees.setStatus(true);
        employeesRepository.save(employees);
        return "redirect:/admin/boss/manage-employee/home-employee?success=true";
    }
    
    @Override
    public String editEmployee(Model model, long id) {
        Employees employees = employeesRepository.findById(id).get();
        EmployeesDTO empDTO = new EmployeesDTO();
        empDTO.getData(employees);
        model.addAttribute("emp", empDTO);
        model.addAttribute("listRole", rolesRepository.findAll());
        return "ad_edit_employee";
    }
    
    @Override
    public String editEmployee(EmployeesDTO dto, BindingResult br, Model model, HttpServletRequest request, long l) {
        long checkEmailExistEmployee;
        long checkEmailExistCustomer;
        String oldEmail = request.getParameter("oldEmail");
        Roles roles = rolesRepository.findById(dto.getRoleTemp()).get();
        if (br.hasErrors()) {
            model.addAttribute("emp", dto);
            model.addAttribute("listRole", rolesRepository.findAll());
            return "ad_edit_employee";
        } else {
            if (!passwordEncoder.matches(dto.getNewPassword(), dto.getPassword()) && dto.getNewPassword() != null) {
                dto.setPassword(passwordEncoder.encode(dto.getPassword()));
            }
            if (!oldEmail.equals(dto.getEmail())) {
                checkEmailExistCustomer = customersHQL.getCountByEmail(dto.getEmail());
                checkEmailExistEmployee = employeesHQL.getCountByEmail(dto.getEmail());
                if (checkEmailExistCustomer > 0 || checkEmailExistEmployee > 0) {
                    br.rejectValue("email", "500", "Email exist ");
                    model.addAttribute("emp", dto);
                    model.addAttribute("listRole", rolesRepository.findAll());
                    return "ad_edit_employee";
                }
            }
        }
        Employees employees = dto.tranferToEntities();
        employees.setRoleID(roles);
        employeesRepository.save(employees);
        return "redirect:/admin/boss/manage-employee/home-employee?success=true";
    }
    
    @Override
    public String deleteEmployee(Model model, HttpServletRequest hsr) {
        Long id = Long.parseLong(hsr.getParameter("empID"));
        Employees emp = employeesRepository.findById(id).get();
        System.out.println("--------------------" + id);
        employeesRepository.delete(emp);
        return "redirect:/admin/boss/manage-employee/home-employee";
    }
    
    @Override
    public String viewDetailEmployee(Model model, long l) {
        Employees emp = employeesRepository.findById(l).get();
        model.addAttribute("emp", emp);
        return "ad_detail_employee";
    }
    
    @Override
    public String deleteEmployee_1(Model model, HttpServletRequest hsr) {
        long empID = Long.parseLong(hsr.getParameter("empID"));
        employeesRepository.deleteEmp(empID);
        return "redirect:/admin/home-employee";
    }
    
    
    
}
