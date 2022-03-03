package tr.com.app.coffeeshop.service;

import tr.com.app.coffeeshop.model.Coffee;
import tr.com.app.coffeeshop.model.CoffeeMenu;

/**
 * The interface Print service.
 */
public interface PrintService {
    /**
     * Create pretty coffee menu string.
     *
     * @param coffeeMenu the coffee menu
     * @return the string
     */
    String createPrettyCoffeeMenu(CoffeeMenu coffeeMenu);

    /**
     * Create pretty order message string.
     *
     * @param coffee the coffee
     * @return the string
     */
    String createPrettyOrderMessage(Coffee coffee);
}
