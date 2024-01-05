/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller;

import com.cusc.dto.FilterHotelDTO;
import com.cusc.dto.FilterLocalTravelDTO;
import com.cusc.service.LocalTravelManageService;
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
public class LocalTravelController {
    
    @Autowired
    LocalTravelManageService localTravelManageService;
    
     @GetMapping("/localtravel/page/{page}")
    public String viewLocalTravel(Model model, @PathVariable("page") int page){
       return localTravelManageService.viewLocalTravelClient(model, page);
    }
    
     @PostMapping("/filter-localtravel")
    public String filterHotel(@ModelAttribute("filterLt") FilterLocalTravelDTO filterLocalTravelDTO, Model model){
       return localTravelManageService.filterLocalTravel(filterLocalTravelDTO, model);
    }
}
