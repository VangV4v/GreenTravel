/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Destinations;
import com.cusc.entities.Hotels;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
public class HotelDTO extends AbstractDTO<Hotels, HotelDTO> {

    private Integer hotelID;

    @NotBlank(message = "Name is not empty")
    @Length(max = 255, message = "Name has max length 255 characters")
    private String name;

    private int rateStar;

    private String image;

    private MultipartFile thumbnailImage;

    private String url;

    @NotBlank(message = "Address is not empty")
    @Length(max = 255, message = "Address has max length 255 characters")
    private String address;

    private boolean freePacking;

    private boolean isHasMiniBar;

    private boolean isHasPool;

    private boolean restaurantOnSite;

    @NotBlank(message = "Description is not empty")
    @Length(max = 255, message = "Description has max length 255 characters")
    private String description;

    private Destinations destination;

    private Integer destinationID;

    public Integer getHotelID() {
        return hotelID;
    }

    public void setHotelID(Integer hotelID) {
        this.hotelID = hotelID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFreePacking() {
        return freePacking;
    }

    public void setFreePacking(boolean freePacking) {
        this.freePacking = freePacking;
    }

    public boolean isIsHasMiniBar() {
        return isHasMiniBar;
    }

    public void setIsHasMiniBar(boolean isHasMiniBar) {
        this.isHasMiniBar = isHasMiniBar;
    }

    public boolean isIsHasPool() {
        return isHasPool;
    }

    public void setIsHasPool(boolean isHasPool) {
        this.isHasPool = isHasPool;
    }

    public boolean isRestaurantOnSite() {
        return restaurantOnSite;
    }

    public void setRestaurantOnSite(boolean restaurantOnSite) {
        this.restaurantOnSite = restaurantOnSite;
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

    @Override
    public Hotels tranferToEntities() {
        Hotels hotel = new Hotels();
        hotel.setHotelID(hotelID);
        hotel.setName(name);
        hotel.setRateStar(rateStar);
        hotel.setImage(image);
        hotel.setUrl(url);
        hotel.setAddress(address);
        hotel.setFreePacking(freePacking);
        hotel.setIsHasMiniBar(isHasMiniBar);
        hotel.setIsHasPool(isHasPool);
        hotel.setRestaurantOnSite(restaurantOnSite);
        hotel.setDescription(description);
        return hotel;
    }

    @Override
    public void getData(Hotels e) {
        setHotelID(e.getHotelID());
        setName(e.getName());
        setUrl(e.getUrl());
        setRateStar(e.getRateStar());
        setAddress(e.getAddress());
        setImage(e.getImage());
        setIsHasPool(e.getIsHasPool());
        setIsHasMiniBar(e.getIsHasMiniBar());
        setFreePacking(e.getFreePacking());
        setRestaurantOnSite(e.getRestaurantOnSite());
        setDescription(e.getDescription());
        setDestination(e.getDestinationID());
        setDestinationID(e.getDestinationID().getDestinationID());
    }

    public void convertJsonModel(Hotels e) {
        setHotelID(e.getHotelID());
        setName(e.getName());
    }

    public MultipartFile getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(MultipartFile thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

}
