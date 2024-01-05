/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller;

import com.cusc.dto.FilterRestaurantDTO;
import com.cusc.service.RestaurantManageService;
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
public class RestaurantController {
    
    @Autowired
    RestaurantManageService restaurantManageService;
    
     @GetMapping("/restaurant/page/{page}")
    public String viewRestaurantPagination(Model model,@PathVariable("page") int page){
        return restaurantManageService.viewRestaurantClient(model,page);
    }
    
     @PostMapping("/filter-restaurant")
    public String filterRestaurant(@ModelAttribute("filterRestaurant") FilterRestaurantDTO filterRestaurantDTO, Model model){
       return restaurantManageService.filterRestaurant(filterRestaurantDTO, model);
    }
}
