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
@Table(name = "TypeCars")
@NamedQueries({
    @NamedQuery(name = "TypeCars.findAll", query = "SELECT t FROM TypeCars t")})
public class TypeCars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CarTypeID")
    private Integer carTypeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CarTypeName")
    private String carTypeName;
    @Size(max = 255)
    @Column(name = "CarTypeDescription")
    private String carTypeDescription;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "carTypeID", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Cars> carsList;

    public TypeCars() {
    }

    public TypeCars(Integer carTypeID) {
        this.carTypeID = carTypeID;
    }

    public TypeCars(Integer carTypeID, String carTypeName) {
        this.carTypeID = carTypeID;
        this.carTypeName = carTypeName;
    }

    public Integer getCarTypeID() {
        return carTypeID;
    }

    public void setCarTypeID(Integer carTypeID) {
        this.carTypeID = carTypeID;
    }

    public String getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName;
    }

    public String getCarTypeDescription() {
        return carTypeDescription;
    }

    public void setCarTypeDescription(String carTypeDescription) {
        this.carTypeDescription = carTypeDescription;
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
        hash += (carTypeID != null ? carTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeCars)) {
            return false;
        }
        TypeCars other = (TypeCars) object;
        if ((this.carTypeID == null && other.carTypeID != null) || (this.carTypeID != null && !this.carTypeID.equals(other.carTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.TypeCars[ carTypeID=" + carTypeID + " ]";
    }

}
