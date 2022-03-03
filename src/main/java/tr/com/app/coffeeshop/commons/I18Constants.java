package tr.com.app.coffeeshop.commons;

import lombok.Getter;

/**
 * The enum 18 constants.
 *
 * @Author Mustafa Çalık
 */
@Getter
public enum I18Constants {
    /**
     * Coffee not found 18 constants.
     */
    COFFEE_NOT_FOUND("coffee.absent"),
    /**
     * Coffee order 18 constants.
     */
    COFFEE_ORDER("coffee.order"),
    /**
     * Coffee order begin 18 constants.
     */
    COFFEE_ORDER_BEGIN("coffee.order.begin"),
    /**
     * Coffee order end 18 constants.
     */
    COFFEE_ORDER_END("coffee.order.end"),
    /**
     * Coffee order quantity 18 constants.
     */
    COFFEE_ORDER_QUANTITY("coffee.order.quantity"),

    /**
     * Coffee menu header id 18 constants.
     */
    COFFEE_MENU_HEADER_ID("coffee.menu.headers.id"),
    /**
     * Coffee menu header name 18 constants.
     */
    COFFEE_MENU_HEADER_NAME("coffee.menu.headers.name"),
    /**
     * Coffee menu header price 18 constants.
     */
    COFFEE_MENU_HEADER_PRICE("coffee.menu.headers.price"),


    /**
     * Coffee order error not found 18 constants.
     */
    COFFEE_ORDER_ERROR_NOT_FOUND("coffee.order.error"),
    /**
     * Coffee order error system 18 constants.
     */
    COFFEE_ORDER_ERROR_SYSTEM("coffee.order.systemerror");


    /**
     * The Key.
     */
    String key;
    I18Constants(String key) {
        this.key = key;
    }
}
