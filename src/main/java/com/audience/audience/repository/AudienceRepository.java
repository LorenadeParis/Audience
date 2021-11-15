package com.audience.audience.repository;

import com.audience.audience.repository.repositoryImp.IAudienceRepository;
import java.util.List;
import java.util.Optional;

import com.audience.audience.entity.Audience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AudienceRepository {

     @Autowired
     IAudienceRepository  iAudienceRepository;

    public List<Audience> getAll(){
        return (List<Audience>)iAudienceRepository.findAll();
    }

    public Optional<Audience>getAudience(int id){
        return iAudienceRepository.findById(id);
    }

    public Audience save(Audience Audience){
        return iAudienceRepository.save(Audience);
    }

    public void delete(int id){
        iAudienceRepository.deleteById(id);
   }
    
}
