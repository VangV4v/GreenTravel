/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.defautvar.StatusOnDatabase;
import com.cusc.email.SendMail;
import com.cusc.entities.BookingCars;
import com.cusc.entities.Employees;
import com.cusc.repositories.BookingCarsRepository;
import com.cusc.repositories.EmployeesRepository;
import com.cusc.service.ConfirmBookingCarService;
import java.security.Principal;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 * @author kyqua
 */
@Service
public class ConfirmBookingCarServiceimpl implements ConfirmBookingCarService {

    @Autowired
    private BookingCarsRepository bookingCarsRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public String viewBookingCar(Model model, Principal principal) {
        Employees emp = employeesRepository.findByUsername(principal.getName());
        model.addAttribute("listBookingCar", bookingCarsRepository.findAllBookingCarsByEmployeeID(emp.getEmployeeID()));
        return "ad_confirm_bookingcar";
    }

    @Override
    public String approveBookingCar(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("bookingID"));
        BookingCars bookingCars = bookingCarsRepository.findById(id).get();
        bookingCars.setStatus(StatusOnDatabase.STATUS_INT_APPROVE);
        bookingCarsRepository.save(bookingCars);
        System.out.println("--" + bookingCars.toString());
        try {
            SendMail.sendMail(bookingCars.getRentalEmail(), "Notify Approved Booking Car", getContentConfirmBookingCar(bookingCars));
        } catch (Exception e) {
            System.out.println("-------" + e);
        }
        return "redirect:/admin/employee/booking-car/home-booking-car";
    }

    @Override
    public String denyBookingCar(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("bookingID"));
        BookingCars bookingCars = bookingCarsRepository.findById(id).get();
        bookingCars.setStatus(StatusOnDatabase.STATUS_INT_DENY);
        bookingCarsRepository.save(bookingCars);
        try {
            SendMail.sendMail(bookingCars.getRentalEmail(), "Notify Denied Booking Car", getContentDenyBookingCar(bookingCars));
        } catch (Exception e) {
            System.out.println("-------" + e);
        }
        return "redirect:/admin/employee/booking-car/home-booking-car";
    }

    private String getContentConfirmBookingCar(BookingCars bookingCars) {
        String content = " <div>We noticed that your booking is approved.Connect website to see more detail of your booking</div><br/>"
                + "        <hr/>"
                + "        <strong>Customer Booking:</strong><br/>"
                + "        Car Name: " + bookingCars.getCarID().getCarName() + "<br/>"
                + "        Rental Date: " + bookingCars.getRentalDate() + "<br/>"
                + "        Return Date: " + bookingCars.getReturnDate() + "<br/>"
                + "        Date Confirmed: " + LocalDateTime.now() + "<br/>"
                + "        Total Price: " + bookingCars.getPrice() + "<br/>"
                + "        Booking Name: " + bookingCars.getRentalName() + "<br/>"
                + "        Booking Email: " + bookingCars.getRentalEmail() + "<br/>"
                + "        Booking Phone: " + bookingCars.getRentalPhone() + "<br/>"
                + "        Note: " + bookingCars.getNote() + "<br/>"
                + "        <hr/>"
                + "        Best regards,<br/>"
                + "        Green Travel"
                + "        Thanks.";
        return content;
    }

    private String getContentDenyBookingCar(BookingCars bookingCars) {
        String content = " <div>We noticed that your booking is denied by any reason. Connect website to see more detail of your booking</div><br/>"
                + "        <hr/>"
                + "        <strong>Customer Booking:</strong><br/>"
                + "        Car Name: " + bookingCars.getCarID().getCarName() + "<br/>"
                + "        Rental Date: " + bookingCars.getRentalDate() + "<br/>"
                + "        Return Date: " + bookingCars.getReturnDate() + "<br/>"
                + "        Date Denied: " + LocalDateTime.now() + "<br/>"
                + "        Total Price: " + bookingCars.getPrice() + "<br/>"
                + "        Booking Name: " + bookingCars.getRentalName() + "<br/>"
                + "        Booking Email: " + bookingCars.getRentalEmail() + "<br/>"
                + "        Booking Phone: " + bookingCars.getRentalPhone() + "<br/>"
                + "        Note: " + bookingCars.getNote() + "<br/>"
                + "        <hr/>"
                + "        Best regards,<br/>"
                + "        Green Travel"
                + "        Thanks.";
        return content;
    }

}
