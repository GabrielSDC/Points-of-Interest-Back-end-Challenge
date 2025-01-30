package com.GPS.PointsOfInterest.dto;

import com.GPS.PointsOfInterest.entity.PointOfInterest;

public record PointOfInterestDTO(String name, Integer x, Integer y) {
    public PointOfInterestDTO(PointOfInterest entity) {
        this(entity.getName(), entity.getX(), entity.getY());
    }
}
