package com.intercom.customersorter.service;

import com.intercom.customersorter.model.Coordinates;

public class DistanceFinderService {

    private static final int RADIUS_OF_EARTH = 6371; // in kilometers

    public Double getDistanceFromCoordinates(Coordinates from, Coordinates to){
        double deltaLat = Math.toRadians(to.getLatitude() - from.getLatitude());
        double deltaLong = Math.toRadians(to.getLongitude() - from.getLongitude());

        double a = haversin(deltaLat) + Math.cos(from.getLatitudeInRadians())
                * Math.cos(to.getLatitudeInRadians()) * haversin(deltaLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RADIUS_OF_EARTH * c;
    }

    public double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}
