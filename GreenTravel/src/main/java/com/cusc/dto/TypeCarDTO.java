/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.TypeCars;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author kyqua
 */
public class TypeCarDTO extends AbstractDTO<TypeCars, TypeCarDTO> {

    private Integer carTypeID;
    @NotEmpty(message = "Type car name is not empty")
    private String carTypeName;
    @NotEmpty(message = "Type car description is not empty")
    private String carTypeDescription;

    @Override
    public TypeCars tranferToEntities() {
        TypeCars typecar = new TypeCars();
        typecar.setCarTypeID(carTypeID);
        typecar.setCarTypeName(carTypeName);
        typecar.setCarTypeDescription(carTypeDescription);
        return typecar;
    }

    @Override
    public void getData(TypeCars e) {
        setCarTypeID(e.getCarTypeID());
        setCarTypeName(e.getCarTypeName());
        setCarTypeDescription(e.getCarTypeDescription());
    }

    public Integer getCarTypeID() {
        return carTypeID;
    }

    public void setCarTypeID(Integer carTypeID) {
        this.carTypeID = carTypeID;
    }

    public String getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName;
    }

    public String getCarTypeDescription() {
        return carTypeDescription;
    }

    public void setCarTypeDescription(String carTypeDescription) {
        this.carTypeDescription = carTypeDescription;
    }

}
