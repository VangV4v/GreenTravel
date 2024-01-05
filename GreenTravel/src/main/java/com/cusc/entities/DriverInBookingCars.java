/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "DriverInBookingCars")
@NamedQueries({
    @NamedQuery(name = "DriverInBookingCars.findAll", query = "SELECT d FROM DriverInBookingCars d")})
public class DriverInBookingCars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DriverInBookingCarID")
    private Integer driverInBookingCarID;
    @Size(max = 255)
    @Column(name = "Note")
    private String note;
    @JoinColumn(name = "BookingCarID", referencedColumnName = "BookingCarID")
    @ManyToOne(optional = false)
    private BookingCars bookingCarID;
    @JoinColumn(name = "DriverID", referencedColumnName = "DriverID")
    @ManyToOne(optional = false)
    private Drivers driverID;

    public DriverInBookingCars() {
    }

    public DriverInBookingCars(Integer driverInBookingCarID) {
        this.driverInBookingCarID = driverInBookingCarID;
    }

    public Integer getDriverInBookingCarID() {
        return driverInBookingCarID;
    }

    public void setDriverInBookingCarID(Integer driverInBookingCarID) {
        this.driverInBookingCarID = driverInBookingCarID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BookingCars getBookingCarID() {
        return bookingCarID;
    }

    public void setBookingCarID(BookingCars bookingCarID) {
        this.bookingCarID = bookingCarID;
    }

    public Drivers getDriverID() {
        return driverID;
    }

    public void setDriverID(Drivers driverID) {
        this.driverID = driverID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (driverInBookingCarID != null ? driverInBookingCarID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DriverInBookingCars)) {
            return false;
        }
        DriverInBookingCars other = (DriverInBookingCars) object;
        if ((this.driverInBookingCarID == null && other.driverInBookingCarID != null) || (this.driverInBookingCarID != null && !this.driverInBookingCarID.equals(other.driverInBookingCarID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.DriverInBookingCars[ driverInBookingCarID=" + driverInBookingCarID + " ]";
    }
    
}
