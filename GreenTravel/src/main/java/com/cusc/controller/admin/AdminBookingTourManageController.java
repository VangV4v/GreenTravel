/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.service.BookingTourManageService;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kyqua
 */
@Controller
@RequestMapping("/admin/employee/manage-bookingtour/")
public class AdminBookingTourManageController {

    @Autowired
    BookingTourManageService bookingTourManageService;

    @GetMapping("home-bookingtour-confirm")
    public String viewBookingTourConfirm(Model model,Principal principal) {
        return bookingTourManageService.viewBookingTourConfirm(model,principal);
    }
    
    @GetMapping("home-bookingtour")
    public String viewBookingTour(Model model) {
        return bookingTourManageService.viewBookingTour(model);
    }
    
     @GetMapping("view-bookingtour/{id}")
    public String viewDetailBookingTour(Model model, @PathVariable("id") int id) {
        return bookingTourManageService.viewDetailBookingTour(model,id);
    }
    
     @GetMapping("view-statistic-tour")
    public String viewStatisticTour() {
        return bookingTourManageService.viewStatistic();
    }

    @PostMapping("confirm-bookingtour")
    public String confirmBookingTour(HttpServletRequest hsr) {
        return bookingTourManageService.confirmBookingTour(hsr);
    }

}
