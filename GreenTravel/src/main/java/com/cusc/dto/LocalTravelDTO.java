/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Destinations;
import com.cusc.entities.LocalTravels;
import com.cusc.entities.TourTypes;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
public class LocalTravelDTO extends AbstractDTO<LocalTravels, LocalTravelDTO> {

    private Integer localTravelID;

    @NotBlank(message = "Name cannot be empty")
    @Length(max = 255, message = "Name has max length 255 characters")
    private String name;

    private String image;

    private MultipartFile thumbnailImage;

    @NotBlank(message = "Description cannot be empty")
    @Length(max = 1000, message = "Description has max length 1000 characters")
    private String description;

    private Destinations destination;

    private Integer destinationID; 

    public Integer getLocalTravelID() {
        return localTravelID;
    }

    public void setLocalTravelID(Integer localTravelID) {
        this.localTravelID = localTravelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Destinations getDestination() {
        return destination;
    }

    public void setDestination(Destinations destination) {
        this.destination = destination;
    }

    public Integer getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Integer destinationID) {
        this.destinationID = destinationID;
    }   

    public MultipartFile getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(MultipartFile thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    @Override
    public LocalTravels tranferToEntities() {
        LocalTravels localTravel = new LocalTravels();
        localTravel.setDescription(getDescription());
        localTravel.setImage(getImage());
        localTravel.setLocalTravelID(getLocalTravelID());
        localTravel.setName(getName());
        return localTravel;
    }

    @Override
    public void getData(LocalTravels e) {
        setLocalTravelID(e.getLocalTravelID());
        setName(e.getName());
        setImage(e.getImage());
        setDescription(e.getDescription());
        setDestination(e.getDestinationID());
        setDestinationID(e.getDestinationID().getDestinationID());    
    }

    public void convertJsonModel(LocalTravels e) {
        setLocalTravelID(e.getLocalTravelID());
        setName(e.getName());
        setImage(e.getImage());
        setDescription(e.getDescription());
        setDestinationID(e.getDestinationID().getDestinationID());      
    }

}
