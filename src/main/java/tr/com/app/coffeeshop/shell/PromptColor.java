package tr.com.app.coffeeshop.shell;

/**
 * The enum Prompt color.
 *
 * @Author Mustafa Çalık
 */
public enum PromptColor {
    /**
     * Black prompt color.
     */
    BLACK(0),
    /**
     * Red prompt color.
     */
    RED(1),
    /**
     * Green prompt color.
     */
    GREEN(2),
    /**
     * Yellow prompt color.
     */
    YELLOW(3),
    /**
     * Blue prompt color.
     */
    BLUE(4),
    /**
     * Magenta prompt color.
     */
    MAGENTA(5),
    /**
     * Cyan prompt color.
     */
    CYAN(6),
    /**
     * White prompt color.
     */
    WHITE(7),
    /**
     * Bright prompt color.
     */
    BRIGHT(8);

    private final int value;

    PromptColor(int value) {
        this.value = value;
    }

    /**
     * To jline attributed style int.
     *
     * @return the int
     */
    public int toJlineAttributedStyle() {
        return this.value;
    }
}
