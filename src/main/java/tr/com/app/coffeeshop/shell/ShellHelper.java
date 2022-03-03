package tr.com.app.coffeeshop.shell;

import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.springframework.beans.factory.annotation.Value;

/**
 * The type Shell helper.
 *
 * @Author Mustafa Çalık
 */
public class ShellHelper {

    /**
     * The Info color.
     */
    @Value("${shell.out.info}")
    public String infoColor;

    /**
     * The Success color.
     */
    @Value("${shell.out.success}")
    public String successColor;

    /**
     * The Warning color.
     */
    @Value("${shell.out.warning}")
    public String warningColor;

    /**
     * The Error color.
     */
    @Value("${shell.out.error}")
    public String errorColor;

    private Terminal terminal;
    private LineReader lineReader;

    /**
     * Instantiates a new Shell helper.
     *
     * @param terminal   the terminal
     * @param lineReader the line reader
     */
    public ShellHelper(Terminal terminal, LineReader lineReader) {
        this.terminal = terminal;
        this.lineReader = lineReader;
    }

    /**
     * Gets colored.
     *
     * @param message the message
     * @param color   the color
     * @return the colored
     */
    public String getColored(String message, PromptColor color) {
        return (new AttributedStringBuilder()).append(message, AttributedStyle.DEFAULT.foreground(color.toJlineAttributedStyle())).toAnsi();
    }

    /**
     * Print.
     *
     * @param message the message
     */
    public void print(String message) {
        print(message, null);
    }

    /**
     * Print message to the console in the error color.
     *
     * @param message message to print
     */
    public void printError(String message) {
        print(message, PromptColor.valueOf(errorColor));
    }

    /**
     * Generic Print to the console method.
     *
     * @param message message to print
     * @param color   (optional) prompt color
     */
    public void print(String message, PromptColor color) {
        String toPrint = message;
        if (color != null) {
            toPrint = getColored(message, color);
        }
        terminal.writer().println(toPrint);
        terminal.flush();
    }

    /**
     * Prompt string.
     *
     * @param prompt the prompt
     * @return the string
     */
    public String prompt(String  prompt) {
        return lineReader.readLine(prompt + ": ");
    }
}