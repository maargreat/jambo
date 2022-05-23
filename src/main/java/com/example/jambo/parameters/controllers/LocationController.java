package com.example.jambo.parameters.controllers;


import com.example.jambo.parameters.models.Location;
import com.example.jambo.parameters.services.CountryService;
import com.example.jambo.parameters.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import javax.xml.stream.Location;
import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;
    private CountryService countryService;
    private CountryService statesService;

    public Model addModelAttribute(Model model){
        model.addAttribute("locations" , locationService.findAll());
        model.addAttribute("countries" , countryService.findAll());
        model.addAttribute("state", statesService.findAll());
        return model;
    }

    @GetMapping("/location")
    public String findAll(Model model){
        addModelAttributes(model);
        return "parameters/locations";
    }

    @GetMapping("/parameters/locationAdd")
    public String addLocation(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "/parameters/locationAdd";
    }

    @GetMapping("/parameters/location/{op}/{id}")
    public String editLocation(@PathVariable Integer id, @PathVariable String op, Model model){
        Location location =locationService.getById(id);
        model.addAttribute("location", location);
        addModelAttributes(model);
        return "parameters/locationEdit" + op; //returns location edit or location details
    }

    private Model addModelAttributes(Model model) {
        model.addAttribute("Locations", locationService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", statesService.findAll());
        return model;
    }

    @PostMapping(value = "/locationAdd") /* /states*/
    public String addNew(Location location){
        locationService.save(location);
        return "parameters/locationAdd"; /* /states*/
    }

    @RequestMapping(value = "/location/delete/{id}", method ={RequestMethod.GET, RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        locationService.delete(id);
        return "redirect:/location";
    }


    @RequestMapping(value = "/location/update/{id}", method ={RequestMethod.GET, RequestMethod.PUT})
    public String update(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    @GetMapping("/locationDetails/{id}")
    public String detailsLocation(@PathVariable Integer id, Model model) {
        com.example.jambo.parameters.models.Location location = locationService.getById(id);
        model.addAttribute("location", location);
        return "parameters/locationDetails";
    }

    @PostMapping("/parameters/location")
    public String save(Location location){
        locationService.save(location);
        return "redirect:/parameters/location";
    }

    @GetMapping("/locations")
    public String getAll(Model model){
        List<Location> locations = locationService.getAll();
        model.addAttribute("locations", locations);
        return "parameters/locations";
    }

}
