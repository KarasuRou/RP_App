package UI.Vampire.Char.Components;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class Menue {
    private MenuBar menuBar;
    private Menu menu1 = new Menu();
    private Menu menu2 = new Menu();
    private Menu menu3 = new Menu();

    public Menue() {
        menuBar = new MenuBar();
        menu1.setText("Datei");
        menu2.setText("Extra-Infos");
        menu3.setText("Charaktere");
        menuBar.getMenus().addAll(menu1, menu2, menu3);
        MenuItem menuItem1_1 = new MenuItem("Testen");
        MenuItem menuItem1_2 = new MenuItem("Testen");
        MenuItem menuItem1_3 = new MenuItem("Testen");
        menu1.getItems().addAll(menuItem1_1, menuItem1_2, menuItem1_3);
        MenuItem menuItem2_1 = new MenuItem("Testen");
        MenuItem menuItem2_2 = new MenuItem("Testen");
        MenuItem menuItem2_3 = new MenuItem("Testen");
        menu2.getItems().addAll(menuItem2_1, menuItem2_2, menuItem2_3);
    }

    public Node getMenueBar() {
        return menuBar;
    }

    public void setCharMenu(MenuItem[] menuItems) {
        menu3.getItems().addAll(menuItems);
    }
}
