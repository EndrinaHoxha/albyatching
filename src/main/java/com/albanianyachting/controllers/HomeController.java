package com.albanianyachting.controllers;

import com.albanianyachting.dto.ServicesDTO;
import com.albanianyachting.services.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@Api("Set of endpoints for Creating, Retrieving, Updating and Deleting.")
public class HomeController {
    @Autowired
    private ToursService toursService;
    @Autowired
    private ProvisioningService provisioningService;
    @Autowired
    private BookTourService bookTourService;
    @Autowired
    private BunkerQuoteService bunkerQuoteService;
    @Autowired
    private ArrivalFormalitiesService arrivalFormalitiesService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private ServicesService servicesService;

    @GetMapping(value = {"/"})
    @ApiOperation(value = "Return home page", notes = "Retrieving the collection of home page operations")
    public String homePage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "index";
    }
    @GetMapping(value = {"/about"})
    @ApiOperation(value = "Return about us page", notes = "Retrieving the collection of about us page operations")
    public String aboutPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "about";
    }
    @GetMapping(value = {"/servicesC"})
    @ApiOperation(value = "Return services page", notes = "Retrieving the collection of services page operations")
    public String activitiesPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "services";
    }
    @GetMapping(value = {"/contact"})
    @ApiOperation(value = "Return contact us page", notes = "Retrieving the collection of contact page operations")
    public String contactPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "contact";
    }
    @GetMapping(value = {"/login"})
    @ApiOperation(value = "Return login page", notes = "Retrieving the collection of login page operations")
    public String loginPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "login";
    }
    @GetMapping(value = {"/controlpanel"})
    @ApiOperation(value = "Return controlpanel page", notes = "Retrieving the collection of controlpanel page operations")
    public String controlpanelPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "controlpanel";
    }
    @GetMapping(value = {"/tours"})
    @ApiOperation(value = "Return tours page", notes = "Retrieving the collection of tours page operations")
    public String toursPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        model.addAttribute("listTours", this.toursService.findTours());
        return "tours";
    }
    @GetMapping(value = {"/provisioning"})
    @ApiOperation(value = "Return provisioning page", notes = "Retrieving the collection of provisioning page operations")
    public String provisioningPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        model.addAttribute("listProvisioning", this.provisioningService.findProvisionings());
        return "provisioning";
    }
    @GetMapping(value = {"/booktour"})
    @ApiOperation(value = "Return booktour page", notes = "Retrieving the collection of booktour page operations")
    public String bookTourPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        model.addAttribute("listBookTour", this.bookTourService.findBookTour());
        return "booktour";
    }
    @GetMapping(value = {"/bunkerquote"})
    @ApiOperation(value = "Return bunkerquote page", notes = "Retrieving the collection of bunkerquote page operations")
    public String bunkerQuotePage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        model.addAttribute("listBunkerQuote", this.bunkerQuoteService.findBunkerQuote());
        return "bunkerquote";
    }
    @GetMapping(value = {"/arrivalformalities"})
    @ApiOperation(value = "Return arrivalformalities page", notes = "Retrieving the collection of arrivalformalities page operations")
    public String arrivalFormalitiesPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        model.addAttribute("listArrivalFormalities", this.arrivalFormalitiesService.findArrivalFormalities());
        return "arrivalformalities";
    }
    @GetMapping(value = {"/users"})
    @ApiOperation(value = "Return users page", notes = "Retrieving the collection of users page operations")
    public String agentsPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        model.addAttribute("listAgents", this.usersService.findUsers());
        return "users";
    }
    @GetMapping(value = {"/bookservice"})
    @ApiOperation(value = "Return users page", notes = "Retrieving the collection of users page operations")
    public String bookservicePage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "bookservice";
    }
    @GetMapping(value = {"/arrivalformalitiesForm"})
    @ApiOperation(value = "Return users page", notes = "Retrieving the collection of users page operations")
    public String arrivalformalitiesFormPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        return "arrivalformalitiesform";
    }
    @GetMapping(value = {"/servicesCP"})
    public String getServices(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        model.addAttribute("listServices", this.servicesService.findServices());
        return "servicesCP";
    }
    @GetMapping(value = {"/manageService"})
    public String manageServices(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        model.addAttribute("listServices", this.servicesService.findServices());
        model.addAttribute("serviceDTO", new ServicesDTO());
        return "manageService";
    }
//    @PostMapping ("/newService")
    @RequestMapping(value = "/newService", method = RequestMethod.POST)
    public String newService(ModelMap model, HttpServletRequest request) {
//        model.addAttribute("listService", this.servicesService.findServices());
//        model.addAttribute("serviceDTO", new ServicesDTO());
        return "manageService";
    }
    @RequestMapping(value = "/insertService", method = RequestMethod.POST, params = {"saveService"})
    public String insertService(Model model, RedirectAttributes redirect, @Validated ServicesDTO servicesDTO, BindingResult result, HttpServletRequest request) {
        servicesDTO = this.servicesService.createServices(servicesDTO);
        if (servicesDTO!= null) {
            return "redirect:/servicesCP";
        } else {
            model.addAttribute("servicesDTO", servicesDTO);
            return "manageService";
        }
    }
}
