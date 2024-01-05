/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.LocalTravelDTO;
import com.cusc.service.LocalTravelManageService;
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
@RequestMapping("/admin/employee/manage-localtravel/")
public class AdminLocalTravelManageController {
    
    @Autowired
    LocalTravelManageService localTravelManageService;
    
     @GetMapping("home-localtravel")
    public String viewLocalLravel(Model model) {
        return localTravelManageService.viewLocalTravel(model);
    }

    @GetMapping("create-localtravel")
    public String createLocalLravel(Model model) {
        return localTravelManageService.createLocalTravel(model);
    }

    @PostMapping("create-localtravel")
    public String createLocalTravel(@ModelAttribute("localtravel") @Valid LocalTravelDTO localTravelDTO , BindingResult br, Model model) {
        return localTravelManageService.createLocalTravel(localTravelDTO, br, model);
    }

    @GetMapping("edit-localtravel/{id}")
    public String editLocalTravel(Model model, @PathVariable("id") int id) {
        return localTravelManageService.editLocalTravel(model, id);
    }

    @PostMapping("edit-localtravel/{id}")
    public String editLocalTravel(@ModelAttribute("localtravel") @Valid LocalTravelDTO localTravelDTO, BindingResult br, Model model, @PathVariable("id") int id) {
        return localTravelManageService.editLocalTravel(localTravelDTO, br, model, id);
    }

    @PostMapping("delete-localtravel")
    public String deleteLocalTravel(HttpServletRequest hsr) {
        return localTravelManageService.deleteLocalTravel(hsr);
    }
    
    @GetMapping("view-localtravel/{id}")
    public String viewDetailLocalTravel(Model model, @PathVariable("id") int id) {
        return localTravelManageService.viewDetailLocalTravel(model, id);
    }
}
