/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.entities.BookingCars;
import com.cusc.entities.BookingTours;
import com.cusc.repositories.BookingCarsRepository;
import com.cusc.repositories.BookingToursRepository;
import com.cusc.repositories.CustomersRepository;
import com.cusc.service.HomeAdminService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 * @author kyqua
 */
@Service
public class HomeAdminServiceimpl implements HomeAdminService {

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private BookingCarsRepository bookingCarsRepository;

    @Autowired
    private BookingToursRepository bookingToursRepository;

    @Override
    public String homeAdmin(Model model) {
      
        List<BookingCars> listBookingCar = bookingCarsRepository.findAll(Sort.by(Sort.Direction.DESC, "bookingCarID"));
        List<BookingTours> listBookingTour = bookingToursRepository.findAll(Sort.by(Sort.Direction.DESC, "bookingTourID"));        double totalSaleBookingCar = getTotalSaleBookingCarToday();
        double totalSaleBookingTour = getTotalSaleBookingTourToday();
        long totalCustomer = customersRepository.count();
       long totalTransaction = bookingCarsRepository.count() + bookingToursRepository.count();
      
        model.addAttribute("listBkc", listBookingCar);
        model.addAttribute("listBkt", listBookingTour);
        model.addAttribute("saleBkc", totalSaleBookingCar);
        model.addAttribute("saleBkt", totalSaleBookingTour);
        model.addAttribute("totalCus", totalCustomer);
        model.addAttribute("totalTran", totalTransaction);
       Date today = Date.valueOf(LocalDate.now());
        long countBookingCar = bookingCarsRepository.getCountBookingCarByToday(today);
        long countBookingTour = bookingToursRepository.getCountBookingCarByToday(today);
        long countBookingCarByDate = bookingCarsRepository.getCountBookingCarByDate(today);
        long countBookingTourByDate = bookingToursRepository.getCountBookingByDate(today);
        model.addAttribute("countBookingCar",countBookingCar);
        model.addAttribute("countBookingTour",countBookingTour);
        model.addAttribute("countBookingCarByDate",countBookingCarByDate);
        model.addAttribute("countBookingTourByDate",countBookingTourByDate);
        return "ad_index";
    }

    private double getTotalSaleBookingCarToday() {
        Date today = Date.valueOf(LocalDate.now());
        try {
            Double result = bookingCarsRepository.getSumPriceByStoreProc(today);
            return result.doubleValue();
        } catch (Exception e) {
            return 0;
        }
    }

    private double getTotalSaleBookingTourToday() {
        Date today = Date.valueOf(LocalDate.now());
        try {
            Double result = bookingToursRepository.getSumTotalPriceByStoreProc(today);
            return result.doubleValue();
        } catch (Exception e) {
            return 0;
        }
    }

}
