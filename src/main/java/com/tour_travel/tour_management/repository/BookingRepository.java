package com.tour_travel.tour_management.repository;
import com.tour_travel.tour_management.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository <Booking, Long> {


    List<Booking> findByCustomerEmail(String email);
}
