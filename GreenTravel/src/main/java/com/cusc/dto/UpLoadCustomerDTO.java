/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Customers;
import com.cusc.entities.Employees;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
public class UpLoadCustomerDTO extends AbstractDTO<Customers, UpLoadCustomerDTO> {

    private long customerID;
    private MultipartFile image;
    private String path;

    @Override
    public Customers tranferToEntities() {
        Customers customers = new Customers();
        return customers;
    }

    @Override
    public void getData(Customers e) {
        setCustomerID(e.getCustomerID());
        setPath(e.getAvatar());
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
