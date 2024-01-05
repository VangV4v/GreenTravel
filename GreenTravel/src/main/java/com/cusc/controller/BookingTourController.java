/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller;

import com.cusc.dto.BookingTourDTO;
import com.cusc.service.BookingTourManageService;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author kyqua
 */
@Controller
public class BookingTourController {
    
    @Autowired
    BookingTourManageService bookingTourManageService;
    
     @GetMapping("/customer/bookingtour/{id}")
    public String bookPackageTour(Model model, @PathVariable("id") int id) {
        return bookingTourManageService.createBookingTour(model, id);
    }

    @PostMapping("/customer/bookingtour/{id}")
    public String bookPackageTour(@ModelAttribute("bookingTour") @Valid BookingTourDTO bookingTourDTO, BindingResult br, Model model, Principal principal, @PathVariable("id") int id) {
        return bookingTourManageService.createBookingTour(bookingTourDTO, br, model, principal, id);
    }
    
     @GetMapping("/customer/my-booking-tour")
    public String showMyBookingTour(Model model, Principal principal) {
        return bookingTourManageService.showMyBookingTour(model, principal);
    }

    @PostMapping("/customer/stop-booking-tour")
    public String stopBookingTour(HttpServletRequest request) {
        return bookingTourManageService.stopBookingTour(request);
    }
    
    @PostMapping("/customer/send-feedback-booking-tour")
    public String sendFeedbackBookingTour(HttpServletRequest request) {
        return bookingTourManageService.sendFeedback(request);
    }
    
    @GetMapping("/qr-get-data-tour/{id}")
    public String showDataQr(Model model, @PathVariable("id") int id) {
        return bookingTourManageService.showDataQr(model, id);
    }

    @GetMapping("/customer/qr-my-booking-tour/{id}")
    public void showQrMyBookingTour(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {
        bookingTourManageService.showQrMyBookingTour(request, response, id);
    }
}
