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

    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation() !=null) {
            Optional<Reservation> consulta=reservationRepository.getReservation(reservation.getIdReservation());
            if (!consulta.isEmpty()) {
                if(consulta.get().getStartDate() != null){
                    consulta.get().setStartDate(reservation.getStartDate());
                }
                if(consulta.get().getDevolutionDate() != null){
                    consulta.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(consulta.get().getScore() != null){
                    consulta.get().setScore(reservation.getScore());
                }
                if(consulta.get().getStatus() != null){
                    consulta.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(consulta.get());
            }
            
        }
        return reservation;
    }
    
    public void delete(int id){
        Optional<Reservation> consulta=reservationRepository.getReservation(id);
        if (!consulta.isEmpty()) {
            reservationRepository.delete(id);
        }
    }
}
