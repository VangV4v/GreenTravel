/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.configuation.GoogleUtils;
import com.cusc.dto.CustomersDTO;
import com.cusc.dto.GooglePOJO;
import com.cusc.email.SendMail;
import com.cusc.entities.Customers;
import com.cusc.entities.Employees;
import com.cusc.entities.Roles;
import com.cusc.repositories.CustomersRepository;
import com.cusc.repositories.EmployeesRepository;
import com.cusc.repositories.RolesRepository;
import com.cusc.repositories.hql.CustomersHQL;
import com.cusc.repositories.hql.EmployeesHQL;
import com.cusc.service.SecurityService;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kyqua
 */
@Service
public class SecurityServiceimpl implements SecurityService {

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private EmployeesHQL employeesHQL;

    @Autowired
    private CustomersHQL customersHQL;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private GoogleUtils googleUtils;

    @Override
    public String login() {
        return "login";
    }

    @Override
    public String loginGoogle(HttpServletRequest request) {
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            return "redirect:/login?message=google_error";
        }
        try {
            String accessToken = googleUtils.getToken(code);
            GooglePOJO googlePOJO = googleUtils.getUserInfo(accessToken);
            UserDetails userDetails = googleUtils.buildUser(googlePOJO);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                    userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------" + e);
        }
        return "redirect:/home";
    }

    @Override
    public String loginProccess(Principal principal, HttpServletRequest request) {
        long cus = customersHQL.getCountByUsername(principal.getName());
        HttpSession ssAuthen = request.getSession();
        if (cus > 0) {
            Customers customer = customersRepository.findByUsername(principal.getName());
            ssAuthen.setAttribute("authen", customer);
            return "redirect:/home";
        } else {
            Employees employees = employeesRepository.findByUsername(principal.getName());
            ssAuthen.setAttribute("authen", employees);
            return "redirect:/admin/home";
        }
    }

    @Override
    public String logout() {
        return "redirect:/login";
    }

    @Override
    public String page403(Model model, Principal prncpl) {
        if (prncpl.getName() != null) {
            model.addAttribute("usernameSec", prncpl.getName());
        }
        return "403page";
    }

    @Override
    public String register(Model model) {
        CustomersDTO cdto = new CustomersDTO();
        model.addAttribute("cus", cdto);
        return "register";
    }

    @Override
    public String register(CustomersDTO cdto, BindingResult br, Model model, HttpServletRequest request, HttpSession session) {
        long checkUsernameExistEmployee;
        long checkUsernameExistCustomer;
        long checkEmailExistEmployee;
        long checkEmailExistCustomer;
        int statusCheck = 0;
        String captchaInput = request.getParameter("captcha");
        String captcha = session.getAttribute("captcha_security").toString();
        if (br.hasErrors()) {
            model.addAttribute("cus", cdto);
            return "register";
        } else {
            checkUsernameExistEmployee = employeesHQL.getCountByUsername(cdto.getUsername());
            checkUsernameExistCustomer = customersHQL.getCountByUsername(cdto.getUsername());
            checkEmailExistCustomer = customersHQL.getCountByEmail(cdto.getEmail());
            checkEmailExistEmployee = employeesHQL.getCountByEmail(cdto.getEmail());
            if (!captcha.equals(captchaInput)) {
                model.addAttribute("errCaptcha", "Captcha invalid ");
                statusCheck++;
            }
            if (checkUsernameExistEmployee > 0 || checkUsernameExistCustomer > 0) {
                br.rejectValue("username", "500", "Username exist ");
                statusCheck++;
            }
            if (checkEmailExistCustomer > 0 || checkEmailExistEmployee > 0) {
                br.rejectValue("email", "500", "Email exist ");
                statusCheck++;
            }
            if (!cdto.getPassword().equals(cdto.getConfirmNewPassword())) {
                br.rejectValue("confirmNewPassword", "500", "Password confirm is incorrect ");
                statusCheck++;
            }
            if (statusCheck > 0) {
                model.addAttribute("cus", cdto);
                return "register";
            }
        }
        Customers customers = cdto.tranferToEntities();
        Roles roles = rolesRepository.findById(3).get();
        customers.setPassword(passwordEncoder.encode(customers.getPassword()));
        customers.setAddress("None");
        customers.setAvatar("https://res.cloudinary.com/dqbzth4fo/image/upload/v1679810212/istockphoto-1223671392-612x612_yalp5s.jpg");
        customers.setStatus(true);
        customers.setRoleID(roles);
        customersRepository.save(customers);
        try {
            SendMail.sendMail(customers.getEmail(), "Register Success", contentEmail(customers));
        } catch (Exception e) {
        }
        return "redirect:/login?register=success";
    }

    private String contentEmail(Customers customers) {
        String content = ""
                + "Hello " + customers.getUsername()
                + "<br/> Welcome to the website <a href='#'>viewmore...</a>"
                + "<br/>From GreenTravel"
                + "<br/>Thanks.";
        return content;
    }

}
