/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.CustomersDTO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface CustomerManageService {

    String viewCustomer(Model model);

    String createCustomer(Model model);

    String createCustomer(CustomersDTO customersDTO, BindingResult br, Model model);

    String editCustomer(Model model, long id);

    String editCustomer(CustomersDTO dto, BindingResult br, Model model, HttpServletRequest request, long id);

    String viewDetailCustomer(Model model, long id);

    String deleteCustomer(HttpServletRequest request);
}
