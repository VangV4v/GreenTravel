/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.TourTypeDTO;
import com.cusc.service.TourTypeManageService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kyqua
 */
@Controller
@RequestMapping("/admin/employee/manage-tourtype/")
public class AdminTourTypeManageController {

    @Autowired
    private TourTypeManageService tourTypeManageService;

    @GetMapping("home-tourtype")
    public String viewTourType(Model model) {
        return tourTypeManageService.viewTourType(model);
    }

    @GetMapping("create-tourtype")
    public String createTourType(Model model) {
        return tourTypeManageService.createTourType(model);
    }

    @PostMapping("create-tourtype")
    public String createTourType(@ModelAttribute("tourtype") @Valid TourTypeDTO tourTypesDTO, BindingResult br, Model model) {
        return tourTypeManageService.createTourType(tourTypesDTO, br, model);
    }

    @GetMapping("edit-tourtype/{id}")
    public String editTourType(Model model, @PathVariable("id") int id) {

        return tourTypeManageService.editTourType(model, id);
    }

    @PostMapping("edit-tourtype/{id}")
    public String editTourType(@ModelAttribute("tourtype") @Valid TourTypeDTO tourTypesDTO, BindingResult br, Model model, @PathVariable("id") int id) {
        return tourTypeManageService.editTourType(tourTypesDTO, br, model, id);
    }

    @PostMapping("delete-tourtype")
    public String deleteTourType(HttpServletRequest hsr) {
        return tourTypeManageService.deleteTourType(hsr);
    }
}
