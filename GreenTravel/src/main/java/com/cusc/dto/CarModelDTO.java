/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.CarModels;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author kyqua
 */
public class CarModelDTO extends AbstractDTO<CarModels, CarModelDTO> {

    private Integer carModelID;
    @NotBlank(message = "Name is not empty")
    private String name;
    @NotBlank(message = "Company name is not empty")
    private String companyName;
    @NotBlank(message = "Url is not empty")
    private String url;
    @NotBlank(message = "Country is not empty")
    private String country;

    @Override
    public CarModels tranferToEntities() {
        CarModels carModels = new CarModels();
        carModels.setCarModelID(carModelID);
        carModels.setCompanyName(companyName);
        carModels.setCountry(country);
        carModels.setUrl(url);
        carModels.setName(name);
        return carModels;
    }

    @Override
    public void getData(CarModels e) {
        setCarModelID(e.getCarModelID());
        setCompanyName(e.getCompanyName());
        setCountry(e.getCountry());
        setName(e.getName());
        setUrl(e.getUrl());
    }

    public Integer getCarModelID() {
        return carModelID;
    }

    public void setCarModelID(Integer carModelID) {
        this.carModelID = carModelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
