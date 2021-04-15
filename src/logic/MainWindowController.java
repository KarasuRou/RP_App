package logic;

import UI.Vampire.Char.Form;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainWindowController {

    public EventHandler<MouseEvent> vampChar(Stage stage){
        return event -> new Form(stage);
    }
}
