/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cusc.dto.FilterLocalTravelDTO;
import com.cusc.dto.LocalTravelDTO;
import com.cusc.entities.Destinations;
import com.cusc.entities.LocalTravels;
import com.cusc.repositories.DestinationsRepository;
import com.cusc.repositories.LocalTravelsRepository;
import com.cusc.repositories.TourTypesRepository;
import com.cusc.repositories.hql.LocalTravelHQL;
import com.cusc.service.LocalTravelManageService;
import java.time.LocalDateTime;
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
public class LocalTravelManageServiceimpl implements LocalTravelManageService {

    @Autowired
    LocalTravelsRepository localTravelsRepository;

    @Autowired
    TourTypesRepository tourTypesRepository;

    @Autowired
    DestinationsRepository destinationsRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    LocalTravelHQL localTravelHQL;

    @Override
    public String viewLocalTravel(Model model) {
        model.addAttribute("listLocalTravel", localTravelsRepository.findAll());
        return "ad_view_localtravel";
    }

    @Override
    public String createLocalTravel(Model model) {
        LocalTravelDTO localTravelDTO = new LocalTravelDTO();
        model.addAttribute("localtravel", localTravelDTO);
        model.addAttribute("listDestination", destinationsRepository.findAll());
        return "ad_create_localtravel";
    }

    @Override
    public String createLocalTravel(LocalTravelDTO localTravelDTO, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("localtravel", localTravelDTO);
            model.addAttribute("listDestination", destinationsRepository.findAll());
            return "ad_create_localtravel";
        }
        if (localTravelDTO.getThumbnailImage().isEmpty()) {
            br.rejectValue("thumbnailImage", "500", "Image cannot be empty");
            model.addAttribute("localtravel", localTravelDTO);
            model.addAttribute("listDestination", destinationsRepository.findAll());
            return "ad_create_localtravel";
        }
        if (localTravelDTO.getThumbnailImage().getSize() > 5000000) {
            br.rejectValue("thumbnailImage", "500", "Image is only allowed less than 5MB");
            model.addAttribute("localtravel", localTravelDTO);
            model.addAttribute("listDestination", destinationsRepository.findAll());
            return "ad_create_localtravel";
        }
        Destinations destination = destinationsRepository.findById(localTravelDTO.getDestinationID()).get();
        LocalTravels localTravel = localTravelDTO.tranferToEntities();
        localTravel.setDestinationID(destination);
        try {
            if (!localTravelDTO.getThumbnailImage().isEmpty()) {
                String imageName = LocalDateTime.now().toString();
                cloudinary.uploader().destroy(imageName, ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName));
                Map upload = cloudinary.uploader().upload(localTravelDTO.getThumbnailImage().getBytes(), ObjectUtils.asMap("public_id", imageName));
                localTravel.setImage((String) upload.get("secure_url"));
            }
        } catch (Exception e) {
        }
        localTravelsRepository.save(localTravel);
        return "redirect:/admin/employee/manage-localtravel/home-localtravel?success=true";

    }

    @Override
    public String editLocalTravel(Model model, int id) {
        LocalTravels localTravel = localTravelsRepository.findById(id).get();
        LocalTravelDTO localTravelDTO = new LocalTravelDTO();
        localTravelDTO.getData(localTravel);
        model.addAttribute("localtravel", localTravelDTO);
        model.addAttribute("listDestination", destinationsRepository.findAll());
        return "ad_edit_localtravel";
    }

    @Override
    public String editLocalTravel(LocalTravelDTO localTravelDTO, BindingResult br, Model model, int id) {
        if (br.hasErrors()) {
            model.addAttribute("localtravel", localTravelDTO);
            model.addAttribute("listDestination", destinationsRepository.findAll());
            return "ad_edit_localtravel";
        }
        if (localTravelDTO.getThumbnailImage().getSize() > 5000000) {
            br.rejectValue("thumbnailImage", "500", "Image is only allowed less than 5MB");
            model.addAttribute("localtravel", localTravelDTO);
            model.addAttribute("listDestination", destinationsRepository.findAll());
            return "ad_edit_localtravel";

        }
        Destinations destination = destinationsRepository.findById(localTravelDTO.getDestinationID()).get();
        LocalTravels localTravel = localTravelDTO.tranferToEntities();
        localTravel.setDestinationID(destination);     
        try {
            if (!localTravelDTO.getThumbnailImage().isEmpty()) {
                String imageName = LocalDateTime.now().toString();
                String oldImageName = localTravel.getImage().substring(localTravel.getImage().lastIndexOf("/") + 1, localTravel.getImage().lastIndexOf("."));
                cloudinary.uploader().destroy(oldImageName, ObjectUtils.asMap("resouce_type", "auto", "public_id", oldImageName));
                Map upload = cloudinary.uploader().upload(localTravelDTO.getThumbnailImage().getBytes(), ObjectUtils.asMap("public_id", imageName));
                localTravel.setImage((String) upload.get("secure_url"));
            }
        } catch (Exception e) {
        }
        localTravelsRepository.save(localTravel);
        return "redirect:/admin/employee/manage-localtravel/home-localtravel?success=true";
    }

    @Override
    public String viewDetailLocalTravel(Model model, int id) {
        LocalTravels localTravel = localTravelsRepository.findById(id).get();
        model.addAttribute("localtravel", localTravel);
        return "ad_detail_localtravel";
    }

    @Override
    public String deleteLocalTravel(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
       
        localTravelsRepository.deleteById(id);
        return "ad_view_localtravel";
    }

    @Override
    public String viewLocalTravelClient(Model model, int pageIndex) {
        int pageSize = 9;
        int maxPage = 2;
        Pageable pageable = PageRequest.of((pageIndex - 1), pageSize).withSort(Sort.by(Sort.Direction.DESC, "localTravelID"));
        List<LocalTravels> listLt = localTravelsRepository.findAll(pageable).getContent();
        int totalRecord = localTravelsRepository.findAll().size();
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
        model.addAttribute("pagination", "pagination");

        FilterLocalTravelDTO dTO = new FilterLocalTravelDTO();
        model.addAttribute("filterLt", dTO);
        model.addAttribute("listLt", listLt);
        model.addAttribute("listDestination", destinationsRepository.findAll());
        return "localtravel";
    }

    @Override
    public String filterLocalTravel(FilterLocalTravelDTO filterLocalTravelDTO, Model model) {
        model.addAttribute("filterLt", filterLocalTravelDTO);
        model.addAttribute("listDestination", destinationsRepository.findAll());
        if(filterLocalTravelDTO.getDestinationID()==0){
            filterLocalTravelDTO.setDestinationID(null);
        }
        model.addAttribute("listLt", localTravelHQL.filterLocalTravel(filterLocalTravelDTO.getKeyword(), filterLocalTravelDTO.getDestinationID()));
        return "localtravel";
    }

}
