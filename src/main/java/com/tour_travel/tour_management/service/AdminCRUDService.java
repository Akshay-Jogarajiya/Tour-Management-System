package com.tour_travel.tour_management.service;

import com.tour_travel.tour_management.model.TourPackage;
import com.tour_travel.tour_management.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminCRUDService {

    @Autowired
    TourPackageRepository tourPackageRepository;

    public boolean deletePackage(Long id) {

        if (tourPackageRepository.existsById(id)) {
            tourPackageRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void savePackage(TourPackage tourPackage) {
        tourPackageRepository.save(tourPackage);
    }

    public boolean updatePackage(Long packageId, String packageName, String description, int days, int nights, double price, String imagePath) {
        Optional<TourPackage> optionalPackage = tourPackageRepository.findById(packageId);

        if (optionalPackage.isPresent()) {
            TourPackage tourPackage = optionalPackage.get();
            tourPackage.setPackageName(packageName);
            tourPackage.setDescription(description);
            tourPackage.setDays(days);
            tourPackage.setNights(nights);
            tourPackage.setPrice(price);

            // Only update the photoPath if a new image is provided
            if (imagePath != null) {
                tourPackage.setPhotoPath(imagePath);
            }

            tourPackageRepository.save(tourPackage);
            return true;
        }
        return false;
    }
}