/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories;

import com.cusc.entities.Employees;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    @Transactional
    @Modifying
    @Query(value = "delete from Employees where EmployeeID = ?1", nativeQuery = true)
    void deleteEmp(long id);

    @Query(value = "{call autoGetEmployee}", nativeQuery = true)
    Employees findByCountRequestConfirmation();

    @Query(value = "{call autoGetEmployeeBookingTour}", nativeQuery = true)
    Employees findByCountRequestConfirmationBookingTour();

    @Query(value = "select [EmployeeID],[RoleID],[Username],[Password],[Email],[Firstname],[Lastname],[Phone],[DateOfBirth],[Avatar],[Address],[Status] from Employees where Username = ? ", nativeQuery = true)
    Employees findByUsername(String username);

    @Query(value = "SELECT count(Email) FROM Employees where Email  = ?1 and EmployeeID not in (?2)", nativeQuery = true)
    long getCountByCheckEmailAndEmployeeID(String email, long id);

    @Query(value = "SELECT count(Email) FROM Employees where Email  = ?1", nativeQuery = true)
    long getCountByCheckEmail(String email);

}
