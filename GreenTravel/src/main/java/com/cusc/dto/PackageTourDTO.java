/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Areas;
import com.cusc.entities.PackageTours;
import com.cusc.entities.Provinces;
import com.cusc.entities.TourTypes;
import java.sql.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
public class PackageTourDTO extends AbstractDTO<PackageTours, PackageTourDTO> {

    private Integer packageTourID;

    //@NotNull(message = "Date Star is not empty")
    private Date dateStart;

    //@NotNull(message = "Date End is not empty")
    private Date dateEnd;

    @NotBlank(message = "Name cannot be empty")
    @Length(max = 255, message = "Name has max length 255 characters")
    private String name;

    private MultipartFile thumbnailImage;

    @NotBlank(message = "Description cannot be empty")
    @Length(max = 500, message = "Description has max length 500 characters")
    private String description;

    @Range(min = 1, max = 100, message = "Capacity is in range 1 to 100 slots")
    private Integer capacity;

    @Range(min=1, max=20000, message = "Price is in range 1 to 20.000 dollar")
    private Double price;

    private String image;

    private int status;

    private Areas area;

    private Integer areaID;

    private TourTypes tourType;

    private Integer tourTypeID;

    private Provinces fromProvince;

    private Integer fromProvinceID;

    private Provinces toProvince;

    private Integer toProvinceID;

    @Override
    public PackageTours tranferToEntities() {
        PackageTours packageTour = new PackageTours();
        packageTour.setPackageTourID(packageTourID);
        packageTour.setDateStart(dateStart);
        packageTour.setDateEnd(dateEnd);
        packageTour.setName(name);
        packageTour.setImage(image);
        packageTour.setCapacity(capacity);
        packageTour.setPrice(price);
        packageTour.setDescription(description);
        packageTour.setStatus(status);
        return packageTour;
    }

    @Override
    public void getData(PackageTours e) {
        setPackageTourID(e.getPackageTourID());
        setDateStart(e.getDateStart());
        setDateEnd(e.getDateEnd());
        setName(e.getName());
        setImage(e.getImage());
        setDescription(e.getDescription());
        setCapacity(e.getCapacity());
        setPrice(e.getPrice());
        setStatus(e.getStatus());
        setArea(e.getAreaID());
        setAreaID(e.getAreaID().getAreaID());
        setTourType(e.getTourTypeID());
        setTourTypeID(e.getTourTypeID().getTourTypeID());
        setFromProvince(e.getFromProvinceID());
        setFromProvinceID(e.getFromProvinceID().getProvinceID());
        setToProvince(e.getToProvinceID());
        setToProvinceID(e.getToProvinceID().getProvinceID());

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

    public Areas getArea() {
        return area;
    }

    public void setArea(Areas area) {
        this.area = area;
    }

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

    public TourTypes getTourType() {
        return tourType;
    }

    public void setTourType(TourTypes tourType) {
        this.tourType = tourType;
    }

    public Integer getTourTypeID() {
        return tourTypeID;
    }

    public void setTourTypeID(Integer tourTypeID) {
        this.tourTypeID = tourTypeID;
    }

    public MultipartFile getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(MultipartFile thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Provinces getFromProvince() {
        return fromProvince;
    }

    public void setFromProvince(Provinces fromProvince) {
        this.fromProvince = fromProvince;
    }

    public Integer getFromProvinceID() {
        return fromProvinceID;
    }

    public void setFromProvinceID(Integer fromProvinceID) {
        this.fromProvinceID = fromProvinceID;
    }  

    public Provinces getToProvince() {
        return toProvince;
    }

    public void setToProvince(Provinces toProvince) {
        this.toProvince = toProvince;
    }

    public Integer getToProvinceID() {
        return toProvinceID;
    }

    public void setToProvinceID(Integer toProvinceID) {
        this.toProvinceID = toProvinceID;
    }

}
