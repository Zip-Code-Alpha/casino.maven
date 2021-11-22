package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 7/21/2020.
 */
public class ApplicationRunnerTest {
    //protected Deck deck;
    //make separate classes for each test
    //@Before
    //public void beforeTest() { // Introduce logic to populate items needed for each test
        //deck = new Deck();
    //}
    @Test
    public void test() { // TODO - replace boiler-plate logic with business logic
        // given
        Runnable runnable = new Casino();

        // when
        runnable.run();

        // then
        Assert.assertNotNull(runnable.toString());
    }
    //create test class foreach class
    //if it's hard to think of a single test for a class maybe break apart the method
}
