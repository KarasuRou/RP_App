package UI.Vampire.Char.Components;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ClansschwaecheNode {
    private final VBox root = new VBox();

    public ClansschwaecheNode(){
        root.setAlignment(Pos.CENTER);
        Label label = new Label("Clansschwäche");
        label.getStyleClass().add("H2");
        TextField textField = new TextField();
        root.getStyleClass().addAll("vampireTextField","clanschwaeche");
        root.getChildren().addAll(label,textField);
    }

    public Node getClansschwaecheNode(){
        return root;
    }
}
