/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cusc.dto.DriverDTO;
import com.cusc.entities.Drivers;
import com.cusc.repositories.DriversRepository;
import com.cusc.service.DriverManageService;
import java.util.Map;
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
public class DriverManageServiceimpl implements DriverManageService {

    @Autowired
    private DriversRepository driversRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String viewDriver(Model model) {
        model.addAttribute("listDriver", driversRepository.findAll());      
        return "ad_view_driver";
    }

    @Override
    public String createDriver(Model model) {
        DriverDTO dto = new DriverDTO();
        String[] listLicenseCar = {"B1", "B2", "C", "D", "E", "F"};
        model.addAttribute("listLicense", listLicenseCar);
        model.addAttribute("driver", dto);
        return "ad_create_driver";
    }

    @Override
    public String createDriver(DriverDTO ddto, BindingResult br, Model model) {
        if (br.hasErrors()) {
            String[] listLicenseCar = {"B1", "B2", "C", "D", "E", "F"};
            model.addAttribute("listLicense", listLicenseCar);
            model.addAttribute("driver", ddto);
            return "ad_create_driver";
        }
        if (!ddto.getImg().isEmpty()) {
            try {
                String imgName = "DRIVER_" + ddto.getDriverName();
                cloudinary.uploader().destroy(imgName, ObjectUtils.asMap("resouce_type", "auto", "public_id", imgName));
                Map upload = cloudinary.uploader().upload(ddto.getImg().getBytes(), ObjectUtils.asMap("public_id", imgName));
                ddto.setAvatar((String) upload.get("secure_url"));
            } catch (Exception e) {
            }
        }
        Drivers drivers = ddto.tranferToEntities();
        drivers.setStatus(true);
        driversRepository.save(drivers);
        return "redirect:/admin/employee/manage-driver/home-driver?success=true";
    }

    @Override
    public String editDriver(Model model, int id) {
        Drivers drivers = driversRepository.findById(id).get();
        DriverDTO dto = new DriverDTO();
        dto.getData(drivers);
        String[] listLicenseCar = {"B1", "B2", "C", "D", "E", "F"};
        model.addAttribute("listLicense", listLicenseCar);
        model.addAttribute("driver", dto);
        return "ad_edit_driver";
    }

    @Override
    public String editDriver(DriverDTO ddto, BindingResult br, Model model, int i) {
        if (br.hasErrors()) {
            String[] listLicenseCar = {"B1", "B2", "C", "D", "E", "F"};
            model.addAttribute("listLicense", listLicenseCar);
            model.addAttribute("driver", ddto);
            return "ad_edit_driver";
        }
        if (!ddto.getImg().isEmpty()) {
            try {
                String imgName = "DRIVER_" + ddto.getDriverName();
                cloudinary.uploader().destroy(imgName, ObjectUtils.asMap("resouce_type", "auto", "public_id", imgName));
                Map upload = cloudinary.uploader().upload(ddto.getImg().getBytes(), ObjectUtils.asMap("public_id", imgName));
                ddto.setAvatar((String) upload.get("secure_url"));
            } catch (Exception e) {
            }
        }
        Drivers drivers = ddto.tranferToEntities();
        driversRepository.save(drivers);
        return "redirect:/admin/employee/manage-driver/home-driver?success=true";
    }

    @Override
    public String deleteDriver(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("driverID"));
        driversRepository.deleteById(id);
        return "redirect:/admin/employee/manage-driver/home-driver";
    }

    @Override
    public String viewDetailDriver(Model model, int i) {
        Drivers drivers = driversRepository.findById(i).get();
        DriverDTO dto = new DriverDTO();
        dto.getData(drivers);
        model.addAttribute("driver", dto);
        return "ad_detail_driver";
    }

}
