/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.DestinationDTO;
import com.cusc.service.DestinationManageService;
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
@RequestMapping("/admin/employee/manage-destination/")
public class AdminDestinationManageController {
    
    @Autowired
    DestinationManageService destinationManageService;
    
    @GetMapping("home-destination")
    public String viewDestination(Model model) {
        return destinationManageService.viewDestination(model);
    }

    @GetMapping("create-destination")
    public String createDestination(Model model) {
        return destinationManageService.createDestination(model);
    }

    @PostMapping("create-destination")
    public String createDestination(@ModelAttribute("destination") @Valid DestinationDTO destinationDTO, BindingResult br, Model model) {
        return destinationManageService.createDestination(destinationDTO, br, model);
    }

    @GetMapping("edit-destination/{id}")
    public String editDestination(Model model, @PathVariable("id") int id) {
        return destinationManageService.editDestination(model, id);
    }

    @PostMapping("edit-destination/{id}")
    public String editDestination(@ModelAttribute("destination") @Valid DestinationDTO destinationDTO, BindingResult br, Model model, @PathVariable("id") int id) {
        return destinationManageService.editDestination(destinationDTO, br, model, id);
    }

    @PostMapping("delete-destination")
    public String deleteDestination(HttpServletRequest hsr) {
        return destinationManageService.deleteDestination(hsr);
    }
    
    @GetMapping("view-destination/{id}")
    public String viewDetailDestination(Model model, @PathVariable("id") int id) {
        return destinationManageService.viewDetailDestination(model, id);
    }
}
