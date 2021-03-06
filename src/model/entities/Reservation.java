package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Long duration() {
        long diff = checkout.getTime() - checkin.getTime();

        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout) throws DomainException{

        Date now = new Date();

        if (checkin.before(now) || checkout.before(now)){
           throw new DomainException("Reservation dates for update must be future dates");
        }
        if (!checkin.after(checkin)) {
            throw new DomainException("Check-out date must be after check-in date");
        }

        this.checkin = checkin;
        this.checkout = checkout;

    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "Reservation: Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkin)
                + ", check-out: "
                + sdf.format(checkout)
                + ", "
                + duration()
                + " nights";
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
        if (!checkin.after(checkin)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
