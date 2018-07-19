package com.prituladima.geeksforgeeks.math.gcd;

import com.prituladima.geeksforgeeks.geometric_algorithms.lines.AmountOfPointOnTheSameLine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.array;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.item;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.testSet;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class DistributivePropertyTest {

    int x, y, z;

    public DistributivePropertyTest(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Parameterized.Parameters(name = "{index}: DistributiveProperty GCD LCM")
    public static Iterable<Object[]> data() {
        return testSet(
                item(2, 4, 2),
                item(2, 4, 20),
                item(2, 514, 2451),
                item(2154, 4, 2)
        );
    }

    DistributiveProperty o = new DistributiveProperty();

    @Test
    public void naive() {
        assertEquals(o.value1(x, y, z), o.value2(x, y, z));
    }

}