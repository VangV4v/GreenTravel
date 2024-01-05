/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.BookingCarDTO;
import com.cusc.dto.CarDTO;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface CarRentalService {

    String filterClientCarRental(CarDTO dto, Model model);

    String searchClientCarRental(CarDTO dto, Model model);

    String paginationClientCarRental(Model model, int page);

    String bookingCar(Model model, int carid);

    @Transactional
    String bookingCar(BookingCarDTO bookingCarDTO, BindingResult br, Model model, HttpServletRequest request, Principal principal, int id);

    String showMyBooking(Model model, Principal principal);

    String stopBookingCar(HttpServletRequest request);

    String sendFeedback(HttpServletRequest request);

    void showQrMyBookingCar(HttpServletRequest request, HttpServletResponse response, int id);

    String showDataQr(Model model, int id);

}
