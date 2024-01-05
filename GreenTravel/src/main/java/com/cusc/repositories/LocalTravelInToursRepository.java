/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories;

import com.cusc.entities.LocalTravelInTours;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface LocalTravelInToursRepository extends JpaRepository<LocalTravelInTours, Integer> {

    @Modifying
    @Transactional
    @Query(value = "delete from LocalTravelInTours where LocalTravelInTourID = ?1", nativeQuery = true)
    void deleteByIdCustom(int id);

}
