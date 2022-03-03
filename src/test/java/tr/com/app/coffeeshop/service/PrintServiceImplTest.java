package tr.com.app.coffeeshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tr.com.app.coffeeshop.commons.I18Constants;
import tr.com.app.coffeeshop.model.Coffee;
import tr.com.app.coffeeshop.model.CoffeeMenu;
import tr.com.app.coffeeshop.model.Ingredient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

/**
 * The type Print service impl test.
 */
@ExtendWith(SpringExtension.class)
class PrintServiceImplTest {


    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private PrintServiceImpl printService;

    /**
     * Create pretty coffee menu when called create pretty coffee menu.
     */
    @Test
    void createPrettyCoffeeMenu_WhenCalled_CreatePrettyCoffeeMenu(){
        List<Coffee> coffeeList = new ArrayList<>();
        Coffee coffee = new Coffee();
        coffee.setId("1");
        coffeeList.add(coffee);
        LinkedHashMap<String, Object> headers = new LinkedHashMap<>();
        headers.put("id", "id");
        CoffeeMenu coffeeMenu = new CoffeeMenu(coffeeList, headers);

        String menu = printService.createPrettyCoffeeMenu(coffeeMenu);

        assertNotEquals("", menu);
    }


    /**
     * Create pretty order messageu when called create pretty order message.
     */
    @Test
    void createPrettyOrderMessageu_WhenCalled_createPrettyOrderMessage(){
        Coffee coffee = new Coffee();
        coffee.setId("1");
        coffee.setIngredients(new ArrayList<>());

        String menu = printService.createPrettyOrderMessage(coffee);

        assertNotEquals("", menu);
    }

}
