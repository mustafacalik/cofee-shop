package tr.com.app.coffeeshop.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * The type Coffee.
 *
 * @Author Mustafa Çalık
 */
@Getter
@Setter
public class Coffee {
    private String id;
    private String name;
    private BigDecimal price;
    private List<Ingredient> ingredients;
}
