package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService service;
    
    @Autowired
    private VendorRepository repository;

    @PostMapping("/add")
    public Vendor add(@RequestBody Vendor vendor) {
        return service.addVendor(vendor);
    }

    @GetMapping("/all")
    public List<Vendor> getAll() {
        return service.getAll();
    }

    @GetMapping("/search")
    public List<Vendor> search(
            @RequestParam String city,
            @RequestParam String category) {
        return service.search(city, category);
    }
    
    @PutMapping("/approve/{id}")
    public Vendor approveVendor(@PathVariable Long id) {

        Vendor vendor = repository.findById(id).orElseThrow();

        vendor.setStatus("APPROVED");

        return repository.save(vendor);
    }
    
    @GetMapping("/count")
    public Long getVendorCount() {
        return service.getVendorCount();
    }
}