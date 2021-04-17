package UI.Vampire.Char.Components;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class Menue {
    private MenuBar menuBar;
    private Menu menu1 = new Menu();
    private Menu menu2 = new Menu();
    private Menu menu3 = new Menu();

    public Menue() {
        menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1, menu2, menu3);
    }

    public Node getMenueBar() {
        return menuBar;
    }

    public void setMenuOne(MenuItem[] menuItems, String text) {menu1.getItems().addAll(menuItems);menu1.setText(text);}
    public void setMenuTwo(MenuItem[] menuItems, String text) {menu2.getItems().addAll(menuItems);menu2.setText(text);}
    public void setMenuThree(MenuItem[] menuItems, String text) {menu3.getItems().addAll(menuItems);menu3.setText(text);}

    public void resetMenu() {
        menuBar.getMenus().removeAll();
        menu1.getItems().removeAll();
        menu2.getItems().removeAll();
        menu3.getItems().removeAll();
    }
}
