/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.CarModelDTO;
import com.cusc.service.AdminCarModelManageService;
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
@RequestMapping("/admin/employee/manage-carmodel/")
public class AdminCarModelManageController {

    @Autowired
    private AdminCarModelManageService adminCarModelManageService;

    @GetMapping("home-carmodel")
    public String viewCarModel(Model model) {
        return adminCarModelManageService.viewCarModel(model);
    }

    @GetMapping("create-carmodel")
    public String createCarModel(Model model) {
        return adminCarModelManageService.createCarModel(model);
    }

    @PostMapping("create-carmodel")
    public String createCarModel(@ModelAttribute("carmodel") @Valid CarModelDTO dTO, BindingResult br, Model model) {
        return adminCarModelManageService.createCarModel(dTO, br, model);
    }

    @GetMapping("edit-carmodel/{id}")
    public String editCarModel(Model model, @PathVariable("id") int id) {
        return adminCarModelManageService.editCarModel(model, id);
    }

    @PostMapping("edit-carmodel/{id}")
    public String editCarModel(@ModelAttribute("carmodel") @Valid CarModelDTO dto, BindingResult br, Model model, @PathVariable("id") int id) {
        return adminCarModelManageService.editCarModel(dto, br, model, id);
    }

    @PostMapping("delete-carmodel")
    public String deleteCarModel(HttpServletRequest hsr) {
        return adminCarModelManageService.deleteCarModel(hsr);
    }

    @GetMapping("view-carmodel/{id}")
    public String viewDetailCarmodel(Model model, @PathVariable("id") int id) {
        return adminCarModelManageService.viewDetailCarModel(model, id);
    }

}
