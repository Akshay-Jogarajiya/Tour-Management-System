package com.tour_travel.tour_management.service;
import com.tour_travel.tour_management.model.Booking;
import com.tour_travel.tour_management.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }


    public int getTotalBookings() {
        return (int) bookingRepository.count();
    }

    public List<Booking> findByCustomerEmail(String email) {
        return bookingRepository.findByCustomerEmail(email);

    }
}
