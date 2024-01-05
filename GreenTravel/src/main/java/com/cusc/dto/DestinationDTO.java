/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Areas;
import com.cusc.entities.Destinations;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
public class DestinationDTO extends AbstractDTO<Destinations, DestinationDTO>{

    private Integer destinationID;
    
    private String image;
    
    private MultipartFile thumbnailImage;
   
    @NotBlank(message = "Name cannot be empty")
    @Length(max = 255, message = "Name has max length 255 characters")
    private String name;
   
    private Integer areaID;  
    
    private Areas area;      
    
    @Override
    public Destinations tranferToEntities() {
        Destinations destination=new Destinations();
        destination.setDestinationID(destinationID);
        destination.setName(name);
        destination.setImage(image);
        return destination;
    }

    @Override
    public void getData(Destinations e) {
        setAreaID(e.getAreaID().getAreaID());
        setArea(e.getAreaID());
        setDestinationID(e.getDestinationID());
        setName(e.getName());
        setImage(e.getImage());
    }

    public Integer getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Integer destinationID) {
        this.destinationID = destinationID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

    public Areas getArea() {
        return area;
    }

    public void setArea(Areas area) {
        this.area = area;
    }

    public MultipartFile getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(MultipartFile thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }
    
    
}
