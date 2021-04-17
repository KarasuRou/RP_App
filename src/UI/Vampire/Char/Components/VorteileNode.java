package UI.Vampire.Char.Components;

import UI.Vampire.Components.CircleRow.CircleRow;
import UI.Vampire.Components.CircleRow.PrefilledCircle;
import UI.Vampire.Components.InputtextCircle;
import UI.Vampire.Components.TextCircle;
import javafx.beans.property.Property;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VorteileNode {

    private final VBox root = new VBox();
    private static final InputtextCircle IC1 = new InputtextCircle("Disziplinen");
    private final Property[][] disziplinProperty = new Property[5][2];
    private static final InputtextCircle IC2 = new InputtextCircle("Hintergrund");
    private final Property[][] hintergrundProperty = new Property[5][2];
    private static final TextCircle TC1 = new TextCircle("Tugenden");
    private final CircleRow[] tugendenCircleRow = new CircleRow[3];
    private final int CIRCLE_AMOUNT = 8;
    private final int CIRCLE_AMOUNT_TUGENDEN = 5;
    private final static PrefilledCircle prefilledCircleONE = PrefilledCircle.ONE;
    private final static PrefilledCircle prefilledCircleZERO = PrefilledCircle.ZERO;

    public VorteileNode(){
        Label label = new Label("Vorteile");
        label.getStyleClass().add("H1");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(IC1.getInputtextCircle(), IC2.getInputtextCircle(), TC1.getTextCircle());
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label, hBox);

        disziplinProperty[0] = IC1.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        disziplinProperty[1] = IC1.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        disziplinProperty[2] = IC1.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        disziplinProperty[3] = IC1.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        disziplinProperty[4] = IC1.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        IC1.addNewStyle("vampireTextField");

        hintergrundProperty[0] = IC2.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        hintergrundProperty[1] = IC2.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        hintergrundProperty[2] = IC2.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        hintergrundProperty[3] = IC2.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        hintergrundProperty[4] = IC2.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        IC2.addNewStyle("vampireTextField");
        IC2.addNewStyle("middleRow");

        tugendenCircleRow[0] = TC1.addRow("Gewissen/Überzeugung",CIRCLE_AMOUNT_TUGENDEN,prefilledCircleONE);
        tugendenCircleRow[1] = TC1.addRow("Selbstbeherrschung/Instinkt",CIRCLE_AMOUNT_TUGENDEN,prefilledCircleONE);
        tugendenCircleRow[2] = TC1.addRow("Mut",CIRCLE_AMOUNT_TUGENDEN,prefilledCircleONE);
    }

    public Node getVorteileNode(){
        return root;
    }

    public void setDisziplinen(String[] vorteileDisziplinenBezeichnung, int[] vorteileDisziplinenWert) {
        for (int i = 0; i < vorteileDisziplinenBezeichnung.length; i++) {
            disziplinProperty[i][0].setValue(vorteileDisziplinenWert[i]);
            disziplinProperty[i][1].setValue(vorteileDisziplinenBezeichnung[i]);
        }
    }

    public void setHintergrund(String[] vorteileHintergrundBezeichnung, int[] vorteileHintergrundWert) {
        for (int i = 0; i < vorteileHintergrundBezeichnung.length; i++) {
            hintergrundProperty[i][0].setValue(vorteileHintergrundWert[i]);
            hintergrundProperty[i][1].setValue(vorteileHintergrundBezeichnung[i]);
        }
    }

    public void setTugenden(boolean[] vorteileTugendenEntscheidung, int[] vorteileTugenden) {
        for (int i = 0; i < vorteileTugenden.length; i++) {
            if (i == 2) {
                tugendenCircleRow[i].getValue().setValue(vorteileTugenden[i]);
            } else {
                tugendenCircleRow[i].getValue().setValue(vorteileTugenden[i]);
                // TODO Vorteile-Tugenden-Entscheidung
            }
        }
    }

    public String[] getDisziplinenBezeichnungProperty() {
        String[] disziplinenBezeichnung = new String[5];
        for (int i = 0; i < disziplinProperty.length; i++){
            disziplinenBezeichnung[i] = disziplinProperty[i][1].getValue().toString();
        }
        return disziplinenBezeichnung;
    }

    public int[] getDisziplinenWertProperty() {
        int[] disziplinenWert = new int[5];
        for (int i = 0; i < disziplinProperty.length; i++){
            disziplinenWert[i] = Integer.parseInt(disziplinProperty[i][0].getValue().toString());
        }
        return disziplinenWert;
    }

    public boolean[] getTugendenEntscheidungProperty() { //TODO Vorteile-Tugenden-Entscheidung
        return null;
    }

    public int[] getTugendenProperty() {
        int[] tugendenProperty = new int[3];
        for (int i = 0; i < tugendenCircleRow.length; i++) {
            tugendenProperty[i] = tugendenCircleRow[i].getValue().get();
        }
        return tugendenProperty;
    }

    public String[] getHintergrundBezeichnungProperty() {
        String[] hintergrundBezeichnung = new String[5];
        for (int i = 0; i < hintergrundProperty.length; i++){
            hintergrundBezeichnung[i] = hintergrundProperty[i][1].getValue().toString();
        }
        return hintergrundBezeichnung;
    }

    public int[] getHintergrundWertProperty() {
        int[] hintergrundWert = new int[3];
        for (int i = 0; i < hintergrundProperty.length; i++) {
            hintergrundWert[i] = Integer.parseInt(hintergrundProperty[i][0].getValue().toString());
        }
        return hintergrundWert;
    }
}
