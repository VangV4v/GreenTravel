/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.repositories.CarsRepository;
import com.cusc.repositories.PackageToursRepository;
import com.cusc.repositories.hql.CarsHQL;
import com.cusc.repositories.hql.PackageTourHQL;
import com.cusc.service.HomeClient;
import java.sql.Date;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 * @author kyqua
 */
@Service
public class HomeClientimpl implements HomeClient {
    
    @Autowired
    PackageTourHQL packageTourHQL;
    
    @Autowired
    private PackageToursRepository packageToursRepository;
    
    @Autowired
    private CarsRepository carsRepository;
    
    @Autowired
    CarsHQL carsHQL;
    
    @Override
    public String homeClient(Model model) {
        LocalDate today = LocalDate.now();
        Date current = Date.valueOf(today);
        model.addAttribute("listPackageNew", packageToursRepository.findAll(Sort.by(Sort.Direction.DESC, "packageTourID")));
        model.addAttribute("listPackageHot", packageToursRepository.findAllPackageTourHot(current));
        model.addAttribute("listPackageLimitDate", packageToursRepository.findAllPackageTourLimitDate(current));
        model.addAttribute("listCarNew", carsRepository.findAll(Sort.by(Sort.Direction.DESC, "carID")));
        return "index";
    }
    
}
