package com.audience.audience.repository;

import com.audience.audience.repository.repositoryImp.IClientRepository;
import java.util.List;
import java.util.Optional;

import com.audience.audience.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {

     @Autowired
     IClientRepository  iClientRepository;

    public List<Client> getAll(){
        return (List<Client>)iClientRepository.findAll();
    }

    public Optional<Client>getClient(int id){
        return iClientRepository.findById(id);
    }

    public Client save(Client Client){
        return iClientRepository.save(Client);
    }
    
}
