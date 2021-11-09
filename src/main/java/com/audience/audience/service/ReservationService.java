package com.audience.audience.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.audience.audience.entity.Reservation;
import com.audience.audience.repository.ReservationRepository;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation>getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation>getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation() ==null) {
            return reservationRepository.save(reservation);
            
        } else {
            Optional<Reservation> consulta=reservationRepository.getReservation(reservation.getIdReservation());
            if (consulta.isEmpty()) {
                return reservationRepository.save(reservation);
                
            } else {
                return reservation;                
            }
            
        }
    }
}
