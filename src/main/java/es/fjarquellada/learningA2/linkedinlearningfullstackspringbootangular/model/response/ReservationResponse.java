package es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular.model.response;

import java.time.LocalDate;

public class ReservationResponse {
	private Long id;
	private LocalDate checkin;
	private LocalDate checkout;
	private Long roomId;
	
	
	
	public ReservationResponse() {
		super();
	}
	public ReservationResponse(LocalDate checkin, LocalDate checkout, Long roomId) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
		this.roomId = roomId;
	}
	public ReservationResponse(Long id, LocalDate checkin, LocalDate checkout, Long roomId) {
		super();
		this.id = id;
		this.checkin = checkin;
		this.checkout = checkout;
		this.roomId = roomId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getCheckin() {
		return checkin;
	}
	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}
	public LocalDate getCheckout() {
		return checkout;
	}
	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	
	
}
