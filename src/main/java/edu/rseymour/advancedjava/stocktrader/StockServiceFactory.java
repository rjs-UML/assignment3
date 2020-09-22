package edu.rseymour.advancedjava.stocktrader;

// APPL, IBM, GOOG, AMZ

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StockServiceFactory implements StockService {

    /**
     * Returns a stock quote with a timestamp of when the quote was requested.
     * @param symbol the stock symbol of the company that you want
     *               a quote for e.g. APPL for APPLE
     * @param timeOfTransaction
     * @return a stock quote with a timestamp.
     */
    @Override
    public StockTransaction getQuote(String symbol, Timestamp timeOfTransaction) {

        if (symbol.equalsIgnoreCase(String.valueOf(StockSymbolType.APPL)))
            return new StockTransaction(new BigDecimal(100.00), StockSymbolType.APPL, timeOfTransaction);
        else if (symbol.equalsIgnoreCase(String.valueOf(StockSymbolType.IBM)))
            return new StockTransaction(new BigDecimal(70.00), StockSymbolType.IBM, timeOfTransaction);
        else if (symbol.equalsIgnoreCase(String.valueOf(StockSymbolType.GOOG)))
            return new StockTransaction(new BigDecimal(150.00), StockSymbolType.GOOG, timeOfTransaction);
        else if (symbol.equalsIgnoreCase(String.valueOf(StockSymbolType.AMZ)))
            return new StockTransaction(new BigDecimal(120.00), StockSymbolType.AMZ, timeOfTransaction);
        else
            return null;
    }

    /**
     * Returns a list of stock quotes where each stock quote has a timestamp that is
     * between two Calendar dates.
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @return a List of stock quotes.
     */
    @Override
    public List<StockTransaction> getQuote(String symbol, Calendar from, Calendar until) {
        // convert from to timestamp
        Date fromDate = from.getTime();
        Timestamp fromTs = new Timestamp(fromDate.getTime());

        // convert until to timestamp
        Date untilDate = until.getTime();
        Timestamp untilTs = new Timestamp(untilDate.getTime());

        // create a List to load dummy stocks
        List<StockTransaction> quoteList = new ArrayList<>();

        // create list to return stocks that meet query
        List<StockTransaction> returnList = new ArrayList<>();

        /**
         * create 1 date per quarter 2019
         */

        // reused calendar instance
        Calendar calendar = Calendar.getInstance();

        // q1
        calendar.set(2019, 0, 15);
        Date date = calendar.getTime();
        Timestamp q1 = new Timestamp(date.getTime());

        // q2
        calendar.set(2019, 3, 22);
        date = calendar.getTime();
        Timestamp q2 = new Timestamp(date.getTime());

        // q3
        calendar.set(2019, 6, 31);
        date = calendar.getTime();
        Timestamp q3 = new Timestamp(date.getTime());

        // q4
        calendar.set(2019, 11, 25);
        date = calendar.getTime();
        Timestamp q4 = new Timestamp(date.getTime());

        // create 1 Amazon stock for each quarter of 2019
        StockTransaction amz_q1_19 = new StockTransaction(new BigDecimal(100.00), StockSymbolType.AMZ, q1);
        StockTransaction amz_q2_19 = new StockTransaction(new BigDecimal(100.00), StockSymbolType.AMZ, q2);
        StockTransaction amz_q3_19 = new StockTransaction(new BigDecimal(100.00), StockSymbolType.AMZ, q3);
        StockTransaction amz_q4_19 = new StockTransaction(new BigDecimal(100.00), StockSymbolType.AMZ, q4);

        // add stocks to list
        quoteList.add(amz_q1_19);
        quoteList.add(amz_q2_19);
        quoteList.add(amz_q3_19);
        quoteList.add(amz_q4_19);

        // iterate through list. If symbol == getStockSymbolType and within date range, add it to returnList
        for (StockTransaction stock : quoteList) {
            Timestamp time = stock.getTime();
            if (symbol.equalsIgnoreCase(stock.getStockSymbol().name()) &&
                    (time.compareTo(fromTs) == 0 || (time.after(fromTs) && time.before(untilTs)))
            )
            {
                returnList.add(stock);
            }
        }

        //
        return returnList;
    }
}
