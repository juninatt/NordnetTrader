package se.pbt.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.pbt.exception.StockLoaderException;
import se.pbt.model.Stock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StockListLoaderTest {

    @Test
    @DisplayName("Should load 3 stocks from JSON file and verify their properties")
    public void testLoadStocksFromFile() {
        // Arrange
        StockListLoader stockListLoader = new StockListLoader();

        // Act
        List<Stock> stockList = stockListLoader.loadStocks("src/test/resources/mock_stock_list.json");

        // Assert
        assertEquals(3, stockList.size(), "Expected to load 3 stocks from the file");

        Stock appleStock = stockList.get(0);
        assertAll("Apple Stock",
                () -> assertEquals("Apple Inc.", appleStock.getName(), "Stock name should be 'Apple Inc.'"),
                () -> assertEquals("AAPL", appleStock.getInstrumentId(), "Stock instrumentId should be 'AAPL'"),
                () -> assertEquals(1, appleStock.getRiskLevel(), "Risk level should be 1")
        );

        Stock teslaStock = stockList.get(1);
        assertAll("Tesla Stock",
                () -> assertEquals("Tesla Inc.", teslaStock.getName(), "Stock name should be 'Tesla Inc.'"),
                () -> assertEquals("TSLA", teslaStock.getInstrumentId(), "Stock instrumentId should be 'TSLA'"),
                () -> assertEquals(2, teslaStock.getRiskLevel(), "Risk level should be 2")
        );

        Stock nvidiaStock = stockList.get(2);
        assertAll("NVIDIA Stock",
                () -> assertEquals("NVIDIA Corporation", nvidiaStock.getName(), "Stock name should be 'NVIDIA Corporation'"),
                () -> assertEquals("NVDA", nvidiaStock.getInstrumentId(), "Stock instrumentId should be 'NVDA'"),
                () -> assertEquals(3, nvidiaStock.getRiskLevel(), "Risk level should be 3")
        );
    }

    @Test
    @DisplayName("Should throw StockLoaderException when trying to load non-existing file")
    public void testInvalidFile() {
        // Arrange
        StockListLoader stockListLoader = new StockListLoader();

        // Act & Assert
        assertThrows(StockLoaderException.class, () ->
                stockListLoader.loadStocks("src/test/resources/non_existing_file.json"),
                "Expected to throw StockLoaderException when file is not found");
    }
}

