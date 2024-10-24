package se.pbt.exception;

/**
 * Exception thrown when an error occurs during loading of local stock list.
 * Extends {@link RuntimeException} to allow unchecked exceptions.
 */
public class StockLoaderException extends RuntimeException {

    /**
     * Constructs a new StockLoaderException with a message and cause.
     */
    public StockLoaderException(String message, Throwable cause) {
        super(message, cause);
    }
}

