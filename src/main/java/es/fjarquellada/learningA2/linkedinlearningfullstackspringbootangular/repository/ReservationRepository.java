package es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.repository;

import org.springframework.data.repository.CrudRepository;

import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.entity.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{
	Reservation findById(Long id);
}
