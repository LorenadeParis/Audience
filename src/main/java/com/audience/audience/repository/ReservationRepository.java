package com.audience.audience.repository;

import com.audience.audience.repository.repositoryImp.IReservationRepository;
import java.util.List;
import java.util.Optional;
import com.audience.audience.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {

     @Autowired
     IReservationRepository  iReservationRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>)iReservationRepository.findAll();
    }

    public Optional<Reservation>getReservation(int id){
        return iReservationRepository.findById(id);
    }

    public Reservation save(Reservation Reservation){
        return iReservationRepository.save(Reservation);
    }
    
}
