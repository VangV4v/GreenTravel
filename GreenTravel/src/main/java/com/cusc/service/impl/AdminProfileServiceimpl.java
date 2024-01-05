/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cusc.dto.EmployeesDTO;
import com.cusc.dto.UpLoadImageEmployeDTO;
import com.cusc.entities.Employees;
import com.cusc.entities.Roles;
import com.cusc.repositories.CustomersRepository;
import com.cusc.repositories.EmployeesRepository;
import com.cusc.repositories.RolesRepository;
import com.cusc.repositories.hql.CustomersHQL;
import com.cusc.repositories.hql.EmployeesHQL;
import com.cusc.service.AdminProfileService;
import java.security.Principal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
@Service
public class AdminProfileServiceimpl implements AdminProfileService {

    @Autowired
    private EmployeesRepository employeesRepository;

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

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String adminProfile(Model model, Principal principal) {
        Employees emp = employeesRepository.findByUsername(principal.getName());
        EmployeesDTO empDTO = new EmployeesDTO();
        UpLoadImageEmployeDTO imageDTO = new UpLoadImageEmployeDTO();
        imageDTO.getData(emp);
        empDTO.getData(emp);
        model.addAttribute("profile", empDTO);
        model.addAttribute("image", imageDTO);
        return "ad_profile";
    }

    @Override
    public String adminProfile(EmployeesDTO edto, BindingResult br, Model model) {
        long checkExistEmailEmployee;
        long checkExistEmailCustomer;
        if (br.hasErrors()) {
            Employees emp = edto.tranferToEntities();
            UpLoadImageEmployeDTO imageDTO = new UpLoadImageEmployeDTO();
            imageDTO.getData(emp);
            model.addAttribute("profile", edto);
            model.addAttribute("image", imageDTO);
            return "ad_profile";
        }
        checkExistEmailEmployee = employeesRepository.getCountByCheckEmailAndEmployeeID(edto.getEmail(), edto.getEmployeeID());
        checkExistEmailCustomer = customersRepository.getCountByCheckEmail(edto.getEmail());
        if (checkExistEmailCustomer > 0 || checkExistEmailEmployee > 0) {
            br.rejectValue("email", "500", "Email exist ");
            Employees emp = edto.tranferToEntities();
            UpLoadImageEmployeDTO imageDTO = new UpLoadImageEmployeDTO();
            imageDTO.getData(emp);
            model.addAttribute("profile", edto);
            model.addAttribute("image", imageDTO);
            return "ad_profile";
        }
        Employees employees = edto.tranferToEntities();
        Roles roles = rolesRepository.findById(edto.getRoleTemp()).get();
        employees.setRoleID(roles);
        employeesRepository.save(employees);
        return "redirect:/admin/my-profile?success=true";
    }

    @Override
    public String uploadImage(UpLoadImageEmployeDTO dTO, BindingResult br, Model model, Principal principal) {
        try {
            if (!dTO.getImage().isEmpty()) {
                Employees employees = employeesRepository.findById(dTO.getEmployeeID()).get();
                String imageName = "EMP_" + principal.getName();
                cloudinary.uploader().destroy(imageName, ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName));
                Map upload = cloudinary.uploader().upload(dTO.getImage().getBytes(), ObjectUtils.asMap("public_id", imageName));
                employees.setAvatar((String) upload.get("secure_url"));
                employeesRepository.save(employees);
            }
        } catch (Exception e) {
        }
        return "redirect:/admin/my-profile?success=true";
    }

    @Override
    public String updatePassword(Model model, Principal principal) {
        Employees employees = employeesRepository.findByUsername(principal.getName());
        EmployeesDTO dto = new EmployeesDTO();
        dto.getData(employees);
        model.addAttribute("emp", dto);
        return "ad_changepassword";
    }

    @Override
    public String updatePassword(EmployeesDTO edto, BindingResult br, Model model) {
        int status = 0;
        if (br.hasErrors()) {
            model.addAttribute("emp", edto);
            return "ad_changepassword";
        } else {
            boolean checkOldPassword = passwordEncoder.matches(edto.getConfirmOldPassword(), edto.getPassword());
            boolean checkConfirmNewPassword = edto.getNewPassword().equals(edto.getConfirmNewPassword());
            if (!checkOldPassword) {
                br.rejectValue("confirmOldPassword", "500", "Confirm password incorrect");
                status++;
            }
            if (!checkConfirmNewPassword) {
                br.rejectValue("confirmNewPassword", "500", "Confirm new password incorrect");
                status++;
            }
            if (status > 0) {
                model.addAttribute("emp", edto);
                return "ad_changepassword";
            }
        }
        Employees employees = edto.tranferToEntities();
        Roles role = rolesRepository.findById(edto.getRoleTemp()).get();
        employees.setPassword(passwordEncoder.encode(edto.getNewPassword()));
        employees.setRoleID(role);
        employeesRepository.save(employees);
        return "redirect:/admin/my-profile?success=true";
    }

}
