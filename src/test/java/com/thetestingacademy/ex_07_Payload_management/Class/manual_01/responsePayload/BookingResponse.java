package com.thetestingacademy.ex_07_Payload_management.Class.manual_01.responsePayload;

import com.thetestingacademy.ex_07_Payload_management.Class.manual_01.requestPayload.Booking;

public class BookingResponse {

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    private Integer bookingid;
    private Booking booking;

}