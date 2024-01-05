/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller;

import com.cusc.dto.CustomersDTO;
import com.cusc.service.SecurityService;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @RequestMapping("/login")
    public String login() {
        return securityService.login();
    }

    @GetMapping("/login-google")
    public String loginGoogle(HttpServletRequest request) {
        return securityService.loginGoogle(request);
    }

    @GetMapping("/login-success")
    public String loginProccess(Principal principal, HttpServletRequest request) {
        return securityService.loginProccess(principal, request);
    }

    @GetMapping("/logout-success")
    public String logout() {
        return securityService.logout();
    }

    @GetMapping("/403")
    public String pageErr(Model model, Principal principal) {
        return securityService.page403(model, principal);
    }

    @GetMapping("/register")
    public String register(Model model) {
        return securityService.register(model);
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("cus") @Valid CustomersDTO cus, BindingResult br, Model model, HttpServletRequest request, HttpSession session) {
        return securityService.register(cus, br, model, request, session);
    }
}
