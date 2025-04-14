package com.tour_travel.tour_management.controller;

import com.tour_travel.tour_management.model.TourPackage;
import com.tour_travel.tour_management.service.AdminCRUDService;
import com.tour_travel.tour_management.service.AdminService;
import com.tour_travel.tour_management.service.BookingService;
import com.tour_travel.tour_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class AdminCRUDController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    AdminCRUDService adminCRUDService;

    @PostMapping("/deletePackage")
    public String deletePackage(@RequestParam("packageId") Long id, Model model) {

        boolean isDeleted = adminCRUDService.deletePackage(id);

        if (isDeleted) {
            model.addAttribute("successMessage", "Package Deleted Successfully.");
        } else {
            model.addAttribute("errorMessage", "Package ID not found. Please enter a valid ID.");
        }


        //Total Number of Tour Available
        int totalTours = adminService.getTotalTours();

        //Total Number of User
        int totalUsers = userService.getTotalUsers();

        //Total number of booking
        int totalBookings = bookingService.getTotalBookings();

        model.addAttribute("totalTours", totalTours);
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("totalBookings", totalBookings);

        return "admin_dashboard";


    }

    @PostMapping("/addPackage")
    public String addPackage(@RequestParam("image") MultipartFile image, TourPackage tourPackage, Model model) {

        try {
            String uploadDir = "/webapp/assets/images/";

            File uploadDirectory = new File(uploadDir);
            if (!uploadDirectory.exists()) {
                uploadDirectory.mkdirs();
            }
            // Generate a unique file name and save the image
           String fileName = "E:/IMAGES/" + image.getOriginalFilename();
//            Path filePath = Paths.get(uploadDir, fileName);
//            Files.write(filePath, image.getBytes());


//            tourPackage.setPhotoPath(filePath\.toString());
            tourPackage.setPhotoPath(uploadDir + image.getOriginalFilename());

            adminCRUDService.savePackage(tourPackage);
            model.addAttribute("sm1", "Package added successfully!");
        } catch (Exception e) {
            model.addAttribute("em1", "Failed to add package! Please try again.");
        }
        //Total Number of Tour Available
        int totalTours = adminService.getTotalTours();

        //Total Number of User
        int totalUsers = userService.getTotalUsers();

        //Total number of booking
        int totalBookings = bookingService.getTotalBookings();

        model.addAttribute("totalTours", totalTours);
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("totalBookings", totalBookings);

        return "admin_dashboard";

    }

    @PostMapping("/updatePackage")
    public String updatePackage(@RequestParam("packageId") Long packageId,
                                @RequestParam("packageName") String packageName,
                                @RequestParam("description") String description,
                                @RequestParam("days") int days,
                                @RequestParam("nights") int nights,
                                @RequestParam("price") double price,
                                @RequestParam("image") MultipartFile image,
                                Model model) {

        try {
            // Logging for debugging
            System.out.println("Received request to update package with ID: " + packageId);

            String imagePath = null;
            if (!image.isEmpty()) {
                String uploadDir = "uploads/images/";
                File uploadDirFile = new File(uploadDir);
                if (!uploadDirFile.exists()) {
                    uploadDirFile.mkdirs(); // Create the directory if it does not exist
                }

                String uniqueFileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
                File uploadFile = new File(uploadDir + uniqueFileName);

                try {
                    image.transferTo(uploadFile);
                    imagePath = "/" + uploadDir + uniqueFileName;
                    System.out.println("Image uploaded successfully: " + imagePath);
                } catch (IOException e) {
                    e.printStackTrace();
                    model.addAttribute("imageError", "Image upload failed");
                    return "admin_dashboard";
                }

            }

            boolean isUpdated = adminCRUDService.updatePackage(packageId, packageName, description, days, nights, price, imagePath);
            if (isUpdated) {
                model.addAttribute("sm2", "Package updated successfully");
            } else {
                model.addAttribute("em2", "Package ID not found");
                System.out.println("Package ID not found: " + packageId);
            }

            // Fetch updated totals for dashboard
            int totalTours = adminService.getTotalTours();
            int totalUsers = userService.getTotalUsers();
            int totalBookings = bookingService.getTotalBookings();

            model.addAttribute("totalTours", totalTours);
            model.addAttribute("totalUsers", totalUsers);
            model.addAttribute("totalBookings", totalBookings);

            return "admin_dashboard";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("em2", "An error occurred while updating the package.");
            return "admin_dashboard";
        }
    }
}
