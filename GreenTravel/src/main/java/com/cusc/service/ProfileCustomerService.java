/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.CustomersDTO;
import com.cusc.dto.UpLoadCustomerDTO;
import java.security.Principal;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface ProfileCustomerService {

    String viewProfile(Model model, Principal principal);

    String viewProfile(CustomersDTO dto, BindingResult br, Model model);

    String uploadImage(UpLoadCustomerDTO dTO, BindingResult br, Model model, Principal principal);

    String updatePassword(Model model, Principal principal);

    String updatePassword(CustomersDTO dto, BindingResult br, Model model);

}
