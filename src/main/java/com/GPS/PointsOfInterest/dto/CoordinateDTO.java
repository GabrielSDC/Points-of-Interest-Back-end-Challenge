package com.GPS.PointsOfInterest.dto;

public record CoordinateDTO(Integer x, Integer y) {
    public Double getDistanceFrom(PointOfInterestDTO point) {
        int deltaX = Math.abs(point.x() - x);
        int deltaY = Math.abs(point.y() - y);

        return (Double) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}
