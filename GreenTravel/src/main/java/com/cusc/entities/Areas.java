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
@Table(name = "Areas")
@NamedQueries({
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a")})
public class Areas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AreaID")
    private Integer areaID;    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "areaID")
    private List<Destinations> destinationsList;
    @OneToMany(cascade = {CascadeType.ALL,CascadeType.REMOVE}, mappedBy = "areaID",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<PackageTours> packageToursList;
    @JoinColumn(name = "ProvinceID", referencedColumnName = "ProvinceID")
    @ManyToOne(optional = false)
    private Provinces provinceID;

    public Areas() {
    }

    public Areas(Integer areaID) {
        this.areaID = areaID;
    }

    public Areas(Integer areaID, String name) {
        this.areaID = areaID;
        this.name = name;
    }

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Destinations> getDestinationsList() {
        return destinationsList;
    }

    public void setDestinationsList(List<Destinations> destinationsList) {
        this.destinationsList = destinationsList;
    }

    public List<PackageTours> getPackageToursList() {
        return packageToursList;
    }

    public void setPackageToursList(List<PackageTours> packageToursList) {
        this.packageToursList = packageToursList;
    }

    public Provinces getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Provinces provinceID) {
        this.provinceID = provinceID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaID != null ? areaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.areaID == null && other.areaID != null) || (this.areaID != null && !this.areaID.equals(other.areaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.Areas[ areaID=" + areaID + " ]";
    }
    
}
