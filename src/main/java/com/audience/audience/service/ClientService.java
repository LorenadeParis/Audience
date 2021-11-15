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
        if (client.getIdClient() ==null) {
            return clientRepository.save(client);
            
        } else {
            Optional<Client> consulta=clientRepository.getClient(client.getIdClient());
            if (consulta.isEmpty()) {
                return clientRepository.save(client);
                
            } else {
                return client;                
            }
            
        }
    }

    public Client update(Client client){
        if (client.getIdClient() !=null) {
            Optional<Client> consulta=clientRepository.getClient(client.getIdClient());
            if (!consulta.isEmpty()) {
                if(consulta.get().getName() != null){
                    consulta.get().setName(client.getName());
                }
                if(consulta.get().getPassword() != null){
                    consulta.get().setPassword(client.getPassword());
                }
                if(consulta.get().getEmail() != null){
                    consulta.get().setEmail(client.getEmail());
                }
                if(consulta.get().getAge() != null){
                    consulta.get().setAge(client.getAge());
                }

                return clientRepository.save(consulta.get());
            } 
            
        }
        return client;
    }
    
    public void delete(int id){
        Optional<Client> consulta=clientRepository.getClient(id);
        if (!consulta.isEmpty()) {
                clientRepository.delete(id);
        }
    }
}
