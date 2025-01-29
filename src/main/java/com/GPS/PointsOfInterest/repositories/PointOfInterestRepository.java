package com.GPS.PointsOfInterest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.GPS.PointsOfInterest.entity.PointOfInterest;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Integer>{
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM tb_points_of_interest WHERE name = :name")
    void deleteByName(String name);
}
