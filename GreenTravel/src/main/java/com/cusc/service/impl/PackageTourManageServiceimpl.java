/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cusc.dto.FilterPackageTourDTO;
import com.cusc.dto.MonthDTO;
import com.cusc.dto.PackageTourDTO;
import com.cusc.dto.StatisticQuantityInMonthDTO;
import com.cusc.dto.StatisticQuantityInYearDTO;
import com.cusc.dto.TourDTO;
import com.cusc.entities.Areas;
import com.cusc.entities.BookingTours;
import com.cusc.entities.LocalTravelInTours;
import com.cusc.entities.PackageTours;
import com.cusc.entities.Provinces;
import com.cusc.entities.TourTypes;
import com.cusc.entities.Tours;
import com.cusc.repositories.AreasRepository;
import com.cusc.repositories.BookingToursRepository;
import com.cusc.repositories.DestinationsRepository;
import com.cusc.repositories.HotelsRepository;
import com.cusc.repositories.LocalTravelInToursRepository;
import com.cusc.repositories.LocalTravelsRepository;
import com.cusc.repositories.PackageToursRepository;
import com.cusc.repositories.ProvincesRepository;
import com.cusc.repositories.RestaurantsRepository;
import com.cusc.repositories.TourTypesRepository;
import com.cusc.repositories.ToursRepository;
import com.cusc.repositories.hql.PackageTourHQL;
import com.cusc.service.PackageTourManageService;
import com.google.gson.Gson;
import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
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
public class PackageTourManageServiceimpl implements PackageTourManageService {

    @Autowired
    PackageToursRepository packageToursRepository;

    @Autowired
    TourTypesRepository tourTypesRepository;

    @Autowired
    AreasRepository areasRepository;

    @Autowired
    DestinationsRepository destinationsRepository;

    @Autowired
    RestaurantsRepository restaurantsRepository;

    @Autowired
    ToursRepository toursRepository;

    @Autowired
    LocalTravelsRepository localTravelsRepository;

    @Autowired
    LocalTravelInToursRepository localTravelInToursRepository;

    @Autowired
    ProvincesRepository provincesRepository;

    @Autowired
    HotelsRepository hotelsRepository;

    @Autowired
    PackageTourHQL packageTourHQL;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    BookingToursRepository bookingToursRepository;

    @Override
    public String viewPackageTour(Model model) {
        LocalDate today = LocalDate.now();
        Date current = Date.valueOf(today);
        model.addAttribute("today", current);
        model.addAttribute("listPackageTour", packageToursRepository.findAll());
        return "ad_view_packagetour";
    }

    @Override
    public String createPackageTour(Model model) {
        PackageTourDTO packageTourDTO = new PackageTourDTO();
        model.addAttribute("packageTour", packageTourDTO);
        model.addAttribute("listTourType", tourTypesRepository.findAll());
        model.addAttribute("listProvince", provincesRepository.findAll());
        return "ad_create_packagetour";
    }

    @Override
    public String createPackageTour(PackageTourDTO packageTourDTO, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("packageTour", packageTourDTO);
            model.addAttribute("listTourType", tourTypesRepository.findAll());
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_create_packagetour";
        }
        LocalDate today = LocalDate.now();
        Date current = Date.valueOf(today);
        if (packageTourDTO.getDateStart().before(current)) {
            br.rejectValue("dateStart", "500", "Started date must be greater than today");
            model.addAttribute("packageTour", packageTourDTO);
            model.addAttribute("listTourType", tourTypesRepository.findAll());
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_create_packagetour";
        }
        if (packageTourDTO.getDateEnd().before(packageTourDTO.getDateStart())) {
            br.rejectValue("dateEnd", "500", "End date must be greater than started date");
            model.addAttribute("packageTour", packageTourDTO);
            model.addAttribute("listTourType", tourTypesRepository.findAll());
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_create_packagetour";
        }
        if (packageTourDTO.getThumbnailImage().isEmpty()) {
            br.rejectValue("thumbnailImage", "500", "Image cannot be empty");
            model.addAttribute("packageTour", packageTourDTO);
            model.addAttribute("listTourType", tourTypesRepository.findAll());
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_create_packagetour";
        }
        if (packageTourDTO.getThumbnailImage().getSize() > 5000000) {
            br.rejectValue("thumbnailImage", "500", "Image is only allowed less than 5MB");
            model.addAttribute("packageTour", packageTourDTO);
            model.addAttribute("listTourType", tourTypesRepository.findAll());
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_create_packagetour";
        }
        packageTourDTO.setStatus(1);
        PackageTours packageTour = packageTourDTO.tranferToEntities();
        packageTour.setFromProvinceID(provincesRepository.findById(packageTourDTO.getFromProvinceID()).get());
        packageTour.setToProvinceID(provincesRepository.findById(packageTourDTO.getToProvinceID()).get());

        if (provincesRepository.findById(packageTourDTO.getToProvinceID()).get().getAreasList().isEmpty()) {
            br.rejectValue("toProvinceID", "500", "Province not have area. Go to area to create new area of province");
            model.addAttribute("packageTour", packageTourDTO);
            model.addAttribute("listTourType", tourTypesRepository.findAll());
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_create_packagetour";
        }
        packageTour.setAreaID(provincesRepository.findById(packageTourDTO.getToProvinceID()).get().getAreasList().get(0));
        packageTour.setTourTypeID(tourTypesRepository.findById(packageTourDTO.getTourTypeID()).get());
        try {
            if (!packageTourDTO.getThumbnailImage().isEmpty()) {
                String imageName = LocalDateTime.now().toString();
                cloudinary.uploader().destroy(imageName, ObjectUtils.asMap("resouce_type", "auto", "public_id", imageName));
                Map upload = cloudinary.uploader().upload(packageTourDTO.getThumbnailImage().getBytes(), ObjectUtils.asMap("public_id", imageName));
                packageTour.setImage((String) upload.get("secure_url"));
            }
        } catch (Exception e) {
        }
        packageToursRepository.save(packageTour);
        return "redirect:/admin/employee/manage-packagetour/home-packagetour?success=true";
    }

    @Override
    public String editPackageTour(Model model, int id) {
        PackageTours packageTour = packageToursRepository.findById(id).get();
        PackageTourDTO packageTourDTO = new PackageTourDTO();
        packageTourDTO.getData(packageTour);
        model.addAttribute("packageTour", packageTourDTO);
        model.addAttribute("listTourType", tourTypesRepository.findAll());
        model.addAttribute("listProvince", provincesRepository.findAll());
        return "ad_edit_packagetour";
    }

    @Override
    public String editPackageTour(PackageTourDTO packageTourDTO, BindingResult br, Model model, int id) {
        if (br.hasErrors()) {
            PackageTours packageTour = packageToursRepository.findById(id).get();
            packageTourDTO.setArea(packageTour.getAreaID());
            model.addAttribute("packageTour", packageTourDTO);
            model.addAttribute("listTourType", tourTypesRepository.findAll());
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_edit_packagetour";
        }
        if (packageTourDTO.getThumbnailImage().getSize() > 5000000) {
            br.rejectValue("thumbnailImage", "500", "Image is only allowed less than 5MB");
            model.addAttribute("packageTour", packageTourDTO);
            model.addAttribute("listTourType", tourTypesRepository.findAll());
            model.addAttribute("listProvince", provincesRepository.findAll());
            return "ad_edit_packagetour";
        }
        PackageTours packageTour = packageTourDTO.tranferToEntities();
        packageTour.setFromProvinceID(provincesRepository.findById(packageTourDTO.getFromProvinceID()).get());
        packageTour.setToProvinceID(provincesRepository.findById(packageTourDTO.getToProvinceID()).get());
        packageTour.setAreaID(areasRepository.findById(packageTourDTO.getAreaID()).get());
        packageTour.setTourTypeID(tourTypesRepository.findById(packageTourDTO.getTourTypeID()).get());
        try {
            if (!packageTourDTO.getThumbnailImage().isEmpty()) {
                String imageName = LocalDateTime.now().toString();
                String oldImageName = packageTour.getImage().substring(packageTour.getImage().lastIndexOf("/") + 1, packageTour.getImage().lastIndexOf("."));
                cloudinary.uploader().destroy(oldImageName, ObjectUtils.asMap("resouce_type", "auto", "public_id", oldImageName));
                Map upload = cloudinary.uploader().upload(packageTourDTO.getThumbnailImage().getBytes(), ObjectUtils.asMap("public_id", imageName));
                packageTour.setImage((String) upload.get("secure_url"));
            }
        } catch (Exception e) {
        }
        packageToursRepository.save(packageTour);
        return "redirect:/admin/employee/manage-packagetour/home-packagetour?success=true";
    }

    @Override
    public String viewDetailPackageTour(Model model, int id) {
        PackageTours packageTour = packageToursRepository.findById(id).get();
        model.addAttribute("packageTour", packageTour);
        return "ad_detail_packagetour";
    }

    @Override
    public String deletePackageTour(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        packageToursRepository.deleteByIdCustom(id);
        return "ad_view_packagetour";
    }

    @Override
    public String createTour(Model model, int id) {
        PackageTours packageTour = packageToursRepository.findById(id).get();
        TourDTO tourDTO = new TourDTO();
        tourDTO.setSchedule("Day " + (packageTour.getToursList().size() + 1));
        tourDTO.setVisitDate(Date.valueOf(packageTour.getDateStart().toLocalDate().plusDays(packageTour.getToursList().size() + 1)));
        model.addAttribute("tour", tourDTO);
        model.addAttribute("listDestination", packageTourHQL.findAllDestinationByArea(packageTour.getAreaID().getAreaID()));
        return "ad_create_tour";
    }

    @Override
    public String createTour(TourDTO tourDTO, BindingResult br, Model model, int id) {
        if (br.hasErrors()) {
            PackageTours packageTour = packageToursRepository.findById(id).get();
            tourDTO.setSchedule("Day " + (packageTour.getToursList().size() + 1));
            tourDTO.setVisitDate(Date.valueOf(packageTour.getDateStart().toLocalDate().plusDays(packageTour.getToursList().size() + 1)));
            model.addAttribute("tour", tourDTO);
            model.addAttribute("listDestination", packageTourHQL.findAllDestinationByArea(packageTour.getAreaID().getAreaID()));
            return "ad_create_tour";
        }
        if (tourDTO.getDestinationID() == null) {
            br.rejectValue("destinationID", "500", "Destination cannot be empty");
            PackageTours packageTour = packageToursRepository.findById(id).get();
            tourDTO.setSchedule("Day " + (packageTour.getToursList().size() + 1));
            tourDTO.setVisitDate(Date.valueOf(packageTour.getDateStart().toLocalDate().plusDays(packageTour.getToursList().size() + 1)));
            model.addAttribute("tour", tourDTO);
            model.addAttribute("listDestination", packageTourHQL.findAllDestinationByArea(packageTour.getAreaID().getAreaID()));
            return "ad_create_tour";
        }
        if (tourDTO.getRestaurantID() == 0) {
            br.rejectValue("restaurantID", "500", "Restaurant cannot be empty");
            PackageTours packageTour = packageToursRepository.findById(id).get();
            tourDTO.setSchedule("Day " + (packageTour.getToursList().size() + 1));
            tourDTO.setVisitDate(Date.valueOf(packageTour.getDateStart().toLocalDate().plusDays(packageTour.getToursList().size() + 1)));
            model.addAttribute("tour", tourDTO);
            model.addAttribute("listDestination", packageTourHQL.findAllDestinationByArea(packageTour.getAreaID().getAreaID()));
            return "ad_create_tour";
        }
        if (tourDTO.getHotelID() == 0) {
            br.rejectValue("hotelID", "500", "Hotel cannot be empty");
            PackageTours packageTour = packageToursRepository.findById(id).get();
            tourDTO.setSchedule("Day " + (packageTour.getToursList().size() + 1));
            tourDTO.setVisitDate(Date.valueOf(packageTour.getDateStart().toLocalDate().plusDays(packageTour.getToursList().size() + 1)));
            model.addAttribute("tour", tourDTO);
            model.addAttribute("listDestination", packageTourHQL.findAllDestinationByArea(packageTour.getAreaID().getAreaID()));
            return "ad_create_tour";
        }
        if (tourDTO.getListLocalTravelinTour().isEmpty()) {
            br.rejectValue("listLocalTravelinTour", "500", "Local travel cannot be empty");
            PackageTours packageTour = packageToursRepository.findById(id).get();
            tourDTO.setSchedule("Day " + (packageTour.getToursList().size() + 1));
            tourDTO.setVisitDate(Date.valueOf(packageTour.getDateStart().toLocalDate().plusDays(packageTour.getToursList().size() + 1)));
            model.addAttribute("tour", tourDTO);
            model.addAttribute("listDestination", packageTourHQL.findAllDestinationByArea(packageTour.getAreaID().getAreaID()));
            return "ad_create_tour";
        }
        Tours tour = tourDTO.tranferToEntities();
        tour.setPackageTourID(packageToursRepository.findById(id).get());
        tour.setDestinationID(destinationsRepository.findById(tourDTO.getDestinationID()).get());
        tour.setRestaurantID(restaurantsRepository.findById(tourDTO.getRestaurantID()).get());
        tour.setHotelID(hotelsRepository.findById(tourDTO.getHotelID()).get());
        toursRepository.save(tour);

        for (int ltID : tourDTO.getListLocalTravelinTour()) {
            LocalTravelInTours localTravelInTour = new LocalTravelInTours();
            localTravelInTour.setLocalTravelID(localTravelsRepository.findById(ltID).get());
            localTravelInTour.setTourID(tour);
            localTravelInToursRepository.save(localTravelInTour);
        }

        PackageTours packageTour = packageToursRepository.findById(id).get();
        long diffDays = (Duration.between(packageTour.getDateStart().toLocalDate().atStartOfDay(), packageTour.getDateEnd().toLocalDate().atStartOfDay())).toDays();
        int countTour = packageTour.getToursList().size();
        if (diffDays == countTour) {
            packageTour.setStatus(2);
            packageToursRepository.save(packageTour);
        }
        return "redirect:/admin/employee/manage-packagetour/home-packagetour?success=true";

    }

    @Override
    public String editTour(Model model, int id) {
        Tours tour = toursRepository.findById(id).get();
        TourDTO tourDTO = new TourDTO();
        tourDTO.getData(tour);
        model.addAttribute("listDestination", packageTourHQL.findAllDestinationByArea(tour.getPackageTourID().getAreaID().getAreaID()));
        model.addAttribute("listRestaurant", packageTourHQL.findAllRestaurentByDestinationID(tour.getDestinationID().getDestinationID()));
        model.addAttribute("listHotel", packageTourHQL.findAllHotelByDestinationID(tour.getDestinationID().getDestinationID()));
        model.addAttribute("listLocalTravel", packageTourHQL.findAllLocalTravelByDestinationID(tour.getDestinationID().getDestinationID()));
        for (LocalTravelInTours ltinTour : tour.getLocalTravelInToursList()) {
            tourDTO.setLocalTravelinTour(ltinTour.getLocalTravelID().getLocalTravelID());
        }

        model.addAttribute("tour", tourDTO);
        return "ad_edit_tour";
    }

    @Override
    public String editTour(TourDTO tourDTO, BindingResult br, Model model, int id) {
        if (br.hasErrors()) {
            Tours tour = toursRepository.findById(id).get();
            model.addAttribute("listDestination", packageTourHQL.findAllDestinationByArea(tour.getPackageTourID().getAreaID().getAreaID()));
            model.addAttribute("listRestaurant", packageTourHQL.findAllRestaurentByDestinationID(tour.getDestinationID().getDestinationID()));
            model.addAttribute("listHotel", packageTourHQL.findAllHotelByDestinationID(tour.getDestinationID().getDestinationID()));
            model.addAttribute("listLocalTravel", packageTourHQL.findAllLocalTravelByDestinationID(tour.getDestinationID().getDestinationID()));
            for (LocalTravelInTours ltinTour : tour.getLocalTravelInToursList()) {
                tourDTO.setLocalTravelinTour(ltinTour.getLocalTravelID().getLocalTravelID());
            }
            model.addAttribute("tour", tourDTO);
            return "ad_edit_tour";
        }
        if (tourDTO.getRestaurantID() == 0) {
            br.rejectValue("restaurantID", "500", "Restaurant cannot be empty");
            Tours tour = toursRepository.findById(id).get();
            model.addAttribute("listDestination", packageTourHQL.findAllDestinationByArea(tour.getPackageTourID().getAreaID().getAreaID()));
            model.addAttribute("listRestaurant", packageTourHQL.findAllRestaurentByDestinationID(tour.getDestinationID().getDestinationID()));
            model.addAttribute("listHotel", packageTourHQL.findAllHotelByDestinationID(tour.getDestinationID().getDestinationID()));
            model.addAttribute("listLocalTravel", packageTourHQL.findAllLocalTravelByDestinationID(tour.getDestinationID().getDestinationID()));
            for (LocalTravelInTours ltinTour : tour.getLocalTravelInToursList()) {
                tourDTO.setLocalTravelinTour(ltinTour.getLocalTravelID().getLocalTravelID());
            }
            model.addAttribute("tour", tourDTO);
            return "ad_edit_tour";
        }
        if (tourDTO.getHotelID() == 0) {
            br.rejectValue("hotelID", "500", "Hotel cannot be empty");
            Tours tour = toursRepository.findById(id).get();
            model.addAttribute("listDestination", packageTourHQL.findAllDestinationByArea(tour.getPackageTourID().getAreaID().getAreaID()));
            model.addAttribute("listRestaurant", packageTourHQL.findAllRestaurentByDestinationID(tour.getDestinationID().getDestinationID()));
            model.addAttribute("listHotel", packageTourHQL.findAllHotelByDestinationID(tour.getDestinationID().getDestinationID()));
            model.addAttribute("listLocalTravel", packageTourHQL.findAllLocalTravelByDestinationID(tour.getDestinationID().getDestinationID()));
            for (LocalTravelInTours ltinTour : tour.getLocalTravelInToursList()) {
                tourDTO.setLocalTravelinTour(ltinTour.getLocalTravelID().getLocalTravelID());
            }
            model.addAttribute("tour", tourDTO);
            return "ad_edit_tour";
        }

        if (tourDTO.getListLocalTravelinTour().isEmpty()) {
            br.rejectValue("listLocalTravelinTour", "500", "Local travel cannot be empty");
            Tours tour = toursRepository.findById(id).get();
            model.addAttribute("listDestination", packageTourHQL.findAllDestinationByArea(tour.getPackageTourID().getAreaID().getAreaID()));
            model.addAttribute("listRestaurant", packageTourHQL.findAllRestaurentByDestinationID(tour.getDestinationID().getDestinationID()));
            model.addAttribute("listHotel", packageTourHQL.findAllHotelByDestinationID(tour.getDestinationID().getDestinationID()));
            model.addAttribute("listLocalTravel", packageTourHQL.findAllLocalTravelByDestinationID(tour.getDestinationID().getDestinationID()));
            for (LocalTravelInTours ltinTour : tour.getLocalTravelInToursList()) {
                tourDTO.setLocalTravelinTour(ltinTour.getLocalTravelID().getLocalTravelID());
            }
            model.addAttribute("tour", tourDTO);
            return "ad_edit_tour";
        }

        Tours tour = tourDTO.tranferToEntities();
        tour.setPackageTourID(packageToursRepository.findById(tourDTO.getPackageTourID()).get());
        tour.setDestinationID(destinationsRepository.findById(tourDTO.getDestinationID()).get());
        tour.setRestaurantID(restaurantsRepository.findById(tourDTO.getRestaurantID()).get());
        tour.setHotelID(hotelsRepository.findById(tourDTO.getHotelID()).get());
        toursRepository.save(tour);

        Tours t = toursRepository.findById(id).get();
        for (LocalTravelInTours lt : t.getLocalTravelInToursList()) {
            localTravelInToursRepository.deleteByIdCustom(lt.getLocalTravelInTourID());
        }

        for (int ltID : tourDTO.getListLocalTravelinTour()) {
            LocalTravelInTours localTravelInTour = new LocalTravelInTours();
            localTravelInTour.setLocalTravelID(localTravelsRepository.findById(ltID).get());
            localTravelInTour.setTourID(tour);
            localTravelInToursRepository.save(localTravelInTour);
        }

        return "redirect:/admin/employee/manage-packagetour/home-packagetour?success=true";
    }

    @Override
    public String viewPackageTourClient(Model model, int pageIndex) {
        int pageSize = 3;
        int maxPage = 2;
        LocalDate today = LocalDate.now();
        Date current = Date.valueOf(today);

        int totalRecord = packageTourHQL.findAllPackageTourAvailable(current).size();
        model.addAttribute("totalRecord", totalRecord);
        pageIndex = Integer.valueOf(pageIndex) == null ? 1 : pageIndex;
        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("pageSize", pageSize);
        int totalPage = (int) Math.ceil(Double.valueOf(totalRecord) / Double.valueOf(pageSize));
        List<PackageTours> listPackageTour = new ArrayList<>();
        if (pageIndex == totalPage) {
            listPackageTour = packageTourHQL.findAllPackageTourAvailable(current).subList((pageIndex - 1) * pageSize, totalRecord);
        } else {
            listPackageTour = packageTourHQL.findAllPackageTourAvailable(current).subList((pageIndex - 1) * pageSize, pageIndex * pageSize);
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

        model.addAttribute("listPackageTour", listPackageTour);
        model.addAttribute("listProvince", provincesRepository.findAll());
        FilterPackageTourDTO filterPackageTourDTO = new FilterPackageTourDTO();
        filterPackageTourDTO.setDate(current);
        model.addAttribute("filterPackageTour", filterPackageTourDTO);
        model.addAttribute("searchPackageTour", filterPackageTourDTO);
        model.addAttribute("pagination", "pagination");
        return "packagetour";
    }

    @Override
    public String filterPackageTourClient(FilterPackageTourDTO filterPackageTourDTO, Model model) {

        if (filterPackageTourDTO.getFromProvinceID() == null && filterPackageTourDTO.getToProvinceID() == null && filterPackageTourDTO.getDate() == null) {
            return "redirect:/packagetour/page/1";
        }
        if (filterPackageTourDTO.getFromProvinceID() == 0) {
            filterPackageTourDTO.setFromProvinceID(null);
        }
        if (filterPackageTourDTO.getToProvinceID() == 0) {
            filterPackageTourDTO.setToProvinceID(null);
        }
        LocalDate today = LocalDate.now();
        Date current = Date.valueOf(today);
        if (filterPackageTourDTO.getDate().equals(current)) {

            filterPackageTourDTO.setDate(null);
        }
        model.addAttribute("listPackageTour", packageTourHQL.findAllPackageTourByFilter(filterPackageTourDTO.getFromProvinceID(), filterPackageTourDTO.getToProvinceID(), filterPackageTourDTO.getDate(), current));
        if (filterPackageTourDTO.getDate() == null) {
            filterPackageTourDTO.setDate(current);
        }
        model.addAttribute("filterPackageTour", filterPackageTourDTO);
        model.addAttribute("searchPackageTour", filterPackageTourDTO);
        model.addAttribute("listProvince", provincesRepository.findAll());
        return "packagetour";
    }

    @Override
    public String searchPackageTourClient(FilterPackageTourDTO filterPackageTourDTO, Model model) {
        LocalDate today = LocalDate.now();
        Date current = Date.valueOf(today);
        filterPackageTourDTO.setDate(current);
        model.addAttribute("filterPackageTour", filterPackageTourDTO);
        model.addAttribute("searchPackageTour", filterPackageTourDTO);
        model.addAttribute("listProvince", provincesRepository.findAll());
        model.addAttribute("listPackageTour", packageTourHQL.findAllPackageTourBySearch(filterPackageTourDTO.getKeyword(), current));
        return "packagetour";
    }

    @Override
    public String viewDetailPackageTourClient(Model model, int id) {
        PackageTours packageTour = packageToursRepository.findById(id).get();
        model.addAttribute("packageTour", packageTour);
        return "packagetour_detail";
    }

    @Override
    public String statisticQuantityTourInYear(HttpServletRequest hsr) {
        int year = Integer.parseInt(hsr.getParameter("year"));
        List<StatisticQuantityInYearDTO> listSq = new ArrayList<>();
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

        List<PackageTours> listPackageTour = packageToursRepository.findAll();
        for (MonthDTO month : listMonth) {
            StatisticQuantityInYearDTO dto = new StatisticQuantityInYearDTO();
            dto.setMonth(month.getName());
            dto.setQuantity(0);
            for (PackageTours item : listPackageTour) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(item.getDateStart());
                int m = cal.get(Calendar.MONTH);
                int y = cal.get(Calendar.YEAR);
                if (m == (month.getMonth() - 1) && y == year && item.getStatus() == 2) {
                    dto.setQuantity(dto.getQuantity() + 1);
                }
            }
            listSq.add(dto);
        }
        Gson gson = new Gson();
        String json = gson.toJson(listSq);
        return json;
    }

    @Override
    public String staticticQuantityBookedInYear(HttpServletRequest hsr) {
        int year = Integer.parseInt(hsr.getParameter("year"));
        List<StatisticQuantityInYearDTO> listSq = new ArrayList<>();
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

        List<BookingTours> listBookingTour = bookingToursRepository.findAll();
        for (MonthDTO month : listMonth) {
            StatisticQuantityInYearDTO dto = new StatisticQuantityInYearDTO();
            dto.setMonth(month.getName());
            dto.setQuantity(0);
            for (BookingTours item : listBookingTour) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(item.getBookDate());
                int m = cal.get(Calendar.MONTH);
                int y = cal.get(Calendar.YEAR);
                if (m == (month.getMonth() - 1) && y == year && item.getStatus() == 2) {
                    dto.setQuantity(dto.getQuantity() + item.getQuantityAdult() + item.getQuantityChildren());
                }
            }
            listSq.add(dto);
        }
        Gson gson = new Gson();
        String json = gson.toJson(listSq);
        return json;
    }

    @Override
    public String staticticQuantityCancelInYear(HttpServletRequest hsr) {
        int year = Integer.parseInt(hsr.getParameter("year"));
        List<StatisticQuantityInYearDTO> listSq = new ArrayList<>();
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

        List<BookingTours> listBookingTour = bookingToursRepository.findAll();
        for (MonthDTO month : listMonth) {
            StatisticQuantityInYearDTO dto = new StatisticQuantityInYearDTO();
            dto.setMonth(month.getName());
            dto.setQuantity(0);
            for (BookingTours item : listBookingTour) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(item.getBookDate());
                int m = cal.get(Calendar.MONTH);
                int y = cal.get(Calendar.YEAR);
                if (m == (month.getMonth() - 1) && y == year && item.getStatus() == -1) {
                    dto.setQuantity(dto.getQuantity() + 1);
                }
            }
            listSq.add(dto);
        }
        Gson gson = new Gson();
        String json = gson.toJson(listSq);
        return json;
    }

    @Override
    public String statisticQuantityAvailableSlotInYear(HttpServletRequest hsr) {
        int year = Integer.parseInt(hsr.getParameter("year"));
        List<StatisticQuantityInYearDTO> listSq = new ArrayList<>();
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

        List<PackageTours> listPackageTour = packageToursRepository.findAll();
        for (MonthDTO month : listMonth) {
            StatisticQuantityInYearDTO dto = new StatisticQuantityInYearDTO();
            dto.setMonth(month.getName());
            dto.setQuantity(0);
            for (PackageTours item : listPackageTour) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(item.getDateStart());
                int m = cal.get(Calendar.MONTH);
                int y = cal.get(Calendar.YEAR);
                if (m == (month.getMonth() - 1) && y == year && item.getStatus() == 2) {
                    dto.setQuantity(dto.getQuantity() + item.getCapacity());
                }
            }
            listSq.add(dto);
        }
        Gson gson = new Gson();
        String json = gson.toJson(listSq);
        return json;
    }

    @Override
    public String statisticQuantityBookedTourTypeInMonth(HttpServletRequest hsr) {
        int month = Integer.parseInt(hsr.getParameter("month"));

        int year = Year.now().getValue();
        List<BookingTours> listBookingTour = bookingToursRepository.findAll();
        List<TourTypes> listTourType = tourTypesRepository.findAll();
        List<StatisticQuantityInMonthDTO> list = new ArrayList<>();

        for (TourTypes item : listTourType) {
            StatisticQuantityInMonthDTO dto = new StatisticQuantityInMonthDTO();
            dto.setQuantity(0);
            for (BookingTours subitem : listBookingTour) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(subitem.getBookDate());
                int m = cal.get(Calendar.MONTH);
                int y = cal.get(Calendar.YEAR);

                if (subitem.getStatus() == 2 && item.getTourTypeID() == subitem.getPackageTourID().getTourTypeID().getTourTypeID() && m == (month - 1) && y == year) {

                    dto.setQuantity(dto.getQuantity() + subitem.getQuantityAdult() + subitem.getQuantityChildren());
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
    public String statisticQuantityBookedFromProvinceInMonth(HttpServletRequest hsr) {
        int month = Integer.parseInt(hsr.getParameter("month"));

        int year = Year.now().getValue();
        List<BookingTours> listBookingTour = bookingToursRepository.findAll();
        List<Provinces> listProvince = provincesRepository.findAll();
        List<StatisticQuantityInMonthDTO> list = new ArrayList<>();

        for (Provinces item : listProvince) {
            StatisticQuantityInMonthDTO dto = new StatisticQuantityInMonthDTO();
            dto.setQuantity(0);
            for (BookingTours subitem : listBookingTour) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(subitem.getBookDate());
                int m = cal.get(Calendar.MONTH);
                int y = cal.get(Calendar.YEAR);

                if (subitem.getStatus() == 2 && item.getProvinceID() == subitem.getPackageTourID().getFromProvinceID().getProvinceID() && m == (month - 1) && y == year) {

                    dto.setQuantity(dto.getQuantity() + subitem.getQuantityAdult() + subitem.getQuantityChildren());
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
    public String statisticQuantityBookedAreaInMonth(HttpServletRequest hsr) {
        int month = Integer.parseInt(hsr.getParameter("month"));

        int year = Year.now().getValue();
        List<BookingTours> listBookingTour = bookingToursRepository.findAll();
        List<Areas> listArea = areasRepository.findAll();
        List<StatisticQuantityInMonthDTO> list = new ArrayList<>();

        for (Areas item : listArea) {
            StatisticQuantityInMonthDTO dto = new StatisticQuantityInMonthDTO();
            dto.setQuantity(0);
            for (BookingTours subitem : listBookingTour) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(subitem.getBookDate());
                int m = cal.get(Calendar.MONTH);
                int y = cal.get(Calendar.YEAR);

                if (subitem.getStatus() == 2 && item.getAreaID() == subitem.getPackageTourID().getAreaID().getAreaID() && m == (month - 1) && y == year) {

                    dto.setQuantity(dto.getQuantity() + subitem.getQuantityAdult() + subitem.getQuantityChildren());
                }
            }
            dto.setLabel(item.getName());
            list.add(dto);
        }
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

}
