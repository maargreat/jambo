package com.example.jambo.parameters.controllers;


import com.example.jambo.parameters.models.Supplier;
import com.example.jambo.parameters.services.CountryService;
import com.example.jambo.parameters.services.StateService;
import com.example.jambo.parameters.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    private CountryService countryService;
    private StateService statesService;

   public Model addModelAttribute(Model model){
        model.addAttribute("suppliers" , supplierService.findAll());
        model.addAttribute("states" , statesService.findAll());
        model.addAttribute("countries" , countryService.findAll());
        return model;
    }

    private Model addModelAttributes(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", statesService.findAll());
        return model;
    }

  /*  @GetMapping("parameters/suppliers")
    public String findAll(Model model){
        addModelAttributes(model);
        return "parameters/suppliers";
    }
*/
    @GetMapping("/suppliers")
    public String getAll(Model model){
        List<Supplier> suppliers = supplierService.getAll();
        model.addAttribute("suppliers", suppliers);
        return "/parameters/suppliers";
    }

    @GetMapping("/supplierAdd")
    public String addSupplier(Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        return "/parameters/supplierAdd";
    }

    @GetMapping("/parameters/supplier/{op}/{id}")
    public String editSupplier(@PathVariable Integer id, @PathVariable String op, Model model){
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        addModelAttributes(model);
        return "parameters/supplierEdit" + op; //returns supplier edit or supplier details
    }

    @PostMapping(value = "/supplierAdd") /* /states*/
    public String addNew(Supplier supplier){
        supplierService.save(supplier);
        return "parameters/supplierAdd"; /* /states*/
    }

    @RequestMapping(value = "/supplier/delete/{id}", method ={RequestMethod.GET, RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        supplierService.delete(id);
        return "redirect:/supplier";
    }


    @RequestMapping(value = "/supplier/update/{id}", method ={RequestMethod.GET, RequestMethod.PUT})
    public String update(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/supplier";
    }

    @GetMapping("/supplierDetails/{id}")
    public String detailsSupplier(@PathVariable Integer id, Model model) {
        Supplier supplier = supplierService.getById(id);
        model.addAttribute("supplier", supplier);
        return "parameters/supplierDetails";
    }

    @PostMapping("/parameters/supplier")
    public String save(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/parameters/supplier";
    }

}
