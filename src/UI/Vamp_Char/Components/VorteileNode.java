package UI.Vamp_Char.Components;

import UI.Components.InputtextCircle;
import UI.Components.TextCircle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VorteileNode {

    private final VBox root = new VBox();
    private final InputtextCircle IC1 = new InputtextCircle("Disziplinen");
    private final InputtextCircle IC2 = new InputtextCircle("Hintergrund");
    private final TextCircle TC1 = new TextCircle("Tugenden");
    private final int CIRCLE_AMOUNT = 8;
    private final int CIRCLE_AMOUNT_TUGENDEN = 5;

    public VorteileNode(){
        Label label = new Label("Fähigkeiten");
        label.getStyleClass().add("H1");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(IC1.getInputtextCircle(), IC2.getInputtextCircle(), TC1.getTextCircle());
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label, hBox);

        IC1.addRow("",CIRCLE_AMOUNT);
        IC1.addRow("",CIRCLE_AMOUNT);
        IC1.addRow("",CIRCLE_AMOUNT);
        IC1.addRow("",CIRCLE_AMOUNT);
        IC1.addRow("",CIRCLE_AMOUNT);
        IC1.addNewStyle("vorteileInputText");

        IC2.addRow("",CIRCLE_AMOUNT);
        IC2.addRow("",CIRCLE_AMOUNT);
        IC2.addRow("",CIRCLE_AMOUNT);
        IC2.addRow("",CIRCLE_AMOUNT);
        IC2.addRow("",CIRCLE_AMOUNT);
        IC2.addNewStyle("vorteileInputText");
        IC2.addNewStyle("middleRow");

        TC1.addRow("Gewissen/Überzeugung",CIRCLE_AMOUNT_TUGENDEN);
        TC1.addRow("Selbstbeherrschung/Instinkt",CIRCLE_AMOUNT_TUGENDEN);
        TC1.addRow("Mut",CIRCLE_AMOUNT_TUGENDEN);
    }

    public Node getVorteileNode(){
        return root;
    }
}
