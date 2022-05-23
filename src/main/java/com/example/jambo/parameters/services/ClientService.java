package com.example.jambo.parameters.services;


import com.example.jambo.parameters.models.Client;
import com.example.jambo.parameters.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

  //  public void save (Client client){clientRepository.save(client);}

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
    
    public Client getById(Integer id) { return (Client) clientRepository.findById(id).orElse(null);    }

    public Client findById(Integer id) { return (Client) clientRepository.findById(id).orElse(null);    }

   public List<Client> findAll() { return clientRepository.findAll();    }

    public void save(Client client) { clientRepository.save(client);
    }
}
