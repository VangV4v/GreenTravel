/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cusc.dto.FilterRestaurantDTO;
import com.cusc.dto.RestaurantDTO;
import com.cusc.entities.Restaurants;
import com.cusc.repositories.DestinationsRepository;
import com.cusc.repositories.RestaurantsRepository;
import com.cusc.repositories.hql.RestaurantHQL;
import com.cusc.service.RestaurantManageService;
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
public class RestaurantManageServiceimpl implements RestaurantManageService {

    @Autowired
    DestinationsRepository destinationsRepository;

    @Autowired
    RestaurantsRepository restaurantsRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    RestaurantHQL restaurantHQL;

    @Override
    public String viewRestaurant(Model model) {
        model.addAttribute("listRestaurant", restaurantsRepository.findAll());
        return "ad_view_restaurant";
    }

    @Override
    public String createRestaurant(Model model) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        model.addAttribute("restaurant", restaurantDTO);
        model.addAttribute("listDestination", destinationsRepository.findAll());
        Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
        mapRateStar.put(1, "1 Star");
        mapRateStar.put(2, "2 Star");
        mapRateStar.put(3, "3 Star");
        mapRateStar.put(4, "4 Star");
        mapRateStar.put(5, "5 Star");
        model.addAttribute("mapRateStar", mapRateStar);
        return "ad_create_restaurant";
    }

    @Override
    public String createRestaurant(RestaurantDTO restaurantDTO, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("restaurant", restaurantDTO);
            model.addAttribute("listDestination", destinationsRepository.findAll());
            Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
            mapRateStar.put(1, "1 Star");
            mapRateStar.put(2, "2 Star");
            mapRateStar.put(3, "3 Star");
            mapRateStar.put(4, "4 Star");
            mapRateStar.put(5, "5 Star");
            model.addAttribute("mapRateStar", mapRateStar);
            return "ad_create_restaurant";
        }
        if (restaurantDTO.getThumbnailImage() == null) {
            br.rejectValue("thumbnailImage", "500", "Image cannot be empty");
            model.addAttribute("restaurant", restaurantDTO);
            model.addAttribute("listDestination", destinationsRepository.findAll());
            Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
            mapRateStar.put(1, "1 Star");
            mapRateStar.put(2, "2 Star");
            mapRateStar.put(3, "3 Star");
            mapRateStar.put(4, "4 Star");
            mapRateStar.put(5, "5 Star");
            model.addAttribute("mapRateStar", mapRateStar);
            return "ad_create_restaurant";
        }
        if (restaurantDTO.getThumbnailImage().getSize() > 5000000) {
            br.rejectValue("thumbnailImage", "500", "Image is only allowed less than 5MB");
            model.addAttribute("restaurant", restaurantDTO);
            model.addAttribute("listDestination", destinationsRepository.findAll());
            Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
            mapRateStar.put(1, "1 Star");
            mapRateStar.put(2, "2 Star");
            mapRateStar.put(3, "3 Star");
            mapRateStar.put(4, "4 Star");
            mapRateStar.put(5, "5 Star");
            model.addAttribute("mapRateStar", mapRateStar);
            return "ad_create_restaurant";
        }
        Restaurants restaurant = restaurantDTO.tranferToEntities();
        restaurant.setDestinationID(destinationsRepository.findById(restaurantDTO.getDestinationID()).get());
        try {
            if (!restaurantDTO.getThumbnailImage().isEmpty()) {
                String imageName = LocalDateTime.now().toString();
                cloudinary.uploader().destroy(imageName, ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName));
                Map upload = cloudinary.uploader().upload(restaurantDTO.getThumbnailImage().getBytes(), ObjectUtils.asMap("public_id", imageName));
                restaurant.setImage((String) upload.get("secure_url"));
            }
        } catch (Exception e) {
        }
        restaurantsRepository.save(restaurant);
        return "redirect:/admin/employee/manage-restaurant/home-restaurant?success=true";
    }

    @Override
    public String editRestaurant(Model model, int id) {
        Restaurants restaurant = restaurantsRepository.findById(id).get();
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.getData(restaurant);
        model.addAttribute("restaurant", restaurantDTO);
        model.addAttribute("listDestination", destinationsRepository.findAll());
        Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
        mapRateStar.put(1, "1 Star");
        mapRateStar.put(2, "2 Star");
        mapRateStar.put(3, "3 Star");
        mapRateStar.put(4, "4 Star");
        mapRateStar.put(5, "5 Star");
        model.addAttribute("mapRateStar", mapRateStar);
        return "ad_edit_restaurant";
    }

    @Override
    public String editRestaurant(RestaurantDTO restaurantDTO, BindingResult br, Model model, int id) {
        if (br.hasErrors()) {
            model.addAttribute("restaurant", restaurantDTO);
            model.addAttribute("listDestination", destinationsRepository.findAll());
            Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
            mapRateStar.put(1, "1 Star");
            mapRateStar.put(2, "2 Star");
            mapRateStar.put(3, "3 Star");
            mapRateStar.put(4, "4 Star");
            mapRateStar.put(5, "5 Star");
            model.addAttribute("mapRateStar", mapRateStar);
            return "ad_edit_restaurant";
        }

        if (restaurantDTO.getThumbnailImage().getSize() > 5000000) {
            br.rejectValue("thumbnailImage", "500", "Image is only allowed less than 5MB");
            model.addAttribute("restaurant", restaurantDTO);
            model.addAttribute("listDestination", destinationsRepository.findAll());
            Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
            mapRateStar.put(1, "1 Star");
            mapRateStar.put(2, "2 Star");
            mapRateStar.put(3, "3 Star");
            mapRateStar.put(4, "4 Star");
            mapRateStar.put(5, "5 Star");
            model.addAttribute("mapRateStar", mapRateStar);
            return "ad_edit_restaurant";

        }
        Restaurants restaurant = restaurantDTO.tranferToEntities();
        restaurant.setDestinationID(destinationsRepository.findById(restaurantDTO.getDestinationID()).get());
        try {
            if (!restaurantDTO.getThumbnailImage().isEmpty()) {
                String imageName = LocalDateTime.now().toString();
                String oldImageName = restaurant.getImage().substring(restaurant.getImage().lastIndexOf("/") + 1, restaurant.getImage().lastIndexOf("."));
                cloudinary.uploader().destroy(oldImageName, ObjectUtils.asMap("resouce_type", "auto", "public_id", oldImageName));
                Map upload = cloudinary.uploader().upload(restaurantDTO.getThumbnailImage().getBytes(), ObjectUtils.asMap("public_id", imageName));
                restaurant.setImage((String) upload.get("secure_url"));
            }
        } catch (Exception e) {
        }
        restaurantsRepository.save(restaurant);
        return "redirect:/admin/employee/manage-restaurant/home-restaurant?success=true";
    }

    @Override
    public String viewDetailRestaurant(Model model, int id) {
        Restaurants restaurant = restaurantsRepository.findById(id).get();
        model.addAttribute("restaurant", restaurant);
        return "ad_detail_restaurant";
    }

    @Override
    public String deleteRestaurant(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        restaurantsRepository.deleteById(id);
        return "ad_view_restaurant";
    }

    @Override
    public String viewRestaurantClient(Model model, int pageIndex) {

        int pageSize = 9;
        int maxPage = 2;
        Pageable pageable = PageRequest.of((pageIndex - 1), pageSize).withSort(Sort.by(Sort.Direction.DESC, "restaurantID"));
        List<Restaurants> listRestaurant = restaurantsRepository.findAll(pageable).getContent();

        int totalRecord = restaurantsRepository.findAll().size();
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

        model.addAttribute("listRestaurant", listRestaurant);
        model.addAttribute("listDestination", destinationsRepository.findAll());
        FilterRestaurantDTO filterRestaurantDTO = new FilterRestaurantDTO();
        model.addAttribute("filterRestaurant", filterRestaurantDTO);
        Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
        mapRateStar.put(0, "--None--");
        mapRateStar.put(1, "1 Star");
        mapRateStar.put(2, "2 Star");
        mapRateStar.put(3, "3 Star");
        mapRateStar.put(4, "4 Star");
        mapRateStar.put(5, "5 Star");
        model.addAttribute("mapRateStar", mapRateStar);
        model.addAttribute("pagination", "pagination");
        return "restaurant";
    }

    @Override
    public String filterRestaurant(FilterRestaurantDTO filterRestaurantDTO, Model model) {
        model.addAttribute("listDestination", destinationsRepository.findAll());
        Map<Integer, String> mapRateStar = new HashMap<Integer, String>();
        mapRateStar.put(0, "--None--");
        mapRateStar.put(1, "1 Star");
        mapRateStar.put(2, "2 Star");
        mapRateStar.put(3, "3 Star");
        mapRateStar.put(4, "4 Star");
        mapRateStar.put(5, "5 Star");
        model.addAttribute("mapRateStar", mapRateStar);
        model.addAttribute("filterRestaurant", filterRestaurantDTO);
        if (filterRestaurantDTO.getDestinationID() == 0) {
            filterRestaurantDTO.setDestinationID(null);
        }
        if (filterRestaurantDTO.getRateStar() == 0) {
            filterRestaurantDTO.setRateStar(null);
        }

        model.addAttribute("listRestaurant", restaurantHQL.findAllRestaurantByDestinationIDandRateStar(filterRestaurantDTO.getDestinationID(), filterRestaurantDTO.getKeyword(), filterRestaurantDTO.getRateStar()));
        return "restaurant";
    }

}
