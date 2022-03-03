package tr.com.app.coffeeshop.shell;

import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * The type Spring shell config.
 *
 * @Author Mustafa Çalık
 */
@Configuration
public class SpringShellConfig {

    /**
     * Shell helper shell helper.
     *
     * @param terminal   the terminal
     * @param lineReader the line reader
     * @return the shell helper
     */
    @Bean
    public ShellHelper shellHelper(@Lazy Terminal terminal, @Lazy LineReader lineReader) {
        return new ShellHelper(terminal, lineReader);
    }
}
