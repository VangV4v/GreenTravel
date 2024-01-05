/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.FilterRestaurantDTO;
import com.cusc.dto.RestaurantDTO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface RestaurantManageService {

    String viewRestaurant(Model model);

    String createRestaurant(Model model);

    String createRestaurant(RestaurantDTO restaurantDTO, BindingResult br, Model model);

    String editRestaurant(Model model, int id);

    String editRestaurant(RestaurantDTO restaurantDTO, BindingResult br, Model model, int id);

    String viewDetailRestaurant(Model model, int id);

    String deleteRestaurant(HttpServletRequest request);

    String viewRestaurantClient(Model model, int pageIndex);

    String filterRestaurant(FilterRestaurantDTO filterRestaurantDTO, Model model);
}
