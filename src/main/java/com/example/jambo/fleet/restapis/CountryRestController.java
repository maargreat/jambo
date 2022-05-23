package com.example.jambo.fleet.restapis;

import com.example.jambo.parameters.models.Country;
import com.example.jambo.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryRestController {
    //rest apis will not return html but will return list of json objects
    //have rest controller in a different package so that you have your api and UI separately--
    //--this is what we call deconstructing a structured monolith to microservices



    @Autowired
    private CountryService countryService;
    @GetMapping("/api/countries") //returns json object list
    public List<Country> getAll(Model model){
        List<Country> countries = countryService.getAll();
        return countries;
    }


}
