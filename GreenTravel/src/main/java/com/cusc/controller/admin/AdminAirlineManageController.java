/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.AirlineDTO;
import com.cusc.service.AirlineManageService;
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
@RequestMapping("/admin/employee/manage-airline/")
public class AdminAirlineManageController {
    
    @Autowired
    AirlineManageService airlineManageService;
    
    @GetMapping("home-airline")
    public String viewAirline(Model model) {
        return airlineManageService.viewAirline(model);
    }

    @GetMapping("create-airline")
    public String createAirline(Model model) {
        return airlineManageService.createAirline(model);
    }

    @PostMapping("create-airline")
    public String createAirline(@ModelAttribute("airline") @Valid AirlineDTO airlineDTO, BindingResult br, Model model) {
        return airlineManageService.createAirline(airlineDTO, br, model);
    }

    @GetMapping("edit-airline/{id}")
    public String editAirline(Model model, @PathVariable("id") int id) {
        return airlineManageService.editAirline(model, id);
    }

    @PostMapping("edit-airline/{id}")
    public String editAirline(@ModelAttribute("airline") @Valid AirlineDTO airlineDTO, BindingResult br, Model model, @PathVariable("id") int id) {
        return airlineManageService.editAirline(airlineDTO, br, model, id);
    }

    @PostMapping("delete-airline")
    public String deleteAirline(HttpServletRequest hsr) {
        return airlineManageService.deleteAirline(hsr);
    }
}
