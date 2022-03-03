package tr.com.app.coffeeshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tr.com.app.coffeeshop.model.Coffee;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The type Order service impl test.
 */
@ExtendWith(SpringExtension.class)
class OrderServiceImplTest {

    @Mock
    private CoffeeService coffeeService;

    @Mock
    private MessageSource messageSource;

    @Mock
    private PrintService printService;

    @InjectMocks
    private OrderServiceImpl orderService;

    /**
     * Order coffee when coffee found return order message.
     */
    @Test
    void orderCoffee_WhenCoffeeFound_ReturnOrderMessage(){
        String coffeeId = "1";
        Coffee coffee = new Coffee();
        coffee.setId(coffeeId);
        when(coffeeService.getCoffee(coffeeId)).thenReturn(coffee);

        orderService.orderCoffee(coffeeId);

        verify(printService).createPrettyOrderMessage(coffee);
    }

}
