package UI.Vampire.Char.Components;

import javafx.beans.property.Property;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Arrays;

public class ClansschwaecheNode {
    private final VBox root = new VBox();
    private Property clansschwaecheTextProperty;

    public ClansschwaecheNode(){
        root.setAlignment(Pos.CENTER);
        Label label = new Label("Clansschwäche");
        label.getStyleClass().add("H2");
        TextField textField = new TextField();
        root.getStyleClass().addAll("vampireTextField","clanschwaeche");
        root.getChildren().addAll(label,textField);
        clansschwaecheTextProperty = textField.textProperty();
    }

    public Node getClansschwaecheNode(){
        return root;
    }

    public void setClansschwaeche(String[] clansschweache) {
        if (clansschweache.length == 1)
            clansschwaecheTextProperty.setValue(clansschweache);
    }
}
