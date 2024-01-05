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
@Table(name = "Restaurants")
@NamedQueries({
    @NamedQuery(name = "Restaurants.findAll", query = "SELECT r FROM Restaurants r")})
public class Restaurants implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RestaurantID")
    private Integer restaurantID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RateStar")
    private int rateStar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Image")
    private String image;
    @Size(max = 255)
    @Column(name = "Url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "restaurantID")
    private List<Tours> toursList;
    @JoinColumn(name = "DestinationID", referencedColumnName = "DestinationID")
    @ManyToOne(optional = false)
    private Destinations destinationID;

    public Restaurants() {
    }

    public Restaurants(Integer restaurantID) {
        this.restaurantID = restaurantID;
    }

    public Restaurants(Integer restaurantID, String name, int rateStar, String image, String description) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.rateStar = rateStar;
        this.image = image;
        this.description = description;
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

    public List<Tours> getToursList() {
        return toursList;
    }

    public void setToursList(List<Tours> toursList) {
        this.toursList = toursList;
    }

    public Destinations getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Destinations destinationID) {
        this.destinationID = destinationID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (restaurantID != null ? restaurantID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurants)) {
            return false;
        }
        Restaurants other = (Restaurants) object;
        if ((this.restaurantID == null && other.restaurantID != null) || (this.restaurantID != null && !this.restaurantID.equals(other.restaurantID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{" + "restaurantID:" + restaurantID + ", name:" + name + ", rateStar:" + rateStar + ", image:" + image + ", url:" + url + ", description:" + description + '}';
    }

}
