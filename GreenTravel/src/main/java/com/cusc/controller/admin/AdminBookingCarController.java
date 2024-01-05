/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.service.BookingCarService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kyqua
 */
@Controller
@RequestMapping("/admin/employee/manage-bookingcar/")
public class AdminBookingCarController {

    @Autowired
    private BookingCarService bookingCarService;

    @GetMapping("home-bookingcar")
    public String viewBookingCar(Model model) {
        return bookingCarService.viewBookingCar(model);
    }

    @GetMapping("view-bookingcar/{id}")
    public String viewDetailBookingCar(Model model, @PathVariable("id") int id) {
        return bookingCarService.viewDetailBookingCar(model, id);
    }
    
     @GetMapping("view-statistic-car")
    public String viewStatisticCar() {
        return bookingCarService.viewStatistic();
    }
}
