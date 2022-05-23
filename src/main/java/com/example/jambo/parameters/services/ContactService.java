package com.example.jambo.parameters.services;

import com.example.jambo.parameters.models.Contact;
import com.example.jambo.parameters.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;


    public void save (Contact contact){ contactRepository.save(contact); }

    public void delete (Integer id){
        contactRepository.deleteById(id);
    }

    public Contact findById(int id) {
        return contactRepository.findById(id).orElse( null);
    }

    public List<Contact> findAll() { return contactRepository.findAll();}

    /*
      public List<Contact> getAll(){ return contactRepository.findAll();    }

    public Contact findById(Integer id) {
        return contactRepository.findById(id).orElse(null);}*/
}
