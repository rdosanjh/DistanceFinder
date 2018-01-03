package com.intercom.customersorter.service;

import com.intercom.customersorter.builder.CustomerBuilder;
import com.intercom.customersorter.model.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerParserTest {
    private CustomerParser customerParser;

    @Before
    public void setUp() {
        customerParser = new CustomerParser();
    }

    @Test
    public void givenValidLineOfJsonParseLineShouldReturnValidCustomer(){
        Customer customer = customerParser.ParseIndervidualCustomerJson(
                "{\"latitude\": \"53.1229599\"," +
                        " \"user_id\": 6, " +
                        "\"name\": \"Theresa Enright\", " +
                        "\"longitude\": \"-6.2705202\"}"
        );
        Customer correct = new CustomerBuilder()
                .setId(6)
                .setName("Theresa Enright")
                .setLatitude(53.1229599)
                .setLongitude(-6.2705202)
                .build();

        assertThat(customer).isEqualToComparingFieldByField(correct);
    }

}
