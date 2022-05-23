package com.example.jambo.parameters.services;


import com.example.jambo.parameters.models.Location;
import com.example.jambo.parameters.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAll(){
        return locationRepository.findAll();
    }

    public void save (Location location){
        locationRepository.save(location);
    }

    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }

    public Location getById(Integer id) { return locationRepository.findById(id).orElse(null);    }

    public Location findById(Integer id) { return locationRepository.findById(id).orElse(null);    }

    public List<Location> findAll() { return locationRepository.findAll();    }

    public void save(javax.xml.stream.Location location) {
    }
}
