package UI.Vampire.Char.Components;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class ButtonField {

    private final HBox root = new HBox();
    private final Button createChar = new Button("Neuen Charakter erstellen");
    private final Button updateChar = new Button("Speichern");

    public ButtonField(){
        root.setAlignment(Pos.BOTTOM_RIGHT);
        root.getChildren().addAll(createChar, updateChar);
    }

    public Node getButtonField(){
        return root;
    }

    public void setCreateCharEvent(EventHandler<MouseEvent> event){
        createChar.setOnMouseClicked(event);
    }

    public void setUpdateCharEvent(EventHandler<MouseEvent> event){
        updateChar.setOnMouseClicked(event);
    }


    // disable create Char button when id is given
}
