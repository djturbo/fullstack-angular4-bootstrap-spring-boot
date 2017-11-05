package es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.entity.Room;

public interface RoomRepository extends CrudRepository<Room, Long>{
	Room findById(Long id);
}
