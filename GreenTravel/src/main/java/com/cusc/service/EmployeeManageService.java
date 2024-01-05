/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.EmployeesDTO;
import com.cusc.entities.Employees;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface EmployeeManageService {

    String viewEmployee(Model model);

    String createEmployee(Model model);

    String createEmployee(EmployeesDTO employeesDTO, BindingResult br, Model model);

    String editEmployee(Model model, long id);

    String editEmployee(EmployeesDTO employees, BindingResult br, Model model, HttpServletRequest request, long id);

    String deleteEmployee(Model model,HttpServletRequest request);

    String viewDetailEmployee(Model model,long id);
    
    String deleteEmployee_1(Model model,HttpServletRequest request);
}
