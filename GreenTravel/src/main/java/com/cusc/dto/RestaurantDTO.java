/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Destinations;
import com.cusc.entities.Restaurants;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
public class RestaurantDTO extends AbstractDTO<Restaurants, RestaurantDTO> {

    private Integer restaurantID;

    @NotBlank(message = "Name cannot be empty")
    @Length(max = 255, message = "Name has max length 255 characters")
    private String name;

    private int rateStar;

    private String image;
    
    private MultipartFile thumbnailImage;

    @Length(max = 255, message = "Url has max length 255 characters")
    private String url;

    @NotBlank(message = "Description cannot be empty")
    @Length(max = 255, message = "Description has max length 255 characters")
    private String description;

    private Integer destinationID;

    private Destinations destination;

    @Override
    public Restaurants tranferToEntities() {
        Restaurants restaurant = new Restaurants();
        restaurant.setRestaurantID(restaurantID);
        restaurant.setName(name);
        restaurant.setRateStar(rateStar);
        restaurant.setDescription(description);
        restaurant.setImage(image);
        restaurant.setUrl(url);
        return restaurant;
    }

    @Override
    public void getData(Restaurants e) {
        setRestaurantID(e.getRestaurantID());
        setName(e.getName());
        setRateStar(e.getRateStar());
        setImage(e.getImage());
        setDescription(e.getDescription());
        setUrl(e.getUrl());
        setDestination(e.getDestinationID());
        setDestinationID(e.getDestinationID().getDestinationID());
    }
    
    public void convertJsonModel(Restaurants e){
         setRestaurantID(e.getRestaurantID());
        setName(e.getName());
        setRateStar(e.getRateStar());
        setImage(e.getImage());
        setDescription(e.getDescription());
        setUrl(e.getUrl());
        setDestinationID(e.getDestinationID().getDestinationID());
    }

    public Integer getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Integer restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRateStar() {
        return rateStar;
    }

    public void setRateStar(int rateStar) {
        this.rateStar = rateStar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Integer destinationID) {
        this.destinationID = destinationID;
    }

    public Destinations getDestination() {
        return destination;
    }

    public void setDestination(Destinations destination) {
        this.destination = destination;
    }

    public MultipartFile getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(MultipartFile thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    
}
