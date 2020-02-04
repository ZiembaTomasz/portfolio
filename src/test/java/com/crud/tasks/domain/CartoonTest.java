package com.crud.tasks.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CartoonTest {

    @Test
    public void tescik(){
        //Given
        Cartoon cartoon = new Cartoon();
        List<UserRating> userRatings = new ArrayList<>();
        userRatings.add(new UserRating(2L, 10, null, 2L));
        userRatings.add(new UserRating(2L, 0, null, 2L));
        cartoon.setUserRatings(userRatings);
        //When
        double srednia = cartoon.ratingAverage();
        //Then
        assertEquals(5.0, srednia, 0.1);

    }

}