package edu.rseymour.advancedjava.stocktrader;

// APPL, IBM, GOOG, AMZ

import java.math.BigDecimal;
import java.sql.Timestamp;

public class StockServiceFactory {

    public StockService getStockService(String service) {
        if (service == null) {
            return null;
        }
        if (service.equalsIgnoreCase("Apple"))
            return new Apple(new BigDecimal(100.00), StockSymbolType.APPL, new Timestamp(System.currentTimeMillis()));
        else if (service.equalsIgnoreCase("IBM"))
            return new IBM(new BigDecimal(70.00), StockSymbolType.IBM, new Timestamp(System.currentTimeMillis()));
        else if (service.equalsIgnoreCase("Google"))
            return new Google(new BigDecimal(150.00), StockSymbolType.GOOG, new Timestamp(System.currentTimeMillis()));
        else if (service.equalsIgnoreCase("Amazon"))
            return new Amazon(new BigDecimal(120.00), StockSymbolType.AMZ, new Timestamp(System.currentTimeMillis()));
        else
            return null;

    }
}
