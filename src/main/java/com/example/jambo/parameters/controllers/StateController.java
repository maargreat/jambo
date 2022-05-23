package com.example.jambo.parameters.controllers;

import com.example.jambo.parameters.models.State;
import com.example.jambo.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/states")
    public String getAll(Model model){
        List<State> states = stateService.getAll();
        model.addAttribute("states", states);
        return "parameters/states";
    }

    @GetMapping("/stateAdd")
    public String addState(){
        return "parameters/stateAdd";
    }

    @GetMapping("/stateEdit/{id}")
    public String editState(@PathVariable Integer id, Model model)
    {
        State state =stateService.getById(id);
        model.addAttribute("state", state);
        return "parameters/stateEdit";
    }

    @PostMapping("/states")
    public String save(State state){
        stateService.save(state);
        return "redirect:/parameters/states";
    }


    @GetMapping("/stateDetails/{id}")
    public String detailsState(@PathVariable Integer id, Model model)
    {
        State state =stateService.getById(id);
        model.addAttribute("state", state);
        return "parameters/stateDetails";

    }
    @RequestMapping(value ="/states/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update( State state)
    {
        stateService.save(state);
        return "redirect:parameters/states";
    }


}
