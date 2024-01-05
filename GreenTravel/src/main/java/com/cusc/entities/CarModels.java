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
@Table(name = "CarModels")
@NamedQueries({
    @NamedQuery(name = "CarModels.findAll", query = "SELECT c FROM CarModels c")})
public class CarModels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CarModelID")
    private Integer carModelID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "CompanyName")
    private String companyName;
    @Size(max = 255)
    @Column(name = "Url")
    private String url;
    @Size(max = 255)
    @Column(name = "Country")
    private String country;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "carModelID",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Cars> carsList;

    public CarModels() {
    }

    public CarModels(Integer carModelID) {
        this.carModelID = carModelID;
    }

    public CarModels(Integer carModelID, String name) {
        this.carModelID = carModelID;
        this.name = name;
    }

    public Integer getCarModelID() {
        return carModelID;
    }

    public void setCarModelID(Integer carModelID) {
        this.carModelID = carModelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Cars> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<Cars> carsList) {
        this.carsList = carsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carModelID != null ? carModelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarModels)) {
            return false;
        }
        CarModels other = (CarModels) object;
        if ((this.carModelID == null && other.carModelID != null) || (this.carModelID != null && !this.carModelID.equals(other.carModelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.CarModels[ carModelID=" + carModelID + " ]";
    }
    
}
