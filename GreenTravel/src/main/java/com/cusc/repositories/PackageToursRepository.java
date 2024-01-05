/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.repositories;

import com.cusc.entities.PackageTours;
import java.sql.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface PackageToursRepository extends JpaRepository<PackageTours, Integer> {

    @Modifying
    @Transactional
    @Query(value = "delete from PackageTours where PackageTourID = ?1", nativeQuery = true)
    void deleteByIdCustom(int id);

    @Query(value = "select * from PackageTours where DateStart >= ?1 and Status = 2 and Capacity > 0 order by Capacity ASC", nativeQuery = true)
    List<PackageTours> findAllPackageTourHot(Date date);

    @Query(value = "select * from PackageTours where DateStart >= ?1 and Status = 2 and Capacity > 0 order by DateStart ASC", nativeQuery = true)
    List<PackageTours> findAllPackageTourLimitDate(Date date);
}
