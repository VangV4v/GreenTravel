/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.dto.HotelDTO;
import com.cusc.dto.LocalTravelDTO;
import com.cusc.dto.PackageTourDTO;
import com.cusc.dto.RestaurantDTO;
import com.cusc.dto.TourDTO;
import com.cusc.entities.Hotels;
import com.cusc.entities.LocalTravels;
import com.cusc.entities.Restaurants;
import com.cusc.repositories.hql.PackageTourHQL;
import com.cusc.service.PackageTourManageService;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/admin/employee/manage-packagetour/")
public class AdminPackageTourManageController {

    @Autowired
    PackageTourManageService packageTourManageService;

    @Autowired
    PackageTourHQL packageTourHQL;

    @GetMapping("home-packagetour")
    public String viewPackageTour(Model model) {
        return packageTourManageService.viewPackageTour(model);
    }

    @GetMapping("create-packagetour")
    public String createPackageTour(Model model) {
        return packageTourManageService.createPackageTour(model);
    }

    @PostMapping("create-packagetour")
    public String createPackageTour(@ModelAttribute("packageTour") @Valid PackageTourDTO packageTourDTO, BindingResult br, Model model) {
        return packageTourManageService.createPackageTour(packageTourDTO, br, model);
    }

    @GetMapping("create-tour/{id}")
    public String createTour(Model model, @PathVariable("id") int id) {
        return packageTourManageService.createTour(model, id);
    }

    @PostMapping("create-tour/{id}")
    public String createTour(@ModelAttribute("tour") @Valid TourDTO tourDTO, BindingResult br, Model model, @PathVariable("id") int id) {
        return packageTourManageService.createTour(tourDTO, br, model, id);
    }

    @GetMapping("view-packagetour/{id}")
    public String viewPackageTour(Model model, @PathVariable("id") int id) {
        return packageTourManageService.viewDetailPackageTour(model, id);
    }

    @GetMapping("load-restaurant")
    public @ResponseBody
    String loadRestaurantByDestination(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("id"));
        List<Restaurants> list = packageTourHQL.findAllRestaurentByDestinationID(id);
        List<RestaurantDTO> listDto = new ArrayList<>();
        for (Restaurants e : list) {
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.convertJsonModel(e);
            listDto.add(restaurantDTO);
        }
        Gson gson = new Gson();
        String json = gson.toJson(listDto);
        return json;
    }

    @GetMapping("load-localtravel")
    public @ResponseBody
    String loadLocalTravelByDestination(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("id"));
        List<LocalTravels> list = packageTourHQL.findAllLocalTravelByDestinationID(id);
        List<LocalTravelDTO> listDto = new ArrayList<>();
        for (LocalTravels e : list) {
            LocalTravelDTO localTravelDTO = new LocalTravelDTO();
            localTravelDTO.convertJsonModel(e);
            listDto.add(localTravelDTO);
        }
        Gson gson = new Gson();
        String json = gson.toJson(listDto);
        return json;
    }

    @GetMapping("load-hotel")
    public @ResponseBody
    String loadHotelByDestination(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("id"));
        List<Hotels> list = packageTourHQL.findAllHotelByDestinationID(id);
        List<HotelDTO> listDto = new ArrayList<>();
        for (Hotels e : list) {
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.convertJsonModel(e);
            listDto.add(hotelDTO);
        }
        Gson gson = new Gson();
        String json = gson.toJson(listDto);
        return json;
    }

    @GetMapping("edit-packagetour/{id}")
    public String editPackageTour(Model model, @PathVariable("id") int id) {

        return packageTourManageService.editPackageTour(model, id);
    }

    @PostMapping("edit-packagetour/{id}")
    public String editPackageTour(@ModelAttribute("packageTour") @Valid PackageTourDTO packageTourDTO, BindingResult br, Model model, @PathVariable("id") int id) {
        return packageTourManageService.editPackageTour(packageTourDTO, br, model, id);
    }

    @PostMapping("delete-packagetour")
    public String deletePackageTour(HttpServletRequest hsr) {
        return packageTourManageService.deletePackageTour(hsr);
    }

    @GetMapping("edit-tour/{id}")
    public String editTour(Model model, @PathVariable("id") int id) {

        return packageTourManageService.editTour(model, id);
    }

    @PostMapping("edit-tour/{id}")
    public String editTour(@ModelAttribute("tour") @Valid TourDTO tourDTO, BindingResult br, Model model, @PathVariable("id") int id) {
        return packageTourManageService.editTour(tourDTO, br, model, id);
    }

    @GetMapping("statistic-quantitytour")
    public @ResponseBody
    String staticticQuantityTourInYear(HttpServletRequest hsr) {
        return packageTourManageService.statisticQuantityTourInYear(hsr);
    }

    @GetMapping("statistic-quantitybooking")
    public @ResponseBody
    String staticticQuantityBookedInYear(HttpServletRequest hsr) {
        return packageTourManageService.staticticQuantityBookedInYear(hsr);
    }

    @GetMapping("statistic-quantitycancel")
    public @ResponseBody
    String staticticQuantityCancelInYear(HttpServletRequest hsr) {
        return packageTourManageService.staticticQuantityCancelInYear(hsr);
    }

    @GetMapping("statistic-quantityslot")
    public @ResponseBody
    String staticticQuantityAvailableSlotInYear(HttpServletRequest hsr) {
        return packageTourManageService.statisticQuantityAvailableSlotInYear(hsr);
    }

    @GetMapping("statistic-quantitytourtype")
    public @ResponseBody
    String staticticQuantityBookedTourTypeInMonth(HttpServletRequest hsr) {
        return packageTourManageService.statisticQuantityBookedTourTypeInMonth(hsr);
    }

    @GetMapping("statistic-quantityfromprovince")
    public @ResponseBody
    String staticticQuantityBookedFromProvinceInMonth(HttpServletRequest hsr) {
        return packageTourManageService.statisticQuantityBookedFromProvinceInMonth(hsr);
    }

    @GetMapping("statistic-quantityarea")
    public @ResponseBody
    String staticticQuantityBookedAreaInMonth(HttpServletRequest hsr) {
        return packageTourManageService.statisticQuantityBookedAreaInMonth(hsr);
    }
}
