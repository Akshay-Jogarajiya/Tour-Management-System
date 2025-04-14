package com.tour_travel.tour_management.controller;

import com.tour_travel.tour_management.model.Booking;
import com.tour_travel.tour_management.model.TourPackage;
import com.tour_travel.tour_management.service.BookingService;
import com.tour_travel.tour_management.service.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import jakarta.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
//@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private TourPackageService tourPackageService;

    @GetMapping("/booking")
    public String showBooking() {
        return "booking";
    }
    @GetMapping("booking/bookTour")
    public String showBookingForm(@RequestParam("tourId") Long tourId, Model model , HttpSession session) {

        TourPackage tourPackage = tourPackageService.getPackageById(tourId);

        if (tourPackage == null) {
            model.addAttribute("err", "Tour package not found.");
            return "tour";
        }
        String loggedInEmail = (String) session.getAttribute("loggedInEmail");

        if (loggedInEmail != null) {
            model.addAttribute("tourPackage", tourPackage);
            return "booking";
        }
        else {

            return "/login";
        }


    }

//    @PostMapping("booking/addBooking")
//    public String addBooking(Booking booking, @RequestParam("tourPackageId") Long tourPackageId, Model model) {
//
//        TourPackage tourPackage = tourPackageService.getPackageById(tourPackageId);
//        booking.setTourPackage(tourPackage);
//        bookingService.saveBooking(booking);
//        model.addAttribute("bs", "Booking successful!");
//        return "booking";
//    }

    @PostMapping("booking/addBooking")
    public String addBooking(Booking booking, @RequestParam("tourPackageId") Long tourPackageId, Model model) {
        TourPackage tourPackage = tourPackageService.getPackageById(tourPackageId);
        booking.setTourPackage(tourPackage);
        bookingService.saveBooking(booking);
        model.addAttribute("bs", "Booking successful!");
        return "booking_success"; // Redirect to a different page after successful booking
    }

    @GetMapping("/my_booking")
    public String getMyBookings(HttpSession session, Model model) {
        // Check if user is logged in
        String loggedInEmail = (String) session.getAttribute("loggedInEmail");

        if (loggedInEmail != null) {
            // User is logged in, fetch bookings using their email
            List<Booking> bookings = bookingService.findByCustomerEmail(loggedInEmail);
            model.addAttribute("bookings", bookings);
            return "my_booking"; // View page to show bookings
        } else {
            // User is not logged in, redirect to login page
            return "/login";
        }
    }

//    // Method to check bookings by email
//    @GetMapping("/booking_results")
//    public String checkBooking(@RequestParam("email") String email, Model model) {
//        List<Booking> bookings = bookingService.findByCustomerEmail(email);
//
//        if (bookings != null && !bookings.isEmpty()) {
//            model.addAttribute("bookings", bookings);
//        } else {
//            model.addAttribute("bookings", Collections.emptyList()); // Avoid null check in JSP
//        }
//
//        return "booking_results"; // Ensure this matches the JSP file name
//    }
}
