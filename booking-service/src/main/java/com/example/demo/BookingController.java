package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService service;
    
    @Autowired
    private BookingRepository repository;

    @PostMapping("/create")
    public Booking createBooking(@RequestBody Booking booking) {
        return service.createBooking(booking);
    }
    
    @PutMapping("/confirm/{id}")
    public Booking confirmBooking(@PathVariable Long id) {

        Booking booking =
                repository.findById(id).orElseThrow();

        booking.setStatus("CONFIRMED");

        return repository.save(booking);
    }
    
    @GetMapping("/count")
    public Long getBookingCount() {
        return service.getBookingCount();
    }
}