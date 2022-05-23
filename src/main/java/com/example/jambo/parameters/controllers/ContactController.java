package com.example.jambo.parameters.controllers;

import com.example.jambo.parameters.models.Contact;
import com.example.jambo.parameters.services.ContactService;
import com.example.jambo.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {


    @Autowired private ContactService contactService;
    @Autowired private CountryService countryService;
    @Autowired private StateController stateService;
    private Integer id;

    @GetMapping("/contacts")
    public String getAll(Model model)
    {   List<Contact> contacts=contactService.findAll();
        model.addAttribute("contacts", contacts);
        return "parameters/contacts"; //contactlist
    }

    @GetMapping("/parameters/contact/{id}")
    @ResponseBody
    public Contact getContact(@PathVariable Integer id){
        return contactService.findById(id);
    }

    @GetMapping("/contactAdd")
    public String addContact()    {
        return "parameters/contactAdd";
    }

    @PostMapping("/contacts")
    public String save(Contact contact)
    {   contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping("/contacts/findById")
    @ResponseBody
    public Contact findById(Integer Id){return contactService.findById(id);}

    //The Get Contact By Id

    @PostMapping(value="contacts/addNew")
    public String addNew(Contact contact){
        contactService.save(contact);
        return "redirect: /contacts";
    }
    @RequestMapping(value ="/contacts/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete( @PathVariable Integer id)
    {   contactService.delete(id);
        return "redirect:/contacts";
    }

    @GetMapping("/parameters/contactEdit/{op}/{id}")
    public String editContact(@PathVariable Integer id, @PathVariable String op, Model model)
    {  Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return " /parameters/contactEdit" +op;
    }

    @GetMapping("/contactDetails/{id}")
    public String detailsContact(@PathVariable Integer id, Model model)
    {    Contact contact =contactService.findById(id);
        model.addAttribute("contact", contact);
        return "parameters/contactDetails";
    }

         @RequestMapping(value ="/contacts/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update( Contact contact )
    {   contactService.save(contact);
        return "redirect:/parameters/contacts";
    }
      /* @GetMapping("/contact")
    public String findAll(Model model){
        addModelAttribute(model);
        return "/parameters/contactList";
    }
    */
     /*  @GetMapping("/contacts")
    public String findAll(Model model){
        addModelAttribute(model);
        return "/parameters/contactList";
    } */

}
