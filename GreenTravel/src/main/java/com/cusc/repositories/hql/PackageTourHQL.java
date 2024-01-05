/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories.hql;

import com.cusc.entities.Destinations;
import com.cusc.entities.Hotels;
import com.cusc.entities.LocalTravels;
import com.cusc.entities.PackageTours;
import com.cusc.entities.Restaurants;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author kyqua
 */
public interface PackageTourHQL {

    List<Destinations> findAllDestinationByArea(int areaID);

    List<Restaurants> findAllRestaurentByDestinationID(int desID);

    List<LocalTravels> findAllLocalTravelByDestinationID(int desID);
    
    List<Hotels> findAllHotelByDestinationID(int desID);   

    List<PackageTours> findAllPackageTourByFilter(Integer areaID, Integer tourTypeID, Date date,Date current);

    List<PackageTours> findAllPackageTourBySearch(String keyword, Date date);
    
    List<PackageTours> findAllPackageTourAvailable(Date date);
    
    List<PackageTours> findAllPackageTourNew(Date date);
    
    List<PackageTours> findAllPackageTourLimitDate(Date date);
    
    List<PackageTours> findAllPackageTourHot(Date date);

}
