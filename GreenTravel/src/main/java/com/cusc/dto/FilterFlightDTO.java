/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author kyqua
 */
public class FilterFlightDTO implements Serializable {
    private Integer fromProvinceID;  
    
    private Integer toProvinceID;

    private Date departureDate;

    public Integer getFromProvinceID() {
        return fromProvinceID;
    }

    public void setFromProvinceID(Integer fromProvinceID) {
        this.fromProvinceID = fromProvinceID;
    }

    public Integer getToProvinceID() {
        return toProvinceID;
    }

    public void setToProvinceID(Integer toProvinceID) {
        this.toProvinceID = toProvinceID;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
    
    
}
