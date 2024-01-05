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
@Table(name = "LocalTravels")
@NamedQueries({
    @NamedQuery(name = "LocalTravels.findAll", query = "SELECT l FROM LocalTravels l")})
public class LocalTravels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LocalTravelID")
    private Integer localTravelID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Image")
    private String image;    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "DestinationID", referencedColumnName = "DestinationID")
    @ManyToOne(optional = false)
    private Destinations destinationID;    
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "localTravelID")
    private List<LocalTravelInTours> localTravelInToursList;

    public LocalTravels() {
    }

    public LocalTravels(Integer localTravelID) {
        this.localTravelID = localTravelID;
    }

    public LocalTravels(Integer localTravelID, String name, String image, String description) {
        this.localTravelID = localTravelID;
        this.name = name;
        this.image = image;
        this.description = description;
    }

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

    public Destinations getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Destinations destinationID) {
        this.destinationID = destinationID;
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
        hash += (localTravelID != null ? localTravelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalTravels)) {
            return false;
        }
        LocalTravels other = (LocalTravels) object;
        if ((this.localTravelID == null && other.localTravelID != null) || (this.localTravelID != null && !this.localTravelID.equals(other.localTravelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.LocalTravels[ localTravelID=" + localTravelID + " ]";
    }
    
}
