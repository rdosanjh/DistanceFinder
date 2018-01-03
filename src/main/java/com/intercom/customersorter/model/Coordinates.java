package com.intercom.customersorter.model;

public class Coordinates {

    private final double latitude;
    private final double longitude;

    public Coordinates(double latitude, double longitude) throws IllegalArgumentException {
        if(Math.abs(latitude) > 90 || Math.abs(longitude) > 180){
            throw new IllegalArgumentException("Latitude and Longitude must be between -90 and 90");
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLatitudeInRadians() {
        return Math.toRadians(latitude);
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLongitudeInRadians() {
        return Math.toRadians(longitude);
    }

}
