/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cusc.dto.CustomersDTO;
import com.cusc.dto.UpLoadCustomerDTO;
import com.cusc.entities.Customers;
import com.cusc.entities.Roles;
import com.cusc.repositories.CustomersRepository;
import com.cusc.repositories.EmployeesRepository;
import com.cusc.repositories.RolesRepository;
import com.cusc.repositories.hql.CustomersHQL;
import com.cusc.service.ProfileCustomerService;
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
public class ProfileCustomerServiceimpl implements ProfileCustomerService {

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private CustomersHQL customersHQL;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String viewProfile(Model model, Principal principal) {
        Customers cus = customersRepository.findByUsername(principal.getName());
        CustomersDTO dto = new CustomersDTO();
        UpLoadCustomerDTO image = new UpLoadCustomerDTO();
        image.getData(cus);
        dto.getData(cus);
        model.addAttribute("cus", dto);
        model.addAttribute("image", image);
        return "personinfomation";
    }

    @Override
    public String viewProfile(CustomersDTO cdto, BindingResult br, Model model) {
        long checkExistEmailEmployee;
        long checkExistEmailCustomer;
        if (br.hasErrors()) {
            Customers customer = cdto.tranferToEntities();
            UpLoadCustomerDTO image = new UpLoadCustomerDTO();
            image.getData(customer);
            model.addAttribute("image", image);
            model.addAttribute("cus", cdto);
            return "personinfomation";
        }
        checkExistEmailCustomer = customersRepository.getCountByCheckEmailAndCustomerID(cdto.getEmail(), cdto.getCustomerID());
        checkExistEmailEmployee = employeesRepository.getCountByCheckEmail(cdto.getEmail());
        if (checkExistEmailCustomer > 0 || checkExistEmailEmployee > 0) {
            br.rejectValue("email", "500", "Email exist ");
            Customers customer = cdto.tranferToEntities();
            UpLoadCustomerDTO image = new UpLoadCustomerDTO();
            image.getData(customer);
            model.addAttribute("image", image);
            model.addAttribute("cus", cdto);
            return "personinfomation";
        }
        Customers customers = cdto.tranferToEntities();
        Roles roles = rolesRepository.findById(cdto.getRoleTemp()).get();
        customers.setRoleID(roles);
        customersRepository.save(customers);
        return "redirect:/customer/my-profile?success=true";
    }

    @Override
    public String uploadImage(UpLoadCustomerDTO dto, BindingResult br, Model model, Principal principal) {
        if (!dto.getImage().isEmpty()) {
            try {
                Customers customer = customersRepository.findById(dto.getCustomerID()).get();
                String imageName = "CUS_" + principal.getName();
                cloudinary.uploader().destroy(imageName, ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName));
                Map upload = cloudinary.uploader().upload(dto.getImage().getBytes(), ObjectUtils.asMap("public_id", imageName));
                customer.setAvatar((String) upload.get("secure_url"));
                customersRepository.save(customer);
            } catch (Exception e) {
            }
        }
        return "redirect:/customer/my-profile?success=true";
    }

    @Override
    public String updatePassword(Model model, Principal prncpl) {
        Customers customers = customersRepository.findByUsername(prncpl.getName());
        Customers cus = customersRepository.findById(customers.getCustomerID()).get();
        CustomersDTO dto = new CustomersDTO();
        dto.getData(cus);
        model.addAttribute("cus", dto);
        return "updatepassword";
    }

    @Override
    public String updatePassword(CustomersDTO cdto, BindingResult br, Model model) {
        int status = 0;
        Customers customers;
        Roles role;
        if (br.hasErrors()) {
            model.addAttribute("cus", cdto);
            return "updatepassword";
        } else {
            boolean checkOldPassword = passwordEncoder.matches(cdto.getConfirmOldPassword(), cdto.getPassword());
            boolean checkConfirmNewPassword = cdto.getNewPassword().equals(cdto.getConfirmNewPassword());
            if (!checkOldPassword) {
                br.rejectValue("confirmOldPassword", "500", "Confirm password incorrect");
                status++;
            }
            if (!checkConfirmNewPassword) {
                br.rejectValue("confirmNewPassword", "500", "Confirm new password incorrect");
                status++;
            }
            if (status > 0) {
                model.addAttribute("cus", cdto);
                return "updatepassword";
            }
        }
        customers = customersRepository.findById(cdto.getCustomerID()).get();
        customers.setPassword(passwordEncoder.encode(cdto.getConfirmNewPassword()));
        customersRepository.save(customers);
        return "redirect:/customer/my-profile?success=true";
    }

}
