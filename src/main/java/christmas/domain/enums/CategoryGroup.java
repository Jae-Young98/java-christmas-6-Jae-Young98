package christmas.domain.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum CategoryGroup {
    APPETIZER("애피타이저", Arrays.asList(Menu.BUTTON_MUSHROOM_SOUP, Menu.TAPAS, Menu.CAESAR_SALAD)),
    MAIN("메인", Arrays.asList(Menu.T_BONE_STEAK, Menu.BARBECUE_RIBS, Menu.SEAFOOD_PASTA, Menu.CHRISTMAS_PASTA)),
    DESSERT("디저트", Arrays.asList(Menu.CHOCOLATE_CAKE, Menu.ICE_CREAM)),
    DRINK("음료", Arrays.asList(Menu.ZERO_COLA, Menu.RED_WINE, Menu.CHAMPAGNE)),
    NONE("없음", Collections.EMPTY_LIST);

    private final String category;
    private final List<Menu> menus;

    CategoryGroup(String category, List<Menu> menus) {
        this.category = category;
        this.menus = menus;
    }

    public String getCategory() {
        return category;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}