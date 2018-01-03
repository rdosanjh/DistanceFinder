package com.intercom.customersorter.service;

import com.intercom.customersorter.model.Coordinates;
import org.assertj.core.data.Percentage;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DistanceFinderServiceTest {

    private DistanceFinderService distanceFinderService;

    @Before
    public void setUp() {
        distanceFinderService = new DistanceFinderService();
    }

    @Test
    public void givenLatLongShouldReturnCorrectDistance(){
        // https://www.google.co.uk/maps/place/51%C2%B030'48.7%22N+0%C2%B004'38.0%22W/@52.4086246,-5.4100651,7z/data=!4m19!1m12!4m11!1m5!1m1!2s53.339428,+-6.257664!2m2!1d-6.257664!2d53.339428!1m3!2m2!1d-0.077228!2d51.513518!3e4!3m5!1s0x0:0x0!7e2!8m2!3d51.5135179!4d-0.0772276
        Coordinates from = new Coordinates(53.339428, -6.257664);
        Coordinates to = new Coordinates(51.513518, -0.077228);

        assertThat(distanceFinderService.getDistanceFromCoordinates(from, to))
                .isCloseTo(465, Percentage.withPercentage(1));
    }
}
