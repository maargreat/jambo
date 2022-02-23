package com.example.jambo.parameters.services;


import com.example.jambo.parameters.models.State;
import com.example.jambo.parameters.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> getAll(){
        return stateRepository.findAll();
    }

    public void save (State state){
        stateRepository.save(state);
    }


}
