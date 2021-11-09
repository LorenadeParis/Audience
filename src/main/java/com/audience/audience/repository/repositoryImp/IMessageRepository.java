package com.audience.audience.repository.repositoryImp;
import com.audience.audience.entity.Message;

import org.springframework.data.repository.CrudRepository;

public interface IMessageRepository extends CrudRepository<Message,Integer> {
    
}
