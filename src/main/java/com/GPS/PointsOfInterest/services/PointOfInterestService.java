package com.GPS.PointsOfInterest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GPS.PointsOfInterest.dto.PointOfInterestDTO;
import com.GPS.PointsOfInterest.entity.PointOfInterest;
import com.GPS.PointsOfInterest.repositories.PointOfInterestRepository;

@Service
public class PointOfInterestService {
    @Autowired
    private PointOfInterestRepository pointOfInterestRepository;

    @Transactional(readOnly = true)
    public List<PointOfInterestDTO> getAll() {
        List<PointOfInterest> result = pointOfInterestRepository.findAll();
        return result.stream().map(x -> new PointOfInterestDTO(x)).toList();
    }
}
