package es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.entity.Room;

public interface PageableRoomRepository extends PagingAndSortingRepository<Room, Long>{
	Page<Room>findById(Long id, Pageable page);
}
