package com.GPS.PointsOfInterest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GPS.PointsOfInterest.dto.CoordinateDTO;
import com.GPS.PointsOfInterest.dto.PointOfInterestDTO;
import com.GPS.PointsOfInterest.services.PointOfInterestService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/points")
public class PointOfInterestController {
    @Autowired
    private PointOfInterestService pointOfInterestService;

    @GetMapping
    public ResponseEntity<List<PointOfInterestDTO>> getAll() {
        return ResponseEntity.ok().body(pointOfInterestService.getAll());
    }
    
    @PostMapping
    public void addPointOfInterest(@RequestBody PointOfInterestDTO entity) {
        pointOfInterestService.addPointOfInterest(entity);
    }

    @PostMapping("/close")
    public ResponseEntity<List<PointOfInterestDTO>> getClosePoints(@RequestBody CoordinateDTO body, 
                                                                   @RequestParam(value = "maxDist", defaultValue = "10") Double maxDist) {
        return ResponseEntity.ok().body(pointOfInterestService.getClosePoints(body, maxDist));
    }
    
    @DeleteMapping
    public void removePointOfInterest(@RequestBody PointOfInterestDTO entity) {
        pointOfInterestService.removePointOfInterest(entity);
    }
}
