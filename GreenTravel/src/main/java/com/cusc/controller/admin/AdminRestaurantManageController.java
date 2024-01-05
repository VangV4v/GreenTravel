/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.RestaurantDTO;
import com.cusc.service.RestaurantManageService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kyqua
 */
@Controller
@RequestMapping("/admin/employee/manage-restaurant/")
public class AdminRestaurantManageController {

    @Autowired
    RestaurantManageService restaurantManageService;

    @GetMapping("home-restaurant")
    public String viewRestaurant(Model model) {
        return restaurantManageService.viewRestaurant(model);
    }

    @GetMapping("create-restaurant")
    public String createRestaurant(Model model) {
        return restaurantManageService.createRestaurant(model);
    }

    @PostMapping("create-restaurant")
    public String createRestaurant(@ModelAttribute("restaurant") @Valid RestaurantDTO restaurantDTO, BindingResult br, Model model) {
        return restaurantManageService.createRestaurant(restaurantDTO, br, model);
    }

    @GetMapping("edit-restaurant/{id}")
    public String editRestaurant(Model model, @PathVariable("id") int id) {
        return restaurantManageService.editRestaurant(model, id);
    }

    @PostMapping("edit-restaurant/{id}")
    public String editRestaurant(@ModelAttribute("restaurant") @Valid RestaurantDTO restaurantDTO, BindingResult br, Model model, @PathVariable("id") int id) {
        return restaurantManageService.editRestaurant(restaurantDTO, br, model, id);
    }

    @PostMapping("delete-restaurant")
    public String deleteRestaurant(HttpServletRequest hsr) {
        return restaurantManageService.deleteRestaurant(hsr);
    }

    @GetMapping("view-restaurant/{id}")
    public String viewDetailRestaurant(Model model, @PathVariable("id") int id) {
        return restaurantManageService.viewDetailRestaurant(model, id);
    }
}
