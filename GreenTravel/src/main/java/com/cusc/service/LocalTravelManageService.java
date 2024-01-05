/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.FilterLocalTravelDTO;
import com.cusc.dto.LocalTravelDTO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface LocalTravelManageService {
     String viewLocalTravel(Model model);
    
    String createLocalTravel(Model model);
    
    String createLocalTravel(LocalTravelDTO localTravelDTO, BindingResult br, Model model);
    
    String editLocalTravel(Model model, int id);
    
    String editLocalTravel(LocalTravelDTO localTravelDTO, BindingResult br, Model model, int id);
    
    String viewDetailLocalTravel(Model model, int id);   
    
    String deleteLocalTravel(HttpServletRequest request);
    
    String viewLocalTravelClient(Model model, int pgaeIndex);
    
    String filterLocalTravel(FilterLocalTravelDTO filterLocalTravelDTO, Model model);
}
