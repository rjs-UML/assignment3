package edu.rseymour.advancedjava.stocktrader;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

public class Apple extends StockTransaction implements StockService {

    private BigDecimal price;
    private StockSymbolType stockSymbol;
    private Timestamp time;

    public Apple(BigDecimal price, StockSymbolType stockSymbol, Timestamp time) {
        super(price, stockSymbol, time);
    }

    @Override
    public StockTransaction getQuote(String symbol, Timestamp timeOfTransaction) {
        return null;
    }

    @Override
    public List<StockTransaction> getQuote(String symbol, Calendar from, Calendar until) {
        return null;
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
