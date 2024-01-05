/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.dto.MonthDTO;
import com.cusc.dto.RevenueInMonthDTO;
import com.cusc.dto.RevenueInYearDTO;
import com.cusc.entities.Areas;
import com.cusc.entities.BookingTours;
import com.cusc.entities.PackageTours;
import com.cusc.entities.Provinces;
import com.cusc.entities.TourTypes;
import com.cusc.repositories.AreasRepository;
import com.cusc.repositories.BookingToursRepository;
import com.cusc.repositories.PackageToursRepository;
import com.cusc.repositories.ProvincesRepository;
import com.cusc.repositories.TourTypesRepository;
import com.cusc.service.RevenueTourManageService;
import com.google.gson.Gson;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 * @author kyqua
 */
@Service
public class RevenueTourManageServiceimpl implements RevenueTourManageService {

    @Autowired
    BookingToursRepository bookingToursRepository;

    @Autowired
    TourTypesRepository tourTypesRepository;

    @Autowired
    AreasRepository areasRepository;

    @Autowired
    private ProvincesRepository provincesRepository;

    @Autowired
    private PackageToursRepository packageToursRepository;

    @Override
    public String homeRevenueTour(Model arg0) {
        return "ad_home_revenuetour";
    }

    @Override
    public String revenueTourTypeInMonth(HttpServletRequest hsr) {
        int month = Integer.parseInt(hsr.getParameter("month"));

        int year = Year.now().getValue();
        List<BookingTours> listBookingTour = bookingToursRepository.findAll();
        List<TourTypes> listTourType = tourTypesRepository.findAll();
        List<RevenueInMonthDTO> list = new ArrayList<>();

        for (TourTypes item : listTourType) {
            RevenueInMonthDTO dto = new RevenueInMonthDTO();
            dto.setRevenue(Double.parseDouble("0"));
            for (BookingTours subitem : listBookingTour) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(subitem.getBookDate());
                int m = cal.get(Calendar.MONTH);
                int y = cal.get(Calendar.YEAR);

                if (subitem.getStatus() == 2 && item.getTourTypeID() == subitem.getPackageTourID().getTourTypeID().getTourTypeID() && m == (month - 1) && y == year) {

                    dto.setRevenue(dto.getRevenue() + subitem.getTotalPrice());
                }
            }
            dto.setLabel(item.getName());
            list.add(dto);
        }
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @Override
    public String revenueTourAreaInMonth(HttpServletRequest hsr) {
        int month = Integer.parseInt(hsr.getParameter("month"));

        int year = Year.now().getValue();
        List<BookingTours> listBookingTour = bookingToursRepository.findAll();
        List<Areas> listArea = areasRepository.findAll();
        List<RevenueInMonthDTO> list = new ArrayList<>();

        for (Areas item : listArea) {
            RevenueInMonthDTO dto = new RevenueInMonthDTO();
            dto.setRevenue(Double.parseDouble("0"));
            for (BookingTours subitem : listBookingTour) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(subitem.getBookDate());
                int m = cal.get(Calendar.MONTH);
                int y = cal.get(Calendar.YEAR);

                if (subitem.getStatus() == 2 && item.getAreaID() == subitem.getPackageTourID().getAreaID().getAreaID() && m == (month - 1) && y == year) {

                    dto.setRevenue(dto.getRevenue() + subitem.getTotalPrice());
                }
            }
            dto.setLabel(item.getName());
            list.add(dto);
        }
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @Override
    public String revenueProvinceInMonth(HttpServletRequest hsr) {
        int month = Integer.parseInt(hsr.getParameter("month"));
        List<Provinces> listPro = provincesRepository.findAll();
        List<RevenueInMonthDTO> listRe = new ArrayList<>();
        Gson gson = new Gson();
        for (Provinces provinces : listPro) {
            RevenueInMonthDTO dto = new RevenueInMonthDTO();
            double value = 0;
            dto.setLabel(provinces.getName());
            if (!provinces.getPackageToursList().isEmpty()) {
                for (PackageTours pkt : provinces.getPackageToursList()) {
                    for (BookingTours bookingTours : pkt.getBookingToursList()) {
                        if (bookingTours.getStatus() == 2 && bookingTours.getBookDate().toLocalDate().getMonthValue() == month) {
                            value += bookingTours.getTotalPrice().doubleValue();
                        }
                    }
                }
            }
            dto.setRevenue(value);
            listRe.add(dto);
        }
        String json = gson.toJson(listRe);
        return json;
    }

    @Override
    public String revenueBookingTourInYear(HttpServletRequest hsr) {
        int year = Integer.parseInt(hsr.getParameter("year"));
        Gson gson = new Gson();
        List<RevenueInYearDTO> listR = new ArrayList<>();
        List<PackageTours> listPackageTour = packageToursRepository.findAll();
        List<MonthDTO> listMonth = new ArrayList<>();
        listMonth.add(new MonthDTO(1, "Juanary"));
        listMonth.add(new MonthDTO(2, "Feburary"));
        listMonth.add(new MonthDTO(3, "March"));
        listMonth.add(new MonthDTO(4, "April"));
        listMonth.add(new MonthDTO(5, "May"));
        listMonth.add(new MonthDTO(6, "June"));
        listMonth.add(new MonthDTO(7, "July"));
        listMonth.add(new MonthDTO(8, "Aggust"));
        listMonth.add(new MonthDTO(9, "September"));
        listMonth.add(new MonthDTO(10, "October"));
        listMonth.add(new MonthDTO(11, "November"));
        listMonth.add(new MonthDTO(12, "December"));
        for (MonthDTO monthDTO : listMonth) {
            RevenueInYearDTO dto = new RevenueInYearDTO();
            dto.setRevenue(Double.parseDouble("0"));          
            dto.setMonth(monthDTO.getName());
            for (PackageTours packageTours : listPackageTour) {
                if (!packageTours.getBookingToursList().isEmpty()) {
                    for (BookingTours bookingTours : packageTours.getBookingToursList()) {
                        if (bookingTours.getStatus() == 2 && bookingTours.getBookDate().toLocalDate().getYear() == year && monthDTO.getMonth() == bookingTours.getBookDate().toLocalDate().getMonthValue()) {
                            dto.setRevenue(dto.getRevenue()+bookingTours.getTotalPrice());
                        }
                    }
                }
            }          
            listR.add(dto);
        }
        String json = gson.toJson(listR);
        return json;
    }

}
