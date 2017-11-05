package es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.converter;

import org.springframework.core.convert.converter.Converter;

import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.entity.Reservation;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.response.ReservableResponse;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.response.ReservationResponse;

public class ReservationToReservationResponse implements Converter<Reservation, ReservationResponse>{

	@Override
	public ReservationResponse convert(Reservation source) {
		ReservationResponse response = new ReservationResponse();
		response.setCheckin(source.getCheckin());
		response.setCheckout(source.getCheckout());
		response.setId(source.getId());
		response.setRoomId(source.getRoomId().getId());
		return response;
	}

}
