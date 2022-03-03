package tr.com.app.coffeeshop.model;

import lombok.Getter;

import java.util.List;
import java.util.Map;

/**
 * The type Coffee menu.
 */
@Getter
public class CoffeeMenu {
    private List<Coffee> data;
    private Map<String, Object> header;

    /**
     * Instantiates a new Coffee menu.
     *
     * @param data   the data
     * @param header the header
     */
    public CoffeeMenu(List<Coffee> data, Map<String, Object> header) {
        this.data = data;
        this.header = header;
    }

}
