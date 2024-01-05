/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories;

import com.cusc.entities.BookingTours;
import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface BookingToursRepository extends JpaRepository<BookingTours, Integer> {

    @Query(value = "{call getTotalBookingTourToday(?1)}", nativeQuery = true)
    Double getSumTotalPriceByStoreProc(Date date);
    
    @Query(value = "select count(BookingTourID) from BookingTours where BookDate = ?1 and Status = 1 ", nativeQuery = true)
    long getCountBookingCarByToday(Date date);

   @Query(value = "select count(PackageTourID) from PackageTours where  ?1 >=DateStart and ?1 <=  DateEnd", nativeQuery = true)
    long getCountBookingByDate(Date date);
}
