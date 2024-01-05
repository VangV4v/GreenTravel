/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Provinces;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author kyqua
 */
public class ProvinceDTO extends AbstractDTO<Provinces, ProvinceDTO> {

    private Integer provinceID;

    @NotBlank(message = "Province Code is not empty")
    @Length(max = 10, message = "Name has max length 10 characters")
    private String provinceCode;

    @NotBlank(message = "Province Name is not empty")
    @Length(max = 255, message = "Name has max length 255 characters")
    private String name;
    
     @NotBlank(message = "Airport Name is not empty")
    @Length(max = 255, message = "Airport Name has max length 255 characters")
    private String airportName;

    @Override
    public Provinces tranferToEntities() {
       Provinces province = new Provinces();
       province.setProvinceID(provinceID);
       province.setProvinceCode(provinceCode);
       province.setName(name);
       province.setAirportName(airportName);
       return province;
    }

    @Override
    public void getData(Provinces e) {
        setProvinceID(e.getProvinceID());
        setProvinceCode(e.getProvinceCode());
        setAirportName(e.getAirportName());
        setName(e.getName());
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
    
    
}
