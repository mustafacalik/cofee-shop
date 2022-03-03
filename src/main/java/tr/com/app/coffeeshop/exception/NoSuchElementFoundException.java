package tr.com.app.coffeeshop.exception;

/**
 * The type No such element found exception.
 *
 * @Author Mustafa Çalık
 */
public class NoSuchElementFoundException extends RuntimeException {
    /**
     * Instantiates a new No such element found exception.
     *
     * @param message the message
     */
    public NoSuchElementFoundException(String message){
        super(message);
    }
}
