/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "Destinations")
@NamedQueries({
    @NamedQuery(name = "Destinations.findAll", query = "SELECT d FROM Destinations d")})
public class Destinations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DestinationID")
    private Integer destinationID;
    @Size(max = 255)
    @Column(name = "Image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @JoinColumn(name = "AreaID", referencedColumnName = "AreaID")
    @ManyToOne(optional = false)
    private Areas areaID;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "destinationID")
    private List<LocalTravels> localTravelsList;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "destinationID")
    private List<Tours> toursList;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "destinationID")
    private List<Restaurants> restaurantsList;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "destinationID")
    private List<Hotels> hotelsList;

    public Destinations() {
    }

    public Destinations(Integer destinationID) {
        this.destinationID = destinationID;
    }

    public Destinations(Integer destinationID, String name) {
        this.destinationID = destinationID;
        this.name = name;
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

    public Areas getAreaID() {
        return areaID;
    }

    public void setAreaID(Areas areaID) {
        this.areaID = areaID;
    }

    public List<LocalTravels> getLocalTravelsList() {
        return localTravelsList;
    }

    public void setLocalTravelsList(List<LocalTravels> localTravelsList) {
        this.localTravelsList = localTravelsList;
    }

    public List<Tours> getToursList() {
        return toursList;
    }

    public void setToursList(List<Tours> toursList) {
        this.toursList = toursList;
    }

    public List<Restaurants> getRestaurantsList() {
        return restaurantsList;
    }

    public void setRestaurantsList(List<Restaurants> restaurantsList) {
        this.restaurantsList = restaurantsList;
    }

    public List<Hotels> getHotelsList() {
        return hotelsList;
    }

    public void setHotelsList(List<Hotels> hotelsList) {
        this.hotelsList = hotelsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (destinationID != null ? destinationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinations)) {
            return false;
        }
        Destinations other = (Destinations) object;
        if ((this.destinationID == null && other.destinationID != null) || (this.destinationID != null && !this.destinationID.equals(other.destinationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.Destinations[ destinationID=" + destinationID + " ]";
    }
    
}
