package tr.com.app.coffeeshop.service;

import tr.com.app.coffeeshop.model.Coffee;
import tr.com.app.coffeeshop.model.CoffeeMenu;

/**
 * The interface Coffee service.
 *
 * @Author Mustafa Çalık
 */
public interface CoffeeService {
    /**
     * Gets coffee.
     *
     * @param id the id
     * @return the coffee
     */
    Coffee getCoffee(String id);

    /**
     * Gets coffee menu.
     *
     * @return the coffee menu
     */
    String getCoffeeMenu();

    /**
     * Create coffee menu coffee menu.
     *
     * @return the coffee menu
     */
    CoffeeMenu createCoffeeMenu();
}
