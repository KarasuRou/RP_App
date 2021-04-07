package UI.Vampire.Char.Components;

import UI.Vampire.Components.InputtextCircle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class AndereEigenschaftenNode {

    private final VBox root = new VBox();
    private final InputtextCircle ITC = new InputtextCircle("andere Eigenschaften");
    private final int CIRCLE_AMOUNT = 8;

    public AndereEigenschaftenNode(){
        root.getChildren().add(ITC.getInputtextCircle());
        root.setAlignment(Pos.TOP_LEFT);
        ITC.addRow("TestTestTestTest",CIRCLE_AMOUNT,false);
        ITC.addRow("Test",CIRCLE_AMOUNT,false);
        ITC.addRow("Test",CIRCLE_AMOUNT,false);
        ITC.addRow("Test",CIRCLE_AMOUNT,false);
        ITC.addNewStyle("vampireTextField");
    }

    public void addRow(){ //TODO

    }

    public Node getAndereEigenschaften(){
        return root;
    }
}
