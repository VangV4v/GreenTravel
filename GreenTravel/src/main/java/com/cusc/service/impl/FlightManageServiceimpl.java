/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.dto.FilterFlightDTO;
import com.cusc.dto.FlightDTO;
import com.cusc.entities.Flights;
import com.cusc.repositories.AirlinesRepository;
import com.cusc.repositories.FlightsRepository;
import com.cusc.repositories.ProvincesRepository;
import com.cusc.repositories.hql.FlightsHQL;
import com.cusc.service.FlightManageService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class FlightManageServiceimpl implements FlightManageService {

    @Autowired
    FlightsRepository flightsRepository;
    @Autowired
    AirlinesRepository airlinesRepository;
    @Autowired
    ProvincesRepository provincesRepository;
    @Autowired
    FlightsHQL flightHQL;

    @Override
    public String viewFlight(Model model) {
        model.addAttribute("listFlight", flightsRepository.findAll());
        LocalDate today = LocalDate.now();
        java.sql.Date current = java.sql.Date.valueOf(today);
        model.addAttribute("today", current);
        return "ad_view_flight";
    }

    @Override
    public String viewDetailFlight(Model model, int id) {
        Flights flight = flightsRepository.findById(id).get();
        model.addAttribute("flight", flight);
        LocalDate today = LocalDate.now();
        java.sql.Date current = java.sql.Date.valueOf(today);
        model.addAttribute("today", current);
        return "ad_detail_flight";
    }

    @Override
    public String createFlight(Model model) {
        FlightDTO flightDTO = new FlightDTO();
        long millis = System.currentTimeMillis();
        java.sql.Date current = new java.sql.Date(millis);
        model.addAttribute("flight", flightDTO);
        model.addAttribute("listAirline", airlinesRepository.findAll());
        model.addAttribute("listProvince", provincesRepository.findAll());
        return "ad_create_flight";
    }

    @Override
    public String createFlight(FlightDTO flightDTO, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("flight", flightDTO);
            model.addAttribute("listAirline", airlinesRepository.findAll());
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_create_flight";
        }
        if (flightDTO.getFromProvinceID() == flightDTO.getToProvinceID()) {
            br.rejectValue("toProvinceID", "500", "Province required different");
            model.addAttribute("flight", flightDTO);
            model.addAttribute("listAirline", airlinesRepository.findAll());
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_create_flight";
        }
        if (flightHQL.getCountFlightCode(flightDTO.getFlightCode()) > 0) {
            br.rejectValue("flightCode", "500", "Flight code cannot be duplicate");
            model.addAttribute("flight", flightDTO);
            model.addAttribute("listAirline", airlinesRepository.findAll());
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_create_flight";
        }
        Date current = new Date();
        if (!flightDTO.getDepartureDate().after(current)) {
            br.rejectValue("departureDate", "500", "Departure date must greater than current date");
            model.addAttribute("flight", flightDTO);
            model.addAttribute("listAirline", airlinesRepository.findAll());
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_create_flight";
        }

        Flights flight = flightDTO.tranferToEntities();
        flight.setStatus(0);
        flight.setAirlineID(airlinesRepository.findById(flightDTO.getAirlineID()).get());
        flight.setFromProvince(provincesRepository.findById(flightDTO.getFromProvinceID()).get());
        flight.setToProvince(provincesRepository.findById(flightDTO.getToProvinceID()).get());
        flightsRepository.save(flight);
        return "redirect:/admin/employee/manage-flight/home-flight?success=true";
    }

    @Override
    public String editFlight(Model model, int id) {
        Flights flight = flightsRepository.findById(id).get();
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.getData(flight);
        model.addAttribute("flight", flightDTO);
        model.addAttribute("listAirline", airlinesRepository.findAll());
        model.addAttribute("listProvince", provincesRepository.findAll());
        return "ad_edit_flight";
    }

    @Override
    public String editFlight(FlightDTO flightDTO, BindingResult br, Model model, int id) {
        if (br.hasErrors()) {
            model.addAttribute("flight", flightDTO);
            model.addAttribute("listAirline", airlinesRepository.findAll());
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_edit_flight";
        }
        Flights flight = flightDTO.tranferToEntities();
        flight.setAirlineID(airlinesRepository.findById(flightDTO.getAirlineID()).get());
        flight.setFromProvince(provincesRepository.findById(flightDTO.getFromProvinceID()).get());
        flight.setToProvince(provincesRepository.findById(flightDTO.getToProvinceID()).get());
        flightsRepository.save(flight);
        return "redirect:/admin/employee/manage-flight/home-flight?success=true";

    }

    @Override
    public String deleteFlight(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        flightsRepository.deleteById(id);
        return "ad_view_flight";
    }

    @Override
    public String filterFlight(FilterFlightDTO filterFlightDTO, Model model) {
        model.addAttribute("listProvince", provincesRepository.findAll());
        model.addAttribute("filterFlight", filterFlightDTO);
        model.addAttribute("searchFlight", filterFlightDTO);
        if (filterFlightDTO.getFromProvinceID() == 0) {
            filterFlightDTO.setFromProvinceID(null);
        }
        if (filterFlightDTO.getToProvinceID() == 0) {
            filterFlightDTO.setToProvinceID(null);
        }
        model.addAttribute("listFlight", flightHQL.filterFlight(filterFlightDTO.getFromProvinceID(), filterFlightDTO.getToProvinceID()));
        return "flight";
    }

    @Override
    public String viewFlightClient(Model model, int pageIndex) {
        model.addAttribute("listProvince", provincesRepository.findAll());
        FilterFlightDTO filterFlightDTO = new FilterFlightDTO();
        model.addAttribute("filterFlight", filterFlightDTO);
        model.addAttribute("searchFlight", filterFlightDTO);

        int pageSize = 9;
        int maxPage = 2;     
        LocalDate today = LocalDate.now();
        java.sql.Date current = java.sql.Date.valueOf(today);
        int totalRecord = flightHQL.getListFlightAvailable(current).size();
        model.addAttribute("totalRecord", totalRecord);
        pageIndex = Integer.valueOf(pageIndex) == null ? 1 : pageIndex;
        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("pageSize", pageSize);
        int totalPage = (int) Math.ceil(Double.valueOf(totalRecord) / Double.valueOf(pageSize));
        List<Flights> listFlight = new ArrayList<>();
        if (pageIndex == totalPage) {
            listFlight = flightHQL.getListFlightAvailable(current).subList((pageIndex - 1) * pageSize, totalRecord);
        } else {
            listFlight = flightHQL.getListFlightAvailable(current).subList((pageIndex - 1) * pageSize, pageIndex * pageSize);

        }
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("maxPage", maxPage);
        int startPage = pageIndex - (int) maxPage / 2;
        int endPage = pageIndex + (int) maxPage / 2;
        if (startPage <= 0) {
            if (totalPage < maxPage) {
                endPage = totalPage;
            }
            endPage = maxPage;
            startPage = 1;
        }
        if (endPage > totalPage) {
            endPage = totalPage;
            if (endPage > maxPage) {
                startPage = endPage - (maxPage - 1);
            }
        }
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        model.addAttribute("pagination", "pagination");
        model.addAttribute("listFlight", listFlight);
        return "flight";
    }

    @Override
    public String searchFlightByDate(FilterFlightDTO filterFlightDTO, Model model) {
        model.addAttribute("listProvince", provincesRepository.findAll());
        model.addAttribute("filterFlight", filterFlightDTO);
        model.addAttribute("searchFlight", filterFlightDTO);
        model.addAttribute("listFlight", flightHQL.searchFlightByDate(filterFlightDTO.getDepartureDate()));
        return "flight";
    }

}
