package UI.Vampire.Char.Components;

import UI.Vampire.Components.CircleRow.CircleRow;
import UI.Vampire.Components.CircleRow.PrefilledCircle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WegNode {

    private final VBox root = new VBox();
    private static final CircleRow cR = new CircleRow(10,"WegWert", PrefilledCircle.ZERO);
    private final TextField wegBezeichnung = new TextField();
    private final TextField auraBezeichnung = new TextField();

    public WegNode(){
        VBox vBox = new VBox();
        Label label = new Label("Weg");
        label.getStyleClass().add("H2");
        wegBezeichnung.setMinWidth(root.getWidth());

        vBox.setAlignment(Pos.CENTER);
        vBox.getStyleClass().add("vampireTextField");
        vBox.getChildren().addAll(label, wegBezeichnung);
        HBox aura = getAura();
        root.getChildren().addAll(vBox,cR.getCircleRow(), aura);
    }
    private HBox getAura(){
        HBox hBox = new HBox();
        HBox AuraBezeichnung = new HBox();
        HBox AuraWert = new HBox();
        hBox.maxWidthProperty().bind(root.widthProperty());
        Label label = new Label("Aura:");
        AuraBezeichnung.getChildren().addAll(label, auraBezeichnung);
        AuraBezeichnung.getStyleClass().addAll("auraBezeichnung","normalText","vampireTextField");
        AuraWert.getStyleClass().addAll("transparentTextField","normalText");

        Label label1 = new Label("(");
        label.getStyleClass().add("normalText");
        TextField textField1 = new TextField();
        textField1.textProperty().bind(cR.getValue().asString());
        textField1.getStyleClass().addAll("transparentTextField","auraWertTextField","transparentTextField");
        textField1.setEditable(false);

        Label label2 = new Label(")");
        AuraWert.getChildren().addAll(label1, textField1, label2);

        hBox.getChildren().addAll(AuraBezeichnung, AuraWert);
        return hBox;
    }

    public Node getWegNode(){
        return root;
    }

    public void setWeg(String weg, int wegWert) {
        wegBezeichnung.setText(weg);
        cR.getValue().setValue(wegWert);
    }
    public void setAura(String aura) {
        auraBezeichnung.setText(aura);
    }

    public boolean getAuraAnzeigenProperty() {
        return true; // TODO: Aura Anzeigen Property ; Handler hinzuf??gen
    }

    public String getAuraProperty() {
        return auraBezeichnung.getText();
    }

    public int getWegWertProperty() {
        return cR.getValue().get();
    }

    public String getWegBezeichnungProperty() {
        return wegBezeichnung.getText();
    }
}
