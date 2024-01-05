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
public interface RevenueTourManageService {

    String homeRevenueTour(Model model);

    String revenueTourTypeInMonth(HttpServletRequest hsr);

    String revenueTourAreaInMonth(HttpServletRequest hsr);

    String revenueProvinceInMonth(HttpServletRequest hsr);

    String revenueBookingTourInYear(HttpServletRequest hsr);
}
