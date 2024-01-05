/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories.hql;

import com.cusc.entities.Employees;

/**
 *
 * @author kyqua
 */
public interface EmployeesHQL {

    //List<Accounts> findAllByStatus();
    long getCountByUsername(String username);

    long getCountByEmail(String email);

    Employees loadByUsername(String username);
}
