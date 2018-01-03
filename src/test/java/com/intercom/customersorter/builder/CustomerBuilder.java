package com.intercom.customersorter.builder;

import com.intercom.customersorter.model.Customer;

public class CustomerBuilder {

    private int id;
    private String name;
    private Double longitude;
    private Double latitude;

    public CustomerBuilder setId(int id){
        this.id = id;
        return this;
    }

    public CustomerBuilder setName(String name){
        this.name = name;
        return this;
    }

    public CustomerBuilder setLongitude(Double longitude){
        this.longitude = longitude;
        return this;
    }

    public CustomerBuilder setLatitude(Double latitude){
        this.latitude = latitude;
        return this;
    }

    public Customer build(){
        return new Customer(name,id,latitude,longitude);
    }
}
