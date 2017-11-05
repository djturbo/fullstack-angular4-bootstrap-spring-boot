package es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.converter;

import org.springframework.core.convert.converter.Converter;

import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.entity.Reservation;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.request.ReservationRequest;

public class ReservationRequestToReservation implements Converter<ReservationRequest, Reservation> {

	@Override
	public Reservation convert(ReservationRequest source) {
		Reservation entity = new Reservation();
		entity.setCheckin(source.getCheckin());
		entity.setCheckout(source.getCheckout());
		if(source.getId() != null) {
			entity.setId(source.getId());
		}
		return entity;
	}

}
