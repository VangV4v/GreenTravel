/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.dto.TourTypeDTO;
import com.cusc.entities.TourTypes;
import com.cusc.repositories.TourTypesRepository;
import com.cusc.service.TourTypeManageService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
@Service
public class TourTypeManageServiceimpl implements TourTypeManageService {

    @Autowired
    private TourTypesRepository tourTypesRepository;

    @Override
    public String viewTourType(Model model) {
        model.addAttribute("listTourType", tourTypesRepository.findAll());
        return "ad_view_tourtype";
    }

    @Override
    public String createTourType(Model model) {
        TourTypeDTO tourTypesDTO = new TourTypeDTO();
        model.addAttribute("tourtype", tourTypesDTO);
        return "ad_create_tourtype";
    }

    @Override
    public String createTourType(TourTypeDTO tourTypesDTO, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("tourtype", tourTypesDTO);
            return "ad_create_tourtype";
        }
        TourTypes tourType = tourTypesDTO.tranferToEntities();
        tourTypesRepository.save(tourType);
        return "redirect:/admin/employee/manage-tourtype/home-tourtype?success=true";
    }

    @Override
    public String editTourType(Model model, int id) {
        TourTypes tourTypes = new TourTypes();
        tourTypes = tourTypesRepository.findById(id).get();
        TourTypeDTO tourTypesDTO = new TourTypeDTO();
        tourTypesDTO.getData(tourTypes);
        model.addAttribute("tourtype", tourTypesDTO);
        return "ad_edit_tourtype";
    }

    @Override
    public String editTourType(TourTypeDTO tourTypesDTO, BindingResult br, Model model, int id) {
        if (br.hasErrors()) {
            model.addAttribute("tourtype", tourTypesDTO);
            return "ad_edit_tourtype";
        }

        TourTypes tourTypes = tourTypesDTO.tranferToEntities();
        tourTypesRepository.save(tourTypes);
        return "redirect:/admin/employee/manage-tourtype/home-tourtype?success=true";
    }

    @Override
    public String deleteTourType(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("id"));
        tourTypesRepository.deleteById(id);
        return "redirect:/admin/employee/manage-tourtype/home-tourtype";
    }

}
