package com.GPS.PointsOfInterest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GPS.PointsOfInterest.dto.CoordinateDTO;
import com.GPS.PointsOfInterest.dto.PointOfInterestDTO;
import com.GPS.PointsOfInterest.entity.PointOfInterest;
import com.GPS.PointsOfInterest.projections.PointOfInterestProjection;
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
    
    @Transactional
    public void addPointOfInterest(PointOfInterestDTO body) {
        PointOfInterest entity = new PointOfInterest(body.name(), body.x(), body.y());
        pointOfInterestRepository.save(entity);
    }

    @Transactional
    public void removePointOfInterest(PointOfInterestDTO body) {
        PointOfInterestProjection projection = pointOfInterestRepository.getPointOfInterestByName(body.name());
        
        if(projection != null)
            pointOfInterestRepository.deleteById(projection.getId());
    }

    @Transactional
    public List<PointOfInterestDTO> getClosePoints(CoordinateDTO userPosition, Double maxDistance) {
        if(maxDistance < 1 || userPosition.x() < 0 || userPosition.y() < 0)
            return null; // raise exception
        
        List<PointOfInterestDTO> allPoints = getAll();
        List<PointOfInterestDTO> closePoints = new ArrayList<PointOfInterestDTO>();

        for(PointOfInterestDTO point : allPoints) {
            if(userPosition.getDistanceFrom(point) <= maxDistance)
                closePoints.add(point);
        }

        return closePoints;
    }
}
