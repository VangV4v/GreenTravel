/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "BookingTours")
@NamedQueries({
    @NamedQuery(name = "BookingTours.findAll", query = "SELECT b FROM BookingTours b")})
public class BookingTours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BookingTourID")
    private Integer bookingTourID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QuantityAdult")
    private int quantityAdult;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QuantityChildren")
    private int quantityChildren;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BookDate")
    private Date bookDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "TotalPrice")
    private Double totalPrice;
    @Size(max = 255)
    @Column(name = "Note")
    private String note;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "FeedBack")
    private String feedBack;
    @Column(name = "DateOfFeedback")
    private Date dateOfFeedback;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private int status;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "BookingName")
    private String bookingName;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "BookingEmail")
    private String bookingEmail;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "BookingPhone")
    private String bookingPhone;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customers customerID;
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    @ManyToOne(optional = false)
    private Employees employeeID;
    @JoinColumn(name = "PackageTourID", referencedColumnName = "PackageTourID")
    @ManyToOne(optional = false)
    private PackageTours packageTourID;

    public BookingTours() {
    }

    public BookingTours(Integer bookingTourID) {
        this.bookingTourID = bookingTourID;
    }

    public BookingTours(Integer bookingTourID, int quantityAdult, int quantityChildren, Date bookDate, Double totalPrice, String feedBack, int status, String bookingName, String bookingEmail, String bookingPhone) {
        this.bookingTourID = bookingTourID;
        this.quantityAdult = quantityAdult;
        this.quantityChildren = quantityChildren;
        this.bookDate = bookDate;
        this.totalPrice = totalPrice;
        this.feedBack = feedBack;
        this.status = status;
        this.bookingName = bookingName;
        this.bookingEmail = bookingEmail;
        this.bookingPhone = bookingPhone;
    }

    public Integer getBookingTourID() {
        return bookingTourID;
    }

    public void setBookingTourID(Integer bookingTourID) {
        this.bookingTourID = bookingTourID;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
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

    public Date getDateOfFeedback() {
        return dateOfFeedback;
    }

    public void setDateOfFeedback(Date dateOfFeedback) {
        this.dateOfFeedback = dateOfFeedback;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public PackageTours getPackageTourID() {
        return packageTourID;
    }

    public void setPackageTourID(PackageTours packageTourID) {
        this.packageTourID = packageTourID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingTourID != null ? bookingTourID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingTours)) {
            return false;
        }
        BookingTours other = (BookingTours) object;
        if ((this.bookingTourID == null && other.bookingTourID != null) || (this.bookingTourID != null && !this.bookingTourID.equals(other.bookingTourID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.BookingTours[ bookingTourID=" + bookingTourID + " ]";
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
