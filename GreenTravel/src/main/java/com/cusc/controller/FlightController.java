/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller;

import com.cusc.dto.FilterFlightDTO;
import com.cusc.service.FlightManageService;
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
public class FlightController {
    @Autowired
    FlightManageService flightManageService;
    
    @GetMapping("/flight/page/{page}")
    public String viewHotel(Model model, @PathVariable("page") int page){
       return flightManageService.viewFlightClient(model, page);
    }
    
     @PostMapping("/filter-flight")
    public String filterFlight(@ModelAttribute("filterFlight") FilterFlightDTO filterFlightDTO, Model model){
       return flightManageService.filterFlight(filterFlightDTO, model);
    }
    
    @PostMapping("/search-flight")
    public String searchFlightByDate(@ModelAttribute("searchFlight") FilterFlightDTO filterFlightDTO, Model model){
       return flightManageService.searchFlightByDate(filterFlightDTO, model);
    }
}
