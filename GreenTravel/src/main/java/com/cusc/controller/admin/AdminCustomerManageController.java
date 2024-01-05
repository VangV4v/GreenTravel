/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.CustomersDTO;
import com.cusc.service.CustomerManageService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kyqua
 */
@Controller
@RequestMapping("/admin/employee/manage-customer/")
public class AdminCustomerManageController {

    @Autowired
    private CustomerManageService customerManageService;

    @GetMapping("home-customer")
    public String viewCustomer(Model model) {
        return customerManageService.viewCustomer(model);
    }

    @GetMapping("create-customer")
    public String createCustomer(Model model) {
        return customerManageService.createCustomer(model);
    }

    @PostMapping("create-customer")
    public String createCustomer(@Valid @ModelAttribute("cus") CustomersDTO customers, BindingResult br, Model model) {
        return customerManageService.createCustomer(customers, br, model);
    }

    @GetMapping("edit-customer/{id}")
    public String editCustomer(Model model, @PathVariable("id") long id) {
        return customerManageService.editCustomer(model, id);
    }

    @PostMapping("edit-customer/{id}")
    public String editCustomer(@ModelAttribute("cus") @Valid CustomersDTO cdto, BindingResult br, Model model, HttpServletRequest request, @PathVariable("id") long id) {
        return customerManageService.editCustomer(cdto, br, model, request, id);
    }

    @GetMapping("view-customer/{id}")
    public String viewDetailCustomer(Model model, @PathVariable("id") long id) {
        return customerManageService.viewDetailCustomer(model, id);
    }

    @PostMapping("delete-customer")
    public String deleteCustomer(HttpServletRequest request) {
        return customerManageService.deleteCustomer(request);
    }
}
