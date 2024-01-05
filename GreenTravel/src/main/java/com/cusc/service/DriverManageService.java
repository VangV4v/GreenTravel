/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.DriverDTO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface DriverManageService {

    String viewDriver(Model model);

    String createDriver(Model model);

    String createDriver(DriverDTO dto, BindingResult br, Model model);

    String editDriver(Model model, int id);

    String editDriver(DriverDTO dto, BindingResult br, Model model, int id);

    String deleteDriver(HttpServletRequest request);

    String viewDetailDriver(Model model, int id);
}
