package tr.com.app.coffeeshop.service;

import org.springframework.context.MessageSource;
import org.springframework.shell.table.BeanListTableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;
import org.springframework.stereotype.Service;
import tr.com.app.coffeeshop.commons.I18Constants;
import tr.com.app.coffeeshop.model.Coffee;
import tr.com.app.coffeeshop.model.CoffeeMenu;
import tr.com.app.coffeeshop.model.Ingredient;
import zemberek.morphology.analysis.tr.TurkishNumbers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * The type Print service.
 */
@Service
public class PrintServiceImpl extends BaseService implements PrintService {

    private static final String SPACE = " ";
    private static final int TABLE_WIDTH = 80;

    /**
     * Instantiates a new Print service.
     *
     * @param messageSource the message source
     */
    public PrintServiceImpl(MessageSource messageSource) {
        super(messageSource);
    }

    @Override
    public String createPrettyCoffeeMenu(CoffeeMenu coffeeMenu) {
        TableModel model = new BeanListTableModel<>(coffeeMenu.getData(), (LinkedHashMap<String, Object>) coffeeMenu.getHeader());
        TableBuilder tableBuilder = new TableBuilder(model);
        tableBuilder.addInnerBorder(BorderStyle.fancy_light);
        tableBuilder.addHeaderBorder(BorderStyle.fancy_double);
        return tableBuilder.build().render(TABLE_WIDTH);
    }

    @Override
    public String createPrettyOrderMessage(Coffee coffee){
        List<Object> objectList = new ArrayList<>();
        objectList.add(coffee.getName());
        StringBuilder messageBuilder = new StringBuilder();
        Iterator<Ingredient> coffeeIterator = coffee.getIngredients().iterator();
        while(coffeeIterator.hasNext()){
            Ingredient ingredient = coffeeIterator.next();
            messageBuilder
                    .append(TurkishNumbers.convertNumberToString(ingredient.getQuantity().toString()))
                    .append(SPACE)
                    .append(getLocalMessage(I18Constants.COFFEE_ORDER_QUANTITY.getKey()))
                    .append(SPACE)
                    .append(ingredient.getName().toLowerCase(TURKISH));
            if(coffeeIterator.hasNext()){
                messageBuilder.append(", ");
            }
        }
        objectList.add(messageBuilder.toString());
        return getLocalMessage(I18Constants.COFFEE_ORDER_END.getKey(), objectList.toArray());
    }
}
