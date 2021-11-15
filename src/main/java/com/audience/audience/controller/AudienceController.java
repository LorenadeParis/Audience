package com.audience.audience.controller;

import java.util.List;
import java.util.Optional;

import com.audience.audience.entity.Audience;
import com.audience.audience.service.AudienceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/Audience")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AudienceController {
    
    @Autowired
    private AudienceService audienceService;

    @GetMapping("/all")
    public List<Audience>getAudience(){
        return audienceService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Audience>getAudience(@PathVariable("id") int id){
        return  audienceService.getAudience(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience save(@RequestBody Audience audience){
        return audienceService.save(audience);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience update(@RequestBody Audience audience){
        return audienceService.update(audience);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        audienceService.delete(id);
    }

}
