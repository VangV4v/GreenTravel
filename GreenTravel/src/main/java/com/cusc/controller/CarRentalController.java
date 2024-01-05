/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller;

import com.cusc.dto.BookingCarDTO;
import com.cusc.dto.CarDTO;
import com.cusc.service.CarRentalService;
import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
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
public class CarRentalController {

    @Autowired
    private CarRentalService carRentalService;

    @PostMapping("/filter-car")
    public String filterClientCarRental(@ModelAttribute("filterCar") CarDTO dto, Model model) {
        return carRentalService.filterClientCarRental(dto, model);
    }

    @PostMapping("/search-car")
    public String searchClientCarRental(@ModelAttribute("searchCar") CarDTO dTO, Model model) {
        return carRentalService.searchClientCarRental(dTO, model);
    }

    @GetMapping("/car/page/{page}")
    public String paginationClientCarRental(Model model, @PathVariable("page") int page) {
        return carRentalService.paginationClientCarRental(model, page);
    }

    @GetMapping("/customer/booking-car/{carid}")
    public String bookingCar(Model model, @PathVariable("carid") int id) {
        return carRentalService.bookingCar(model, id);
    }

    @PostMapping("/customer/booking-car/{carid}")
    public String bookingCar(@ModelAttribute("bookingcar") @Valid BookingCarDTO dTO, BindingResult br, Model model, HttpServletRequest request, Principal principal, @PathVariable("carid") int id) {
        return carRentalService.bookingCar(dTO, br, model, request, principal, id);
    }

    @GetMapping("/customer/my-booking-car")
    public String showMyBookingCar(Model model, Principal principal) {
        return carRentalService.showMyBooking(model, principal);
    }

    @PostMapping("/customer/stop-booking-car")
    public String stopBookingCar(HttpServletRequest request) {
        return carRentalService.stopBookingCar(request);
    }

    @PostMapping("/customer/send-feedback-booking-car")
    public String sendFeedBack(HttpServletRequest request) {
        return carRentalService.sendFeedback(request);
    }

    @GetMapping("/qr-get-data/{id}")
    public String showDataQr(Model model, @PathVariable("id") int id) {
        return carRentalService.showDataQr(model, id);
    }

    @GetMapping("/customer/qr-my-booking-car/{id}")
    public void showQrMyBookingCar(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {
        carRentalService.showQrMyBookingCar(request, response, id);
    }
}
