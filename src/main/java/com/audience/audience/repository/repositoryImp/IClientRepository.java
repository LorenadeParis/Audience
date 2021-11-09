package com.audience.audience.repository.repositoryImp;
import com.audience.audience.entity.Client;

import org.springframework.data.repository.CrudRepository;

public interface IClientRepository extends CrudRepository<Client,Integer> {
    
}
