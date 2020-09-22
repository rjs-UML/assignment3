package edu.rseymour.advancedjava.generics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the GenericContainer class.
 */

public class GenericContainerTest {

    GenericContainer<String> text;
    GenericContainer<Integer> number;
    GenericContainer<Boolean> bool;

    /**
     * Creates the a String, Integer, and Boolean type instance
     * of the GenericContainer class.
     */
    @Before
    public void setup() {
        text = new GenericContainer<>();
        number = new GenericContainer<>();
        bool = new GenericContainer<>();
    }

    @Test
    public void setAndGetTest() {
        String textTest = "Passing test!";
        Integer numberTest = 6;
        Boolean boolTest = false;

        text.set("Passing test!");
        number.set(6);
        bool.set(false);

        Assert.assertEquals(textTest, text.get());
        Assert.assertEquals(numberTest, number.get());
        Assert.assertEquals(boolTest, false);
    }
}
