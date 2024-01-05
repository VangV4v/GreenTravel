/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Areas;
import com.cusc.entities.Provinces;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author kyqua
 */
public class AreaDTO extends AbstractDTO<Areas, AreaDTO> {

    private Integer areaID;

 
    @NotBlank(message = "Name cannot be empty")
    @Length(max = 255, message = "Name has max length 255 characters")
    private String name;

    private Integer provinceID;

    private Provinces province;

    @Override
    public Areas tranferToEntities() {
        Areas area = new Areas();
        area.setAreaID(areaID);      
        area.setName(name);
        return area;
    }

    @Override
    public void getData(Areas e) {
        setAreaID(e.getAreaID());
        setName(e.getName());     
        setProvinceID(e.getProvinceID().getProvinceID());
        setProvince(e.getProvinceID());
    }

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public Provinces getProvince() {
        return province;
    }

    public void setProvince(Provinces province) {
        this.province = province;
    }

   
}
