package com.intercom.customersorter.model;

import com.google.gson.annotations.SerializedName;

public class Customer {
    public Customer(){}

    @SerializedName("name")
    private String name;

    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("latitude")
    private Double latitude;

    @SerializedName("longitude")
    private Double longitude;


    public Customer(String name, Integer UserId, Double latitude, Double longitude){
        this.name = name;
        this.userId = UserId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        userId = userId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        longitude = longitude;
    }

    public Coordinates getCoordinates(){
        return new Coordinates(this.latitude,this.longitude);
    }

}
