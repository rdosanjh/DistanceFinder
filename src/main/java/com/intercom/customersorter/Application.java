package com.intercom.customersorter;


import com.intercom.customersorter.model.Coordinates;
import com.intercom.customersorter.model.Customer;
import com.intercom.customersorter.service.CustomerParser;
import com.intercom.customersorter.service.DistanceFinderService;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Application {

    private static final Coordinates baseCoordinates = new Coordinates(53.339428, -6.257664);


    public static void main(String[] args){
        Path filePath = Paths.get(Application.class.getClassLoader()
                .getResource("customers.txt").getPath());

        CustomerParser parser = new CustomerParser();
        ArrayList<Customer> customers = parser.Parse(filePath);

        DistanceFinderService distanceFinder = new DistanceFinderService();
        Collections.sort(customers, Comparator.comparing(Customer::getUserId));

        for(Customer customer : customers){
            Double distanceFromOffice =
                    distanceFinder.getDistanceFromCoordinates(baseCoordinates, customer.getCoordinates());
            if(distanceFromOffice <= 100){
                System.out.printf("UserId : %s , Name : %s \n", customer.getUserId(), customer.getName());
            }
        }

    }
}
