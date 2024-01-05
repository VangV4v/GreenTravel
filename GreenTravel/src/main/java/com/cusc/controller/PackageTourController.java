/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller;

import com.cusc.dto.FilterPackageTourDTO;
import com.cusc.service.PackageTourManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author kyqua
 */
@Controller
public class PackageTourController {
    
    @Autowired
    PackageTourManageService packageTourManageService;
    
//    @GetMapping("/packagetour")
//    public String viewPackageTour(Model model){
//        return packageTourManageService.viewPackageTourClient(model);
//    }
    
    @GetMapping("/packagetour/page/{page}")
    public String viewPackageTourPagination(Model model,@PathVariable("page") int page){
        return packageTourManageService.viewPackageTourClient(model,page);
    }
    
     @GetMapping("/packagetour/detail/{id}")
    public String viewDetailPackageTour(Model model,@PathVariable("id") int id){
        return packageTourManageService.viewDetailPackageTourClient(model,id);
    }
         
    @PostMapping("/filter-packagetour")
    public String filterPackageTour(@ModelAttribute("filterPackageTour") FilterPackageTourDTO filterPackageTourDTO,Model model){
        return packageTourManageService.filterPackageTourClient(filterPackageTourDTO,model);
    }     
    
    @PostMapping("/search-packagetour")
    public String searchPackageTour(@ModelAttribute("searchPackageTour") FilterPackageTourDTO filterPackageTourDTO,Model model){
        return packageTourManageService.searchPackageTourClient(filterPackageTourDTO,model);
    }
}
