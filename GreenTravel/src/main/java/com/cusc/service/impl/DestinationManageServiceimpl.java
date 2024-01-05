/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cusc.dto.DestinationDTO;
import com.cusc.dto.FilterDestinationDTO;
import com.cusc.entities.Destinations;
import com.cusc.repositories.AreasRepository;
import com.cusc.repositories.DestinationsRepository;
import com.cusc.repositories.hql.DestinationHQL;
import com.cusc.service.DestinationManageService;
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
public class DestinationManageServiceimpl implements DestinationManageService {

    @Autowired
    DestinationsRepository destinationsRepository;

    @Autowired
    AreasRepository areasRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    DestinationHQL destinationHQL;

    @Override
    public String viewDestination(Model model) {
        model.addAttribute("listDestination", destinationsRepository.findAll());
        return "ad_view_destination";
    }

    @Override
    public String createDestination(Model model) {
        DestinationDTO destinationDTO = new DestinationDTO();
        model.addAttribute("destination", destinationDTO);
        model.addAttribute("listArea", areasRepository.findAll());
        return "ad_create_destination";
    }

    @Override
    public String createDestination(DestinationDTO destinationDTO, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("destination", destinationDTO);
            model.addAttribute("listArea", areasRepository.findAll());
            return "ad_create_destination";
        }
        Destinations destination = destinationDTO.tranferToEntities();
        destination.setAreaID(areasRepository.findById(destinationDTO.getAreaID()).get());
        if (destinationDTO.getThumbnailImage().isEmpty()) {
            br.rejectValue("thumbnailImage", "500", "Image cannot be empty");
            model.addAttribute("destination", destinationDTO);
            model.addAttribute("listArea", areasRepository.findAll());
            return "ad_create_destination";
        }
        if (destinationDTO.getThumbnailImage().getSize() > 5000000) {
            br.rejectValue("thumbnailImage", "500", "Image is only allowed less than 5MB");
            model.addAttribute("destination", destinationDTO);
            model.addAttribute("listArea", areasRepository.findAll());
            return "ad_create_destination";
        }
        try {
            if (!destinationDTO.getThumbnailImage().isEmpty()) {
                String imageName = LocalDateTime.now().toString();
                cloudinary.uploader().destroy(imageName, ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName));
                Map upload = cloudinary.uploader().upload(destinationDTO.getThumbnailImage().getBytes(), ObjectUtils.asMap("public_id", imageName));
                destination.setImage((String) upload.get("secure_url"));
            }
        } catch (Exception e) {
        }
        destinationsRepository.save(destination);
        return "redirect:/admin/employee/manage-destination/home-destination?success=true";
    }

    @Override
    public String editDestination(Model model, int id) {
        Destinations destination = destinationsRepository.findById(id).get();
        DestinationDTO destinationDTO = new DestinationDTO();
        destinationDTO.getData(destination);
        model.addAttribute("destination", destinationDTO);
        model.addAttribute("listArea", areasRepository.findAll());
        return "ad_edit_destination";
    }

    @Override
    public String editDestination(DestinationDTO destinationDTO, BindingResult br, Model model, int id) {
        if (br.hasErrors()) {
            model.addAttribute("destination", destinationDTO);
            return "ad_edit_destination";
        }
        Destinations destination = destinationDTO.tranferToEntities();
        destination.setAreaID(areasRepository.findById(destinationDTO.getAreaID()).get());
        if (destinationDTO.getThumbnailImage().getSize() > 5000000) {
            br.rejectValue("thumbnailImage", "500", "Image is only allowed less than 5MB");
            model.addAttribute("destination", destinationDTO);
            model.addAttribute("listArea", areasRepository.findAll());
            return "ad_edit_destination";

        }
        try {
            if (!destinationDTO.getThumbnailImage().isEmpty()) {
                String imageName = LocalDateTime.now().toString();
                String oldImageName = destination.getImage().substring(destination.getImage().lastIndexOf("/") + 1, destination.getImage().lastIndexOf("."));
                cloudinary.uploader().destroy(oldImageName, ObjectUtils.asMap("resouce_type", "auto", "public_id", oldImageName));
                Map upload = cloudinary.uploader().upload(destinationDTO.getThumbnailImage().getBytes(), ObjectUtils.asMap("public_id", imageName));
                destination.setImage((String) upload.get("secure_url"));
            }
        } catch (Exception e) {
        }
        destinationsRepository.save(destination);
        return "redirect:/admin/employee/manage-destination/home-destination?success=true";
    }

    @Override
    public String viewDetailDestination(Model model, int id) {
        Destinations destination = destinationsRepository.findById(id).get();
        model.addAttribute("destination", destination);
        return "ad_detail_destination";
    }

    @Override
    public String deleteDestination(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));       
        destinationsRepository.deleteById(id);
        return "ad_view_destination";
    }

    @Override
    public String viewDestinationClient(Model model, int pageIndex) {
        int pageSize = 9;
        int maxPage = 2;
        Pageable pageable = PageRequest.of((pageIndex-1), pageSize).withSort(Sort.by(Sort.Direction.DESC, "destinationID"));
        List<Destinations> listDestination = destinationsRepository.findAll(pageable).getContent();
        int totalRecord = destinationsRepository.findAll().size();
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

        FilterDestinationDTO dTO = new FilterDestinationDTO();
        model.addAttribute("filterDestination", dTO);
        model.addAttribute("listDestination", listDestination);
        return "destination";
    }

    @Override
    public String searchDestination( FilterDestinationDTO filterDestinationDTO,Model model) {
        model.addAttribute("filterDestination", filterDestinationDTO);
        model.addAttribute("listDestination", destinationHQL.searchDestination(filterDestinationDTO.getKeyword()));
        return "destination";
    }

}
