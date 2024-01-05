/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

import com.cusc.entities.Customers;
import com.cusc.validatorcustom.CheckDate;
import com.cusc.validatorcustom.CheckSpace;
import java.sql.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
/**
 *
 * @author kyqua
 */
public class CustomersDTO extends AbstractDTO<Customers, CustomersDTO> {

    private Long customerID;
    @Length(min = 6, max = 50, message = "Username must has 6 to 50 characters ")
    @CheckSpace
    private String username;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must has at least 6 characters and digital and speical character ")
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
    private String newPassword;
    @NotBlank(message = "Confirm password is not empty")
    private String confirmNewPassword;
    private String confirmOldPassword;

    @Override
    public Customers tranferToEntities() {
        Customers customers = new Customers();
        customers.setCustomerID(customerID);
        customers.setUsername(username);
        customers.setPassword(password);
        customers.setEmail(email);
        customers.setFirstname(firstname);
        customers.setLastname(lastname);
        customers.setPhone(phone);
        customers.setDateOfBirth(dateOfBirth);
        customers.setAvatar(avatar);
        customers.setAddress(address);
        customers.setStatus(status);
        return customers;
    }

    @Override
    public void getData(Customers t) {
        setCustomerID(t.getCustomerID());
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRoleTemp() {
        return roleTemp;
    }

    public void setRoleTemp(int roleTemp) {
        this.roleTemp = roleTemp;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
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

}
