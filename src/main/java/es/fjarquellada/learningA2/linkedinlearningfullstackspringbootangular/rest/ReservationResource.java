package es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.rest;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.request.ReservationRequest;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.response.ReservationResponse;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.response.ResourceConstants;

@RestController
@RequestMapping(value = ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {
	
	@RequestMapping(path="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse>getAvailableRooms(
			@RequestParam(name="checkin")
			@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
			LocalDate checkin, 
			@RequestParam(name="checkout")
			@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
			LocalDate checkout){
		
		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
		
	}
	@RequestMapping(path = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationRequest>cretateReservation(
			@RequestBody
			ReservationRequest reservationRequest){
		
		return new ResponseEntity<>(new ReservationRequest(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationRequest>updateReservation(
			@RequestBody
			ReservationRequest reservationRequest){
		
		return new ResponseEntity<>(new ReservationRequest(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{idReservation}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>deleteReservation(
			@PathVariable
			Long idReservation){
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
