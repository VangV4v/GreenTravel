/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.AreaDTO;
import com.cusc.service.AreaManageService;
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
@RequestMapping("/admin/employee/manage-area/")
public class AdminAreaManageController {
    @Autowired
    AreaManageService areaManageService;
    
    @GetMapping("home-area")
    public String viewArea(Model model) {
        return areaManageService.viewArea(model);
    }

    @GetMapping("create-area")
    public String createArea(Model model) {
        return areaManageService.createArea(model);
    }

    @PostMapping("create-area")
    public String createArea(@ModelAttribute("area") @Valid AreaDTO areaDTO, BindingResult br, Model model) {
        return areaManageService.createArea(areaDTO, br, model);
    }

    @GetMapping("edit-area/{id}")
    public String editArea(Model model, @PathVariable("id") int id) {
        return areaManageService.editArea(model, id);
    }

    @PostMapping("edit-area/{id}")
    public String editArea(@ModelAttribute("area") @Valid AreaDTO areaDTO, BindingResult br, Model model, @PathVariable("id") int id) {
        return areaManageService.editArea(areaDTO, br, model, id);
    }

    @PostMapping("delete-area")
    public String deleteArea(HttpServletRequest hsr) {
        return areaManageService.deleteArea(hsr);
    }
    
    @GetMapping("view-area/{id}")
    public String viewDetailArea(Model model, @PathVariable("id") int id) {
        return areaManageService.viewDetailArea(model, id);
    }
}
