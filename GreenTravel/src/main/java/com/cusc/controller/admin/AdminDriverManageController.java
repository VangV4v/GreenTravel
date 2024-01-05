/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.DriverDTO;
import com.cusc.service.DriverManageService;
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
@RequestMapping("/admin/employee/manage-driver/")
public class AdminDriverManageController {

    @Autowired
    private DriverManageService driverManageService;

    @GetMapping("home-driver")
    public String viewDriver(Model model) {
        return driverManageService.viewDriver(model);
    }

    @GetMapping("create-driver")
    public String createDriver(Model model) {
        return driverManageService.createDriver(model);
    }

    @PostMapping("create-driver")
    public String createDriver(@ModelAttribute("driver") @Valid DriverDTO dto, BindingResult br, Model model) {
        return driverManageService.createDriver(dto, br, model);
    }

    @GetMapping("edit-driver/{id}")
    public String editDriver(Model model, @PathVariable("id") int id) {
        return driverManageService.editDriver(model, id);
    }

    @PostMapping("edit-driver/{id}")
    public String editDriver(@ModelAttribute("driver") @Valid DriverDTO dto, BindingResult br, Model model, @PathVariable("id") int id) {
        return driverManageService.editDriver(dto, br, model, id);
    }

    @PostMapping("delete-driver")
    public String deleteDriver(HttpServletRequest hsr) {
        return driverManageService.deleteDriver(hsr);
    }

    @GetMapping("view-driver/{id}")
    public String viewDetailDriver(Model model, @PathVariable("id") int id) {
        return driverManageService.viewDetailDriver(model, id);
    }
}
