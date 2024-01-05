/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.CustomersDTO;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface SecurityService {

    String login();
    
    String loginGoogle(HttpServletRequest request);

    String loginProccess(Principal principal,HttpServletRequest request);

    String logout();

    String page403(Model model, Principal principal);

    String register(Model model);

    String register(CustomersDTO cdto, BindingResult br, Model model,HttpServletRequest request,HttpSession session);

}
