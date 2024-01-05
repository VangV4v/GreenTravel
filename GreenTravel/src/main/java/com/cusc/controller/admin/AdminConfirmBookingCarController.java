/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.service.ConfirmBookingCarService;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kyqua
 */
@Controller
@RequestMapping("/admin/employee/booking-car/")
public class AdminConfirmBookingCarController {

    @Autowired
    private ConfirmBookingCarService confirmBookingCarService;

    @GetMapping("home-booking-car")
    public String viewBookingCar(Model model, Principal principal) {
        return confirmBookingCarService.viewBookingCar(model, principal);
    }

    @PostMapping("approve-car")
    public String approveBookingCar(HttpServletRequest request) {
        return confirmBookingCarService.approveBookingCar(request);
    }

    @PostMapping("deny-car")
    public String denyBookingCar(HttpServletRequest request) {
        return confirmBookingCarService.denyBookingCar(request);
    }

}
