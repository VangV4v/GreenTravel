/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories;

import com.cusc.entities.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kyqua
 */
public interface FlightsRepository extends JpaRepository<Flights, Integer>{
    
}
