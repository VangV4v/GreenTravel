/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.FilterHotelDTO;
import com.cusc.dto.HotelDTO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface HotelManageService {
    
    String viewHotel(Model model);
    
    String createHotel(Model model);
    
    String createHotel(HotelDTO hotelDTO, BindingResult br, Model model);
    
    String editHotel(Model model, int id);
    
    String editHotel(HotelDTO hotelDTO, BindingResult br, Model model, int id);
    
    String viewDetailHotel(Model model, int id);   
    
    String deleteHotel(HttpServletRequest request);
    
    String viewHotelClient(Model model, int pageIndex);
    
    String filterHotel(FilterHotelDTO filterHotelDTO, Model model);
}
