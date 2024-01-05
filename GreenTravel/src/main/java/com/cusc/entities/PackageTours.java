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
@Table(name = "PackageTours")
@NamedQueries({
    @NamedQuery(name = "PackageTours.findAll", query = "SELECT p FROM PackageTours p")})
public class PackageTours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PackageTourID")
    private Integer packageTourID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateStart")
    private Date dateStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateEnd")
    private Date dateEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 500)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Capacity")
    private int capacity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private Double price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private int status;
    @JoinColumn(name = "AreaID", referencedColumnName = "AreaID")
    @ManyToOne(optional = false)
    private Areas areaID;
    @JoinColumn(name = "TourTypeID", referencedColumnName = "TourTypeID")
    @ManyToOne(optional = false)
    private TourTypes tourTypeID;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "packageTourID", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Tours> toursList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageTourID", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<BookingTours> bookingToursList;
    @JoinColumn(name = "FromProvinceID", referencedColumnName = "ProvinceID")
    @ManyToOne(optional = false)
    private Provinces fromProvinceID;
    @JoinColumn(name = "ToProvinceID", referencedColumnName = "ProvinceID")
    @ManyToOne(optional = false)
    private Provinces toProvinceID;

    public PackageTours() {
    }

    public PackageTours(Integer packageTourID) {
        this.packageTourID = packageTourID;
    }

    public PackageTours(Integer packageTourID, Date dateStart, Date dateEnd, String name, int capacity, Double price, String image, int status) {
        this.packageTourID = packageTourID;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.image = image;
        this.status = status;
    }

    public Integer getPackageTourID() {
        return packageTourID;
    }

    public void setPackageTourID(Integer packageTourID) {
        this.packageTourID = packageTourID;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Areas getAreaID() {
        return areaID;
    }

    public void setAreaID(Areas areaID) {
        this.areaID = areaID;
    }

    public TourTypes getTourTypeID() {
        return tourTypeID;
    }

    public void setTourTypeID(TourTypes tourTypeID) {
        this.tourTypeID = tourTypeID;
    }

    public List<Tours> getToursList() {
        return toursList;
    }

    public void setToursList(List<Tours> toursList) {
        this.toursList = toursList;
    }

    public List<BookingTours> getBookingToursList() {
        return bookingToursList;
    }

    public void setBookingToursList(List<BookingTours> bookingToursList) {
        this.bookingToursList = bookingToursList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (packageTourID != null ? packageTourID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PackageTours)) {
            return false;
        }
        PackageTours other = (PackageTours) object;
        if ((this.packageTourID == null && other.packageTourID != null) || (this.packageTourID != null && !this.packageTourID.equals(other.packageTourID))) {
            return false;
        }
        return true;
    }

    public Provinces getFromProvinceID() {
        return fromProvinceID;
    }

    public void setFromProvinceID(Provinces fromProvinceID) {
        this.fromProvinceID = fromProvinceID;
    }

    public Provinces getToProvinceID() {
        return toProvinceID;
    }

    public void setToProvinceID(Provinces toProvinceID) {
        this.toProvinceID = toProvinceID;
    }

    @Override
    public String toString() {
        return "PackageTours{" + "packageTourID=" + packageTourID + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", name=" + name + ", description=" + description + ", capacity=" + capacity + ", price=" + price + ", image=" + image + ", status=" + status + '}';
    }

}
