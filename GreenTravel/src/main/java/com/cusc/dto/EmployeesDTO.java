/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Employees;
import com.cusc.entities.Roles;
import com.cusc.validatorcustom.CheckDate;
import com.cusc.validatorcustom.CheckSpace;
import java.sql.Date;
import javax.persistence.Basic;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
/**
 *
 * @author kyqua
 */
public class EmployeesDTO extends AbstractDTO<Employees, EmployeesDTO> {

    private Long employeeID;
    @Basic(optional = false)
    @Length(min = 6, max = 15, message = "Username must has 6 to 15 characters ")
    @CheckSpace
    private String username;
    //@Pattern(regexp = "/^(?=.*\\d)(?=.*[^A-Za-z0-9])[A-Za-z\\d!@#$%^&*()]{8,}$/", message = "Password must has at least 6 characters and digital and speical character ")
    private String password;
    @NotBlank(message = "Email is not empty")
    @Email(message = "Email is incorrect format")
    private String email;
    @NotBlank(message = "Firstname is not empty")
    private String firstname;
    @NotBlank(message = "Lastname is not empty")
    private String lastname;
    @Pattern(regexp = "0[0-9]{9,11}", message = "Phone must begin with 0 and must has 10 to 12 number")
    private String phone;
    @CheckDate
    private Date dateOfBirth;
    private String avatar;
    private String address;
    private boolean status;
    private int roleTemp;
    //
    private String newPassword;
    // @NotBlank(message = "Field is not empty")
    private String confirmOldPassword;
    @NotBlank(message = "Field is not empty")
    private String confirmNewPassword;

    @Override
    public Employees tranferToEntities() {
        Employees employees = new Employees();
        employees.setEmployeeID(employeeID);
        employees.setUsername(username);
        employees.setPassword(password);
        employees.setEmail(email);
        employees.setFirstname(firstname);
        employees.setLastname(lastname);
        employees.setPhone(phone);
        employees.setDateOfBirth(dateOfBirth);
        employees.setAvatar(avatar);
        employees.setAddress(address);
        employees.setStatus(status);
        return employees;
    }

    @Override
    public void getData(Employees t) {
        setEmployeeID(t.getEmployeeID());
        setUsername(t.getUsername());
        setPassword(t.getPassword());
        setEmail(t.getEmail());
        setFirstname(t.getFirstname());
        setLastname(t.getLastname());
        setPhone(t.getPhone());
        setDateOfBirth(t.getDateOfBirth());
        setAvatar(t.getAvatar());
        setAddress(t.getAddress());
        setStatus(t.getStatus());
        setRoleTemp(t.getRoleID().getRoleID());
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    public String getConfirmOldPassword() {
        return confirmOldPassword;
    }

    public void setConfirmOldPassword(String confirmOldPassword) {
        this.confirmOldPassword = confirmOldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public int getRoleTemp() {
        return roleTemp;
    }

    public void setRoleTemp(int roleTemp) {
        this.roleTemp = roleTemp;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

}
