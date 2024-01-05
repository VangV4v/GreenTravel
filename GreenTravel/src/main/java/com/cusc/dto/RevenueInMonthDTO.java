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
public class RevenueInMonthDTO implements Serializable{
    
    private String label;
    
    private Double revenue;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }  

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }
    
    
}
