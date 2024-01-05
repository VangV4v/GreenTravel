/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories.hql;

import com.cusc.entities.Cars;
import java.util.List;

/**
 *
 * @author kyqua
 */
public interface CarsHQL {

    long getCountByCarName(String carname);

    List<Cars> findAllByTypeIDAndModelID(int typeid, int modelid);

    List<Cars> findAllByCarName(String carname);
    
    List<Cars> findAllCarNew();
}
