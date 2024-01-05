/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller;

import com.cusc.dto.FilterDestinationDTO;
import com.cusc.dto.FilterHotelDTO;
import com.cusc.service.DestinationManageService;
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
public class DestinationController {
    
    @Autowired
    DestinationManageService destinationManageService;
    
      @GetMapping("/destination/page/{page}")
    public String viewHotel(Model model, @PathVariable("page") int page){
       return destinationManageService.viewDestinationClient(model, page);
    }
    
     @PostMapping("/filter-destination")
    public String filterHotel(@ModelAttribute("filterDestination") FilterDestinationDTO filterDestinationDTO, Model model){
       return destinationManageService.searchDestination(filterDestinationDTO, model);
    }
}
