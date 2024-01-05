/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.controller.admin;

import com.cusc.service.HomeAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author kyqua
 */
@Controller
@RequestMapping("/admin/")
public class AdminHomeController {

    @Autowired
    private HomeAdminService adminService;

    @GetMapping("home")
    public String homeAdmin(Model model) {
        return adminService.homeAdmin(model);
    }

    @GetMapping("datatable")
    public String datatable() {
        return "ad_datatable";
    }

    @GetMapping("without-menu")
    public String withoutMenu() {
        return "ad_withoutmenu";
    }

    @GetMapping("without-navbar")
    public String withoutNavBar() {
        return "ad_withoutnavbar";
    }

    @GetMapping("container")
    public String container() {
        return "ad_container";
    }

    @GetMapping("fluid")
    public String fluid() {
        return "ad_fluid";
    }

    @GetMapping("blank")
    public String blank() {
        return "ad_blank";
    }

    @GetMapping("account-setting")
    public String accountSetting() {
        return "ad_accountsetting";
    }

    @GetMapping("account-notification")
    public String accountNotification() {
        return "ad_accountnotification";
    }

    @GetMapping("account-connection")
    public String accountConnection() {
        return "ad_accountconnection";
    }

    @GetMapping("login")
    public String login() {
        return "ad_login";
    }

    @GetMapping("register")
    public String register() {
        return "ad_register";
    }

    @GetMapping("forgot-password")
    public String forgotPassword() {
        return "ad_forgotpassword";
    }

    @GetMapping("error")
    public String error() {
        return "ad_error";
    }

    @GetMapping("under-maintenance")
    public String underMaintenance() {
        return "ad_undermaintenance";
    }

    @GetMapping("card")
    public String card() {
        return "ad_card";
    }

    @GetMapping("accordion")
    public String accordion() {
        return "ad_accordion";
    }

    @GetMapping("alert")
    public String alert() {
        return "ad_alert";
    }

    @GetMapping("badges")
    public String badges() {
        return "ad_badges";
    }

    @GetMapping("button")

    public String button() {
        return "ad_button";
    }

    @GetMapping("carousel")
    public String carousel() {
        return "ad_carousel";
    }

    @GetMapping("collapse")
    public String collapse() {
        return "ad_collapse";
    }

    @GetMapping("dropdown")
    public String dropdown() {
        return "ad_dropdown";
    }

    @GetMapping("footer")
    public String footer() {
        return "ad_footer";
    }

    @GetMapping("list-group")
    public String listgroup() {
        return "ad_listgroup";
    }

    @GetMapping("modal")
    public String modal() {
        return "ad_modal";
    }

    @GetMapping("navbar")
    public String navbar() {
        return "ad_navbar";
    }

    @GetMapping("offcanvas")
    public String offcanvas() {
        return "ad_offcanvas";
    }

    @GetMapping("breadcrumb")
    public String breadcrumb() {
        return "ad_breadcrumb";
    }

    @GetMapping("progress")
    public String progress() {
        return "ad_progress";
    }

    @GetMapping("spinner")
    public String spinner() {
        return "ad_spinner";
    }

    @GetMapping("tabpill")
    public String tabpill() {
        return "ad_tabpill";
    }

    @GetMapping("toast")
    public String toast() {
        return "ad_toast";
    }

    @GetMapping("tooltip")
    public String tooltip() {
        return "ad_tooltip";
    }

    @GetMapping("typography")
    public String typography() {
        return "ad_typography";
    }

    @GetMapping("boxicon")
    public String boxicon() {
        return "ad_boxicon";
    }

    @GetMapping("perfectscrollbar")
    public String perfectscrollbar() {
        return "ad_perfectscrollbar";
    }

    @GetMapping("textdivider")
    public String textdivider() {
        return "ad_textdivider";
    }

    @GetMapping("basicinput")
    public String basicinput() {
        return "ad_basicinput";
    }

    @GetMapping("inputgroup")
    public String inputgroup() {
        return "ad_inputgroup";
    }

    @GetMapping("formvertical")
    public String formvertical() {
        return "ad_formvertical";
    }

    @GetMapping("formhorizontal")
    public String formhorizontal() {
        return "ad_formhorizontal";
    }

    @GetMapping("table")
    public String table() {
        return "ad_table";
    }
}
