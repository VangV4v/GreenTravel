/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Airlines;
import com.cusc.entities.Flights;
import com.cusc.entities.Provinces;
import java.sql.Date;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author kyqua
 */
public class FlightDTO extends AbstractDTO<Flights, FlightDTO> {

    private Integer flightID;

    @NotBlank(message = "Airplane Code is not empty")
    @Length(max = 255, message = "Airplane Code has max length 255 characters")
    private String airplaneCode;

    @NotBlank(message = "Flight Code is not empty")
    @Length(max = 255, message = "Flight Code has max length 255 characters")
    private String flightCode;

    @Range(min = 0,max = 100000000, message = "Price is invalid!")
    private Double businessPrice;

    @Range(min = 0,max = 100000000, message = "Price is invalid!")
    private Double economyPrice;

    private Date departureDate;  

    private int status;

    private Airlines airline;

    private Integer airlineID;

    private Provinces fromProvince;
    
    private Integer fromProvinceID;

    private Provinces toProvince;
    
    private Integer toProvinceID;

    @Override
    public Flights tranferToEntities() {
        Flights flight = new Flights();
        flight.setFlightID(flightID);
        flight.setAirplaneCode(airplaneCode);
        flight.setFlightCode(flightCode);
        flight.setBusinessPrice(businessPrice);
        flight.setEconomyPrice(economyPrice);
        flight.setDepartureDate(departureDate);      
        flight.setStatus(status);
        return flight;
    }

    @Override
    public void getData(Flights e) {
        setFlightID(e.getFlightID());
        setAirplaneCode(e.getAirplaneCode());
        setFlightCode(e.getFlightCode());
        setBusinessPrice(e.getBusinessPrice());
        setEconomyPrice(e.getEconomyPrice());
        setDepartureDate((Date) e.getDepartureDate());     
        setStatus(e.getStatus());
        setAirline(e.getAirlineID());
        setAirlineID(e.getAirlineID().getAirlineID());
        setFromProvince(e.getFromProvince());
        setFromProvinceID(e.getFromProvince().getProvinceID());
        setToProvince(e.getToProvince());
        setToProvinceID(e.getToProvince().getProvinceID());
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

    public Airlines getAirline() {
        return airline;
    }

    public void setAirline(Airlines airline) {
        this.airline = airline;
    }

    public Integer getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(Integer airlineID) {
        this.airlineID = airlineID;
    }

    public Provinces getFromProvince() {
        return fromProvince;
    }

    public void setFromProvince(Provinces fromProvince) {
        this.fromProvince = fromProvince;
    }

    public Integer getFromProvinceID() {
        return fromProvinceID;
    }

    public void setFromProvinceID(Integer formProvinceID) {
        this.fromProvinceID = formProvinceID;
    }

    public Provinces getToProvince() {
        return toProvince;
    }

    public void setToProvince(Provinces toProvince) {
        this.toProvince = toProvince;
    }

    public Integer getToProvinceID() {
        return toProvinceID;
    }

    public void setToProvinceID(Integer toProvinceID) {
        this.toProvinceID = toProvinceID;
    }

}
