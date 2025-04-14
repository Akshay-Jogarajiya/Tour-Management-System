package com.tour_travel.tour_management.controller;

import com.tour_travel.tour_management.model.TourPackage;
import com.tour_travel.tour_management.service.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class TourPackageController {

    @Autowired
    private TourPackageService tourPackageService;

    private final String UPLOAD_DIRECTORY = "uploads/";

    @GetMapping("/tour")
    public String getAllPackages(Model model) {

        List<TourPackage> packages = tourPackageService.getAllPackages();
        System.out.println("Number of packages: " + packages);
        model.addAttribute("pack", packages);
        return "tour";
    }

//    @PostMapping
//    public ResponseEntity<String> savePackage(@RequestParam("packageName") String packageName,
//                                              @RequestParam("description") String description,
//                                              @RequestParam("price") double price,
//                                              @RequestParam("nights") int nights,
//                                              @RequestParam("days") int days,
//                                              @RequestParam("photo") MultipartFile file) {
//        try {
//            // Save the photo to the file system
//            Path path = Paths.get(UPLOAD_DIRECTORY + file.getOriginalFilename());
//            Files.write(path, file.getBytes());
//
//            // Create and save the TourPackage object
//            TourPackage tourPackage = new TourPackage();
//            tourPackage.setPackageName(packageName);
//            tourPackage.setDescription(description);
//            tourPackage.setPrice(price);
//            tourPackage.setNights(nights);
//            tourPackage.setDays(days);
//            tourPackage.setPhotoPath(path.toString());
//
//            tourPackageService.savePackage(tourPackage);
//
//            return ResponseEntity.status(HttpStatus.CREATED).body("Package saved successfully");
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving package");
//        }
//    }
}
