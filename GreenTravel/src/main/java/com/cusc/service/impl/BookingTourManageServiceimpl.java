/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.bef.ZXingHelper;
import com.cusc.dto.BookingTourDTO;
import com.cusc.email.SendMail;

import com.cusc.entities.BookingTours;
import com.cusc.entities.Customers;
import com.cusc.entities.Employees;
import com.cusc.entities.PackageTours;
import com.cusc.repositories.BookingToursRepository;
import com.cusc.repositories.CustomersRepository;
import com.cusc.repositories.EmployeesRepository;
import com.cusc.repositories.PackageToursRepository;
import com.cusc.repositories.hql.BookingTourHQL;
import com.cusc.repositories.hql.CustomersHQL;
import com.cusc.service.BookingTourManageService;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
@Service
public class BookingTourManageServiceimpl implements BookingTourManageService {

    @Autowired
    BookingToursRepository bookingTourRepository;

    @Autowired
    PackageToursRepository packageToursRepository;

    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    BookingTourHQL bookingTourHQL;

    @Autowired
    CustomersHQL customerHQL;

    @Override
    public String createBookingTour(Model model, int id) {
        model.addAttribute("packageTour", packageToursRepository.findById(id).get());
        BookingTourDTO bookingTourDTO = new BookingTourDTO();
        model.addAttribute("bookingTour", bookingTourDTO);
        return "bookingtour";
    }

    @Override
    public String createBookingTour(BookingTourDTO bookingTourDTO, BindingResult br, Model model, Principal principal, int id) {
        PackageTours packageTour = packageToursRepository.findById(id).get();
        Customers customer = customerHQL.loadByUsername(principal.getName());
        if (br.hasErrors()) {
            model.addAttribute("packageTour", packageTour);
            model.addAttribute("bookingTour", bookingTourDTO);
            return "bookingtour";
        }
        if (bookingTourDTO.getQuantityAdult() + bookingTourDTO.getQuantityChildren() == 0) {
            br.rejectValue("quantityAdult", "500", "Invalid quantity");
            br.rejectValue("quantityChildren", "500", "Invalid quantity");
            model.addAttribute("packageTour", packageTour);
            model.addAttribute("bookingTour", bookingTourDTO);
            return "bookingtour";
        }
        if (bookingTourDTO.getQuantityAdult() + bookingTourDTO.getQuantityChildren() > packageTour.getCapacity()) {
            br.rejectValue("quantityAdult", "500", "Not enough avaivle slot for tour");
            br.rejectValue("quantityChildren", "500", "Not enough avaivle slot for tour");
            model.addAttribute("packageTour", packageTour);
            model.addAttribute("bookingTour", bookingTourDTO);
            return "bookingtour";
        }
        BookingTours bookingTour = bookingTourDTO.tranferToEntities();
        bookingTour.setPackageTourID(packageTour);
        bookingTour.setCustomerID(customer);
        bookingTour.setEmployeeID(getEmployeeAuto());
        bookingTour.setStatus(1);
        bookingTour.setBookDate(new Date(System.currentTimeMillis()));
        bookingTour.setTotalPrice((bookingTourDTO.getQuantityAdult() * packageTour.getPrice()) + (bookingTourDTO.getQuantityChildren() * 0.8 * packageTour.getPrice()));
        bookingTourRepository.save(bookingTour);
        packageTour.setCapacity(packageTour.getCapacity() - bookingTourDTO.getQuantityAdult() - bookingTourDTO.getQuantityChildren());
        packageToursRepository.save(packageTour);

        try {
            String content = " <div>We noticed that you - " + bookingTour.getEmployeeID().getUsername() + " have to confirm booking tour. Pleased go to website to confirm booking tour for customer.</div><br/>"
                    + "        <hr/>"
                    + "        <strong>Customer Booking:</strong><br/>"
                    + "        Package Tour: " + bookingTour.getPackageTourID().getName() + "<br/>"
                    + "        Booking Date: " + bookingTour.getBookDate().toString() + "<br/>"
                    + "        Adult Quantity: " + String.valueOf(bookingTour.getQuantityAdult()) + " Slots<br/>"
                    + "        Children Quantity: " + String.valueOf(bookingTour.getQuantityChildren()) + " Slots<br/>"
                    + "        Total Price: " + String.valueOf(bookingTour.getTotalPrice()) + "<br/>"
                    + "        Booking Name: " + bookingTour.getBookingName() + "<br/>"
                    + "        Booking Email: " + bookingTour.getBookingEmail() + "<br/>"
                    + "        Booking Phone: " + bookingTour.getBookingPhone() + "<br/>"
                    + "        Note: " + bookingTour.getNote() + "<br/>"
                    + "        <hr/>"
                    + "        Best regards,<br/>"
                    + "        Green Travel";

            SendMail.sendMail(bookingTour.getEmployeeID().getEmail(), "GreenTravel - Request Booking", content);
        } catch (MessagingException ex) {
            Logger.getLogger(BookingTourManageServiceimpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String content = " <div>We noticed that you have to success booking tour. Pleased go to website to view booking tour detail.</div><br/>"
                    + "        <hr/>"
                    + "        <strong>Customer Booking:</strong><br/>"
                    + "        Package Tour: " + bookingTour.getPackageTourID().getName() + "<br/>"
                    + "        Booking Date: " + bookingTour.getBookDate().toString() + "<br/>"
                    + "        Adult Quantity: " + String.valueOf(bookingTour.getQuantityAdult()) + " Slots<br/>"
                    + "        Children Quantity: " + String.valueOf(bookingTour.getQuantityChildren()) + " Slots<br/>"
                    + "        Total Price: " + String.valueOf(bookingTour.getTotalPrice()) + "<br/>"
                    + "        Booking Name: " + bookingTour.getBookingName() + "<br/>"
                    + "        Booking Email: " + bookingTour.getBookingEmail() + "<br/>"
                    + "        Booking Phone: " + bookingTour.getBookingPhone() + "<br/>"
                    + "        Note: " + bookingTour.getNote() + "<br/>"
                    + "        <hr/>"
                    + "        Best regards,<br/>"
                    + "        Green Travel";

            SendMail.sendMail(bookingTour.getBookingEmail(), "GreenTravel - Notify Booking", content);
        } catch (MessagingException ex) {
            Logger.getLogger(BookingTourManageServiceimpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/customer/my-booking-tour?success=true";
    }

    @Override
    public String viewBookingTourConfirm(Model model, Principal principal) {
        LocalDate today = LocalDate.now();
        Date date = Date.valueOf(today);
        model.addAttribute("today", date);
        Employees employee = employeesRepository.findByUsername(principal.getName());
        model.addAttribute("listBookingTourConfirm", bookingTourHQL.findAllBookingTourConfirm(employee.getEmployeeID()));
        return "ad_view_bookingtour_confirm";
    }

    @Override
    public String confirmBookingTour(HttpServletRequest request) {
        int bookingTourID = Integer.parseInt(request.getParameter("bookingTourID"));
        int confirmStatus = Integer.parseInt(request.getParameter("confirmStatus"));

        BookingTours bookingTour = bookingTourRepository.findById(bookingTourID).get();
        bookingTour.setStatus(confirmStatus);
        bookingTourRepository.save(bookingTour);
        if (confirmStatus == 2) {
            try {
                String content = " <div>We noticed your booking is approved. Connect website to see more detail of your booking.</div><br/>"
                        + "        <hr/>"
                        + "        <strong>Your Booking:</strong><br/>"
                        + "        Package Tour: " + bookingTour.getPackageTourID().getName() + "<br/>"
                        + "        Booking Date: " + bookingTour.getBookDate().toString() + "<br/>"
                        + "        Adult Quantity: " + String.valueOf(bookingTour.getQuantityAdult()) + " Slots<br/>"
                        + "        Children Quantity: " + String.valueOf(bookingTour.getQuantityChildren()) + " Slots<br/>"
                        + "        Total Price: " + String.valueOf(bookingTour.getTotalPrice()) + "<br/>"
                        + "        Booking Name: " + bookingTour.getBookingName() + "<br/>"
                        + "        Booking Email: " + bookingTour.getBookingEmail() + "<br/>"
                        + "        Booking Phone: " + bookingTour.getBookingPhone() + "<br/>"
                        + "        Note: " + bookingTour.getNote() + "<br/>"
                        + "        <hr/>"
                        + "        Hope you have good time with this tour. Thanks a lot!<br/>"
                        + "        Best regards,<br/>"
                        + "        Green Travel";

                SendMail.sendMail(bookingTour.getBookingEmail(), "GreenTravel - Approved Booking", content);
            } catch (MessagingException ex) {
                Logger.getLogger(BookingTourManageServiceimpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (confirmStatus == -1) {
            PackageTours packageTour = bookingTour.getPackageTourID();
            packageTour.setCapacity(packageTour.getCapacity() + bookingTour.getQuantityAdult() + bookingTour.getQuantityChildren());
            packageToursRepository.save(packageTour);
            try {
                String content = " <div>We noticed your booking is canceled by many reason. Any question please contact our employee to be answered. Pleased go to website to book other package tour.</div><br/>"
                        + "        <hr/>"
                        + "        <strong>Your Booking:</strong><br/>"
                        + "        Package Tour: " + bookingTour.getPackageTourID().getName() + "<br/>"
                        + "        Booking Date: " + bookingTour.getBookDate().toString() + "<br/>"
                        + "        Adult Quantity: " + String.valueOf(bookingTour.getQuantityAdult()) + " Slots<br/>"
                        + "        Children Quantity: " + String.valueOf(bookingTour.getQuantityChildren()) + " Slots<br/>"
                        + "        Total Price: " + String.valueOf(bookingTour.getTotalPrice()) + "<br/>"
                        + "        Booking Name: " + bookingTour.getBookingName() + "<br/>"
                        + "        Booking Email: " + bookingTour.getBookingEmail() + "<br/>"
                        + "        Booking Phone: " + bookingTour.getBookingPhone() + "<br/>"
                        + "        Note: " + bookingTour.getNote() + "<br/>"
                        + "        <hr/>"
                        + "        Best regards,<br/>"
                        + "        Green Travel";

                SendMail.sendMail(bookingTour.getBookingEmail(), "GreenTravel - Cancel Booking", content);
            } catch (MessagingException ex) {
                Logger.getLogger(BookingTourManageServiceimpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        // return "ad_view_bookingtour";
        return "redirect:/admin/employee/manage-bookingtour/home-bookingtour";

    }

    @Override
    public String viewBookingTour(Model model) {
        LocalDate today = LocalDate.now();
        Date date = Date.valueOf(today);
        model.addAttribute("today", date);
        model.addAttribute("listBookingTour", bookingTourHQL.findAllBookingTour());
        return "ad_view_bookingtour";
    }

    @Override
    public String viewDetailBookingTour(Model model, int id) {
        BookingTours bookingTour = bookingTourRepository.findById(id).get();
        model.addAttribute("bookingTour", bookingTour);
        return "ad_detail_bookingtour";

    }

    private Employees getEmployeeAuto() {
        List<Employees> listEp = employeesRepository.findAll(Sort.by(Sort.Direction.ASC, "employeeID"));
        Employees minEmp = listEp.get(0);
        for (Employees employees : listEp) {
            if (employees.getRoleID().getRoleID() == 2) {
                if (employees.getBookingToursList().size() < minEmp.getBookingToursList().size()) {
                    minEmp = employees;
                }
            }
        }
        return minEmp;
    }

    @Override
    public String showMyBookingTour(Model model, Principal pricipal) {
        LocalDate today = LocalDate.now();
        Date date = Date.valueOf(today);
        Customers customers = customerHQL.loadByUsername(pricipal.getName());
        List<BookingTours> listBookingTour = bookingTourHQL.findAllBookingTourCustomer(customers.getCustomerID());
        model.addAttribute("listBookingTour", listBookingTour);
        model.addAttribute("today", date);
        return "mybookingtour";
    }

    @Override
    public String stopBookingTour(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("bookingTourID"));
        double priceAfterStop = 0;
        BookingTours bookingTour = bookingTourRepository.findById(id).get();
        bookingTour.setStatus(-1);
        bookingTourRepository.save(bookingTour);

        LocalDate today = LocalDate.now();
        Date dateStopBooking = Date.valueOf(today);
        Date dateStart = bookingTour.getBookDate();
        long day = (dateStart.getTime() - dateStopBooking.getTime()) / (24 * 3600 * 1000);
        if (day >= 5) {
            priceAfterStop = bookingTour.getTotalPrice() - (bookingTour.getTotalPrice() * 0.05);
        } else if (day == 4) {
            priceAfterStop = bookingTour.getTotalPrice() - (bookingTour.getTotalPrice() * 0.1);
        } else if (day == 3) {
            priceAfterStop = bookingTour.getTotalPrice() - (bookingTour.getTotalPrice() * 0.15);
        } else if (day == 2) {
            priceAfterStop = bookingTour.getTotalPrice() - (bookingTour.getTotalPrice() * 0.2);
        } else {
            priceAfterStop = bookingTour.getTotalPrice() - (bookingTour.getTotalPrice() * 0.25);
        }

        try {
            String content = " <div>We noticed your booking is canceled by many reason. Any question please contact our employee to be answered. Pleased go to website to book other package tour.</div><br/>"
                    + "        <hr/>"
                    + "        <strong>Your Booking:</strong><br/>"
                    + "        Package Tour: " + bookingTour.getPackageTourID().getName() + "<br/>"
                    + "        Booking Date: " + bookingTour.getBookDate().toString() + "<br/>"
                    + "        Adult Quantity: " + String.valueOf(bookingTour.getQuantityAdult()) + " Slots<br/>"
                    + "        Children Quantity: " + String.valueOf(bookingTour.getQuantityChildren()) + " Slots<br/>"
                    + "        Total Price: " + String.valueOf(bookingTour.getTotalPrice()) + "<br/>"
                    + "       Total Price Refund: " + priceAfterStop + "<br/>"
                    + "        Booking Name: " + bookingTour.getBookingName() + "<br/>"
                    + "        Booking Email: " + bookingTour.getBookingEmail() + "<br/>"
                    + "        Booking Phone: " + bookingTour.getBookingPhone() + "<br/>"
                    + "        Note: " + bookingTour.getNote() + "<br/>"
                    + "        <hr/>"
                    + "        Best regards,<br/>"
                    + "        Green Travel";

            SendMail.sendMail(bookingTour.getBookingEmail(), "GreenTravel - Cancel Booking", content);

        } catch (MessagingException ex) {
            Logger.getLogger(BookingTourManageServiceimpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "mybookingtour";

        // return "redirect:/customer/my-booking-tour";
    }

    @Override
    public String sendFeedback(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("bookingTourID"));
        String feedback = hsr.getParameter("feedback");
        LocalDate today = LocalDate.now();
        Date date = Date.valueOf(today);
        BookingTours bookingTour = bookingTourRepository.findById(id).get();
        bookingTour.setFeedBack(feedback);
        bookingTour.setDateOfFeedback(date);
        bookingTourRepository.save(bookingTour);
        return "mybookingtour";

    }

    @Override
    public void showQrMyBookingTour(HttpServletRequest hsr, HttpServletResponse response, int i) {
        OutputStream outputStream = null;
        try {
            String url = "http://172.16.160.84:8088/CP2296H01_GROUP1-1.0/qr-get-data-tour/" + i;
            response.setContentType("image/png");
            outputStream = response.getOutputStream();
            outputStream.write(ZXingHelper.getQrcodeimage(url, 200, 200));
            outputStream.flush();
        } catch (Exception e) {

        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                }
            }
        }

    }

    @Override
    public String showDataQr(Model model, int i) {
        BookingTours bookingTour = bookingTourRepository.findById(i).get();
        model.addAttribute("bookingTour", bookingTour);
        return "view_qr_tour";
    }

    @Override
    public String viewStatistic() {
        return "ad_statistic_tour";
    }

}
