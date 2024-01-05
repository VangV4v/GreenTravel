/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.AreaDTO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface AreaManageService {
    
    String viewArea(Model model);
    
    String createArea(Model model);
    
    String createArea(AreaDTO areaDTO, BindingResult br, Model model);
    
    String editArea(Model model, int id);
    
    String editArea(AreaDTO areaDTO, BindingResult br, Model model, int id);
    
    String viewDetailArea(Model model, int id);   
    
    String deleteArea(HttpServletRequest request);
}
