package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		if(!checkOut.after(checkIn)) {
			
			throw new DomainException("Error reservation must be after");
		
	}
		this.roomNumber = roomNumber;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumb(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut ;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			
			throw new DomainException("Error resevation must be future");
			
		}
		
		if(!checkOut.after(checkIn)) {
			
			throw new DomainException("Error reservation must be after");
		
	}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	@Override
	public String toString() {
		return "Room " + 
				roomNumber +
				", check-in " +
				sdf.format(checkIn) +
				", check-out: " +
				sdf.format(checkOut) +
				 ", " +
				duration() +
				" nights";
	}
	
	
	}
