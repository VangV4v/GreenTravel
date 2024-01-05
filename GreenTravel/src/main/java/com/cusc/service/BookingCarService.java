/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import java.security.Principal;
import org.springframework.ui.Model;

/**
 *
 * @author kyqua
 */
public interface BookingCarService {

    String viewBookingCar(Model model);

    String viewDetailBookingCar(Model model, int id);
    
    String viewStatistic();
}
