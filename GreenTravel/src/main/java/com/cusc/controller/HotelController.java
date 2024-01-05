/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller;

import com.cusc.dto.FilterHotelDTO;
import com.cusc.service.HotelManageService;
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
public class HotelController {
    
    @Autowired
    HotelManageService hotelManageService;
    
    @GetMapping("/hotel/page/{page}")
    public String viewHotel(Model model, @PathVariable("page") int page){
       return hotelManageService.viewHotelClient(model, page);
    }
    
     @PostMapping("/filter-hotel")
    public String filterHotel(@ModelAttribute("filterHotel") FilterHotelDTO filterHotelDTO, Model model){
       return hotelManageService.filterHotel(filterHotelDTO, model);
    }
}
