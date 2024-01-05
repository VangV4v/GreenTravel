/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.TypeCarDTO;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface TypeCarManageService {

    String viewTypeCar(Model model);

    String createTypeCar(Model model);

    String createTypeCar(TypeCarDTO dto, BindingResult br, Model model);

    String editTypeCar(Model model, int id);

    String editTypeCar(TypeCarDTO typeCarDTO, BindingResult br, Model model, int id);

    String deleteTypeCar(HttpServletRequest request);

    String viewDetailTypeCar(Model model, int id);
}
