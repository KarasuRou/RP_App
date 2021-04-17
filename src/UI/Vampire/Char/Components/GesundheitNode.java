package UI.Vampire.Char.Components;

import UI.Vampire.Components.RectangleColumn;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GesundheitNode {

    private final VBox root = new VBox();
    private final static RectangleColumn rC = new RectangleColumn(7,"Gesundheit",false);

    public GesundheitNode(){
        Label label = new Label("Gesundheit");
        label.getStyleClass().add("H2");
        root.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(getBezeichnung(),getBezeichnungMinus(),rC.getRectangleBox());
        hBox.getStyleClass().add("gesundheit");
        root.getChildren().addAll(label,hBox);
    }

    private Node getBezeichnung(){
        VBox vBox = new VBox();
        Label[] label = new Label[7];
        for (int i = 0; i < label.length; i++) {
            String s="";
            switch (i) {
                case 0:
                    s = "Blaue Flecken:";
                    break;
                case 1:
                    s = "Verletzt:";
                    break;
                case 2:
                    s = "Schwer verletzt:";
                    break;
                case 3:
                    s = "Verwundet:";
                    break;
                case 4:
                    s = "Schwer Verwundet:";
                    break;
                case 5:
                    s = "Verkrüppelt:";
                    break;
                case 6:
                    s = "Außer Gefecht:";
                    break;
                default:
                    s = "ERROR";
                    break;
            }
            label[i] = new Label(s);
        }
        vBox.getChildren().addAll(label);
        return vBox;
    }

    private Node getBezeichnungMinus(){
        VBox vBox = new VBox();
        Label[] label = new Label[7];
        for (int i = 0; i < label.length; i++) {
            String s="";
            switch (i) {
                case 0:
                case 6:
                    s = "";
                    break;
                case 1:
                case 2:
                    s = "-1";
                    break;
                case 3:
                case 4:
                    s = "-2";
                    break;
                case 5:
                    s = "-5";
                    break;
                default:
                    s = "ERROR";
                    break;
            }
            label[i] = new Label(s);
        }
        vBox.getChildren().addAll(label);
        vBox.setStyle("-fx-padding: 0 15 0 15;");
        return vBox;
    }

    public Node getGesundheitNode(){
        return root;
    }

    public void setGesundheit(int gesundheit, int gesundheit2) {
        rC.getValue().setValue(gesundheit);
    }
}
