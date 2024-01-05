/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.BookingCars;
import com.cusc.validatorcustom.CheckDateByToDay;
import java.sql.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author kyqua
 */
public class BookingCarDTO extends AbstractDTO<BookingCars, BookingCarDTO> {

    private Integer bookingCarID;
    @CheckDateByToDay
    private Date rentalDate;
    @NotBlank(message = "Name is not empty")
    @Length(max = 255, message = "Retalname must less than 255 character")
    private String rentalName;
    @NotBlank(message = "Email is not empty")
    @Email(message = "Email is incorrect format ")
    private String rentalEmail;
    @Pattern(regexp = "0[0-9]{9,11}", message = "Phone must begin with 0 and must has 10 to 12 number")
    private String rentalPhone;
    @NotBlank(message = "Address is not empty ")
    @Length(max = 255, message = "Address must less than 255 character")
    private String rentalAddress;
    @Length(max = 255, message = "Note must less than 255 character")
    private String note;
    @CheckDateByToDay
    private Date returnDate;
    private boolean driver;
    private String feedBack;
    private double price;
    private Date dateOfFeedBack;
    private int status;

    private long employeeID;
    private long customerID;
    private int carID;

    @Override
    public BookingCars tranferToEntities() {
        BookingCars bookingCars = new BookingCars();
        bookingCars.setBookingCarID(bookingCarID);
        bookingCars.setDateOfFeedBack(dateOfFeedBack);
        bookingCars.setDriver(driver);
        bookingCars.setFeedBack(feedBack);
        bookingCars.setNote(note);
        bookingCars.setPrice(price);
        bookingCars.setRentalAddress(rentalAddress);
        bookingCars.setRentalDate(rentalDate);
        bookingCars.setRentalEmail(rentalEmail);
        bookingCars.setRentalName(rentalName);
        bookingCars.setRentalPhone(rentalPhone);
        bookingCars.setReturnDate(returnDate);
        bookingCars.setStatus(status);
        return bookingCars;
    }

    @Override
    public void getData(BookingCars e) {
        setBookingCarID(e.getBookingCarID());
        setCarID(e.getCarID().getCarID());
        setCustomerID(e.getCustomerID().getCustomerID());
        setDateOfFeedBack(e.getDateOfFeedBack());
        setDriver(e.getDriver());
        setEmployeeID(e.getEmployeeID().getEmployeeID());
        setFeedBack(e.getFeedBack());
        setNote(e.getNote());
        setPrice(e.getPrice());
        setRentalAddress(e.getRentalAddress());
        setRentalDate(e.getRentalDate());
        setRentalName(e.getRentalName());
        setRentalPhone(e.getRentalPhone());
        setReturnDate(e.getReturnDate());
        setStatus(e.getStatus());
    }

    public Integer getBookingCarID() {
        return bookingCarID;
    }

    public void setBookingCarID(Integer bookingCarID) {
        this.bookingCarID = bookingCarID;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getRentalName() {
        return rentalName;
    }

    public void setRentalName(String rentalName) {
        this.rentalName = rentalName;
    }

    public String getRentalEmail() {
        return rentalEmail;
    }

    public void setRentalEmail(String rentalEmail) {
        this.rentalEmail = rentalEmail;
    }

    public String getRentalPhone() {
        return rentalPhone;
    }

    public void setRentalPhone(String rentalPhone) {
        this.rentalPhone = rentalPhone;
    }

    public String getRentalAddress() {
        return rentalAddress;
    }

    public void setRentalAddress(String rentalAddress) {
        this.rentalAddress = rentalAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isDriver() {
        return driver;
    }

    public void setDriver(boolean driver) {
        this.driver = driver;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateOfFeedBack() {
        return dateOfFeedBack;
    }

    public void setDateOfFeedBack(Date dateOfFeedBack) {
        this.dateOfFeedBack = dateOfFeedBack;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

}
