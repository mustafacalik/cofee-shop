package tr.com.app.coffeeshop.service;

import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * The type Base service.
 *
 * @Author Mustafa Çalık
 */
public class BaseService {

    /**
     * The constant TURKISH.
     */
    protected static final Locale TURKISH = Locale.forLanguageTag("tr");

    private MessageSource messageSource;

    /**
     * Instantiates a new Base service.
     *
     * @param messageSource the message source
     */
    public BaseService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Get local message string.
     *
     * @param key the key
     * @return the string
     */
    protected String getLocalMessage(String key){
        return getLocalMessage(key, (Object) null);
    }

    /**
     * Get local message string.
     *
     * @param key    the key
     * @param params the params
     * @return the string
     */
    protected String getLocalMessage(String key, Object... params){
        return messageSource.getMessage(key,
                params,
                TURKISH);
    }
}
