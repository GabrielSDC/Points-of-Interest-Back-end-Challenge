package com.GPS.PointsOfInterest.dto;

import com.GPS.PointsOfInterest.entity.PointOfInterest;

public class PointOfInterestDTO {
    private String name;
    private Integer x;
    private Integer y;
    
    public PointOfInterestDTO() {
    }
    
    public PointOfInterestDTO(PointOfInterest entity) {
        name = entity.getName();
        x = entity.getX();
        y = entity.getY();
    }

    public String getName() {
        return name;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
