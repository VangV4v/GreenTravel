/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Employees;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
public class UpLoadImageEmployeDTO extends AbstractDTO<Employees, UpLoadImageEmployeDTO> {
    
    private long employeeID;
    private MultipartFile image;
    private String path;
    
    @Override
    public Employees tranferToEntities() {
        Employees employees = new Employees();
        return employees;
    }
    
    @Override
    public void getData(Employees e) {
        setEmployeeID(e.getEmployeeID());
        setPath(e.getAvatar());
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
    
    public long getEmployeeID() {
        return employeeID;
    }
    
    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }
    
}
