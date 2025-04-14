package com.tour_travel.tour_management.service;

import com.tour_travel.tour_management.model.User;
import com.tour_travel.tour_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        userRepository.save(user); // Save the user to the database
    }

    public int getTotalUsers() {
        System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        return (int) userRepository.count();
    }
}

