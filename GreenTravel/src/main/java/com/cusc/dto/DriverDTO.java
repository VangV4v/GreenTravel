/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Drivers;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
public class DriverDTO extends AbstractDTO<Drivers, Integer> {

    private Integer driverID;
    @NotBlank(message = "Driver name is not empty")
    private String driverName;
    @NotBlank(message = "Address  is not empty")
    private String address;
    @Pattern(regexp = "0[0-9]{9,11}", message = "Phone must begin with 0 and must has 10 to 12 number")
    private String phone;
    @NotBlank(message = "Phone  is not empty")
    @Length(max = 255, message = "Email less than 255 ")
    @Email(message = "Email is incorrect format")
    private String email;
    @NotBlank(message = "Driver license no is not empty")
    @Length(max = 15, message = "Driver license no less than 15")
    private String driverLicenseNo;
    private String class1;
    private String avatar;
    private boolean status;
    private MultipartFile img;

    @Override
    public Drivers tranferToEntities() {
        Drivers driver = new Drivers();
        driver.setDriverID(driverID);
        driver.setDriverName(driverName);
        driver.setAddress(address);
        driver.setPhone(phone);
        driver.setClass1(class1);
        driver.setEmail(email);
        driver.setDriverLicenseNo(driverLicenseNo);
        driver.setStatus(status);
        driver.setAvatar(avatar);
        return driver;
    }

    @Override
    public void getData(Drivers e) {
        setAddress(e.getAddress());
        setAvatar(e.getAvatar());
        setClass1(e.getClass1());
        setDriverID(e.getDriverID());
        setDriverLicenseNo(e.getDriverLicenseNo());
        setDriverName(e.getDriverName());
        setEmail(e.getEmail());
        setPhone(e.getPhone());
        setStatus(e.getStatus());
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

    public boolean isStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

}
