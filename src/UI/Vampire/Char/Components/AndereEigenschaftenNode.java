package UI.Vampire.Char.Components;

import UI.Vampire.Components.CircleRow.PrefilledCircle;
import UI.Vampire.Components.InputtextCircle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class AndereEigenschaftenNode {

    private final VBox root = new VBox();
    private final InputtextCircle ITC = new InputtextCircle("andere Eigenschaften");
    private final int CIRCLE_AMOUNT = 8;
    private final static PrefilledCircle prefilledCircleZero = PrefilledCircle.ZERO;

    public AndereEigenschaftenNode(){
        root.getChildren().add(ITC.getInputtextCircle());
        root.setAlignment(Pos.TOP_LEFT);
        ITC.addRow("TestTestTestTest",CIRCLE_AMOUNT, prefilledCircleZero);
        ITC.addRow("Test",CIRCLE_AMOUNT, prefilledCircleZero);
        ITC.addRow("Test",CIRCLE_AMOUNT, prefilledCircleZero);
        ITC.addRow("Test",CIRCLE_AMOUNT, prefilledCircleZero);
        ITC.addNewStyle("vampireTextField");
    }

    public void addRow(){ //TODO

    }

    public Node getAndereEigenschaften(){
        return root;
    }

    public void setAndereEigenschaften(String[] andereEigenschaftenBezeichnung, int[] andereEigenschaftenWert) { //TODO
    }
}
