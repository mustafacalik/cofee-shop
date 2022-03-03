package tr.com.app.coffeeshop.exception;

/**
 * The type Coffee db exception.
 */
public class CoffeeDbException extends RuntimeException {
    /**
     * Instantiates a new Coffee db exception.
     *
     * @param message   the message
     * @param exception the exception
     */
    public CoffeeDbException(String message, Exception exception){
        super(message, exception);
    }
}
