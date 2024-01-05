/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "BookingCars")
@NamedQueries({
    @NamedQuery(name = "BookingCars.findAll", query = "SELECT b FROM BookingCars b")})
public class BookingCars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BookingCarID")
    private Integer bookingCarID;
    @Column(name = "RentalDate")
    private Date rentalDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RentalName")
    private String rentalName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RentalEmail")
    private String rentalEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RentalPhone")
    private String rentalPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RentalAddress")
    private String rentalAddress;
    @Basic(optional = false)
    @Column(name = "Note")
    private String note;
    @Column(name = "ReturnDate")
    private Date returnDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Driver")
    private boolean driver;
    @Size(max = 500)
    @Column(name = "FeedBack")
    private String feedBack;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private double price;
    @Column(name = "DateOfFeedBack")
    private Date dateOfFeedBack;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingCarID")
    private List<DriverInBookingCars> driverInBookingCarsList;
    @JoinColumn(name = "CarID", referencedColumnName = "CarID")
    @ManyToOne(optional = false)
    private Cars carID;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customers customerID;
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    @ManyToOne(optional = false)
    private Employees employeeID;

    public BookingCars() {
    }

    public BookingCars(Integer bookingCarID) {
        this.bookingCarID = bookingCarID;
    }

    public BookingCars(Integer bookingCarID, String rentalName, String rentalEmail, String rentalPhone, String rentalAddress, String note, boolean driver, double price, int status) {
        this.bookingCarID = bookingCarID;
        this.rentalName = rentalName;
        this.rentalEmail = rentalEmail;
        this.rentalPhone = rentalPhone;
        this.rentalAddress = rentalAddress;
        this.note = note;
        this.driver = driver;
        this.price = price;
        this.status = status;
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

    public boolean getDriver() {
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

    public List<DriverInBookingCars> getDriverInBookingCarsList() {
        return driverInBookingCarsList;
    }

    public void setDriverInBookingCarsList(List<DriverInBookingCars> driverInBookingCarsList) {
        this.driverInBookingCarsList = driverInBookingCarsList;
    }

    public Cars getCarID() {
        return carID;
    }

    public void setCarID(Cars carID) {
        this.carID = carID;
    }

    public Customers getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customers customerID) {
        this.customerID = customerID;
    }

    public Employees getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employees employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingCarID != null ? bookingCarID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingCars)) {
            return false;
        }
        BookingCars other = (BookingCars) object;
        if ((this.bookingCarID == null && other.bookingCarID != null) || (this.bookingCarID != null && !this.bookingCarID.equals(other.bookingCarID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.BookingCars[ bookingCarID=" + bookingCarID + " ]";
    }

}
