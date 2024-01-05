/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cusc.dto.CarDTO;
import com.cusc.dto.CarImageDTO;
import com.cusc.dto.StatisticQuantityInMonthDTO;
import com.cusc.entities.BookingCars;
import com.cusc.entities.CarImages;
import com.cusc.entities.CarModels;
import com.cusc.entities.Cars;
import com.cusc.entities.TypeCars;
import com.cusc.repositories.BookingCarsRepository;
import com.cusc.repositories.CarImagesRepository;
import com.cusc.repositories.CarModelsRepository;
import com.cusc.repositories.CarsRepository;
import com.cusc.repositories.TypeCarsRepository;
import com.cusc.repositories.hql.CarsHQL;
import com.cusc.service.CarManageService;
import com.google.gson.Gson;
import java.util.ArrayList;
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
public class CarManageServiceimpl implements CarManageService {

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private CarModelsRepository carModelsRepository;

    @Autowired
    private TypeCarsRepository typeCarsRepository;

    @Autowired
    private BookingCarsRepository bookingCarsRepository;

    @Autowired
    private CarImagesRepository imagesRepository;

    @Autowired
    private CarsHQL carsHQL;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String viewCar(Model model) {
        model.addAttribute("listCar", carsRepository.findAll());
        return "ad_view_car";
    }

    @Override
    public String createCar(Model model) {
        CarDTO carDTO = new CarDTO();
        model.addAttribute("listCarType", typeCarsRepository.findAll());
        model.addAttribute("listCarModel", carModelsRepository.findAll());
        model.addAttribute("car", carDTO);
        return "ad_create_car";
    }

    @Override
    public String createCar(CarDTO cardto, BindingResult br, Model model) {
        CarImageDTO imageDTO = new CarImageDTO();
        if (br.hasErrors()) {
            model.addAttribute("listCarType", typeCarsRepository.findAll());
            model.addAttribute("listCarModel", carModelsRepository.findAll());
            model.addAttribute("car", cardto);
            return "ad_create_car";
        }
        long checkCarname = carsHQL.getCountByCarName(cardto.getCarName());
        if (checkCarname > 0) {
            br.rejectValue("carName", "500", "Car name is exist ");
            model.addAttribute("listCarType", typeCarsRepository.findAll());
            model.addAttribute("listCarModel", carModelsRepository.findAll());
            model.addAttribute("car", cardto);
            return "ad_create_car";
        }
        if (!cardto.getImage().isEmpty()) {    try {
                String imgName = "CAR_" + cardto.getCarName();
                cloudinary.uploader().destroy(imgName, ObjectUtils.asMap("resouce_type", "auto", "public_id", imgName));
                Map upload = cloudinary.uploader().upload(cardto.getImage().getBytes(), ObjectUtils.asMap("public_id", imgName));
                cardto.setUrlImage((String) upload.get("secure_url"));
            } catch (Exception e) {
            }
        }
        cardto.setStatus(true);
        Cars car = cardto.tranferToEntities();
        CarModels carModels = carModelsRepository.findById(cardto.getCarModelID()).get();
        TypeCars typeCars = typeCarsRepository.findById(cardto.getCarTypeID()).get();
        car.setCarModelID(carModels);
        car.setCarTypeID(typeCars);
        carsRepository.save(car);
        imageDTO.setCarID(car.getCarID());
        CarImages img = imageDTO.tranferToEntities();
        img.setCarID(car);
        imagesRepository.save(img);
        return "redirect:/admin/employee/manage-car/home-car?success=true";
    }

    @Override
    public String editCar(Model model, int id) {
        Cars cars = carsRepository.findById(id).get();
        CarDTO cdto = new CarDTO();
        cdto.getData(cars);
        model.addAttribute("listCarType", typeCarsRepository.findAll());
        model.addAttribute("listCarModel", carModelsRepository.findAll());
        model.addAttribute("car", cdto);
        return "ad_edit_car";
    }

    @Override
    public String editCar(CarDTO dTO, BindingResult br, Model model, HttpServletRequest request, int id) {
        String urlImg = dTO.getUrlImage();
        String oldNameCar = request.getParameter("oldCarName");
        boolean checkSameName = oldNameCar.equals(dTO.getCarName());
        if (br.hasErrors()) {
            model.addAttribute("listCarType", typeCarsRepository.findAll());
            model.addAttribute("listCarModel", carModelsRepository.findAll());
            model.addAttribute("car", dTO);
            return "ad_edit_car";
        }
        if (!checkSameName) {
            long checkCarname = carsHQL.getCountByCarName(dTO.getCarName());
            if (checkCarname > 0) {
                br.rejectValue("carName", "500", "Car name is exist ");
                model.addAttribute("listCarType", typeCarsRepository.findAll());
                model.addAttribute("listCarModel", carModelsRepository.findAll());
                model.addAttribute("car", dTO);
                return "ad_edit_car";
            }
        }
        if (!dTO.getImage().isEmpty()) {
            try {
                String imgName = "CAR_" + dTO.getCarName();
                cloudinary.uploader().destroy(imgName, ObjectUtils.asMap("resouce_type", "auto", "public_id", imgName));
                Map upload = cloudinary.uploader().upload(dTO.getImage().getBytes(), ObjectUtils.asMap("public_id", imgName));
                dTO.setUrlImage((String) upload.get("secure_url"));
            } catch (Exception e) {
            }
        }
        Cars car = dTO.tranferToEntities();
        CarModels carModels = carModelsRepository.findById(dTO.getCarModelID()).get();
        TypeCars typeCars = typeCarsRepository.findById(dTO.getCarTypeID()).get();
        car.setCarModelID(carModels);
        car.setCarTypeID(typeCars);
        carsRepository.save(car);
        return "redirect:/admin/employee/manage-car/home-car?success=true";
    }

    @Override
    public String deleteCar(HttpServletRequest hsr) {
        int id = Integer.parseInt(hsr.getParameter("carID"));
        carsRepository.deleteById(id);
        return "redirect:/admin/employee/manage-car/home-car";
    }

    @Override
    public String viewDetailCar(Model model, int i) {
        Cars cars = carsRepository.findById(i).get();
        model.addAttribute("car", cars);
        return "ad_detail_car";
    }

    @Override
    public String statisticCarByAirCondition(HttpServletRequest request) {
        int month = Integer.parseInt(request.getParameter("month"));
        List<Cars> listCar = carsRepository.findAll();
        List<StatisticQuantityInMonthDTO> listStatistic = new ArrayList<>();
        Gson gson = new Gson();
        for (Cars cars : listCar) {
            if (cars.getIsHasAirConditioned()) {
                StatisticQuantityInMonthDTO dto = new StatisticQuantityInMonthDTO();
                int value = 0;
                dto.setLabel(cars.getCarName());
                if (!cars.getBookingCarsList().isEmpty()) {
                    for (BookingCars bkc : cars.getBookingCarsList()) {
                        if (bkc.getRentalDate().toLocalDate().getMonthValue() == month && bkc.getStatus() == 2) {
                            value++;
                        }
                    }
                }
                dto.setQuantity(value);
                listStatistic.add(dto);
            }
        }
        String json = gson.toJson(listStatistic);
        System.out.println("--" + json);
        return json;
    }

    @Override
    public String statisticCarByUnAirCondition(HttpServletRequest hsr) {
        int month = Integer.parseInt(hsr.getParameter("month"));
        List<Cars> listCar = carsRepository.findAll();
        List<StatisticQuantityInMonthDTO> listStatistic = new ArrayList<>();
        Gson gson = new Gson();
        for (Cars cars : listCar) {
            if (!cars.getIsHasAirConditioned()) {
                StatisticQuantityInMonthDTO dto = new StatisticQuantityInMonthDTO();
                int value = 0;
                dto.setLabel(cars.getCarName());
                if (!cars.getBookingCarsList().isEmpty()) {
                    for (BookingCars bkc : cars.getBookingCarsList()) {
                        if (bkc.getRentalDate().toLocalDate().getMonthValue() == month && bkc.getStatus() == 2) {
                            value++;
                        }
                    }
                }
                dto.setQuantity(value);
                listStatistic.add(dto);
            }
        }
        String json = gson.toJson(listStatistic);
        System.out.println("--" + json);
        return json;
    }

    @Override
    public String statisticCarByTypeCar(HttpServletRequest hsr) {
        int month = Integer.parseInt(hsr.getParameter("month"));
        List<TypeCars> listTypeCar = typeCarsRepository.findAll();
        List<StatisticQuantityInMonthDTO> listStatistic = new ArrayList<>();
        Gson gson = new Gson();
        for (TypeCars typeCars : listTypeCar) {
            StatisticQuantityInMonthDTO dto = new StatisticQuantityInMonthDTO();
            int value = 0;
            dto.setLabel(typeCars.getCarTypeName());
            for (Cars cars : typeCars.getCarsList()) {
                if (!cars.getBookingCarsList().isEmpty()) {
                    for (BookingCars bkc : cars.getBookingCarsList()) {
                        if (bkc.getRentalDate().toLocalDate().getMonthValue() == month && bkc.getStatus() == 2) {
                            value++;
                        }
                    }
                }
            }
            dto.setQuantity(value);
            listStatistic.add(dto);
        }
        String json = gson.toJson(listStatistic);
        return json;
    }

    @Override
    public String statisticCarByModelCar(HttpServletRequest hsr) {
        int month = Integer.parseInt(hsr.getParameter("month"));
        List<CarModels> listModel = carModelsRepository.findAll();
        List<StatisticQuantityInMonthDTO> listStatistic = new ArrayList<>();
        Gson gson = new Gson();
        for (CarModels model : listModel) {
            StatisticQuantityInMonthDTO dto = new StatisticQuantityInMonthDTO();
            int value = 0;
            dto.setLabel(model.getName());
            for (Cars cars : model.getCarsList()) {
                if (!cars.getBookingCarsList().isEmpty()) {
                    for (BookingCars bkc : cars.getBookingCarsList()) {
                        if (bkc.getRentalDate().toLocalDate().getMonthValue() == month && bkc.getStatus() == 2) {
                            value++;
                        }
                    }
                }
            }
            dto.setQuantity(value);
            listStatistic.add(dto);
        }
        String json = gson.toJson(listStatistic);
        return json;
    }

}
