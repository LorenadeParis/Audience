package com.audience.audience.repository;

import com.audience.audience.repository.repositoryImp.IMessageRepository;
import java.util.List;
import java.util.Optional;

import com.audience.audience.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {

     @Autowired
     IMessageRepository  iMessageRepository;

    public List<Message> getAll(){
        return (List<Message>)iMessageRepository.findAll();
    }

    public Optional<Message>getMessage(int id){
        return iMessageRepository.findById(id);
    }

    public Message save(Message Message){
        return iMessageRepository.save(Message);
    }
    
}
