package com.prituladima.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by prituladima on 5/31/18.
 */
public class DPTest {

    DynamicProg dp = new DynamicProg();

    @Test
    public void test(){
        Assert.assertEquals(514229, dp.fib(30) );
    }

}
