package tr.com.app.coffeeshop.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import tr.com.app.coffeeshop.commons.CoffeeConstants;
import tr.com.app.coffeeshop.commons.I18Constants;
import tr.com.app.coffeeshop.exception.NoSuchElementFoundException;
import tr.com.app.coffeeshop.model.Coffee;
import tr.com.app.coffeeshop.model.CoffeeMenu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Coffee service.
 *
 * @Author Mustafa Çalık
 */
@Service
public class CoffeeServiceImpl extends BaseService implements CoffeeService{

    private CoffeeRepository coffeeRepository;
    private PrintService printService;


    /**
     * Instantiates a new Coffee service.
     *
     * @param messageSource    the message source
     * @param coffeeRepository the coffee repository
     * @param printService     the print service
     */
    public CoffeeServiceImpl(MessageSource messageSource, CoffeeRepository coffeeRepository, PrintService printService) {
        super(messageSource);
        this.coffeeRepository = coffeeRepository;
        this.printService = printService;
    }

    @Override
    public Coffee getCoffee(String coffeeId){
        return coffeeRepository.findById(coffeeId).orElseThrow(()->
                new NoSuchElementFoundException(getLocalMessage(I18Constants.COFFEE_NOT_FOUND.getKey(), coffeeId)));
    }

    @Override
    @Cacheable("coffee-menu")
    public String getCoffeeMenu(){
        return printService.createPrettyCoffeeMenu(createCoffeeMenu());
    }

    @Override
    public CoffeeMenu createCoffeeMenu(){
        List<Coffee> coffeeList = new ArrayList<>(coffeeRepository.findAll().values());
        Map<String, Object> headers = new LinkedHashMap<>();
        headers.put(CoffeeConstants.COFFEE_MENU_ID, getLocalMessage(I18Constants.COFFEE_MENU_HEADER_ID.getKey()));
        headers.put(CoffeeConstants.COFFEE_MENU_NAME, getLocalMessage(I18Constants.COFFEE_MENU_HEADER_NAME.getKey()));
        headers.put(CoffeeConstants.COFFEE_MENU_PRICE, getLocalMessage(I18Constants.COFFEE_MENU_HEADER_PRICE.getKey()));
        return new CoffeeMenu(coffeeList, headers);
    }

}
