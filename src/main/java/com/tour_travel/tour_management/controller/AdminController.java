package com.tour_travel.tour_management.controller;

import com.tour_travel.tour_management.service.AdminService;
import com.tour_travel.tour_management.service.BookingService;
import com.tour_travel.tour_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/admin_login")
    public String loginPage() {
        return "admin_login";
    }

    @PostMapping("/AdminLogin")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (adminService.validateAdmin(username, password)) {

            //Total Number of Tour Available
            int totalTours = adminService.getTotalTours();

            //Total Number of User
            int totalUsers = userService.getTotalUsers();

            //Total number of booking
            int totalBookings = bookingService.getTotalBookings();

            model.addAttribute("totalTours", totalTours);
            model.addAttribute("totalUsers", totalUsers);
            model.addAttribute("totalBookings", totalBookings);

            return "admin_dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "admin_login";
        }
    }
}

