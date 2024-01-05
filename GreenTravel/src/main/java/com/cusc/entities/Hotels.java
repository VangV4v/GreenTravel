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
@Table(name = "Hotels")
@NamedQueries({
    @NamedQuery(name = "Hotels.findAll", query = "SELECT h FROM Hotels h")})
public class Hotels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HotelID")
    private Integer hotelID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RateStar")
    private int rateStar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Image")
    private String image;
    @Size(max = 255)
    @Column(name = "Url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FreePacking")
    private boolean freePacking;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsHasMiniBar")
    private boolean isHasMiniBar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsHasPool")
    private boolean isHasPool;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RestaurantOnSite")
    private boolean restaurantOnSite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "hotelID",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<HotelFeedBacks> hotelFeedBacksList;
     @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "hotelID")
    private List<Tours> toursList;
    @JoinColumn(name = "DestinationID", referencedColumnName = "DestinationID")
    @ManyToOne(optional = false)
    private Destinations destinationID;

    public Hotels() {
    }

    public Hotels(Integer hotelID) {
        this.hotelID = hotelID;
    }

    public Hotels(Integer hotelID, String name, int rateStar, String image, String address, boolean freePacking, boolean isHasMiniBar, boolean isHasPool, boolean restaurantOnSite, String description) {
        this.hotelID = hotelID;
        this.name = name;
        this.rateStar = rateStar;
        this.image = image;
        this.address = address;
        this.freePacking = freePacking;
        this.isHasMiniBar = isHasMiniBar;
        this.isHasPool = isHasPool;
        this.restaurantOnSite = restaurantOnSite;
        this.description = description;
    }

    public Integer getHotelID() {
        return hotelID;
    }

    public void setHotelID(Integer hotelID) {
        this.hotelID = hotelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRateStar() {
        return rateStar;
    }

    public void setRateStar(int rateStar) {
        this.rateStar = rateStar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imageDefault) {
        this.image = imageDefault;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getFreePacking() {
        return freePacking;
    }

    public void setFreePacking(boolean freePacking) {
        this.freePacking = freePacking;
    }

    public boolean getIsHasMiniBar() {
        return isHasMiniBar;
    }

    public void setIsHasMiniBar(boolean isHasMiniBar) {
        this.isHasMiniBar = isHasMiniBar;
    }

    public boolean getIsHasPool() {
        return isHasPool;
    }

    public void setIsHasPool(boolean isHasPool) {
        this.isHasPool = isHasPool;
    }

    public boolean getRestaurantOnSite() {
        return restaurantOnSite;
    }

    public void setRestaurantOnSite(boolean restaurantOnSite) {
        this.restaurantOnSite = restaurantOnSite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<HotelFeedBacks> getHotelFeedBacksList() {
        return hotelFeedBacksList;
    }

    public void setHotelFeedBacksList(List<HotelFeedBacks> hotelFeedBacksList) {
        this.hotelFeedBacksList = hotelFeedBacksList;
    }

   

    public Destinations getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Destinations destinationID) {
        this.destinationID = destinationID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelID != null ? hotelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotels)) {
            return false;
        }
        Hotels other = (Hotels) object;
        if ((this.hotelID == null && other.hotelID != null) || (this.hotelID != null && !this.hotelID.equals(other.hotelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cusc.entities.Hotels[ hotelID=" + hotelID + " ]";
    }

    public List<Tours> getToursList() {
        return toursList;
    }

    public void setToursList(List<Tours> toursList) {
        this.toursList = toursList;
    }
    
}
