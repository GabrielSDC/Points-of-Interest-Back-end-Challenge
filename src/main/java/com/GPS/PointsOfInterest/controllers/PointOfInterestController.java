package com.GPS.PointsOfInterest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GPS.PointsOfInterest.dto.PointOfInterestDTO;
import com.GPS.PointsOfInterest.services.PointOfInterestService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "pois")
public class PointOfInterestController {
    @Autowired
    private PointOfInterestService pointOfInterestService;

    @GetMapping
    public ResponseEntity<List<PointOfInterestDTO>> getAll() {
        return ResponseEntity.ok().body(pointOfInterestService.getAll());
    }
    
}
