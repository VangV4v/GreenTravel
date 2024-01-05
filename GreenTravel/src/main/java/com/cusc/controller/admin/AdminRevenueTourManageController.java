/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.service.RevenueTourManageService;
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
@RequestMapping("/admin/manage-revenuetour/")
public class AdminRevenueTourManageController {

    @Autowired
    RevenueTourManageService revenueTourManageService;

    @GetMapping("home-revenuetour")
    public String homeRevenueTour(Model model) {
        return revenueTourManageService.homeRevenueTour(model);
    }

    @GetMapping("revenue-tourtype")
    public @ResponseBody
    String revenueTourTypeInMonth(HttpServletRequest hsr) {
        return revenueTourManageService.revenueTourTypeInMonth(hsr);
    }

    @GetMapping("revenue-tourarea")
    public @ResponseBody
    String revenueTourAreaInMonth(HttpServletRequest hsr) {
        return revenueTourManageService.revenueTourAreaInMonth(hsr);
    }

    @GetMapping("revenue-province")
    public @ResponseBody
    String revenueProvinceInMonth(HttpServletRequest hsr) {
        return revenueTourManageService.revenueProvinceInMonth(hsr);
    }

    @GetMapping("revenue-tour-year")
    public @ResponseBody
    String revenueTourInYear(HttpServletRequest request) {
        return revenueTourManageService.revenueBookingTourInYear(request);
    }
}
