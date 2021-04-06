package UI.Vampire.Char.Components;

import UI.Vampire.Components.TextCircle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AttributeNode {

    private final VBox root = new VBox();
    private final TextCircle TC1 = new TextCircle("Körperlich");
    private final TextCircle TC2 = new TextCircle("Gesellschaftlich");
    private final TextCircle TC3 = new TextCircle("Geistig");
    private final int CIRCLE_AMOUNT = 8;

    public AttributeNode(){
        Label label = new Label("Attribute");
        label.getStyleClass().add("H1");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(TC1.getTextCircle(), TC2.getTextCircle(), TC3.getTextCircle());
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label, hBox);
        TC1.addRow("Körperkraft", CIRCLE_AMOUNT);
        TC1.addRow("Geschick", CIRCLE_AMOUNT);
        TC1.addRow("Widerstandsfähigkeit", CIRCLE_AMOUNT);
        TC2.addRow("Charisma", CIRCLE_AMOUNT);
        TC2.addRow("Manipulation", CIRCLE_AMOUNT);
        TC2.addRow("Erscheinungsbild", CIRCLE_AMOUNT);
        TC2.addNewStyle("middleRow");
        TC3.addRow("Wahrnehmung", CIRCLE_AMOUNT);
        TC3.addRow("Intelligenz", CIRCLE_AMOUNT);
        TC3.addRow("Geistesschärfe", CIRCLE_AMOUNT);
    }

    public Node getFaehigkeitenNode(){
        return root;
    }
}
