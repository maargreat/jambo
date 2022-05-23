package com.example.jambo.parameters.services;




import com.example.jambo.parameters.models.Supplier;
import com.example.jambo.parameters.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAll(){
        return supplierRepository.findAll();
    }

    public void save (Supplier supplier){
        supplierRepository.save(supplier);
    }

    public void delete(Integer id) {
        supplierRepository.deleteById(id);
    }
    
    public Supplier getById(Integer id) { return supplierRepository.findById(id).orElse(null);    }

    public Supplier findById(Integer id) { return supplierRepository.findById(id).orElse(null);    }

    public List<Supplier> findAll() { return supplierRepository.findAll();    }
}
