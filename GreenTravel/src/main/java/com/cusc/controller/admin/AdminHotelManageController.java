/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.HotelDTO;
import com.cusc.service.HotelManageService;
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
@RequestMapping("/admin/employee/manage-hotel/")
public class AdminHotelManageController {

    @Autowired
    HotelManageService hotelManageService;

    @GetMapping("home-hotel")
    public String viewHotel(Model model) {
        return hotelManageService.viewHotel(model);
    }

    @GetMapping("create-hotel")
    public String createHotel(Model model) {
        return hotelManageService.createHotel(model);
    }

    @PostMapping("create-hotel")
    public String createHotel(@ModelAttribute("hotel") @Valid HotelDTO hotelDTO, BindingResult br, Model model) {
        return hotelManageService.createHotel(hotelDTO, br, model);
    }

    @GetMapping("edit-hotel/{id}")
    public String editHotel(Model model, @PathVariable("id") int id) {
        return hotelManageService.editHotel(model, id);
    }

    @PostMapping("edit-hotel/{id}")
    public String editHotel(@ModelAttribute("hotel") @Valid HotelDTO hotelDTO, BindingResult br, Model model, @PathVariable("id") int id) {
        return hotelManageService.editHotel(hotelDTO, br, model, id);
    }

    @PostMapping("delete-hotel")
    public String deleteHotel(HttpServletRequest hsr) {
        return hotelManageService.deleteHotel(hsr);
    }

    @GetMapping("view-hotel/{id}")
    public String viewDetailHotel(Model model, @PathVariable("id") int id) {
        return hotelManageService.viewDetailHotel(model, id);
    }
}
