/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories;

import com.cusc.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface CustomersRepository extends JpaRepository<Customers, Long> {

    @Query(value = "select [CustomerID],[RoleID],[Username],[Password],[Email],[Firstname],[Lastname],[Phone],[DateOfBirth],[Avatar],[Address],[Status] from Customers where Username = ?1", nativeQuery = true)
    Customers findByUsername(String username);

    @Query(value = "SELECT count(Email) FROM Customers where Email  = ?1 ", nativeQuery = true)
    long getCountByCheckEmail(String email);

    @Query(value = "SELECT count(Email) FROM Customers where Email  = ?1 and CustomerID not in (?2)", nativeQuery = true)
    long getCountByCheckEmailAndCustomerID(String email, long id);
}
