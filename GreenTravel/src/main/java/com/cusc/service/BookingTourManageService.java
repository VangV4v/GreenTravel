/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.BookingTourDTO;
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
public interface BookingTourManageService {
    
    String viewBookingTourConfirm(Model model, Principal principal);
    
    String viewBookingTour(Model model);
    
    String viewDetailBookingTour(Model model,int id);
    
    String viewStatistic();
    
    String confirmBookingTour(HttpServletRequest request);
    
    String createBookingTour(Model model, int id);
    
    @Transactional
    String createBookingTour(BookingTourDTO bookingTourDTO,BindingResult br, Model model, Principal principal, int id);
    
    String showMyBookingTour(Model model, Principal principal);

    String stopBookingTour(HttpServletRequest request);
    
    String sendFeedback(HttpServletRequest request);
    
     void showQrMyBookingTour(HttpServletRequest request, HttpServletResponse response, int id);

    String showDataQr(Model model, int id);
}
