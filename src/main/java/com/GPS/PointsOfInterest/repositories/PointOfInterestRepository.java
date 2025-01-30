package com.GPS.PointsOfInterest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GPS.PointsOfInterest.entity.PointOfInterest;
import com.GPS.PointsOfInterest.projections.PointOfInterestProjection;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Integer>{
    @Query(nativeQuery = true, value = "SELECT * FROM tb_points_of_interest WHERE name LIKE :name")
    PointOfInterestProjection getPointOfInterestByName(String name);
}
