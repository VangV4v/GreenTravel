/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.dto.CustomersDTO;
import com.cusc.entities.Customers;
import com.cusc.entities.Roles;
import com.cusc.repositories.CustomersRepository;
import com.cusc.repositories.RolesRepository;
import com.cusc.repositories.hql.CustomersHQL;
import com.cusc.repositories.hql.EmployeesHQL;
import com.cusc.service.CustomerManageService;
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
public class CustomerManageServiceimpl implements CustomerManageService {

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private EmployeesHQL employeesHQL;

    @Autowired
    private CustomersHQL customersHQL;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String viewCustomer(Model model) {
        model.addAttribute("listCus", customersRepository.findAll());
        return "ad_view_customer";
    }

    @Override
    public String createCustomer(Model model) {
        CustomersDTO dto = new CustomersDTO();
        model.addAttribute("cus", dto);
        return "ad_create_customer";
    }

    @Override
    public String createCustomer(CustomersDTO cdto, BindingResult br, Model model) {
        long checkUsernameExistEmployee;
        long checkUsernameExistCustomer;
        long checkEmailExistEmployee;
        long checkEmailExistCustomer;
        int statusCheck = 0;
        if (br.hasErrors()) {
            model.addAttribute("cus", cdto);
            return "ad_create_customer";
        } else {
            checkUsernameExistEmployee = employeesHQL.getCountByUsername(cdto.getUsername());
            checkUsernameExistCustomer = customersHQL.getCountByUsername(cdto.getUsername());
            checkEmailExistCustomer = customersHQL.getCountByEmail(cdto.getEmail());
            checkEmailExistEmployee = employeesHQL.getCountByEmail(cdto.getEmail());
            if (checkUsernameExistEmployee > 0 || checkUsernameExistCustomer > 0) {
                br.rejectValue("username", "500", "Username exist ");
                statusCheck++;
            }
            if (checkEmailExistCustomer > 0 || checkEmailExistEmployee > 0) {
                br.rejectValue("email", "500", "Email exist ");
                statusCheck++;
            }
            if (statusCheck > 0) {
                model.addAttribute("cus", cdto);
                return "ad_create_customer";
            }
        }
        Customers customers = cdto.tranferToEntities();
        Roles roles = rolesRepository.findById(3).get();
        customers.setPassword(passwordEncoder.encode(customers.getPassword()));
        customers.setAddress("None");
        customers.setAvatar("https://res.cloudinary.com/dqbzth4fo/image/upload/v1679810212/istockphoto-1223671392-612x612_yalp5s.jpg");
        customers.setStatus(true);
        customers.setRoleID(roles);
        customersRepository.save(customers);
        return "redirect:/admin/employee/manage-customer/home-customer?success=true";
    }

    @Override
    public String editCustomer(Model model, long l) {
        Customers customers = customersRepository.findById(l).get();
        CustomersDTO dto = new CustomersDTO();
        dto.getData(customers);
        model.addAttribute("cus", dto);
        return "ad_edit_customer";
    }

    @Override
    public String editCustomer(CustomersDTO cdto, BindingResult br, Model model, HttpServletRequest request, long l) {
        long checkEmailExistEmployee;
        long checkEmailExistCustomer;
        String oldEmail = request.getParameter("oldEmail");
        if (br.hasErrors()) {
            model.addAttribute("cus", cdto);
            return "ad_edit_customer";
        } else {
            if (!passwordEncoder.matches(cdto.getNewPassword(), cdto.getPassword()) && cdto.getNewPassword() != null) {
                cdto.setPassword(passwordEncoder.encode(cdto.getPassword()));
            }
            if (!oldEmail.equals(cdto.getEmail())) {
                checkEmailExistCustomer = customersHQL.getCountByEmail(cdto.getEmail());
                checkEmailExistEmployee = employeesHQL.getCountByEmail(cdto.getEmail());
                if (checkEmailExistCustomer > 0 || checkEmailExistEmployee > 0) {
                    br.rejectValue("email", "500", "Email exist ");
                    model.addAttribute("cus", cdto);
                    return "ad_edit_customer";
                }
            }
        }
        Roles role = rolesRepository.findById(cdto.getRoleTemp()).get();
        Customers customers = cdto.tranferToEntities();
        customers.setRoleID(role);
        customersRepository.save(customers);
        return "redirect:/admin/employee/manage-customer/home-customer?success=true";
    }

    @Override
    public String viewDetailCustomer(Model model, long l) {
        Customers customer = customersRepository.findById(l).get();
        CustomersDTO dto = new CustomersDTO();
        dto.getData(customer);
        model.addAttribute("cus", dto);
        return "ad_detail_customer";
    }

    @Override
    public String deleteCustomer(HttpServletRequest hsr) {
        long id = Long.parseLong(hsr.getParameter("cusID"));
        customersRepository.deleteById(id);
        return "redirect:/admin/employee/manage-customer/home-customer";
    }

}
