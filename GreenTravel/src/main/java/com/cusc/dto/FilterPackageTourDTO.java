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
public class FilterPackageTourDTO implements Serializable{
    
    private Integer fromProvinceID;
    
    private Integer toProvinceID;
       
    private Date date;
    
    private Double price;
    
    private String keyword;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    
}
