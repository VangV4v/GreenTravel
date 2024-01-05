/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cusc.dto.FilterHotelDTO;
import com.cusc.dto.HotelDTO;
import com.cusc.entities.Hotels;
import com.cusc.repositories.DestinationsRepository;
import com.cusc.repositories.HotelsRepository;
import com.cusc.repositories.hql.HotelsHQL;
import com.cusc.service.HotelManageService;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
@Service
public class HotelManageServiceimpl implements HotelManageService {

    @Autowired
    HotelsRepository hotelsRepository;

    @Autowired
    DestinationsRepository destinationsRepository;

    @Autowired
    HotelsHQL hotelsHQL;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String viewHotel(Model model) {
        model.addAttribute("listHotel", hotelsRepository.findAll());
        return "ad_view_hotel";
    }

    @Override
    public String createHotel(Model model) {
        HotelDTO hotelDTO = new HotelDTO();
        model.addAttribute("hotel", hotelDTO);
        model.addAttribute("listDestination", destinationsRepository.findAll());
        Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
        mapRateStar.put(1, "1 Star");
        mapRateStar.put(2, "2 Star");
        mapRateStar.put(3, "3 Star");
        mapRateStar.put(4, "4 Star");
        mapRateStar.put(5, "5 Star");
        model.addAttribute("mapRateStar", mapRateStar);
        return "ad_create_hotel";
    }

    @Override
    public String createHotel(HotelDTO hotelDTO, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("hotel", hotelDTO);
            model.addAttribute("listDestination", destinationsRepository.findAll());
            Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
            mapRateStar.put(1, "1 Star");
            mapRateStar.put(2, "2 Star");
            mapRateStar.put(3, "3 Star");
            mapRateStar.put(4, "4 Star");
            mapRateStar.put(5, "5 Star");
            model.addAttribute("mapRateStar", mapRateStar);
            return "ad_create_hotel";
        }
        Hotels hotel = hotelDTO.tranferToEntities();
        hotel.setDestinationID(destinationsRepository.findById(hotelDTO.getDestinationID()).get());
        try {
            if (!hotelDTO.getThumbnailImage().isEmpty()) {
                String imageName = LocalDateTime.now().toString();
                cloudinary.uploader().destroy(imageName, ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName));
                Map upload = cloudinary.uploader().upload(hotelDTO.getThumbnailImage().getBytes(), ObjectUtils.asMap("public_id", imageName));
                hotel.setImage((String) upload.get("secure_url"));
            }
        } catch (Exception e) {
        }

        hotelsRepository.save(hotel);
        return "redirect:/admin/employee/manage-hotel/home-hotel?success=true";
    }

    @Override
    public String editHotel(Model model, int id) {
        Hotels hotel = hotelsRepository.findById(id).get();
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.getData(hotel);
        model.addAttribute("hotel", hotelDTO);
        model.addAttribute("listDestination", destinationsRepository.findAll());
        Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
        mapRateStar.put(1, "1 Star");
        mapRateStar.put(2, "2 Star");
        mapRateStar.put(3, "3 Star");
        mapRateStar.put(4, "4 Star");
        mapRateStar.put(5, "5 Star");
        model.addAttribute("mapRateStar", mapRateStar);
        return "ad_edit_hotel";
    }

    @Override
    public String editHotel(HotelDTO hotelDTO, BindingResult br, Model model, int id) {
        if (br.hasErrors()) {
            model.addAttribute("hotel", hotelDTO);
            model.addAttribute("listDestination", destinationsRepository.findAll());
            Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
            mapRateStar.put(1, "1 Star");
            mapRateStar.put(2, "2 Star");
            mapRateStar.put(3, "3 Star");
            mapRateStar.put(4, "4 Star");
            mapRateStar.put(5, "5 Star");
            model.addAttribute("mapRateStar", mapRateStar);
            return "ad_edit_hotel";
        }
        Hotels hotel = hotelDTO.tranferToEntities();
        hotel.setDestinationID(destinationsRepository.findById(hotelDTO.getDestinationID()).get());
        try {
            if (!hotelDTO.getThumbnailImage().isEmpty()) {
                String imageName = LocalDateTime.now().toString();
                String oldImageName = hotel.getImage().substring(hotel.getImage().lastIndexOf("/") + 1, hotel.getImage().lastIndexOf("."));
                cloudinary.uploader().destroy(oldImageName, ObjectUtils.asMap("resouce_type", "auto", "public_id", oldImageName));
                Map upload = cloudinary.uploader().upload(hotelDTO.getThumbnailImage().getBytes(), ObjectUtils.asMap("public_id", imageName));
                hotel.setImage((String) upload.get("secure_url"));
            }
        } catch (Exception e) {
        }
        hotelsRepository.save(hotel);
        return "redirect:/admin/employee/manage-hotel/home-hotel?success=true";
    }

    @Override
    public String viewDetailHotel(Model model, int id) {
        Hotels hotel = hotelsRepository.findById(id).get();
        model.addAttribute("hotel", hotel);
        return "ad_detail_hotel";
    }

    @Override
    public String deleteHotel(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
       
        hotelsRepository.deleteById(id);
        return "ad_view_hotel";
    }

    @Override
    public String viewHotelClient(Model model, int pageIndex) {
        model.addAttribute("listDestination", destinationsRepository.findAll());
        FilterHotelDTO filterHotelDTO = new FilterHotelDTO();
        model.addAttribute("filterHotel", filterHotelDTO);
        
        int pageSize = 9;
        int maxPage = 2;
        Pageable pageable = PageRequest.of((pageIndex - 1), pageSize).withSort(Sort.by(Sort.Direction.DESC, "hotelID"));
        List<Hotels> listHotel = hotelsRepository.findAll(pageable).getContent();
        int totalRecord = hotelsRepository.findAll().size();
        model.addAttribute("totalRecord", totalRecord);
        pageIndex = Integer.valueOf(pageIndex) == null ? 1 : pageIndex;
        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("pageSize", pageSize);
        int totalPage = (int) Math.ceil(Double.valueOf(totalRecord) / Double.valueOf(pageSize));
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

        model.addAttribute("listHotel", listHotel);
        Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
        mapRateStar.put(0, "--None--");
        mapRateStar.put(1, "1 Star");
        mapRateStar.put(2, "2 Star");
        mapRateStar.put(3, "3 Star");
        mapRateStar.put(4, "4 Star");
        mapRateStar.put(5, "5 Star");
        model.addAttribute("mapRateStar", mapRateStar);
        model.addAttribute("pagination", "pagination");
        return "hotel";
    }

    @Override
    public String filterHotel(FilterHotelDTO filterHotelDTO, Model model) {
        model.addAttribute("listDestination", destinationsRepository.findAll());
        Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
        mapRateStar.put(0, "--None--");
        mapRateStar.put(1, "1 Star");
        mapRateStar.put(2, "2 Star");
        mapRateStar.put(3, "3 Star");
        mapRateStar.put(4, "4 Star");
        mapRateStar.put(5, "5 Star");
        model.addAttribute("mapRateStar", mapRateStar);
        model.addAttribute("filterHotel", filterHotelDTO);
        if (filterHotelDTO.getDestinationID() == 0) {
            filterHotelDTO.setDestinationID(null);
        }
        if (filterHotelDTO.getRateStar() == 0) {
            filterHotelDTO.setRateStar(null);
        }

        model.addAttribute("listHotel", hotelsHQL.filterHotel(filterHotelDTO.getDestinationID(), filterHotelDTO.getKeyword(), filterHotelDTO.getRateStar()));
        return "hotel";
    }

}
