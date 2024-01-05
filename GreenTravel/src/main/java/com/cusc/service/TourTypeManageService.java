/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;


import com.cusc.dto.TourTypeDTO;
import com.cusc.entities.TourTypes;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface TourTypeManageService {
    
    String viewTourType(Model model);
    
    String createTourType(Model model);
    
    String createTourType(TourTypeDTO tourTypesDTO, BindingResult br, Model model);
    
    String editTourType(Model model, int id);
    
    String editTourType(TourTypeDTO tourTypesDTO, BindingResult br, Model model, int id);
    
    String deleteTourType(HttpServletRequest request);
 
}
