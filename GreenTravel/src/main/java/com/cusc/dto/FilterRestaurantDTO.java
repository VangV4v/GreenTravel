/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import java.io.Serializable;

/**
 *
 * @author kyqua
 */
public class FilterRestaurantDTO implements  Serializable{
    
    private String keyword;
    
    private Integer rateStar;
    
    private Integer destinationID;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getRateStar() {
        return rateStar;
    }

    public void setRateStar(Integer rateStar) {
        this.rateStar = rateStar;
    }

    public Integer getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Integer destinationID) {
        this.destinationID = destinationID;
    }
    
    
}
