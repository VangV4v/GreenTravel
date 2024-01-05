/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.entities.Employees;
import com.cusc.repositories.BookingCarsRepository;
import com.cusc.repositories.EmployeesRepository;
import com.cusc.service.BookingCarService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 * @author kyqua
 */
@Service
public class BookingCarServiceimpl implements BookingCarService {
    
    @Autowired
    private BookingCarsRepository bookingCarsRepository;
    
    @Autowired
    EmployeesRepository employeesRepository;
    
    @Override
    public String viewBookingCar(Model model) {    
        model.addAttribute("listBookingCar", bookingCarsRepository.findAllBookingCar());
        return "ad_view_bookingcar";
        
    }
    
    @Override
    public String viewDetailBookingCar(Model model, int id) {
        model.addAttribute("bookingcar", bookingCarsRepository.findById(id).get());
        return "ad_detail_bookingcar";
    }

    @Override
    public String viewStatistic() {
        return "ad_statistic_car";
    }
    
}
