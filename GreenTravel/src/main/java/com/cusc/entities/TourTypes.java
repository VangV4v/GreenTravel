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
@Table(name = "TourTypes")
@NamedQueries({
    @NamedQuery(name = "TourTypes.findAll", query = "SELECT t FROM TourTypes t")})
public class TourTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TourTypeID")
    private Integer tourTypeID;
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
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "tourTypeID")
    private List<PackageTours> packageToursList;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "tourTypeID")
    private List<Blogs> blogsList;

    public TourTypes() {
    }

    public TourTypes(Integer tourTypeID) {
        this.tourTypeID = tourTypeID;
    }

    public TourTypes(Integer tourTypeID, String name, String description) {
        this.tourTypeID = tourTypeID;
        this.name = name;
        this.description = description;
    }

    public Integer getTourTypeID() {
        return tourTypeID;
    }

    public void setTourTypeID(Integer tourTypeID) {
        this.tourTypeID = tourTypeID;
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

    public List<PackageTours> getPackageToursList() {
        return packageToursList;
    }

    public void setPackageToursList(List<PackageTours> packageToursList) {
        this.packageToursList = packageToursList;
    }

    public List<Blogs> getBlogsList() {
        return blogsList;
    }

    public void setBlogsList(List<Blogs> blogsList) {
        this.blogsList = blogsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tourTypeID != null ? tourTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourTypes)) {
            return false;
        }
        TourTypes other = (TourTypes) object;
        if ((this.tourTypeID == null && other.tourTypeID != null) || (this.tourTypeID != null && !this.tourTypeID.equals(other.tourTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.TourTypes[ tourTypeID=" + tourTypeID + " ]";
    }
    
}
