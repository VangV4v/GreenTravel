/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories.hql;

import com.cusc.entities.Restaurants;
import java.util.List;

/**
 *
 * @author kyqua
 */
public interface RestaurantHQL {
    
     List<Restaurants> findAllRestaurantByDestinationIDandRateStar(Integer destinationID, String keyword, Integer rateStar);
}
