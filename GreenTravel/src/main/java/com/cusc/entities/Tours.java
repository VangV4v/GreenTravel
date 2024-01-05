/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.entities;

import java.io.Serializable;
import java.sql.Date;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "Tours")
@NamedQueries({
    @NamedQuery(name = "Tours.findAll", query = "SELECT t FROM Tours t")})
public class Tours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TourID")
    private Integer tourID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Description")
    private String description;
    @Size(max = 255)
    @Column(name = "Note")
    private String note;
    @Column(name = "VisitDate")
    private Date visitDate;
    @Size(max = 255)
    @Column(name = "Schedule")
    private String schedule;
    @JoinColumn(name = "DestinationID", referencedColumnName = "DestinationID")
    @ManyToOne(optional = false)
    private Destinations destinationID;
    @JoinColumn(name = "PackageTourID", referencedColumnName = "PackageTourID")
    @ManyToOne(optional = false)
    private PackageTours packageTourID;
    @JoinColumn(name = "RestaurantID", referencedColumnName = "RestaurantID")
    @ManyToOne(optional = false)
    private Restaurants restaurantID;
    @JoinColumn(name = "HotelID", referencedColumnName = "HotelID")
    @ManyToOne(optional = false)
    private Hotels hotelID;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "tourID", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<LocalTravelInTours> localTravelInToursList;

    public Tours() {
    }

    public Tours(Integer tourID) {
        this.tourID = tourID;
    }

    public Tours(Integer tourID, String name, String description) {
        this.tourID = tourID;
        this.name = name;
        this.description = description;
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

    public Destinations getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Destinations destinationID) {
        this.destinationID = destinationID;
    }

    public PackageTours getPackageTourID() {
        return packageTourID;
    }

    public void setPackageTourID(PackageTours packageTourID) {
        this.packageTourID = packageTourID;
    }

    public Restaurants getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Restaurants restaurantID) {
        this.restaurantID = restaurantID;
    }

    public List<LocalTravelInTours> getLocalTravelInToursList() {
        return localTravelInToursList;
    }

    public void setLocalTravelInToursList(List<LocalTravelInTours> localTravelInToursList) {
        this.localTravelInToursList = localTravelInToursList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tourID != null ? tourID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tours)) {
            return false;
        }
        Tours other = (Tours) object;
        if ((this.tourID == null && other.tourID != null) || (this.tourID != null && !this.tourID.equals(other.tourID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.Tours[ tourID=" + tourID + " ]";
    }

    public Hotels getHotelID() {
        return hotelID;
    }

    public void setHotelID(Hotels hotelID) {
        this.hotelID = hotelID;
    }
    
}
