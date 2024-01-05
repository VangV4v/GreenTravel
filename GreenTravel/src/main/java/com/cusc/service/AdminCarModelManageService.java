/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.CarModelDTO;
import com.cusc.entities.CarModels;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface AdminCarModelManageService {

    String viewCarModel(Model model);

    String createCarModel(Model model);

    String createCarModel(CarModelDTO dto, BindingResult br, Model model);

    String editCarModel(Model model, int id);

    String editCarModel(CarModelDTO dto, BindingResult br, Model model, int id);

    String deleteCarModel(HttpServletRequest request);

    String viewDetailCarModel(Model model, int id);

}
