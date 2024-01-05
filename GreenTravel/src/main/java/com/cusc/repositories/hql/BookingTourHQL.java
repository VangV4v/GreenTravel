/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories.hql;

import com.cusc.entities.BookingTours;
import java.util.List;

/**
 *
 * @author kyqua
 */
public interface BookingTourHQL {
    
    List<BookingTours> findAllBookingTourConfirm(Long empID);
    
    List<BookingTours> findAllBookingTour();
    
    List<BookingTours> findAllBookingTourCustomer(Long customerID);
}
