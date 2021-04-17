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
    private final Property[] disziplinCircleRowProperty = new Property[5];
    private final Property[] disziplinProperty = new Property[5];
    private static final InputtextCircle IC2 = new InputtextCircle("Hintergrund");
    private final Property[] hintergrundCircleRowProperty = new Property[5];
    private final Property[] hintergrundProperty = new Property[5];
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
        Property[] properties;

        properties= IC1.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        System.out.println(properties.length);
        disziplinCircleRowProperty[0] = properties[0];
        disziplinProperty[0] = properties[1];
        properties = IC1.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        disziplinCircleRowProperty[1] = properties[0];
        disziplinProperty[1] = properties[1];
        properties = IC1.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        disziplinCircleRowProperty[2] = properties[0];
        disziplinProperty[2] = properties[1];
        properties = IC1.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        disziplinCircleRowProperty[3] = properties[0];
        disziplinProperty[3] = properties[1];
        properties = IC1.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        disziplinCircleRowProperty[4] = properties[0];
        disziplinProperty[4] = properties[1];
        IC1.addNewStyle("vampireTextField");

        properties = IC2.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        hintergrundCircleRowProperty[0] = properties[0];
        hintergrundProperty[0] = properties[1];
        properties = IC2.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        hintergrundCircleRowProperty[1] = properties[0];
        hintergrundProperty[1] = properties[1];
        properties = IC2.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        hintergrundCircleRowProperty[2] = properties[0];
        hintergrundProperty[2] = properties[1];
        properties = IC2.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        hintergrundCircleRowProperty[3] = properties[0];
        hintergrundProperty[3] = properties[1];
        properties = IC2.addRow("",CIRCLE_AMOUNT,prefilledCircleZERO);
        hintergrundCircleRowProperty[4] = properties[0];
        hintergrundProperty[4] = properties[1];
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
            disziplinCircleRowProperty[i].setValue(vorteileDisziplinenWert[i]);
            disziplinProperty[i].setValue(vorteileDisziplinenBezeichnung[i]);
        }
    }

    public void setHintergrund(String[] vorteileHintergrundBezeichnung, int[] vorteileHintergrundWert) {
        for (int i = 0; i < vorteileHintergrundBezeichnung.length; i++) {
            hintergrundCircleRowProperty[i].setValue(vorteileHintergrundWert[i]);
            hintergrundProperty[i].setValue(vorteileHintergrundBezeichnung[i]);
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
}
