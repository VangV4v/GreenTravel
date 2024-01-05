/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.entities.Roles;
import com.cusc.repositories.RolesRepository;
import com.cusc.service.RoleManageService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
@Service
public class RoleManageServiceimpl implements RoleManageService {
    
    @Autowired
    private RolesRepository rolesRepository;
    
    @Override
    public String viewRole(Model model) {
        model.addAttribute("listRole", rolesRepository.findAll());
        return "ad_view_role";
    }
    
    @Override
    public String createRole(Model model) {
        Roles roles = new Roles();
        model.addAttribute("role", roles);
        return "ad_create_role";
    }
    
    @Override
    public String createRole(Roles roles, BindingResult br, Model model) {
        roles.setRoleName("ROLE_" + roles.getRoleName());
        if (br.hasErrors()) {
            model.addAttribute("role", roles);
            return "ad_create_role";
        }
        rolesRepository.save(roles);
        return "redirect:/admin/role/home-role";
    }
    
    @Override
    public String editRole(Model model, int i) {
        Roles role = rolesRepository.findById(i).get();
        model.addAttribute("role", role);
        return "ad_edit_role";
    }
    
    @Override
    public String editRole(Roles role, BindingResult br, Model model, int i) {
        if (br.hasErrors()) {
            model.addAttribute("role", role);
            return "ad_edit_role";
        }
        rolesRepository.save(role);
        return "redirect:/admin/role/home-role";
    }
    
    @Override
    public String deleteRole(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("roleID"));
        rolesRepository.deleteById(id);
        return "redirect:/admin/role/home-role";
    }
    
}
