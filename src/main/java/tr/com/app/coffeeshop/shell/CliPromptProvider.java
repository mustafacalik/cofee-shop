package tr.com.app.coffeeshop.shell;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

/**
 * The type Cli prompt provider.
 *
 * @Author Mustafa Çalık
 */
@Component
public class CliPromptProvider implements PromptProvider {

    @Override
    public AttributedString getPrompt() {
        return new AttributedString("COFFEE-SHOP:>",
                AttributedStyle.DEFAULT.foreground(AttributedStyle.BLUE)
        );
    }
}