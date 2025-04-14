package com.tour_travel.tour_management.controller;

import com.tour_travel.tour_management.model.User;
import com.tour_travel.tour_management.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String showRegistrationForm() {
        return "register"; // Return the name of your JSP file (register.jsp)
    }

    @PostMapping("/Register")
    public String registerUser(User user, Model model) {
        // Here you could add validation or checks for existing users

        userService.registerUser(user); // Save the user
        model.addAttribute("successMessage", "Registration successful! Please login."); // Optionally add success message
        return "login"; // Redirect to login page or success page
    }

    @GetMapping("/logout")
    public String logoutAdmin(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "main";
    }


}

