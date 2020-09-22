package edu.rseymour.advancedjava.generics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the GenericHash class
 */
public class GenericHashTest {

    GenericHash<Integer, String> oneHash;
    GenericHash<String, Boolean> twoHash;

    /**
     * Instantiate GenericHash instances with different
     * type values.
     */
    @Before
    public void setup() {
        oneHash = new GenericHash<>();
        twoHash = new GenericHash<>();
    }

    /**
     * Tests that the correct key is returned for each
     * GenericHash class instance.
     */
    @Test
    public void getKeyTest() {

        oneHash.getHashMap().put(1, "Ryan Seymour");
        twoHash.getHashMap().put("Monday", true);

        Assert.assertTrue(oneHash.getHashMap().containsKey(1));
        Assert.assertTrue(twoHash.getHashMap().containsKey("Monday"));
    }

    /**
     * Tests that the correct value is returned for each
     * GenericHash class instance.
     */
    @Test
    public void getValueTest() {
        oneHash.getHashMap().put(1, "Ryan Seymour");
        oneHash.getHashMap().put(2, "John Seymour");
        twoHash.getHashMap().put("Monday", true);

        Assert.assertTrue(oneHash.getHashMap().containsValue("John Seymour"));
        Assert.assertTrue(twoHash.getHashMap().containsValue(true));
    }

}
