/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories;

import com.cusc.entities.BookingCars;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface BookingCarsRepository extends JpaRepository<BookingCars, Integer> {

    @Query(value = "{call getTotalBookingCarToday(?1)}", nativeQuery = true)
    Double getSumPriceByStoreProc(Date date);

    @Query(value = "select count(BookingCarID) from BookingCars where RentalDate = ?1 and Status = 1 ", nativeQuery = true)
    long getCountBookingCarByToday(Date date);

    @Query(value = "select count(bkc.BookingCarID) from BookingCars bkc join Cars cars on bkc.CarID = cars.CarID where ?1 >= bkc.RentalDate and ?1 <= bkc.ReturnDate and bkc.Status = 1", nativeQuery = true)
    long getCountBookingCarByDate(Date date);

    @Query(value = "select BookingCarID,CarID,CustomerID,EmployeeID,RentalDate,RentalName,RentalEmail,RentalPhone,RentalAddress,Note,ReturnDate,Driver,FeedBack,Price,DateOfFeedBack,Status from BookingCars where EmployeeID = ?1 and Status = 1", nativeQuery = true)
    List<BookingCars> findAllBookingCarsByEmployeeID(long id);

    @Query(value = "select BookingCarID,CarID,CustomerID,EmployeeID,RentalDate,RentalName,RentalEmail,RentalPhone,RentalAddress,Note,ReturnDate,Driver,FeedBack,Price,DateOfFeedBack,Status from BookingCars where Status != 1", nativeQuery = true)
    List<BookingCars> findAllBookingCar();
}
