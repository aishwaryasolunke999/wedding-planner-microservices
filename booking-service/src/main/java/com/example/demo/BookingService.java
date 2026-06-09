package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public Booking createBooking(Booking booking) {

        String url =
                "http://localhost:8084/wedding/expense?coupleId="
                + booking.getCoupleId()
                + "&amount="
                + booking.getAmount();

        restTemplate.postForObject(
                url,
                null,
                String.class);

        booking.setStatus("CONFIRMED");

        return repository.save(booking);
    }
    
    public Long getBookingCount() {
        return repository.count();
    }
}