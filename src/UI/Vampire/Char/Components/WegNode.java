package UI.Vampire.Char.Components;

import UI.Vampire.Components.CircleRow;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WegNode { //TODO

    private final VBox root = new VBox();
    private final HBox aura = getAura();
    private static final CircleRow cR = new CircleRow(10,"WegWert",false);

    public WegNode(){
        VBox vBox = new VBox();
        Label label = new Label("Weg");
        label.getStyleClass().add("H2");
        TextField wegBezeichnung = new TextField();
        wegBezeichnung.setMinWidth(root.getWidth());

        vBox.setAlignment(Pos.CENTER);
        vBox.getStyleClass().add("vampireTextField");
        vBox.getChildren().addAll(label, wegBezeichnung);
        root.getChildren().addAll(vBox,cR.getCircleRow(),aura);
    }
    private HBox getAura(){
        HBox hBox = new HBox();
        HBox AuraBezeichnung = new HBox();
        HBox AuraWert = new HBox();
        hBox.maxWidthProperty().bind(root.widthProperty());
        Label label = new Label("Aura:");
        TextField textField = new TextField();
        AuraBezeichnung.getChildren().addAll(label, textField);
        AuraBezeichnung.getStyleClass().addAll("auraBezeichnung","normalText","vampireTextField");
        AuraWert.getStyleClass().addAll("transparentTextField","normalText");

        Label label1 = new Label("(");
        label.getStyleClass().add("normalText");
        TextField textField1 = new TextField();
        textField1.textProperty().bind(cR.getValue().asString());
        textField1.getStyleClass().addAll("transparentTextField","auraWertTextField","transparentTextField");

        Label label2 = new Label(")");
        AuraWert.getChildren().addAll(label1, textField1, label2);

        hBox.getChildren().addAll(AuraBezeichnung, AuraWert);
        return hBox;
    }

    public Node getWegNode(){
        return root;
    }
}