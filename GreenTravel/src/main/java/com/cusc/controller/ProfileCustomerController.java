/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller;

import com.cusc.dto.CustomersDTO;
import com.cusc.dto.UpLoadCustomerDTO;
import com.cusc.service.ProfileCustomerService;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kyqua
 */
@Controller
@RequestMapping("/customer/")
public class ProfileCustomerController {

    @Autowired
    private ProfileCustomerService profileCustomerService;

    @GetMapping("my-profile")
    public String viewProfile(Model model, Principal principal,Authentication authentication) {
        System.out.println("---"+authentication.getName());
        return profileCustomerService.viewProfile(model, principal);
    }

    @PostMapping("change-my-profile")
    public String viewProfile(@ModelAttribute("cus") @Valid CustomersDTO dto, BindingResult br, Model model) {
        return profileCustomerService.viewProfile(dto, br, model);
    }

    @PostMapping("upload-avatar")
    public String uploadImage(@ModelAttribute("image") @Valid UpLoadCustomerDTO dto, BindingResult br, Model model, Principal principal) {
        return profileCustomerService.uploadImage(dto, br, model, principal);
    }

    @GetMapping("update-password")
    public String updatePassword(Model model, Principal principal) {
        return profileCustomerService.updatePassword(model, principal);
    }

    @PostMapping("update-password")
    public String updatePassword(@ModelAttribute("cus") @Valid CustomersDTO dto, BindingResult br, Model model) {
        return profileCustomerService.updatePassword(dto, br, model);
    }

}
