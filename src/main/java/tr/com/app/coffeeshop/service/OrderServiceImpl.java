package tr.com.app.coffeeshop.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import tr.com.app.coffeeshop.model.Coffee;

/**
 * The type Order service.
 *
 * @Author Mustafa Çalık
 */
@Service
public class OrderServiceImpl extends BaseService implements OrderService{

    private CoffeeService coffeeService;
    private PrintService printService;


    /**
     * Instantiates a new Order service.
     *
     * @param messageSource the message source
     * @param coffeeService the coffee service
     * @param printService  the print service
     */
    public OrderServiceImpl(MessageSource messageSource, CoffeeService coffeeService, PrintService printService) {
        super(messageSource);
        this.coffeeService = coffeeService;
        this.printService = printService;
    }

    public String orderCoffee(String coffeeId){
        Coffee coffee = coffeeService.getCoffee(coffeeId);
        return printService.createPrettyOrderMessage(coffee);
    }

}
