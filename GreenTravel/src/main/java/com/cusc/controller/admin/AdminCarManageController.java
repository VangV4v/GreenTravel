/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.CarDTO;
import com.cusc.service.CarManageService;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kyqua
 */
@Controller
@RequestMapping("/admin/employee/manage-car/")
public class AdminCarManageController {

    @Autowired
    private CarManageService carManageService;

    @GetMapping("home-car")
    public String viewCar(Model model) {
        return carManageService.viewCar(model);
    }

    @GetMapping("create-car")
    public String createCar(Model model) {
        return carManageService.createCar(model);
    }

    @PostMapping("create-car")
    public String createCar(@ModelAttribute("car") @Valid CarDTO dto, BindingResult br, Model model) {
        return carManageService.createCar(dto, br, model);
    }

    @GetMapping("edit-car/{id}")
    public String editCar(Model model, @PathVariable("id") int id) {
        return carManageService.editCar(model, id);
    }

    @PostMapping("edit-car/{id}")
    public String editCar(@ModelAttribute("car") @Valid CarDTO carDTO, BindingResult br, Model model, HttpServletRequest request, @PathVariable("id") int id) {
        return carManageService.editCar(carDTO, br, model, request, id);
    }

    @PostMapping("delete-car")
    public String deleteCar(HttpServletRequest request) {
        return carManageService.deleteCar(request);
    }

    @GetMapping("view-car/{id}")
    public String viewDetailCar(Model model, @PathVariable("id") int id) {
        return carManageService.viewDetailCar(model, id);
    }

    @GetMapping("statistic-car-air-conditon")
    public @ResponseBody
    String statisticAirCondition(HttpServletRequest request) {
        return carManageService.statisticCarByAirCondition(request);
    }

    @GetMapping("statistic-car-un-air-conditon")
    public @ResponseBody
    String statisticUnAirCondition(HttpServletRequest request) {
        return carManageService.statisticCarByUnAirCondition(request);
    }

    @GetMapping("statistic-car-type")
    public @ResponseBody
    String statisticCarModel(HttpServletRequest request) {
        return carManageService.statisticCarByTypeCar(request);
    }

    @GetMapping("statistic-car-model")
    public @ResponseBody
    String statisticCarType(HttpServletRequest request) {
        return carManageService.statisticCarByModelCar(request);
    }
}
