package UI.Vampire.Char.Components;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class Menue {
    private MenuBar menuBar;

    public Menue(){
        menuBar = new MenuBar();
        Menu menu1 = new Menu("Datei");
        Menu menu2 = new Menu("Extra-Informationen");
        Menu menu3 = new Menu("Charaktere");
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
}
