package edu.rseymour.advancedjava.stocktrader;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * This interfaces describes a simple stock purchase service.
 */

public interface StockService {
    /**
     * Return the current price for a share of stock for the
     * given symbol.
     * @param symbol the stock symbol of the company that you want
     *               a quote for e.g. APPL for APPLE
     * @return a <CODE>BigDecimal</CODE> instance
     */

    StockTransaction getQuote(String symbol, Timestamp timeOfTransaction);

    /**
     * Get a historical list of stock quotes for the provided symbol.
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @return a list of StockQuote instances. One for each day in the
     * range specified.
     */
    List<StockTransaction> getQuote(String symbol, Calendar from, Calendar until);
}
