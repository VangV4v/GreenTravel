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
@Table(name = "Cars")
@NamedQueries({
    @NamedQuery(name = "Cars.findAll", query = "SELECT c FROM Cars c")})
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CarID")
    private Integer carID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CarName")
    private String carName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Seat")
    private int seat;
    @Size(max = 255)
    @Column(name = "Gearbox")
    private String gearbox;
    @Size(max = 255)
    @Column(name = "Fearure")
    private String fearure;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YearIssure")
    private int yearIssure;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsHasAirConditioned")
    private boolean isHasAirConditioned;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PriceInDay")
    private double priceInDay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private boolean status;

    @Column(name = "Image")
    private String image;

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "carID", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<CarImages> carImagesList;
    @JoinColumn(name = "CarModelID", referencedColumnName = "CarModelID")
    @ManyToOne(optional = false)
    private CarModels carModelID;
    @ManyToOne
    @JoinColumn(name = "CarTypeID", referencedColumnName = "CarTypeID")
    private TypeCars carTypeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carID", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<BookingCars> bookingCarsList;

    public Cars() {
    }

    public Cars(Integer carID) {
        this.carID = carID;
    }

    public Cars(Integer carID, String carName, int seat, int yearIssure, boolean isHasAirConditioned, double priceInDay, boolean status) {
        this.carID = carID;
        this.carName = carName;
        this.seat = seat;
        this.yearIssure = yearIssure;
        this.isHasAirConditioned = isHasAirConditioned;
        this.priceInDay = priceInDay;
        this.status = status;
    }

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getFearure() {
        return fearure;
    }

    public void setFearure(String fearure) {
        this.fearure = fearure;
    }

    public int getYearIssure() {
        return yearIssure;
    }

    public void setYearIssure(int yearIssure) {
        this.yearIssure = yearIssure;
    }

    public boolean getIsHasAirConditioned() {
        return isHasAirConditioned;
    }

    public void setIsHasAirConditioned(boolean isHasAirConditioned) {
        this.isHasAirConditioned = isHasAirConditioned;
    }

    public double getPriceInDay() {
        return priceInDay;
    }

    public void setPriceInDay(double priceInDay) {
        this.priceInDay = priceInDay;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<CarImages> getCarImagesList() {
        return carImagesList;
    }

    public void setCarImagesList(List<CarImages> carImagesList) {
        this.carImagesList = carImagesList;
    }

    public CarModels getCarModelID() {
        return carModelID;
    }

    public void setCarModelID(CarModels carModelID) {
        this.carModelID = carModelID;
    }

    public TypeCars getCarTypeID() {
        return carTypeID;
    }

    public void setCarTypeID(TypeCars carTypeID) {
        this.carTypeID = carTypeID;
    }

    public List<BookingCars> getBookingCarsList() {
        return bookingCarsList;
    }

    public void setBookingCarsList(List<BookingCars> bookingCarsList) {
        this.bookingCarsList = bookingCarsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carID != null ? carID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.carID == null && other.carID != null) || (this.carID != null && !this.carID.equals(other.carID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.Cars[ carID=" + carID + " ]";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
