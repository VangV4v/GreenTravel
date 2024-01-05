/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.dto.AirlineDTO;
import com.cusc.entities.Airlines;
import com.cusc.repositories.AirlinesRepository;
import com.cusc.service.AirlineManageService;
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
public class AirlineManageServiceimpl implements AirlineManageService{

    @Autowired
    AirlinesRepository airlinesRepository;
    
    @Override
    public String viewAirline(Model model) {
        model.addAttribute("listAirline", airlinesRepository.findAll());
        return "ad_view_airline";
    }

    @Override
    public String createAirline(Model model) {
        AirlineDTO airlineDTO = new AirlineDTO();
        model.addAttribute("airline", airlineDTO);
        return "ad_create_airline";
    }

    @Override
    public String createAirline(AirlineDTO airlineDTO, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("airline", airlineDTO);
            return "ad_create_airline";
        }
        
        Airlines airline = airlineDTO.tranferToEntities();
        airlinesRepository.save(airline);
        return "redirect:/admin/employee/manage-airline/home-airline?success=true";
    }

    @Override
    public String editAirline(Model model, int id) {
        Airlines airline = airlinesRepository.findById(id).get();
        AirlineDTO airlineDTO = new AirlineDTO();
        airlineDTO.getData(airline);
        model.addAttribute("airline", airlineDTO);
        return "ad_edit_airline";
    }

    @Override
    public String editAirline(AirlineDTO airlineDTO, BindingResult br, Model model, int id) {
        if (br.hasErrors()) {
            model.addAttribute("airline", airlineDTO);
            return "ad_edit_airline";
        }
        Airlines airlines = airlineDTO.tranferToEntities();
        airlinesRepository.save(airlines);
        return "redirect:/admin/employee/manage-airline/home-airline?success=true";
    }

    @Override
    public String deleteAirline(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        airlinesRepository.deleteById(id);
        return "ad_view_airline";
    }
    
}
