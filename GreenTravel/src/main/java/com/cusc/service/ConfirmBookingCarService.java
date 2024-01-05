/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

/**
 *
 * @author kyqua
 */
public interface ConfirmBookingCarService {

    String viewBookingCar(Model model, Principal principal);

    String approveBookingCar(HttpServletRequest request);

    String denyBookingCar(HttpServletRequest request);
}
