package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Component;
import com.example.accessingdatamysql.Reservation;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
@Component
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

	List<Reservation> findByNameIgnoreCase(String name);
	List<Reservation> findByDayAndHour(String day, Integer hour);
	void deleteByDay(String day);
	void deleteByDayAndHour(String day, Integer hour);
	
}
