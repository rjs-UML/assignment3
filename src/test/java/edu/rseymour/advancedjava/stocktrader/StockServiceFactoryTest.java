package edu.rseymour.advancedjava.stocktrader;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * JUnit test for the StockServiceFactory class.
 */

public class StockServiceFactoryTest {

    Calendar fromTest = Calendar.getInstance();
    Calendar untilTest = Calendar.getInstance();

    Calendar fromTestFail = Calendar.getInstance();
    Calendar untilTestFail = Calendar.getInstance();

    Timestamp time;
    BigDecimal price;

    StockServiceFactory factory;
    StockTransaction amazon;

    List<StockTransaction> testList;

    /**
     * Creates a timestamp to pass as parameter to ensure the timestamps match
     * when necessary.
     *
     * Creates new StockServiceFactory to test both getQuote()
     * implementations. Values match those hardcoded into the
     * StockServiceFactory.java implementation.
     *
     * Creates from and until Calendar instances to pass as params
     * to the getQuote implementation that returns a List.
     */
    @Before
    public void setup() {

        time = new Timestamp(System.currentTimeMillis());
        price = new BigDecimal(120.00);

        factory = new StockServiceFactory();
        amazon = factory.getQuote("AMZ", time);

        fromTest.set(2019, 0, 16);
        untilTest.set(2019, 11, 26);

        fromTestFail.set(2018, 0, 16);
        untilTestFail.set(2018, 11, 26);
    }

    /**
     * Tests if a StockTransaction instance was created correctly in
     * setup()
     */
    @Test
    public void getQuoteTest() {
        Assert.assertEquals(price, amazon.getPrice());
        Assert.assertEquals("AMZ", amazon.getStockSymbol().name());
        Assert.assertEquals(time, amazon.getTime());
    }

    /**
     * Tests if a StockTransaction instance that is not equal to or
     * between the from and until parameters is not included in the
     * returnList.
     *
     * The returnList should contain 3 StockTrader instances.
     *
     * NOTE: I am having a hard time testing for EXACT matches because
     * I cannot figure out how to configure the milliseconds part of
     * the timestamp. I did not worry too much about it because I figure
     * that reproducing stock timestamps that match to the millisecond
     * are incredibly rare or do not exist.
     */
    @Test
    public void getQuoteIncludedTest() {
        testList = factory.getQuote("AMZ", fromTest, untilTest);
        int testListSize = testList.size();
        Assert.assertEquals(3, testListSize);
    }

    /**
     * Tests if StockTranscation List is returns empty if no instances
     * match the from and until dates.
     */
    @Test
    public void getQuoteNotIncludedTest() {
        testList = factory.getQuote("AMZ", fromTestFail, untilTestFail);
        int testListSize = testList.size();
        Assert.assertEquals(0, testListSize);
    }
}
