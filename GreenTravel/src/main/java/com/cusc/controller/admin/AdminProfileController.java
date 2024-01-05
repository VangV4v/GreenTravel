/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.EmployeesDTO;
import com.cusc.dto.UpLoadImageEmployeDTO;
import com.cusc.service.AdminProfileService;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
@RequestMapping("/admin/")
public class AdminProfileController {

    @Autowired
    private AdminProfileService adminProfileService;

    @GetMapping("my-profile")
    public String adminProfile(Model model, Principal principal) {
        return adminProfileService.adminProfile(model, principal);
    }

    @PostMapping("change-my-profile")
    public String adminProfile(@ModelAttribute("profile") @Valid EmployeesDTO edto, BindingResult br, Model model, Principal principal) {
        return adminProfileService.adminProfile(edto, br, model);
    }

    @PostMapping("upload-image-employee")
    public String upLoadImage(@ModelAttribute("image") @Valid UpLoadImageEmployeDTO imageEmployeDTO, BindingResult br, Model model, Principal principal) {
        return adminProfileService.uploadImage(imageEmployeDTO, br, model, principal);
    }

    @GetMapping("change-password")
    public String updatePassword(Model model, Principal principal) {
        return adminProfileService.updatePassword(model, principal);
    }

    @PostMapping("change-password")
    public String updatePassword(@ModelAttribute("emp") @Valid EmployeesDTO edto, BindingResult br, Model model) {
        return adminProfileService.updatePassword(edto, br, model);
    }
}
