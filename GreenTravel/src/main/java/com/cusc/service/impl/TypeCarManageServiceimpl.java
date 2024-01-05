/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.dto.TypeCarDTO;
import com.cusc.entities.TypeCars;
import com.cusc.repositories.TypeCarsRepository;
import com.cusc.service.TypeCarManageService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
@Service
public class TypeCarManageServiceimpl implements TypeCarManageService {

    @Autowired
    private TypeCarsRepository typeCarsRepository;

    @Override
    public String viewTypeCar(Model model) {
        model.addAttribute("listTypeCar", typeCarsRepository.findAll());
        System.out.println(typeCarsRepository.findAll().size());
        return "ad_view_typecar";
    }

    @Override
    public String createTypeCar(Model model) {
        TypeCarDTO dto = new TypeCarDTO();
        model.addAttribute("typecar", dto);
        return "ad_create_typecar";
    }

    @Override
    public String createTypeCar(TypeCarDTO dto, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("typecar", dto);
            return "ad_create_typecar";
        }
        TypeCars typeCars = dto.tranferToEntities();
        typeCarsRepository.save(typeCars);
        return "redirect:/admin/employee/manage-typecar/home-typecar?success=true";
    }

    @Override
    public String editTypeCar(Model model, int i) {
        TypeCars typeCars = typeCarsRepository.findById(i).get();
        TypeCarDTO dto = new TypeCarDTO();
        dto.getData(typeCars);
        model.addAttribute("typecar", dto);
        return "ad_edit_typecar";
    }

    @Override
    public String editTypeCar(TypeCarDTO tcdto, BindingResult br, Model model, int i) {
        if (br.hasErrors()) {
            model.addAttribute("typecar", tcdto);
            return "ad_edit_typecar";
        }
        TypeCars typeCars = tcdto.tranferToEntities();
        typeCarsRepository.save(typeCars);
        return "redirect:/admin/employee/manage-typecar/home-typecar?success=true";
    }

    @Override
    public String deleteTypeCar(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("typeCarID"));
        typeCarsRepository.deleteById(id);
        return "redirect:/admin/employee/manage-typecar/home-typecar";
    }

    @Override
    public String viewDetailTypeCar(Model model, int id) {
        TypeCars typeCars = typeCarsRepository.findById(id).get();
        TypeCarDTO dto = new TypeCarDTO();
        dto.getData(typeCars);
        model.addAttribute("typecar", dto);
        return "ad_detail_typecar";
    }

}
