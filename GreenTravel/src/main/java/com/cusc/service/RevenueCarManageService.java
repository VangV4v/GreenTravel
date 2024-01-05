/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

/**
 *
 * @author kyqua
 */
public interface RevenueCarManageService {

    String homeRevenueCar(Model model);

    String revenueCarModelInMonth(HttpServletRequest hsr);

    String revenueCarTypeInMonth(HttpServletRequest hsr);

    String revenueAirConditionedCarInYear(HttpServletRequest hsr);

    String revenueNonAirConditionedCarInYear(HttpServletRequest hsr);

    String revenueCarInYear(HttpServletRequest hsr);
    
    

}
