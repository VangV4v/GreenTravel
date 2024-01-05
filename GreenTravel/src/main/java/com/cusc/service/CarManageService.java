/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.CarDTO;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface CarManageService {

    String viewCar(Model model);

    String createCar(Model model);

    @Transactional
    String createCar(CarDTO dTO, BindingResult br, Model model);

    String editCar(Model model, int id);

    @Transactional
    String editCar(CarDTO dTO, BindingResult br, Model model, HttpServletRequest request, int id);

    String deleteCar(HttpServletRequest request);

    String viewDetailCar(Model model, int id);

    String statisticCarByAirCondition(HttpServletRequest request);

    String statisticCarByUnAirCondition(HttpServletRequest request);

    String statisticCarByTypeCar(HttpServletRequest request);

    String statisticCarByModelCar(HttpServletRequest request);
}
