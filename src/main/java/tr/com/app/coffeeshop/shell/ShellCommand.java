package tr.com.app.coffeeshop.shell;

import org.springframework.context.MessageSource;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.util.ObjectUtils;
import tr.com.app.coffeeshop.commons.I18Constants;
import tr.com.app.coffeeshop.exception.CoffeeOrderException;
import tr.com.app.coffeeshop.exception.NoSuchElementFoundException;
import tr.com.app.coffeeshop.service.BaseService;
import tr.com.app.coffeeshop.service.CoffeeService;
import tr.com.app.coffeeshop.service.OrderService;

/**
 * The type Shell command.
 *
 * @Author Mustafa Çalık
 */
@ShellComponent
public class ShellCommand extends BaseService {

    private static final String EXIT_COMMAND = "exit";
    private ShellHelper shellHelper;
    private OrderService orderService;
    private CoffeeService coffeeService;


    /**
     * Instantiates a new Shell command.
     *
     * @param messageSource the message source
     * @param shellHelper   the shell helper
     * @param orderService  the order service
     * @param coffeeService the coffee service
     */
    public ShellCommand(MessageSource messageSource, ShellHelper shellHelper, OrderService orderService, CoffeeService coffeeService) {
        super(messageSource);
        this.shellHelper = shellHelper;
        this.orderService = orderService;
        this.coffeeService = coffeeService;
    }

    /**
     * Menu.
     */
    @ShellMethod("Get Coffee Menu")
    public void menu() {
        String coffeeMenu = coffeeService.getCoffeeMenu();
        shellHelper.print(coffeeMenu);
    }

    /**
     * Order.
     *
     * @param coffeeID the coffee id
     */
    @ShellMethod("Order Coffee")
    public void order(@ShellOption(defaultValue = "") String coffeeID) {
        boolean coffeeOrderContinue = true;

        if(ObjectUtils.isEmpty(coffeeID)){
            shellHelper.print(getLocalMessage(I18Constants.COFFEE_ORDER.getKey()));
            coffeeID = shellHelper.prompt("Coffee");
        }

        while(coffeeOrderContinue){
            try {
                if(EXIT_COMMAND.equals(coffeeID)){
                    return;
                }

                coffeeService.getCoffee(coffeeID);

                shellHelper.print(getLocalMessage(I18Constants.COFFEE_ORDER_BEGIN.getKey()));

                sleep();

                shellHelper.print(orderService.orderCoffee(coffeeID));

                coffeeOrderContinue = false;
            } catch (NoSuchElementFoundException e) {
                shellHelper.printError(getLocalMessage(I18Constants.COFFEE_ORDER_ERROR_NOT_FOUND.getKey()));
                coffeeID = shellHelper.prompt("Coffee");
            } catch(Exception e){
                shellHelper.printError(getLocalMessage(I18Constants.COFFEE_ORDER_ERROR_SYSTEM.getKey()));
                coffeeOrderContinue = false;
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CoffeeOrderException(getLocalMessage(I18Constants.COFFEE_ORDER_ERROR_SYSTEM.getKey()));
        }
    }
}
