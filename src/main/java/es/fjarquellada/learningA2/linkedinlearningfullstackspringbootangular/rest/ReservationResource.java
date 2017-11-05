package es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.converter.RoomToReservableRoomResponseConverter;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.entity.Reservation;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.entity.Room;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.request.ReservationRequest;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.response.ReservableRoomResponse;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.response.ReservationResponse;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.response.ResourceConstants;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.repository.PageableRoomRepository;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.repository.ReservationRepository;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.repository.RoomRepository;

@RestController
@RequestMapping(value = ResourceConstants.ROOM_RESERVATION_V1)
@CrossOrigin
public class ReservationResource {

	@Autowired
	private PageableRoomRepository pageableRoomRepository;
	@Autowired
	private RoomRepository repository;
	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private ConversionService conversionService;
	
	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ReservableRoomResponse> getAvailableRooms(
			@RequestParam(name = "checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
			@RequestParam(name = "checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout,
			Pageable pageable) {
		Page<Room> entityList = pageableRoomRepository.findAll(pageable);

		return entityList.map(new RoomToReservableRoomResponseConverter());

	}

	@RequestMapping(path = "/{roomId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Room> getRoomById(@PathVariable Long roomId) {
		Room room = repository.findById(roomId);
		ResponseEntity<Room> response = new ResponseEntity<Room>(room, HttpStatus.OK);
		return response;
	}

	@RequestMapping(path = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> cretateReservation(@RequestBody ReservationRequest reservationRequest) {
		Reservation reservation = conversionService.convert(reservationRequest, Reservation.class); 
		reservationRepository.save(reservation);
		Room room =  repository.findById(reservationRequest.getRoomId());
		room.addReservation(reservation);
		repository.save(room);

		reservation.setRoomId(room);
		reservationRepository.save(reservation);
		ReservationResponse response = conversionService.convert(reservation, ReservationResponse.class);
		
				
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@RequestMapping(path = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationRequest> updateReservation(@RequestBody ReservationRequest reservationRequest) {

		return new ResponseEntity<>(new ReservationRequest(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{idReservation}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReservation(@PathVariable Long idReservation) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
