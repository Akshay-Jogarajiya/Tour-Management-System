package com.tour_travel.tour_management.repository;

import com.tour_travel.tour_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findByUsername(String username);
}
