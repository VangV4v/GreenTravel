/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.DestinationDTO;
import com.cusc.dto.FilterDestinationDTO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface DestinationManageService {
    
    String viewDestination(Model model);
    
    String createDestination(Model model);
    
    String createDestination(DestinationDTO destinationDTO, BindingResult br, Model model);
    
    String editDestination(Model model, int id);
    
    String editDestination(DestinationDTO destinationDTO, BindingResult br, Model model, int id);
    
    String viewDetailDestination(Model model, int id);   
    
    String deleteDestination(HttpServletRequest request);
    
    String viewDestinationClient(Model model, int pageIndex);
    
    String searchDestination( FilterDestinationDTO filterDestinationDTO,Model model);
}
