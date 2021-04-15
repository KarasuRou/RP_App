package UI.Vampire.Char.Components;

import UI.Vampire.Components.CircleRow;
import UI.Vampire.Components.TextCircle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AttributeNode {

    private final VBox root = new VBox();
    private final TextCircle TC1 = new TextCircle("Körperlich");
    private final CircleRow[] koerperlichCircleRow = new CircleRow[3];
    private final TextCircle TC2 = new TextCircle("Gesellschaftlich");
    private final CircleRow[] gesellschaftlichCircleRow = new CircleRow[3];
    private final TextCircle TC3 = new TextCircle("Geistig");
    private final CircleRow[] geistigCircleRow = new CircleRow[3];
    private final int CIRCLE_AMOUNT = 8;

    public AttributeNode(){
        Label label = new Label("Attribute");
        label.getStyleClass().add("H1");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(TC1.getTextCircle(), TC2.getTextCircle(), TC3.getTextCircle());
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label, hBox);
        koerperlichCircleRow[0] = TC1.addRow("Körperkraft", CIRCLE_AMOUNT,true);
        koerperlichCircleRow[1] = TC1.addRow("Geschick", CIRCLE_AMOUNT,true);
        koerperlichCircleRow[2] = TC1.addRow("Widerstandsfähigkeit", CIRCLE_AMOUNT,true);
        gesellschaftlichCircleRow[0] = TC2.addRow("Charisma", CIRCLE_AMOUNT,true);
        gesellschaftlichCircleRow[1] = TC2.addRow("Manipulation", CIRCLE_AMOUNT,true);
        gesellschaftlichCircleRow[2] = TC2.addRow("Erscheinungsbild", CIRCLE_AMOUNT,true);
        TC2.addNewStyle("middleRow");
        geistigCircleRow[0] = TC3.addRow("Wahrnehmung", CIRCLE_AMOUNT,true);
        geistigCircleRow[1] = TC3.addRow("Intelligenz", CIRCLE_AMOUNT,true);
        geistigCircleRow[2] = TC3.addRow("Geistesschärfe", CIRCLE_AMOUNT,true);
    }

    public Node getFaehigkeitenNode(){
        return root;
    }

    public void setGesellschaftlich(int[] attributeGesellschaftlich) {
        for(int i = 0; i<attributeGesellschaftlich.length;i++) {
            gesellschaftlichCircleRow[i].getValue().setValue(attributeGesellschaftlich[i]);
            System.out.println(attributeGesellschaftlich[i]);
        }
    }

    public void setGeistig(int[] attributeGeistig) {
        for(int i = 0; i<attributeGeistig.length;i++) {
            geistigCircleRow[i].getValue().setValue(attributeGeistig[i]);
            System.out.println(attributeGeistig[i]);
        }

    }

    public void setKoerperlich(int[] attributeKoerperlich) {
        for(int i = 0; i<attributeKoerperlich.length;i++) {
            koerperlichCircleRow[i].getValue().setValue(attributeKoerperlich[i]);
            System.out.println(attributeKoerperlich[i]);
        }
    }
}
