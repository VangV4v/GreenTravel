/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.CarImages;

/**
 *
 * @author kyqua
 */
public class CarImageDTO extends AbstractDTO<CarImages, CarImageDTO> {

    private Integer imageID;
    private String image;
    private int carID;
    private String urlImg;

    @Override
    public void getData(CarImages e) {
        setImage(e.getImage());
        setImageID(e.getImageID());
        setCarID(e.getCarID().getCarID());
    }

    @Override
    public CarImages tranferToEntities() {
        CarImages carImages = new CarImages();
        carImages.setImage(image);
        carImages.setImageID(imageID);
        return carImages;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

}
