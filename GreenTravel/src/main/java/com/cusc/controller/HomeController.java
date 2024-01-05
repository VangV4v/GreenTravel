/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller;

import com.cusc.email.SendMail;
import com.cusc.repositories.hql.EmployeesHQL;
import com.cusc.service.CarRentalService;
import com.cusc.service.HomeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author kyqua
 */
@Controller
public class HomeController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private EmployeesHQL employeesHQL;

    @Autowired
    private CarRentalService carRentalService;

    @Autowired
    HomeClient homeClient;

    @GetMapping(value = {"/home", "/"})
    public String homeClient(Model model) {
        return homeClient.homeClient(model);
    }

    @GetMapping(value = "/about")
    public String about() {
        return "about";
    }

    @GetMapping(value = "/customer/about")
    public String cusabout() {
        return "about";
    }

    @GetMapping(value = "/insurance")
    public String insurance() {
        return "insurance";
    }

    @GetMapping(value = "/blog-home")
    public String bloghome() {
        return "bloghome";
    }

    @GetMapping(value = "/blog-detail")
    public String blogdetail() {
        return "blogdetail";
    }

    @GetMapping(value = "/element")
    public String element() {
        return "element";
    }

    @GetMapping(value = "/contact")
    public String contact() {
        return "contact";
    }
}
