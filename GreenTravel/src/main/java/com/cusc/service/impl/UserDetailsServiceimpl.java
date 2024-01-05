/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.dto.LoginDTO;
import com.cusc.entities.Customers;
import com.cusc.entities.Employees;
import com.cusc.repositories.hql.CustomersHQL;
import com.cusc.repositories.hql.EmployeesHQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class UserDetailsServiceimpl implements UserDetailsService {

    @Autowired
    private EmployeesHQL employeesHQL;

    @Autowired
    private CustomersHQL customersHQL;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginDTO loginDTO;
        long loginCheckUsername = customersHQL.getCountByUsername(username);
        if (loginCheckUsername == 0) {
            Employees emp = employeesHQL.loadByUsername(username);
            loginDTO = new LoginDTO(emp.getUsername(), emp.getPassword(), emp.getRoleID().getRoleName());
        } else {
            Customers customers = customersHQL.loadByUsername(username);
            loginDTO = new LoginDTO(customers.getUsername(), customers.getPassword(), customers.getRoleID().getRoleName());
        }
        UserDetails userDetails = new User(loginDTO.getUsername(), loginDTO.getPassword(), loginDTO.getListGrant());
        return userDetails;
    }

}
