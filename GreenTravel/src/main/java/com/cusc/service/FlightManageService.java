/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.FilterFlightDTO;
import com.cusc.dto.FlightDTO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
/**
 *
 * @author kyqua
 */
public interface FlightManageService {
    String viewFlight(Model model);
    
    String viewDetailFlight(Model model, int id);

    String createFlight(Model model);
    
    String createFlight(FlightDTO flightDTO, BindingResult br, Model model);
    
    String editFlight(Model model, int id);
    
    String editFlight(FlightDTO flightDTO, BindingResult br, Model model, int id);
    
    String deleteFlight(HttpServletRequest request);
    
    String filterFlight(FilterFlightDTO filterFlightDTO, Model model);
    
    String viewFlightClient(Model model, int pageIndex);
    
    String searchFlightByDate(FilterFlightDTO filterFlightDTO, Model model);
}
