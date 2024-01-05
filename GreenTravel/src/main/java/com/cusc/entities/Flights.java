/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "Flights")
@NamedQueries({
    @NamedQuery(name = "Flights.findAll", query = "SELECT f FROM Flights f")})
public class Flights implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FlightID")
    private Integer flightID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "AirplaneCode")
    private String airplaneCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FlightCode")
    private String flightCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "BusinessPrice")
    private Double businessPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EconomyPrice")
    private Double economyPrice;
    
    @Column(name = "DepartureDate")
    private Date departureDate;      
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private int status;
    @JoinColumn(name = "AirlineID", referencedColumnName = "AirlineID")
    @ManyToOne(optional = false)
    private Airlines airlineID;
    @JoinColumn(name = "FromProvince", referencedColumnName = "ProvinceID")
    @ManyToOne(optional = false)
    private Provinces fromProvince;
    @JoinColumn(name = "ToProvince", referencedColumnName = "ProvinceID")
    @ManyToOne(optional = false)
    private Provinces toProvince;

    public Flights() {
    }

    public Flights(Integer flightID) {
        this.flightID = flightID;
    }

    public Flights(Integer flightID, String airplaneCode, String flightCode, Double businessPrice, Double economyPrice, int status) {
        this.flightID = flightID;
        this.airplaneCode = airplaneCode;
        this.flightCode = flightCode;
        this.businessPrice = businessPrice;
        this.economyPrice = economyPrice;    
        this.status = status;
    }

    public Integer getFlightID() {
        return flightID;
    }

    public void setFlightID(Integer flightID) {
        this.flightID = flightID;
    }

    public String getAirplaneCode() {
        return airplaneCode;
    }

    public void setAirplaneCode(String airplaneCode) {
        this.airplaneCode = airplaneCode;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public Double getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(Double businessPrice) {
        this.businessPrice = businessPrice;
    }

    public Double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(Double economyPrice) {
        this.economyPrice = economyPrice;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Airlines getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(Airlines airlineID) {
        this.airlineID = airlineID;
    }

    public Provinces getFromProvince() {
        return fromProvince;
    }

    public void setFromProvince(Provinces fromProvince) {
        this.fromProvince = fromProvince;
    }

    public Provinces getToProvince() {
        return toProvince;
    }

    public void setToProvince(Provinces toProvince) {
        this.toProvince = toProvince;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightID != null ? flightID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flights)) {
            return false;
        }
        Flights other = (Flights) object;
        if ((this.flightID == null && other.flightID != null) || (this.flightID != null && !this.flightID.equals(other.flightID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.Flights[ flightID=" + flightID + " ]";
    }
    
}
