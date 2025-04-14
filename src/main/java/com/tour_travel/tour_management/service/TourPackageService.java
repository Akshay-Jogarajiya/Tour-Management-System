package com.tour_travel.tour_management.service;

import com.tour_travel.tour_management.model.TourPackage;
import com.tour_travel.tour_management.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourPackageService {

    @Autowired
    private TourPackageRepository tourPackageRepository;

    public List<TourPackage> getAllPackages() {
        return tourPackageRepository.findAll();
    }

    public TourPackage getPackageById(Long tourPackageId) {
        return tourPackageRepository.getById(tourPackageId);
    }

//    public TourPackage savePackage(TourPackage tourPackage) {
//        return tourPackageRepository.save(tourPackage);
//    }
//
}
