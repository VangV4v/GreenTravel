/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.CarImages;
import com.cusc.entities.Cars;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
public class CarDTO extends AbstractDTO<Cars, CarDTO> {

    private Integer carID;
    @NotBlank(message = "Car name is not empty ")
    private String carName;
    @Range(min = 2, max = 40, message = "Seat must less than 40 and  ")
    private int seat;
    private String gearbox;
    @NotBlank(message = "Feature is not empty ")
    private String fearure;
    @Range(min = 2, max = 2000, message = "Price must less than 2000$ ")
    private double priceInDay;
    @Range(min = 2010, max = 2023, message = "Year must less than 2010")
    private int yearIssure;
    private boolean isHasAirConditioned;
    private boolean status;
    private List<CarImages> carImagesList;

    private int carTypeID;
    private int carModelID;

    private String urlImage;
    private MultipartFile image;

    public CarDTO() {
    }

    @Override
    public Cars tranferToEntities() {
        Cars cars = new Cars();
        cars.setCarID(carID);
        cars.setCarName(carName);
        cars.setSeat(seat);
        cars.setGearbox(gearbox);
        cars.setFearure(fearure);
        cars.setYearIssure(yearIssure);
        cars.setPriceInDay(priceInDay);
        cars.setIsHasAirConditioned(isHasAirConditioned);
        cars.setStatus(status);
        cars.setImage(urlImage);
        return cars;
    }

    @Override
    public void getData(Cars e) {
        setCarID(e.getCarID());
        setCarName(e.getCarName());
        setFearure(e.getFearure());
        setIsHasAirConditioned(e.getIsHasAirConditioned());
        setSeat(e.getSeat());
        setStatus(e.getStatus());
        setYearIssure(e.getYearIssure());
        setPriceInDay(e.getPriceInDay());
        setGearbox(e.getGearbox());
        setUrlImage(e.getImage());
        setCarModelID(e.getCarModelID().getCarModelID());
        setCarTypeID(e.getCarTypeID().getCarTypeID());
        setUrlImage(e.getImage());
        setCarImagesList(e.getCarImagesList());
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

    public boolean isIsHasAirConditioned() {
        return isHasAirConditioned;
    }

    public void setIsHasAirConditioned(boolean isHasAirConditioned) {
        this.isHasAirConditioned = isHasAirConditioned;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCarTypeID() {
        return carTypeID;
    }

    public void setCarTypeID(int carTypeID) {
        this.carTypeID = carTypeID;
    }

    public int getCarModelID() {
        return carModelID;
    }

    public void setCarModelID(int carModelID) {
        this.carModelID = carModelID;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public double getPriceInDay() {
        return priceInDay;
    }

    public void setPriceInDay(double priceInDay) {
        this.priceInDay = priceInDay;
    }

    public List<CarImages> getCarImagesList() {
        return carImagesList;
    }

    public void setCarImagesList(List<CarImages> carImagesList) {
        this.carImagesList = carImagesList;
    }

}
