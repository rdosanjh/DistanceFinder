package com.intercom.customersorter.service;

import com.google.gson.Gson;
import com.intercom.customersorter.model.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CustomerParser {
    public ArrayList<Customer> Parse(Path filePath){
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            Stream<String> lines = null;
            lines = Files.lines(filePath);
            lines.forEach(s -> customers.add(ParseIndervidualCustomerJson(s)));

        } catch (IOException e) {
            System.err.println("There was an error parsing the file does the path exist?");
            e.printStackTrace();
        }

        return customers;
    }

    public Customer ParseIndervidualCustomerJson(String line){
        Gson gson = new Gson();
        return gson.fromJson(line, Customer.class);
    }
}
