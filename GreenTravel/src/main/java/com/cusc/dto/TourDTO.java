/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Destinations;
import com.cusc.entities.Hotels;
import com.cusc.entities.PackageTours;
import com.cusc.entities.Restaurants;
import com.cusc.entities.Tours;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author kyqua
 */
public class TourDTO extends AbstractDTO<Tours, TourDTO> {

    private Integer tourID;

    @NotBlank(message = "Name cannot be empty")
    @Length(max = 255, message = "Name has max length 255 characters")
    private String name;

    @NotBlank(message = "Description cannot be empty")
    @Length(max = 255, message = "Description has max length 255 characters")
    private String description;

    @Length(max = 255, message = "Note has max length 255 characters")
    private String note;

    private Date visitDate;

    private String schedule;

    private Destinations destination;

    private Integer destinationID;

    private PackageTours packageTour;

    private Integer packageTourID;

    private Restaurants restaurant;

    private Integer restaurantID;
    
    private Hotels hotel;
    
    private Integer hotelID;
    
    private List<Integer> listLocalTravelinTour=new ArrayList<Integer>();

    public List<Integer> getListLocalTravelinTour() {
        return listLocalTravelinTour;
    }

    public void setListLocalTravelinTour(List<Integer> listLocalTravelinTour) {
        this.listLocalTravelinTour = listLocalTravelinTour;
    }
    
    public void setLocalTravelinTour(Integer localTravelinTourID){
        this.listLocalTravelinTour.add(localTravelinTourID);
    }
            

    @Override
    public Tours tranferToEntities() {
        Tours tour = new Tours();
        tour.setTourID(tourID);
        tour.setName(name);
        tour.setDescription(description);
        tour.setNote(note);
        tour.setVisitDate(visitDate);
        tour.setSchedule(schedule);
        return tour;
    }

    @Override
    public void getData(Tours e) {
        setTourID(e.getTourID());
        setName(e.getName());
        setDescription(e.getDescription());
        setNote(e.getNote());      
        setVisitDate(e.getVisitDate());
        setSchedule(e.getSchedule());
        setDestination(e.getDestinationID());
        setDestinationID(e.getDestinationID().getDestinationID());
        setRestaurant(e.getRestaurantID());
        setRestaurantID(e.getRestaurantID().getRestaurantID());
        setPackageTour(e.getPackageTourID());
        setPackageTourID(e.getPackageTourID().getPackageTourID());
        setHotel(e.getHotelID());
        setHotelID(e.getHotelID().getHotelID());
       
    }

    public Integer getTourID() {
        return tourID;
    }

    public void setTourID(Integer tourID) {
        this.tourID = tourID;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
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

    public PackageTours getPackageTour() {
        return packageTour;
    }

    public void setPackageTour(PackageTours packageTour) {
        this.packageTour = packageTour;
    }

    public Integer getPackageTourID() {
        return packageTourID;
    }

    public void setPackageTourID(Integer packageTourID) {
        this.packageTourID = packageTourID;
    }

    public Restaurants getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Integer restaurantID) {
        this.restaurantID = restaurantID;
    }

    public Hotels getHotel() {
        return hotel;
    }

    public void setHotel(Hotels hotel) {
        this.hotel = hotel;
    }

    public Integer getHotelID() {
        return hotelID;
    }

    public void setHotelID(Integer hotelID) {
        this.hotelID = hotelID;
    }
    
    
}
