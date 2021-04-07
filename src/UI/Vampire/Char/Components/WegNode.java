package UI.Vampire.Char.Components;

import UI.Vampire.Components.CircleRow;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WegNode { //TODO

    private final VBox root = new VBox();
    private final HBox aura = new HBox();
    private final CircleRow cR = new CircleRow(10,"WegWert");

    public WegNode(){
        root.setAlignment(Pos.CENTER);
        Label label = new Label("Weg");
        label.getStyleClass().add("H2");
        TextField wegBezeichnung = new TextField();
        wegBezeichnung.setMinWidth(root.getWidth());

        root.getChildren().addAll(label,wegBezeichnung,cR.getCircleRow(),aura);
    }

    public Node getWegNode(){
        return root;
    }
}
