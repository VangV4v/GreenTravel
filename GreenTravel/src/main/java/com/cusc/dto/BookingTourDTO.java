/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.BookingTours;
import com.cusc.entities.Customers;
import com.cusc.entities.Employees;
import com.cusc.entities.PackageTours;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author kyqua
 */
public class BookingTourDTO extends AbstractDTO<BookingTours, BookingTourDTO> {

    private Integer bookingTourID;

    private int quantityAdult;

    private int quantityChildren;

    private Double totalPrice;

    @Length(max = 255, message = "Note has max length 255 characters")
    private String note;

    @NotBlank(message = "Booking name cannot be empty")
    @Length(max = 255, message = "Booking name has max length 255 characters")
    private String bookingName;

    @NotBlank(message = "Booking email cannot be empty")
    @Length(max = 255, message = "Booking email has max length 255 characters")
    private String bookingEmail;

    @NotBlank(message = "Booking phone cannot be empty")
    @Length(max = 255, message = "Booking phoneG has max length 255 characters")
    private String bookingPhone;

    private String feedBack;

    private Customers customer;

    private Long CustomerID;

    private Employees employee;

    private Long employeeID;

    private PackageTours packageTour;

    private Integer packageTourID;

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getBookingTourID() {
        return bookingTourID;
    }

    public void setBookingTourID(Integer bookingTourID) {
        this.bookingTourID = bookingTourID;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Long CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public PackageTours getPackageTour() {
        return packageTour;
    }

    public void setPackageTour(PackageTours packageTour) {
        this.packageTour = packageTour;
    }

    public Integer getPackageTourID() {
        return packageTourID;
    }

    public void setPackageTourID(Integer packageTourID) {
        this.packageTourID = packageTourID;
    }

    @Override
    public BookingTours tranferToEntities() {
        BookingTours bookingTours = new BookingTours();
        bookingTours.setBookingTourID(bookingTourID);
        bookingTours.setQuantityAdult(quantityAdult);
        bookingTours.setQuantityChildren(quantityChildren);
        bookingTours.setTotalPrice(totalPrice);
        bookingTours.setNote(note);
        bookingTours.setBookingName(bookingName);
        bookingTours.setBookingEmail(bookingEmail);
        bookingTours.setBookingPhone(bookingPhone);
        bookingTours.setFeedBack(feedBack);
        bookingTours.setStatus(status);
        return bookingTours;
    }

    @Override
    public void getData(BookingTours e) {
        setBookingTourID(e.getBookingTourID());
        setQuantityAdult(e.getQuantityAdult());
        setQuantityChildren(e.getQuantityChildren());
        setTotalPrice(e.getTotalPrice());
        setNote(e.getNote());
        setFeedBack(e.getFeedBack());
        setBookingName(e.getBookingName());
        setBookingPhone(e.getBookingPhone());
        setBookingEmail(e.getBookingEmail());
        setCustomer(e.getCustomerID());
        setCustomerID(e.getCustomerID().getCustomerID());
        setEmployee(e.getEmployeeID());
        setEmployeeID(e.getEmployeeID().getEmployeeID());
        setPackageTour(e.getPackageTourID());
        setPackageTourID(e.getPackageTourID().getPackageTourID());
        setStatus(e.getStatus());
    }

    public int getQuantityAdult() {
        return quantityAdult;
    }

    public void setQuantityAdult(int quantityAdult) {
        this.quantityAdult = quantityAdult;
    }

    public int getQuantityChildren() {
        return quantityChildren;
    }

    public void setQuantityChildren(int quantityChildren) {
        this.quantityChildren = quantityChildren;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public String getBookingEmail() {
        return bookingEmail;
    }

    public void setBookingEmail(String bookingEmail) {
        this.bookingEmail = bookingEmail;
    }

    public String getBookingPhone() {
        return bookingPhone;
    }

    public void setBookingPhone(String bookingPhone) {
        this.bookingPhone = bookingPhone;
    }

}
