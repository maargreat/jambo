package com.example.jambo.parameters.controllers;

import com.example.jambo.parameters.models.Client;
import com.example.jambo.parameters.services.ClientService;
import com.example.jambo.parameters.services.CountryService;
import com.example.jambo.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;
    private CountryService countryService;
    private StateService statesService;

    public Model addModelAttribute(Model model){
        model.addAttribute("clients" , clientService.findAll());
        model.addAttribute("countries" , countryService.findAll());
        model.addAttribute("states" , statesService.findAll());
        return model;
    }

    private Model addModelAttributes(Model model) {
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", statesService.findAll());
        return model;
    }

 /*   @GetMapping("/client")
    public String findAll(Model model){
        addModelAttributes(model);
        return "/parameters/clients";
    }
*/
    @GetMapping("/clients")
    public String getAll(Model model){
        List<Client> clients = clientService.getAll();
        model.addAttribute("clients", clients);
        return "/parameters/clients";
    }

    @GetMapping("/parameters/clientAdd")
    public String addClient(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "/parameters/clientAdd";
    }

    @GetMapping("/parameters/client/{op}/{id}")
    public String editClient(@PathVariable Integer id, @PathVariable String op, Model model){
        Client client =clientService.findById(id);
        model.addAttribute("client", client);
        addModelAttributes(model);
        return "/parameters/clientEdit" + op; //returns client edit or client details
    }

    @PostMapping(value = "/clientAdd") /* /states*/
    public String addNew(Client client){
        clientService.save(client);
        return "parameters/clientAdd"; /* /states*/
    }

    @RequestMapping(value = "/client/delete/{id}", method ={RequestMethod.GET, RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        clientService.delete(id);
        return "redirect:/client";
    }


    @RequestMapping(value = "/client/update/{id}", method ={RequestMethod.GET, RequestMethod.PUT})
    public String update(Client client){
        clientService.save(client);
        return "redirect:/client";
    }

    @GetMapping("/clientDetails/{id}")
    public String detailsClient(@PathVariable Integer id, Model model) {
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        return "parameters/clientDetails";
    }

    @PostMapping("/parameters/client")
    public String save(Client client){
        clientService.save(client);
        return "redirect:/parameters/client";
    }

}
