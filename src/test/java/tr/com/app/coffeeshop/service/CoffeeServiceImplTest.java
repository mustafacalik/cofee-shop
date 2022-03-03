package tr.com.app.coffeeshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tr.com.app.coffeeshop.exception.NoSuchElementFoundException;
import tr.com.app.coffeeshop.model.Coffee;
import tr.com.app.coffeeshop.model.CoffeeMenu;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * The type Coffee service impl test.
 */
@ExtendWith(SpringExtension.class)
class CoffeeServiceImplTest {

    @Mock
    private CoffeeRepository coffeeRepository;

    @Mock
    private MessageSource messageSource;

    /**
     * The Print service.
     */
    @Mock PrintService printService;

    @InjectMocks
    private CoffeeServiceImpl coffeeService;

    /**
     * Get coffee when coffee found return coffee.
     */
    @Test
    void getCoffee_WhenCoffeeFound_ReturnCoffee(){
        Coffee coffee = new Coffee();
        coffee.setId("1");
        when(coffeeRepository.findById(coffee.getId())).thenReturn(Optional.of(coffee));

        Coffee coffeeTest = coffeeService.getCoffee("1");

        assertEquals("1", coffeeTest.getId());
    }

    /**
     * Get coffee when coffee not found throw no such element found exception.
     */
    @Test
    void getCoffee_WhenCoffeeNotFound_ThrowNoSuchElementFoundException(){
        Coffee coffee = new Coffee();
        coffee.setId("1");
        when(coffeeRepository.findById(coffee.getId())).thenReturn(Optional.of(coffee));

        Exception exception = assertThrows(NoSuchElementFoundException.class, () -> {
            coffeeService.getCoffee("2");
        });

        assertEquals(NoSuchElementFoundException.class, exception.getClass());
    }

    /**
     * Create coffee menu when called return coffee menu.
     */
    @Test
    void createCoffeeMenu_WhenCalled_ReturnCoffeeMenu(){
        List<Coffee> coffeeList = new ArrayList<>();
        Coffee coffee = new Coffee();
        coffee.setId("1");
        coffee.setName("1");
        coffee.setPrice(BigDecimal.ONE);
        coffeeList.add(coffee);

        Map<String, Coffee> coffeeMap = new HashMap<>();
        coffeeMap.put("1", coffee);
        when(coffeeRepository.findAll()).thenReturn(coffeeMap);

        CoffeeMenu coffeeMenu = coffeeService.createCoffeeMenu();

        assertEquals(3, coffeeMenu.getHeader().size());
        assertEquals(coffeeList, coffeeMenu.getData());
    }


    /**
     * Get coffee menu when called return pretty coffee menu.
     */
    @Test
    void getCoffeeMenu_WhenCalled_ReturnPrettyCoffeeMenu(){
        coffeeService.getCoffeeMenu();

        verify(printService, times(1)).createPrettyCoffeeMenu(any());
    }

}
