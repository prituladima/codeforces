package com.prituladima.geeksforgeeks.util;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by prituladima on 6/13/18.
 */
public class Asserts {


    public static void assertMatrixEquals(int[][] expected, int[][] actual) {
        assertEquals(expected.length, actual.length);

        for (int i = 0; i < actual.length; i++) {
            assertArrayEqualsWithNull(expected[i], actual[i]);
        }
    }

    public static void assertMatrixEquals(long[][] expected, long[][] actual) {
        assertEquals(expected.length, actual.length);

        for (int i = 0; i < actual.length; i++) {
            assertArrayEqualsWithNull(expected[i], actual[i]);
        }
    }

    public static void assertArrayEqualsWithNull(int[] a, int[] b) {
        if (a == null) {
            assertTrue(b == null);
        } else
            assertArrayEquals(a, b);
    }

    public static void assertArrayEqualsWithNull(long[] a, long[] b) {
        if (a == null) {
            assertTrue(b == null);
        } else
            assertArrayEquals(a, b);
    }

}
