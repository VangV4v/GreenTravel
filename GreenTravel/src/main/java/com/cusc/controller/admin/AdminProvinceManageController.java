/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.ProvinceDTO;
import com.cusc.service.ProvinceManageService;
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
@RequestMapping("/admin/employee/manage-province/")
public class AdminProvinceManageController {
    @Autowired
    ProvinceManageService provinceManageService;
    
    @GetMapping("home-province")
    public String viewProvince(Model model) {
        return provinceManageService.viewProvince(model);
    }

    @GetMapping("create-province")
    public String createProvince(Model model) {
        return provinceManageService.createProvince(model);
    }

    @PostMapping("create-province")
    public String createProvince(@ModelAttribute("province") @Valid ProvinceDTO provinceDTO, BindingResult br, Model model) {
        return provinceManageService.createProvince(provinceDTO, br, model);
    }

    @GetMapping("edit-province/{id}")
    public String editProvince(Model model, @PathVariable("id") int id) {

        return provinceManageService.editProvince(model, id);
    }

    @PostMapping("edit-province/{id}")
    public String editProvince(@ModelAttribute("province") @Valid ProvinceDTO provinceDTO, BindingResult br, Model model, @PathVariable("id") int id) {
        return provinceManageService.editProvince(provinceDTO, br, model, id);
    }

    @PostMapping("delete-province")
    public String deleteProvince(HttpServletRequest hsr) {
        return provinceManageService.deleteProvince(hsr);
    }
}
