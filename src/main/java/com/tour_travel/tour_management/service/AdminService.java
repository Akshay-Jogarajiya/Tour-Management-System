package com.tour_travel.tour_management.service;

import com.tour_travel.tour_management.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    TourPackageRepository tourPackageRepository;

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    public boolean validateAdmin(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    public int getTotalTours() {

        return (int) tourPackageRepository.count();
    }
}
