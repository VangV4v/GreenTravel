/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.ProvinceDTO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface ProvinceManageService {
    String viewProvince(Model model);
    
    String createProvince(Model model);
    
    String createProvince(ProvinceDTO provinceDTO, BindingResult br, Model model);
    
    String editProvince(Model model, int id);
    
    String editProvince(ProvinceDTO provinceDTO, BindingResult br, Model model, int id);
    
    String deleteProvince(HttpServletRequest request);
}
