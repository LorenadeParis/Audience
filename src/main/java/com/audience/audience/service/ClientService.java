package com.audience.audience.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.audience.audience.entity.Client;
import com.audience.audience.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public List<Client>getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client>getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if (client.getIdCliente() ==null) {
            return clientRepository.save(client);
            
        } else {
            Optional<Client> consulta=clientRepository.getClient(client.getIdCliente());
            if (consulta.isEmpty()) {
                return clientRepository.save(client);
                
            } else {
                return client;                
            }
            
        }
    }
}
