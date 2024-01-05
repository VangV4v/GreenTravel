/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.entities.Roles;
import com.cusc.service.RoleManageService;
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
@RequestMapping("/admin/boss/role/")
public class AdminRoleManageController {

    @Autowired
    private RoleManageService roleManageService;

    @GetMapping("home-role")
    public String viewRole(Model model) {
        return roleManageService.viewRole(model);
    }

    @GetMapping("create-role")
    public String createRole(Model model) {
        return roleManageService.createRole(model);
    }

    @PostMapping("create-role")
    public String createRole(@ModelAttribute("role") @Valid Roles roles, BindingResult br, Model model) {
        return roleManageService.createRole(roles, br, model);
    }

    @GetMapping("edit-role/{id}")
    public String editRole(Model model, @PathVariable("id") int id) {
        return roleManageService.editRole(model, id);
    }

    @PostMapping("edit-role/{id}")
    public String editRole(@ModelAttribute("role") @Valid Roles roles, BindingResult br, Model model, @PathVariable("id") int id) {
        return roleManageService.editRole(roles, br, model, id);
    }

    @PostMapping("delete-role")
    public String deleteRole(HttpServletRequest request) {
        return roleManageService.deleteRole(request);
    }
}
