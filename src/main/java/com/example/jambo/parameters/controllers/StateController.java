package com.example.jambo.parameters.controllers;

import com.example.jambo.parameters.models.State;
import com.example.jambo.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/states")
    public String getAll(Model model){
        List<State> states = stateService.getAll();
        model.addAttribute("states", states);
        return "parameters/stateList";
    }

    @GetMapping("/stateAdd")
    public String addState(){
        return "parameters/stateAdd";
    }

    @PostMapping("/states")
    public String save(State state){
        stateService.save(state);
        return "redirect:/states";
    }




}
