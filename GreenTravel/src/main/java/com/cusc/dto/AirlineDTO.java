/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Airlines;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author kyqua
 */
public class AirlineDTO extends AbstractDTO<Airlines, AirlineDTO>{
    private Integer airlineID;
    
    @NotBlank(message = "Airline Name is not empty")
    @Length(max = 255, message = "Airline Name has max length 255 characters")
    private String name;
    
    @NotBlank(message = "Url is not empty")
    @Length(max = 255, message = "Url has max length 255 characters")
    private String url;
    
    @NotBlank(message = "Airline Company is not empty")
    @Length(max = 255, message = "Airline Company has max length 255 characters")
    private String company;
    
    @Override
    public Airlines tranferToEntities() {
       Airlines airline = new Airlines();
       airline.setAirlineID(airlineID);
       airline.setName(name);
       airline.setUrl(url);
       airline.setCompany(company);
       return airline;
    }

    @Override
    public void getData(Airlines e) {
        setAirlineID(e.getAirlineID());
        setName(e.getName());
        setUrl(e.getUrl());
        setCompany(e.getCompany());
    }

    public Integer getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(Integer airlineID) {
        this.airlineID = airlineID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
