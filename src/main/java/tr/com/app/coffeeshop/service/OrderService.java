package tr.com.app.coffeeshop.service;

/**
 * The interface Order service.
 *
 * @Author Mustafa Çalık
 */
public interface OrderService {
    /**
     * Order coffee string.
     *
     * @param coffeeId the coffee id
     * @return the string
     */
    String orderCoffee(String coffeeId);
}
