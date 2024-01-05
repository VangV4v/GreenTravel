/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cloudinary.Cloudinary;
import com.cusc.dto.AreaDTO;
import com.cusc.entities.Areas;
import com.cusc.entities.Provinces;
import com.cusc.repositories.AreasRepository;
import com.cusc.repositories.ProvincesRepository;
import com.cusc.service.AreaManageService;
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
public class AreaManageServiceimpl implements AreaManageService {

    @Autowired
    AreasRepository areasRepository;

    @Autowired
    ProvincesRepository provincesRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String viewArea(Model model) {
        model.addAttribute("listArea", areasRepository.findAll());
        return "ad_view_area";
    }

    @Override
    public String createArea(Model model) {
        AreaDTO areaDTO = new AreaDTO();
        model.addAttribute("area", areaDTO);
        model.addAttribute("listProvince", provincesRepository.findAll());
        return "ad_create_area";
    }

    @Override
    public String createArea(AreaDTO areaDTO, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("area", areaDTO);
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_create_area";
        }
        Provinces province = provincesRepository.findById(areaDTO.getProvinceID()).get();
        if (province.getAreasList().size() == 1) {
            br.rejectValue("provinceID", "500", "This province have existed area. Please select other province");
            model.addAttribute("area", areaDTO);
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_create_area";
        }
        Areas area = areaDTO.tranferToEntities();
        area.setProvinceID(province);
       
        areasRepository.save(area);
        return "redirect:/admin/employee/manage-area/home-area?success=true";
    }

    @Override
    public String editArea(Model model, int id) {
        Areas area = areasRepository.findById(id).get();
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.getData(area);
        model.addAttribute("area", areaDTO);
        model.addAttribute("listProvince", provincesRepository.findAll());
        return "ad_edit_area";
    }

    @Override
    public String editArea(AreaDTO areaDTO, BindingResult br, Model model, int id) {
        if (br.hasErrors()) {
            model.addAttribute("area", areaDTO);
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_edit_area";
        }
        Areas a = areasRepository.findById(id).get();

        Provinces province = provincesRepository.findById(areaDTO.getProvinceID()).get();
        if (!a.getProvinceID().getProvinceID().equals(province.getProvinceID())) {
            if (province.getAreasList().size() == 1) {
                br.rejectValue("provinceID", "500", "This province have existed area. Please select other province");
                model.addAttribute("area", areaDTO);
                model.addAttribute("listProvince", provincesRepository.findAll());
                return "ad_edit_area";
            }
        }
        Areas area = areaDTO.tranferToEntities();
        area.setProvinceID(province);
    
        areasRepository.save(area);
        return "redirect:/admin/employee/manage-area/home-area?success=true";
    }

    @Override
    public String viewDetailArea(Model model, int id) {
        Areas area = areasRepository.findById(id).get();
        model.addAttribute("area", area);
        return "ad_detail_area";
    }

    @Override
    public String deleteArea(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Areas area = areasRepository.findById(id).get();     
        areasRepository.deleteById(id);
        return "ad_view_area";
    }

}
