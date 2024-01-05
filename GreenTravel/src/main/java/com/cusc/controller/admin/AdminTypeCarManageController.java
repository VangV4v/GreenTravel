/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.TypeCarDTO;
import com.cusc.service.TypeCarManageService;
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
@RequestMapping("/admin/employee/manage-typecar/")
public class AdminTypeCarManageController {

    @Autowired
    private TypeCarManageService typeCarManageService;

    @GetMapping("home-typecar")
    public String viewTypeCar(Model model) {
        return typeCarManageService.viewTypeCar(model);
    }

    @GetMapping("create-typecar")
    public String createTypeCar(Model model) {
        return typeCarManageService.createTypeCar(model);
    }

    @PostMapping("create-typecar")
    public String createTypeCar(@ModelAttribute("typecar") @Valid TypeCarDTO typeCarDTO, BindingResult br, Model model) {
        return typeCarManageService.createTypeCar(typeCarDTO, br, model);
    }

    @GetMapping("edit-typecar/{id}")
    public String editTypeCar(Model model, @PathVariable("id") int id) {
        return typeCarManageService.editTypeCar(model, id);
    }

    @PostMapping("edit-typecar/{id}")
    public String editTypeCar(@ModelAttribute("typecar") @Valid TypeCarDTO dto, BindingResult br, Model model, @PathVariable("id") int id) {
        return typeCarManageService.editTypeCar(dto, br, model, id);
    }

    @PostMapping("delete-typecar")
    public String deleteTypeCar(HttpServletRequest request) {
        return typeCarManageService.deleteTypeCar(request);
    }

    @GetMapping("view-typecar/{id}")
    public String viewDetailTypeCar(Model model, @PathVariable("id") int id) {
        return typeCarManageService.viewDetailTypeCar(model, id);
    }
}
