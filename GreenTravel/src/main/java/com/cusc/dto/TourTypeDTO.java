/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.TourTypes;
import static java.lang.Integer.min;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author kyqua
 */
public class TourTypeDTO extends AbstractDTO<TourTypes, TourTypeDTO> {

    private Integer tourTypeID;

    @NotBlank(message = "Name cannot be empty")
    @Length(max = 255, message = "Name has max length 255 characters")
    private String name;

    @NotBlank(message = "Description cannot be empty")
    @Length(max = 255, message = "Description has max length 255 characters")
    private String description;

    @Override
    public TourTypes tranferToEntities() {
        TourTypes tourTypes = new TourTypes();
        tourTypes.setTourTypeID(tourTypeID);
        tourTypes.setName(name);
        tourTypes.setDescription(description);
        return tourTypes;
    }

    @Override
    public void getData(TourTypes e) {
        setTourTypeID(e.getTourTypeID());
        setName(e.getName());
        setDescription(e.getDescription());
    }

    public Integer getTourTypeID() {
        return tourTypeID;
    }

    public void setTourTypeID(Integer tourTypeID) {
        this.tourTypeID = tourTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
