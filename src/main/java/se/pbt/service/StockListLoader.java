package se.pbt.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.pbt.exception.StockLoaderException;
import se.pbt.model.Stock;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Class responsible for loading the list of stocks from a JSON file.
 */
public class StockListLoader {

    private static final Logger logger = LoggerFactory.getLogger(StockListLoader.class);
    private final ObjectMapper objectMapper;

    /**
     * Constructs a StockListLoader with a default ObjectMapper.
     */
    public StockListLoader() {
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Loads a list of stocks from the specified JSON file.
     */
    public List<Stock> loadStocks(String stockListPath) {
        if (stockListPath == null || stockListPath.trim().isEmpty()) {
            throw new IllegalArgumentException("Stock list file path cannot be null or empty");
        }
        try {
            return objectMapper.readValue(new File(stockListPath), new TypeReference<>() {
            });
        } catch (IOException e) {
            logger.error("Failed to load stock list from file: {}", stockListPath, e);
            throw new StockLoaderException("Error loading stock list from file: " + stockListPath, e);
        }
    }
}
