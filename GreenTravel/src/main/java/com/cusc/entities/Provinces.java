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
@Table(name = "Provinces")
@NamedQueries({
    @NamedQuery(name = "Provinces.findAll", query = "SELECT p FROM Provinces p")})
public class Provinces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProvinceID")
    private Integer provinceID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ProvinceCode")
    private String provinceCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "AirportName")
    private String airportName;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "fromProvince")
    private List<Flights> flightsList;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "toProvince")
    private List<Flights> flightsList1;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "provinceID", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Areas> areasList;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "fromProvinceID", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<PackageTours> packageToursList;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "toProvinceID", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<PackageTours> packageToursList1;

    public Provinces() {
    }

    public Provinces(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public Provinces(Integer provinceID, String provinceCode, String name, String airportName) {
        this.provinceID = provinceID;
        this.provinceCode = provinceCode;
        this.name = name;
        this.airportName = airportName;
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flights> getFlightsList() {
        return flightsList;
    }

    public void setFlightsList(List<Flights> flightsList) {
        this.flightsList = flightsList;
    }

    public List<Flights> getFlightsList1() {
        return flightsList1;
    }

    public void setFlightsList1(List<Flights> flightsList1) {
        this.flightsList1 = flightsList1;
    }

    public List<Areas> getAreasList() {
        return areasList;
    }

    public void setAreasList(List<Areas> areasList) {
        this.areasList = areasList;
    }

    public List<PackageTours> getPackageToursList() {
        return packageToursList;
    }

    public void setPackageToursList(List<PackageTours> packageToursList) {
        this.packageToursList = packageToursList;
    }

    public List<PackageTours> getPackageToursList1() {
        return packageToursList1;
    }

    public void setPackageToursList1(List<PackageTours> packageToursList1) {
        this.packageToursList1 = packageToursList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinceID != null ? provinceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provinces)) {
            return false;
        }
        Provinces other = (Provinces) object;
        if ((this.provinceID == null && other.provinceID != null) || (this.provinceID != null && !this.provinceID.equals(other.provinceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.Provinces[ provinceID=" + provinceID + " ]";
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

}
