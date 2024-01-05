/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.bef.ZXingHelper;
import com.cusc.defautvar.StatusOnDatabase;
import com.cusc.dto.BookingCarDTO;
import com.cusc.dto.CarDTO;
import com.cusc.email.SendMail;
import com.cusc.entities.BookingCars;
import com.cusc.entities.Cars;
import com.cusc.entities.Customers;
import com.cusc.entities.DriverInBookingCars;
import com.cusc.entities.Drivers;
import com.cusc.entities.Employees;
import com.cusc.repositories.BookingCarsRepository;
import com.cusc.repositories.CarModelsRepository;
import com.cusc.repositories.CarsRepository;
import com.cusc.repositories.CustomersRepository;
import com.cusc.repositories.DriverInBookingCarsRepository;
import com.cusc.repositories.DriversRepository;
import com.cusc.repositories.EmployeesRepository;
import com.cusc.repositories.TypeCarsRepository;
import com.cusc.repositories.hql.CarsHQL;
import com.cusc.repositories.hql.CustomersHQL;
import com.cusc.service.CarRentalService;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
@Service
public class CarRentalServiceimpl implements CarRentalService {

    @Autowired
    private BookingCarsRepository bookingCarsRepository;

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private CarModelsRepository carModelsRepository;

    @Autowired
    private TypeCarsRepository typeCarsRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private DriversRepository driversRepository;

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private DriverInBookingCarsRepository driverInBookingCarsRepository;

    @Autowired
    private CustomersHQL customersHQL;

    @Autowired
    private CarsHQL carsHQL;

    @Override
    public String filterClientCarRental(CarDTO dto, Model model) {
        model.addAttribute("filterCar", dto);
        model.addAttribute("searchCar", dto);
        model.addAttribute("listCarModel", carModelsRepository.findAll());
        model.addAttribute("listCarType", typeCarsRepository.findAll());
        model.addAttribute("listCar", carsHQL.findAllByTypeIDAndModelID(dto.getCarTypeID(), dto.getCarModelID()));
        return "carrental";
    }

    @Override
    public String searchClientCarRental(CarDTO cardto, Model model) {
        model.addAttribute("filterCar", cardto);
        model.addAttribute("searchCar", cardto);
        model.addAttribute("listCarModel", carModelsRepository.findAll());
        model.addAttribute("listCarType", typeCarsRepository.findAll());
        model.addAttribute("listCar", carsHQL.findAllByCarName(cardto.getCarName()));
        return "carrental";
    }

    @Override
    public String paginationClientCarRental(Model model, int pageIndex) {
        int pageSize = 6;
        int maxPage = 2;
        int totalRecord = carsRepository.findAll().size();
        int totalPage = (int) Math.ceil(Double.valueOf(totalRecord) / Double.valueOf(pageSize));
        Pageable pageable = PageRequest.of((pageIndex - 1), pageSize);
        List<Cars> listCar = carsRepository.findAll(pageable).getContent();
        int startPage = pageIndex - (int) maxPage / 2;
        int endPage = pageIndex + (int) maxPage / 2;
        CarDTO dtoCar = new CarDTO();
        if (startPage <= 0) {
            if (totalPage < maxPage) {
                endPage = totalPage;
            }
            endPage = maxPage;
            startPage = 1;
        }
        if (endPage > totalPage) {
            endPage = totalPage;
            if (endPage > maxPage) {
                startPage = endPage - (maxPage - 1);
            }
        }
        model.addAttribute("totalRecord", totalRecord);
        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("pagination", "pagination");

        model.addAttribute("filterCar", dtoCar);
        model.addAttribute("searchCar", dtoCar);
        model.addAttribute("listCarModel", carModelsRepository.findAll());
        model.addAttribute("listCarType", typeCarsRepository.findAll());
        model.addAttribute("listCar", listCar);
        return "carrental";
    }

    @Override
    public String bookingCar(Model model, int i) {
        Cars car = carsRepository.findById(i).get();
        BookingCarDTO bookingCarDTO = new BookingCarDTO();
        model.addAttribute("bookingcar", bookingCarDTO);
        model.addAttribute("car", car);
        return "viewbookingcar";
    }

    @Override
    public String bookingCar(BookingCarDTO bcdto, BindingResult br, Model model, HttpServletRequest request, Principal principal, int i) {
        int checkDateReturn = bcdto.getReturnDate().compareTo(bcdto.getRentalDate());
        Cars car;
        Customers customer;
        Employees emp;
        BookingCars bookingCars;
        Drivers drivers = new Drivers();

        DriverInBookingCars driverInBookingCars = new DriverInBookingCars();
        if (br.hasErrors()) {
            car = carsRepository.findById(i).get();
            model.addAttribute("bookingcar", bcdto);
            model.addAttribute("car", car);
            return "viewbookingcar";
        }
        if (checkDateReturn == 0 || checkDateReturn == -1) {
            br.rejectValue("returnDate", "500", "Return day must greater than rental day");
            car = carsRepository.findById(i).get();
            model.addAttribute("bookingcar", bcdto);
            model.addAttribute("car", car);
            return "viewbookingcar";
        }
        if (bcdto.isDriver()) {
            drivers = getDriverAuto(bcdto.getRentalDate(), bcdto.getReturnDate());
            if (drivers == null) {
                br.rejectValue("driver", "500", "Driver is not avaiable");
                car = carsRepository.findById(i).get();
                model.addAttribute("bookingcar", bcdto);
                model.addAttribute("car", car);
                return "viewbookingcar";
            }
        }
        bcdto.setStatus(StatusOnDatabase.STATUS_INT_ENABLE);
        bookingCars = bcdto.tranferToEntities();
        customer = customersHQL.loadByUsername(principal.getName());
        emp = getEmployeeAuto();
        car = carsRepository.findById(i).get();
        bookingCars.setCarID(car);
        bookingCars.setCustomerID(customer);
        bookingCars.setEmployeeID(emp);
        bookingCarsRepository.save(bookingCars);
        try {
            String content = " <div>We noticed that you - " +bookingCars.getEmployeeID().getUsername()+" have to confirm booking car. Pleased go to website to confirm booking car for customer.</div><br/>"
                   + "        <hr/>"
                + "        <strong>Customer Booking:</strong><br/>"
                + "        Car Name: " + bookingCars.getCarID().getCarName() + "<br/>"
                + "        Rental Date: " + bookingCars.getRentalDate() + "<br/>"
                + "        Return Date: " + bookingCars.getReturnDate() + "<br/>"
                + "        Total Price: " + bookingCars.getPrice() + "<br/>"
                + "        Booking Name: " + bookingCars.getRentalName() + "<br/>"
                + "        Booking Email: " + bookingCars.getRentalEmail() + "<br/>"
                + "        Booking Phone: " + bookingCars.getRentalPhone() + "<br/>"
                + "        Note: " + bookingCars.getNote() + "<br/>"
                + "        <hr/>"
                + "        Best regards,<br/>"
                + "        Green Travel";

            SendMail.sendMail(bookingCars.getEmployeeID().getEmail(), "GreenTravel - Request Booking", content);
        } catch (Exception ex) {          
        }
        try {
            SendMail.sendMail(bookingCars.getRentalEmail(), "Booking Car From GreenTravel", getContentBookingCar(bookingCars));
        } catch (Exception e) {
        }
        if (bcdto.isDriver()) {
            driverInBookingCars.setDriverID(drivers);
            driverInBookingCars.setBookingCarID(bookingCars);
            driverInBookingCarsRepository.save(driverInBookingCars);
        }
        return "redirect:/customer/my-booking-car?success=true";
    }

    private Drivers getDriverAuto(Date start, Date end) {
        List<Drivers> listDriver = driversRepository.findAll();
        for (Drivers drivers : listDriver) {
            if (drivers.getDriverInBookingCarsList().isEmpty()) {
                System.out.println("----------1" + drivers.toString());
                return drivers;
            }
        }
        if (!driversRepository.findAllByRentalDay(start).isEmpty()) {
            System.out.println("----------2" + driversRepository.findAllByRentalDay(start).toString());
            return driversRepository.findAllByRentalDay(start).get(0);
        }
        if (!driversRepository.findAllByReturnDay(end).isEmpty()) {
            System.out.println("----------3" + driversRepository.findAllByReturnDay(end).toString());
            return driversRepository.findAllByReturnDay(end).get(0);
        }
        return null;
    }

    private Employees getEmployeeAuto() {      
        List<Employees> listEp = employeesRepository.findAll(Sort.by(Sort.Direction.ASC, "employeeID"));
        Employees minEmp = listEp.get(0);
        for (Employees employees : listEp) {
            if (employees.getRoleID().getRoleID() == 2) {
                if (employees.getBookingCarsList().size() < minEmp.getBookingCarsList().size()) {
                    minEmp = employees;
                }
            }
        }
        return minEmp;
    }

    @Override
    public String showMyBooking(Model model, Principal prncpl) {
        LocalDate today = LocalDate.now();
        Date date = Date.valueOf(today);
        Customers customers = customersRepository.findByUsername(prncpl.getName());
        List<BookingCars> listBookingCar = customers.getBookingCarsList();
        model.addAttribute("listBookingCar", listBookingCar);
        model.addAttribute("today", date);
        return "mybookingcar";
    }

    @Override
    public String stopBookingCar(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("bookingCarID"));
        double priceAfterStop = 0;
        BookingCars bookingCars = bookingCarsRepository.findById(id).get();
        bookingCars.setStatus(-1);
        bookingCarsRepository.save(bookingCars);
        LocalDate today = LocalDate.now();
        Date dateStopBooking = Date.valueOf(today);
        Date dateStart = bookingCars.getRentalDate();
        long day = (dateStart.getTime() - dateStopBooking.getTime()) / (24 * 3600 * 1000);
        if (day >= 5) {
            priceAfterStop = bookingCars.getPrice() - (bookingCars.getPrice() * 0.05);
        } else if (day == 4) {
            priceAfterStop = bookingCars.getPrice() - (bookingCars.getPrice() * 0.1);
        } else if (day == 3) {
            priceAfterStop = bookingCars.getPrice() - (bookingCars.getPrice() * 0.15);
        } else if (day == 2) {
            priceAfterStop = bookingCars.getPrice() - (bookingCars.getPrice() * 0.2);
        } else {
            priceAfterStop = bookingCars.getPrice() - (bookingCars.getPrice() * 0.25);
        }
        try {
            SendMail.sendMail(bookingCars.getRentalEmail(), "Stop Booking Car", getContentStopBookingCar(bookingCars, priceAfterStop));
        } catch (Exception e) {
          
        }
       

        return "mybookingcar";
    }

    @Override
    public void showQrMyBookingCar(HttpServletRequest hsr, HttpServletResponse response, int i) {
        OutputStream outputStream = null;
        try {
            String url = "http://172.16.160.84:8088/CP2296H01_GROUP1-1.0/qr-get-data/" + i;
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
        BookingCars bookingCars = bookingCarsRepository.findById(i).get();
        model.addAttribute("bookingcar", bookingCars);
        return "view_qr";
    }

    @Override
    public String sendFeedback(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("bookingCarID"));
        String value = request.getParameter("feedback");
        BookingCars bkc = bookingCarsRepository.findById(id).get();
        bkc.setDateOfFeedBack(Date.valueOf(LocalDate.now()));
        bkc.setFeedBack(value);
        bookingCarsRepository.save(bkc);
        return "redirect:/customer/my-booking-car";
    }

    private String getContentBookingCar(BookingCars bookingCars) {
        String content = " <div>We noticed that you have to confirm booking car. Pleased go to website to confirm booking car for customer.</div><br/>"
                + "        <hr/>"
                + "        <strong>Customer Booking:</strong><br/>"
                + "        Car Name: " + bookingCars.getCarID().getCarName() + "<br/>"
                + "        Rental Date: " + bookingCars.getRentalDate() + "<br/>"
                + "        Return Date: " + bookingCars.getReturnDate() + "<br/>"
                + "        Total Price: " + bookingCars.getPrice() + "<br/>"
                + "        Booking Name: " + bookingCars.getRentalName() + "<br/>"
                + "        Booking Email: " + bookingCars.getRentalEmail() + "<br/>"
                + "        Booking Phone: " + bookingCars.getRentalPhone() + "<br/>"
                + "        Note: " + bookingCars.getNote() + "<br/>"
                + "        <hr/>"
                + "        Best regards,<br/>"
                + "        Green Travel";
               
        return content;
    }

    private String getContentStopBookingCar(BookingCars bookingCars, double refundPrice) {
        String content = " <div>We noticed that you have to confirm stop booking car. Pleased go to website to confirm stop booking car for customer.</div><br/>"
                + "        <hr/>"
                + "        <strong>Customer Booking:</strong><br/>"
                + "        Car Name: " + bookingCars.getCarID().getCarName() + "<br/>"
                + "        Rental Date: " + bookingCars.getRentalDate() + "<br/>"
                + "        Return Date: " + bookingCars.getReturnDate() + "<br/>"
                + "        Total Price: " + bookingCars.getPrice() + "<br/>"
                + "        Total Price Refund: " + refundPrice + "<br/>"
                + "        Date Stop: " + LocalDateTime.now() + "<br/>"
                + "        Booking Name: " + bookingCars.getRentalName() + "<br/>"
                + "        Booking Email: " + bookingCars.getRentalEmail() + "<br/>"
                + "        Booking Phone: " + bookingCars.getRentalPhone() + "<br/>"
                + "        Note: " + bookingCars.getNote() + "<br/>"
                + "        <hr/>"
                + "        Best regards,<br/>"
                + "        Green Travel";
              
        return content;
    }

}
