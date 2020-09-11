package com.albanianyachting.controllers;

import com.albanianyachting.services.ToursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class HomeController {
    @Autowired
    private ToursService toursService;
    @GetMapping(value = {"/"})
    public String homePage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "index";
    }
    @GetMapping(value = {"/about"})
    public String aboutPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "about";
    }
    @GetMapping(value = {"/services"})
    public String activitiesPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "activities";
    }
    @GetMapping(value = {"/contact"})
    public String contactPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "contact";
    }
    @GetMapping(value = {"/login"})
    public String loginPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "login";
    }
    @GetMapping(value = {"/controlpanel"})
    public String controlpanelPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "controlpanel";
    }
    @GetMapping(value = {"/tours"})
    public String toursPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        model.addAttribute("listTours", this.toursService.findTours());
        return "tours";
    }
}
