/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.dto.CarModelDTO;
import com.cusc.entities.CarModels;
import com.cusc.repositories.CarModelsRepository;
import com.cusc.service.AdminCarModelManageService;
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
public class CarModelManageServiceimpl implements AdminCarModelManageService {

    @Autowired
    private CarModelsRepository carModelsRepository;
    

    @Override
    public String viewCarModel(Model model) {
        model.addAttribute("listCarModel", carModelsRepository.findAll());
        return "ad_view_carmodel";
    }

    @Override
    public String createCarModel(Model model) {
        CarModelDTO dto = new CarModelDTO();
        model.addAttribute("carmodel", dto);
        return "ad_create_carmodel";
    }

    @Override
    public String createCarModel(CarModelDTO dto, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("carmodel", dto);
            return "ad_create_carmodel";
        }
        CarModels carModels = dto.tranferToEntities();
        carModelsRepository.save(carModels);
        return "redirect:/admin/employee/manage-carmodel/home-carmodel?success=true";
    }

    @Override
    public String editCarModel(Model model, int i) {
        CarModels carModels = carModelsRepository.findById(i).get();
        CarModelDTO dto = new CarModelDTO();
        dto.getData(carModels);
        model.addAttribute("carmodel", dto);
        return "ad_edit_carmodel";
    }

    @Override
    public String editCarModel(CarModelDTO cmdto, BindingResult br, Model model, int i) {
        if (br.hasErrors()) {
            model.addAttribute("carmodel", cmdto);
            return "ad_edit_carmodel";
        }
        CarModels carModels = cmdto.tranferToEntities();
        carModelsRepository.save(carModels);
        return "redirect:/admin/employee/manage-carmodel/home-carmodel?success=true";
    }

    @Override
    public String deleteCarModel(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("carmodelID"));
        carModelsRepository.deleteById(id);
        return "redirect:/admin/employee/manage-carmodel/home-carmodel";
    }

    @Override
    public String viewDetailCarModel(Model model, int i) {
        CarModels carmodel = carModelsRepository.findById(i).get();
        model.addAttribute("carmodel", carmodel);
        return "ad_detail_carmodel";
    }

}
