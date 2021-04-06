package UI.Vamp_Char.Components;

import UI.Components.TextCircle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AndereEigenschaftenNode {

    private final VBox root = new VBox();
    private final TextCircle TC1 = new TextCircle("andere Eigenschaften");
    private final int CIRCLE_AMOUNT = 8;

    public AndereEigenschaftenNode(){
        root.getChildren().add(TC1.getTextCircle());
        root.setAlignment(Pos.TOP_LEFT);
        TC1.addRow("TestTestTestTest",CIRCLE_AMOUNT);
        TC1.addRow("Test",CIRCLE_AMOUNT);
        TC1.addRow("Test",CIRCLE_AMOUNT);
        TC1.addRow("Test",CIRCLE_AMOUNT);
    }

    public void addRow(){ //TODO

    }

    public Node getAndereEigenschaften(){
        return root;
    }
}
