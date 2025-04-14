package com.tour_travel.tour_management.controller;

import com.tour_travel.tour_management.model.User;
import com.tour_travel.tour_management.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Returns the login.jsp view
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("username") String username,
                              @RequestParam("password") String password ,
                              HttpSession session,
                              Model model) {
        User user = loginService.validateUser(username, password);

        if (user != null) {
            session.setAttribute("loggedInEmail", user.getEmail());
//            model.addAttribute("username", user.getUsername());
            return "main"; // Assuming a "welcome.jsp" page exists for successful login
        } else {
            model.addAttribute("errorMessage", "Invalid username or password");
            return "login";
        }
    }
}
