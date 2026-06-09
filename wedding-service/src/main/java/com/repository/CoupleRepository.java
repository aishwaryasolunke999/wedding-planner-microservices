package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Couple;

public interface CoupleRepository extends JpaRepository<Couple, Long> {
}


