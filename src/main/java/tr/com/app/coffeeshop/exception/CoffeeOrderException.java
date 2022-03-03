package tr.com.app.coffeeshop.exception;

/**
 * The type Coffee order exception.
 *
 * @Author Mustafa Çalık
 */
public class CoffeeOrderException extends RuntimeException {
    /**
     * Instantiates a new Coffee order exception.
     *
     * @param message the message
     */
    public CoffeeOrderException(String message){
        super(message);
    }
}
