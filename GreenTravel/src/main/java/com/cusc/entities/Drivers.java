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
@Table(name = "Drivers")
@NamedQueries({
    @NamedQuery(name = "Drivers.findAll", query = "SELECT d FROM Drivers d")})
public class Drivers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DriverID")
    private Integer driverID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DriverName")
    private String driverName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Email")
    private String email;
    @Size(max = 255)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DriverLicenseNo")
    private String driverLicenseNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Class")
    private String class1;
    @Size(max = 255)
    @Column(name = "Avatar")
    private String avatar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private boolean status;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "driverID", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<DriverInBookingCars> driverInBookingCarsList;

    public Drivers() {
    }

    public Drivers(Integer driverID) {
        this.driverID = driverID;
    }

    public Drivers(Integer driverID, String driverName, String phone, String email, String driverLicenseNo, String class1, boolean status) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.phone = phone;
        this.email = email;
        this.driverLicenseNo = driverLicenseNo;
        this.class1 = class1;
        this.status = status;
    }

    public Integer getDriverID() {
        return driverID;
    }

    public void setDriverID(Integer driverID) {
        this.driverID = driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(String driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<DriverInBookingCars> getDriverInBookingCarsList() {
        return driverInBookingCarsList;
    }

    public void setDriverInBookingCarsList(List<DriverInBookingCars> driverInBookingCarsList) {
        this.driverInBookingCarsList = driverInBookingCarsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (driverID != null ? driverID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drivers)) {
            return false;
        }
        Drivers other = (Drivers) object;
        if ((this.driverID == null && other.driverID != null) || (this.driverID != null && !this.driverID.equals(other.driverID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Drivers{" + "driverID=" + driverID + ", driverName=" + driverName + ", phone=" + phone + ", email=" + email + ", address=" + address + ", driverLicenseNo=" + driverLicenseNo + ", class1=" + class1 + ", avatar=" + avatar + ", status=" + status + '}';
    }



}
