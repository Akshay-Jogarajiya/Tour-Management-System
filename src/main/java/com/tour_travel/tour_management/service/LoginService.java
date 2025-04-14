package com.tour_travel.tour_management.service;

import com.tour_travel.tour_management.model.User;
import com.tour_travel.tour_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public User validateUser(String username, String password) {

        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
