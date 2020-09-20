package edu.rseymour.advancedjava.stocktrader;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * This class holds information about a single stock transaction.
 */
public class StockTransaction {

    private BigDecimal price;
    private StockSymbolType stockSymbol;
    private Timestamp time;

    public StockTransaction(BigDecimal price, StockSymbolType stockSymbol, Timestamp time) {
        this.price = price;
        this.stockSymbol = stockSymbol;
        this.time = time;
    }

    /**
     * Get the Stock Symbol
     * @return a StockSymbol value
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Get the Stock Symbol
     * @return a StockSymbolType value
     */
    public StockSymbolType getStockSymbol() {
        return stockSymbol;
    }

    /**
     * Get the time of the transaction
     * @return a Timestamp value
     */
    public Timestamp getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "StockQuote{" +
                "price=" + price +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", time=" + time +
                '}';
    }
}
