/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "LocalTravelInTours")
@NamedQueries({
    @NamedQuery(name = "LocalTravelInTours.findAll", query = "SELECT l FROM LocalTravelInTours l")})
public class LocalTravelInTours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LocalTravelInTourID")
    private Integer localTravelInTourID;
    @JoinColumn(name = "LocalTravelID", referencedColumnName = "LocalTravelID")
    @ManyToOne(optional = false)
    private LocalTravels localTravelID;
    @JoinColumn(name = "TourID", referencedColumnName = "TourID")
    @ManyToOne(optional = false)
    private Tours tourID;
    @Size(max = 255)
    @Column(name = "Note")
    private String note;

    public LocalTravelInTours() {
    }

    public LocalTravelInTours(Integer localTravelInTourID) {
        this.localTravelInTourID = localTravelInTourID;
    }

    public Integer getLocalTravelInTourID() {
        return localTravelInTourID;
    }

    public void setLocalTravelInTourID(Integer localTravelInTourID) {
        this.localTravelInTourID = localTravelInTourID;
    }

    public LocalTravels getLocalTravelID() {
        return localTravelID;
    }

    public void setLocalTravelID(LocalTravels localTravelID) {
        this.localTravelID = localTravelID;
    }

    public Tours getTourID() {
        return tourID;
    }

    public void setTourID(Tours tourID) {
        this.tourID = tourID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
       

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localTravelInTourID != null ? localTravelInTourID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalTravelInTours)) {
            return false;
        }
        LocalTravelInTours other = (LocalTravelInTours) object;
        if ((this.localTravelInTourID == null && other.localTravelInTourID != null) || (this.localTravelInTourID != null && !this.localTravelInTourID.equals(other.localTravelInTourID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.LocalTravelInTours[ localTravelInTourID=" + localTravelInTourID + " ]";
    }
    
}
