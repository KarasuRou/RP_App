package UI.Vampire.Char.Components;

import UI.Vampire.Components.CircleRow.PrefilledCircle;
import UI.Vampire.Components.InputtextCircle;
import javafx.beans.property.Property;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class AndereEigenschaftenNode {

    private final VBox root = new VBox();
    private final InputtextCircle ITC = new InputtextCircle("andere Eigenschaften");
    private final Property[][] andereEigenschaftenProperty = new Property[4][2];
    private final int CIRCLE_AMOUNT = 8;
    private final static PrefilledCircle prefilledCircleZero = PrefilledCircle.ZERO;

    public AndereEigenschaftenNode(){
        root.getChildren().add(ITC.getInputtextCircle());
        root.setAlignment(Pos.TOP_LEFT);
        andereEigenschaftenProperty[0] = ITC.addRow("TestTestTestTest",CIRCLE_AMOUNT, prefilledCircleZero);
        andereEigenschaftenProperty[1] = ITC.addRow("Test",CIRCLE_AMOUNT, prefilledCircleZero);
        andereEigenschaftenProperty[2] = ITC.addRow("Test",CIRCLE_AMOUNT, prefilledCircleZero);
        andereEigenschaftenProperty[3] = ITC.addRow("Test",CIRCLE_AMOUNT, prefilledCircleZero);
        ITC.addNewStyle("vampireTextField");
    }

    public void addRow(){ //TODO

    }

    public Node getAndereEigenschaften(){
        return root;
    }

    public void setAndereEigenschaften(String[] andereEigenschaftenBezeichnung, int[] andereEigenschaftenWert) {
        for (int i=0;i<andereEigenschaftenWert.length;i++){
            andereEigenschaftenProperty[i][0].setValue(andereEigenschaftenWert[i]);
            andereEigenschaftenProperty[i][0].setValue(andereEigenschaftenBezeichnung[i]);
        }
    }
}
