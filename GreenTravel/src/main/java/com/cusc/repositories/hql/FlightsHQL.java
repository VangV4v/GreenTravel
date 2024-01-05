/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories.hql;

import com.cusc.entities.Flights;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author kyqua
 */
public interface FlightsHQL {

    List<Flights> filterFlight(Integer fromProvinceID, Integer toProvinceID);

    List<Flights> searchFlightByDate(Date date);
    
    long getCountFlightCode(String flightCode);
    
    List<Flights> getListFlightAvailable(Date date);

}
