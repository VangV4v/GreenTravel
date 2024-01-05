/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.service.RevenueCarManageService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kyqua
 */
@Controller
@RequestMapping("/admin/manage-revenuecar/")
public class AdminRevenueCarManageController {

    @Autowired
    RevenueCarManageService revenueCarManageService;

    @GetMapping("home-revenuecar")
    public String homeRevenueCar(Model model) {
        return revenueCarManageService.homeRevenueCar(model);
    }

    @GetMapping("revenue-carmodel")
    public @ResponseBody
    String revenueCarModelInMonth(HttpServletRequest hsr) {
        return revenueCarManageService.revenueCarModelInMonth(hsr);
    }

    @GetMapping("revenue-cartype")
    public @ResponseBody
    String revenueCarTypeInMonth(HttpServletRequest hsr) {
        return revenueCarManageService.revenueCarTypeInMonth(hsr);
    }

    @GetMapping("revenue-car-non-air-condition-year")
    public @ResponseBody
    String revenueCarNonAirConditionInYear(HttpServletRequest hsr) {
        return revenueCarManageService.revenueNonAirConditionedCarInYear(hsr);
    }

    @GetMapping("revenue-car-air-condition-year")
    public @ResponseBody
    String revenueCarAirConditionInYear(HttpServletRequest hsr) {
        return revenueCarManageService.revenueAirConditionedCarInYear(hsr);
    }

    @GetMapping("revenue-car-year")
    public @ResponseBody
    String revenueCarInYear(HttpServletRequest hsr) {
        return revenueCarManageService.revenueCarInYear(hsr);
    }

}
