package com.GPS.PointsOfInterest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GPS.PointsOfInterest.entity.PointOfInterest;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Integer>{
    
}
