package com.tour_travel.tour_management.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "tour_package_id")
    private TourPackage tourPackage;

    private String customerName;
    private String customerEmail;
    private int numberOfPersons;
    private String bookingDate;

}
