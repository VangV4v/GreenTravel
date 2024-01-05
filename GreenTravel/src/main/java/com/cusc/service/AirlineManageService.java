/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.AirlineDTO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface AirlineManageService {
    String viewAirline(Model model);
    
    String createAirline(Model model);
    
    String createAirline(AirlineDTO airlineDTO, BindingResult br, Model model);
    
    String editAirline(Model model, int id);
    
    String editAirline(AirlineDTO airlineDTO, BindingResult br, Model model, int id);
    
    String deleteAirline(HttpServletRequest request);
}
