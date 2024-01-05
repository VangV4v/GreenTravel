/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.EmployeesDTO;
import com.cusc.entities.Employees;
import com.cusc.service.EmployeeManageService;
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
@RequestMapping("/admin/boss/manage-employee/")
public class AdminEmployeeManageController {

    @Autowired
    private EmployeeManageService employeeManageService;

    @GetMapping("home-employee")
    public String viewEmployee(Model model) {
        return employeeManageService.viewEmployee(model);
    }

    @GetMapping("create-employee")
    public String createEmployee(Model model) {
        return employeeManageService.createEmployee(model);
    }

    @PostMapping("create-employee")
    public String createEmployee(@ModelAttribute("emp") @Valid EmployeesDTO employees, BindingResult br, Model model) {
        return employeeManageService.createEmployee(employees, br, model);
    }

    @GetMapping("edit-employee/{id}")
    public String editEmployee(Model model, @PathVariable("id") long id) {
        return employeeManageService.editEmployee(model, id);
    }

    @GetMapping("view-employee/{id}")
    public String viewDetailEmployee(Model model, @PathVariable("id") long id) {
        return employeeManageService.viewDetailEmployee(model, id);
    }

    @PostMapping("edit-employee/{id}")
    public String editEmployee(@ModelAttribute("emp") @Valid EmployeesDTO employees, BindingResult br, Model model, HttpServletRequest request, @PathVariable("id") long id) {
        return employeeManageService.editEmployee(employees, br, model, request, id);
    }

    @PostMapping("delete-employee")
    public String deleteEmployee(Model model, HttpServletRequest request) {
        return employeeManageService.deleteEmployee(model, request);
    }
}
