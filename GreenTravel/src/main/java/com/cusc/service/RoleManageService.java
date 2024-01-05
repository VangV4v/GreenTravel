/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.entities.Roles;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface RoleManageService {

    String viewRole(Model model);

    String createRole(Model model);

    String createRole(Roles roles, BindingResult br, Model model);

    String editRole(Model model, int id);

    String editRole(Roles roles, BindingResult br, Model model, int id);

    String deleteRole(HttpServletRequest request);
}
