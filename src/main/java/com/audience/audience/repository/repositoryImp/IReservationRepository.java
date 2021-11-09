package com.audience.audience.repository.repositoryImp;
import com.audience.audience.entity.Reservation;

import org.springframework.data.repository.CrudRepository;

public interface IReservationRepository extends CrudRepository<Reservation,Integer> {
    
}
