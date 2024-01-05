/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cusc.service;

import com.cusc.dto.FilterPackageTourDTO;
import com.cusc.dto.PackageTourDTO;
import com.cusc.dto.TourDTO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
public interface PackageTourManageService {

    String viewPackageTour(Model model);

    String createPackageTour(Model model);

    String createPackageTour(PackageTourDTO packageTourDTO, BindingResult br, Model model);

    String createTour(Model model, int id);

    String createTour(TourDTO tourDTO, BindingResult br, Model model, int id);

    String editTour(Model model, int id);

    String editTour(TourDTO tourDTO, BindingResult br, Model model, int id);

    String editPackageTour(Model model, int id);

    String editPackageTour(PackageTourDTO packageTourDTO, BindingResult br, Model model, int id);

    String viewDetailPackageTour(Model model, int id);

    String deletePackageTour(HttpServletRequest request);

    String viewPackageTourClient(Model model, int pageIndex);

    String filterPackageTourClient(FilterPackageTourDTO filterPackageTourDTO, Model model);

    String searchPackageTourClient(FilterPackageTourDTO filterPackageTourDTO, Model model);

    String viewDetailPackageTourClient(Model model, int id);

    String statisticQuantityTourInYear(HttpServletRequest hsr);

    String statisticQuantityAvailableSlotInYear(HttpServletRequest hsr);

    String staticticQuantityBookedInYear(HttpServletRequest hsr);

    String staticticQuantityCancelInYear(HttpServletRequest hsr);
    
    String statisticQuantityBookedTourTypeInMonth(HttpServletRequest hsr);
    
    String statisticQuantityBookedFromProvinceInMonth(HttpServletRequest hsr);
    
    String statisticQuantityBookedAreaInMonth(HttpServletRequest hsr);
       
    
}
