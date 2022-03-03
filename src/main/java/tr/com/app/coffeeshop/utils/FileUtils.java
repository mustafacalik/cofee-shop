package tr.com.app.coffeeshop.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import tr.com.app.coffeeshop.model.Coffee;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/**
 * The type File utils.
 *
 * @Author Mustafa Çalık
 */
public class FileUtils {


    private FileUtils() {
    }

    /**
     * Json to object list.
     *
     * @param fileName the file name
     * @return the list
     * @throws IOException the io exception
     */
    public static List<Coffee> jsonToObject(String fileName) throws IOException {
        return new ObjectMapper().readValue(getResourceFile(fileName), new TypeReference<>() {});
    }

    private static File getResourceFile(final String fileName)
    {

        ClassLoader classLoader = FileUtils.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);

        try {
            return new File(resource.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
