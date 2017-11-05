package es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.converter;

import org.springframework.core.convert.converter.Converter;

import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.entity.Room;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.Links;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.Self;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.response.ReservableRoomResponse;
import es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.response.ResourceConstants;

public class RoomToReservableRoomResponseConverter implements Converter<Room, ReservableRoomResponse> {

	@Override
	public ReservableRoomResponse convert(Room source) {
		ReservableRoomResponse reservation = new ReservableRoomResponse();
		
		reservation.setId(source.getId());
		reservation.setLinks(generateLink(source.getId()));
		reservation.setPrice(Integer.valueOf(source.getPrice()));
		reservation.setRoomNumber(source.getRoomNumber());
		
		return reservation;
	}

	private Links generateLink(Long id) {
		Links link = new Links();
		Self self = new Self();
		
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/"+id);
		link.setSerlf(self);
		return link;
	}

}
