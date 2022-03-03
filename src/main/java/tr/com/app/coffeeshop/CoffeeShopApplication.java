package tr.com.app.coffeeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


/**
 * The type Coffee shop application.
 */
@SpringBootApplication
@EnableCaching
public class CoffeeShopApplication {

	/**
	 * Main.
	 *
	 * @param args the args
	 */
	public static void main(String[] args){
		SpringApplication.run(CoffeeShopApplication.class, args);
	}

	/**
	 * Message source message source.
	 *
	 * @return the message source
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setUseCodeAsDefaultMessage(false);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

}
