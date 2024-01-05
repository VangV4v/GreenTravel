/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.FlightDTO;
import com.cusc.service.FlightManageService;
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
@RequestMapping("/admin/employee/manage-flight/")
public class AdminFlightManageController {
    
    @Autowired
    FlightManageService flightManageService;
    
    @GetMapping("home-flight")
    public String viewFlight(Model model) {
        return flightManageService.viewFlight(model);
    }
    
    @GetMapping("view-flight/{id}")
    public String viewDetailFlight(Model model, @PathVariable("id") int id) {
        return flightManageService.viewDetailFlight(model, id);
    }

    @GetMapping("create-flight")
    public String createFlight(Model model) {
        return flightManageService.createFlight(model);
    }

    @PostMapping("create-flight")
    public String createFlight(@ModelAttribute("flight") @Valid FlightDTO flightDTO, BindingResult br, Model model) {
        return flightManageService.createFlight(flightDTO, br, model);
    }

    @GetMapping("edit-flight/{id}")
    public String editFlight(Model model, @PathVariable("id") int id) {
        return flightManageService.editFlight(model, id);
    }

    @PostMapping("edit-flight/{id}")
    public String editFlight(@ModelAttribute("flight") @Valid FlightDTO flightDTO, BindingResult br, Model model, @PathVariable("id") int id) {
        return flightManageService.editFlight(flightDTO, br, model, id);
    }

    @PostMapping("delete-flight")
    public String deleteFlight(HttpServletRequest hsr) {
        return flightManageService.deleteFlight(hsr);
    }
}
