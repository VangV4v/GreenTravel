/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.dto.ProvinceDTO;
import com.cusc.entities.Provinces;
import com.cusc.repositories.ProvincesRepository;
import com.cusc.service.ProvinceManageService;
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
public class ProvinceManageServiceimpl implements ProvinceManageService{

    @Autowired
    ProvincesRepository provinceRepository;
    
    @Override
    public String viewProvince(Model model) {
        model.addAttribute("listProvince",provinceRepository.findAll());
        return "ad_view_province";
    }

    @Override
    public String createProvince(Model model) {
        ProvinceDTO provinceDTO = new ProvinceDTO();
        model.addAttribute("province", provinceDTO);
        return "ad_create_province";
    }

    @Override
    public String createProvince(ProvinceDTO provinceDTO, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("province", provinceDTO);
            return "ad_create_province";
        }
        
        Provinces province = provinceDTO.tranferToEntities();
        provinceRepository.save(province);
        return "redirect:/admin/employee/manage-province/home-province?success=true";
    }

    @Override
    public String editProvince(Model model, int id) {
        Provinces province = provinceRepository.findById(id).get();
        ProvinceDTO provinceDTO = new ProvinceDTO();
        provinceDTO.getData(province);
        model.addAttribute("province", provinceDTO);
        return "ad_edit_province";
    }

    @Override
    public String editProvince(ProvinceDTO provinceDTO, BindingResult br, Model model, int id) {
        if (br.hasErrors()) {
            model.addAttribute("province", provinceDTO);
            return "ad_edit_province";
        }
        Provinces province = provinceDTO.tranferToEntities();
        provinceRepository.save(province);
        return "redirect:/admin/employee/manage-province/home-province?success=true";
    }

    @Override
    public String deleteProvince(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        provinceRepository.deleteById(id);
        return "ad_view_province";
    }
    
}
