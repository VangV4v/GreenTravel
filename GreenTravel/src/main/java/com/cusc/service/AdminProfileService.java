/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.EmployeesDTO;
import com.cusc.dto.UpLoadImageEmployeDTO;
import java.security.Principal;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface AdminProfileService {

    String adminProfile(Model model, Principal principal);

    String adminProfile(EmployeesDTO edto, BindingResult br, Model model);

    String uploadImage(UpLoadImageEmployeDTO dTO, BindingResult br, Model model, Principal principal);

    String updatePassword(Model model, Principal principal);

    String updatePassword(EmployeesDTO edto, BindingResult br, Model model);
    

}
