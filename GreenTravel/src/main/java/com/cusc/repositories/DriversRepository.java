/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories;

import com.cusc.entities.Drivers;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface DriversRepository extends JpaRepository<Drivers, Integer> {

    @Query(value = "{call autoGetDriverByReturnDate(?1)}", nativeQuery = true)
    List<Drivers> findAllByReturnDay(Date date);

    @Query(value = "{call autoGetDriverByRentalDate(?1)}", nativeQuery = true)
    List<Drivers> findAllByRentalDay(Date date);
}
