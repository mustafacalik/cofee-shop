package tr.com.app.coffeeshop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tr.com.app.coffeeshop.exception.CoffeeDbException;
import tr.com.app.coffeeshop.model.Coffee;
import tr.com.app.coffeeshop.utils.FileUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The type Coffee repository.
 *
 * @Author Mustafa Çalık
 */
@Service
@Slf4j
public class CoffeeRepository {

    private static final String COFFEE_DATA_PATH = "data\\coffee.json";

    /**
     * Find all map.
     *
     * @return the map
     */
    public Map<String, Coffee> findAll() {
        Map<String, Coffee> coffeeMap = new HashMap<>();
        try {
            FileUtils.jsonToObject(COFFEE_DATA_PATH).forEach(coffee ->
                    coffeeMap.put(coffee.getId(), coffee)
            );
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new CoffeeDbException("Coffee Repo Error", e);
        }
        return coffeeMap;
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Coffee> findById(String id) {
        return Optional.ofNullable(findAll().get(id));
    }
}
