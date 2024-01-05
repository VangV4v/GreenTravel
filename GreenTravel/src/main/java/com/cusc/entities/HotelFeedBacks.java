/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "HotelFeedBacks")
@NamedQueries({
    @NamedQuery(name = "HotelFeedBacks.findAll", query = "SELECT h FROM HotelFeedBacks h")})
public class HotelFeedBacks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FeedBackID")
    private Integer feedBackID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Message")
    private String message;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customers customerID;
    @JoinColumn(name = "HotelID", referencedColumnName = "HotelID")
    @ManyToOne(optional = false)
    private Hotels hotelID;

    public HotelFeedBacks() {
    }

    public HotelFeedBacks(Integer feedBackID) {
        this.feedBackID = feedBackID;
    }

    public HotelFeedBacks(Integer feedBackID, String message) {
        this.feedBackID = feedBackID;
        this.message = message;
    }

    public Integer getFeedBackID() {
        return feedBackID;
    }

    public void setFeedBackID(Integer feedBackID) {
        this.feedBackID = feedBackID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Customers getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customers customerID) {
        this.customerID = customerID;
    }

    public Hotels getHotelID() {
        return hotelID;
    }

    public void setHotelID(Hotels hotelID) {
        this.hotelID = hotelID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feedBackID != null ? feedBackID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelFeedBacks)) {
            return false;
        }
        HotelFeedBacks other = (HotelFeedBacks) object;
        if ((this.feedBackID == null && other.feedBackID != null) || (this.feedBackID != null && !this.feedBackID.equals(other.feedBackID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.HotelFeedBacks[ feedBackID=" + feedBackID + " ]";
    }
    
}
