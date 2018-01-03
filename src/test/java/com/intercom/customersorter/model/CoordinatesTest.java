package com.intercom.customersorter.service.model;

import com.intercom.customersorter.model.Coordinates;
import org.assertj.core.data.Percentage;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CoordinatesTest {
    @Test
    public void givenLatLongOutOfRangeShouldThrow(){
        assertThatThrownBy(() -> new Coordinates(100,100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void shouldReturnLatitudeInRadians(){
        Coordinates latlong = new Coordinates(45,50);
        assertThat(latlong.getLatitudeInRadians()).isCloseTo(0.785398, Percentage.withPercentage(1));
        assertThat(latlong.getLongitudeInRadians()).isCloseTo(0.872665, Percentage.withPercentage(1));
    }
}
