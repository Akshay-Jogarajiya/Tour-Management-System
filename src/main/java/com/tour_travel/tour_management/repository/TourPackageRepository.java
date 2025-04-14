package com.tour_travel.tour_management.repository;

import com.tour_travel.tour_management.model.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourPackageRepository extends JpaRepository <TourPackage , Long> {

}
