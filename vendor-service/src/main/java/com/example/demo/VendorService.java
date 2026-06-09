package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    @Autowired
    private VendorRepository repository;

    /*public Vendor addVendor(Vendor vendor) {
        return repo.save(vendor);
    }*/

    public List<Vendor> getAll() {
        return repository.findAll();
    }

    public List<Vendor> search(String city, String category) {
        return repository.findByCityAndCategory(city, category);
    }
    
    public Vendor addVendor(Vendor vendor) {

        vendor.setStatus("PENDING");

        return repository.save(vendor);
    }
    
    public Long getVendorCount() {
        return repository.count();
    }
}