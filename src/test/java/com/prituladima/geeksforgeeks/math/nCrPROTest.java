package com.prituladima.geeksforgeeks.math;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by prituladima on 6/9/18.
 */
public class nCrPROTest {

    final double delta = 0.000001;
    final nCrPRO nCrPRO = new nCrPRO();

    @Test
    public void probability_three_randomly_chosen_numbers_ap_test(){
        assertEquals(0.4, nCrPRO.probability_three_randomly_chosen_numbers_ap(2), delta);
        assertEquals(0.151515, nCrPRO.probability_three_randomly_chosen_numbers_ap(5), delta);
    }

}