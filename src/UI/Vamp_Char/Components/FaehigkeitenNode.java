package UI.Vamp_Char.Components;

import UI.Components.TextCircle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FaehigkeitenNode {

    private final VBox root = new VBox();
    private final TextCircle TC1 = new TextCircle("Talente");
    private final TextCircle TC2 = new TextCircle("Fertigkeiten");
    private final TextCircle TC3 = new TextCircle("Kenntnisse");
    private final int CIRCLE_AMOUNT = 8;

    public FaehigkeitenNode(){
        Label label = new Label("Fähigkeiten");
        label.getStyleClass().add("H1");
        HBox hBox = new HBox();
        setTC1();setTC2();setTC3();
        hBox.getChildren().addAll(TC1.getTextCircle(), TC2.getTextCircle(), TC3.getTextCircle());
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label, hBox);
    }

    private void setTC1(){
        TC1.addRow("Aufmerksamkeit",CIRCLE_AMOUNT);
        TC1.addRow("Ausdruck",CIRCLE_AMOUNT);
        TC1.addRow("Ausflüchte",CIRCLE_AMOUNT);
        TC1.addRow("Ausweichen",CIRCLE_AMOUNT);
        TC1.addRow("Diebstahl",CIRCLE_AMOUNT);
        TC1.addRow("Einschüchtern",CIRCLE_AMOUNT);
        TC1.addRow("Empathie",CIRCLE_AMOUNT);
        TC1.addRow("Führungsqualitäten",CIRCLE_AMOUNT);
        TC1.addRow("Handgemenge",CIRCLE_AMOUNT);
        TC1.addRow("Sportlichkeit",CIRCLE_AMOUNT);
    }
    private void setTC2(){
        TC2.addRow("Bogenschießen",CIRCLE_AMOUNT);
        TC2.addRow("Etikette",CIRCLE_AMOUNT);
        TC2.addRow("Handeln",CIRCLE_AMOUNT);
        TC2.addRow("Handwerk",CIRCLE_AMOUNT);
        TC2.addRow("Heimlichkeit",CIRCLE_AMOUNT);
        TC2.addRow("Nahkampf",CIRCLE_AMOUNT);
        TC2.addRow("Reiten",CIRCLE_AMOUNT);
        TC2.addRow("Tierkunde",CIRCLE_AMOUNT);
        TC2.addRow("Überleben",CIRCLE_AMOUNT);
        TC2.addRow("Vortrag",CIRCLE_AMOUNT);
        TC2.addNewStyle("middleRow");

    }
    private void setTC3(){
        TC3.addRow("Akademisches Wissen",CIRCLE_AMOUNT);
        TC3.addRow("Folklore",CIRCLE_AMOUNT);
        TC3.addRow("Gesetzeskenntnis",CIRCLE_AMOUNT);
        TC3.addRow("Linguistik",CIRCLE_AMOUNT);
        TC3.addRow("Medizin",CIRCLE_AMOUNT);
        TC3.addRow("Nachforschungen",CIRCLE_AMOUNT);
        TC3.addRow("Okkultismus",CIRCLE_AMOUNT);
        TC3.addRow("Politik",CIRCLE_AMOUNT);
        TC3.addRow("Seneschall",CIRCLE_AMOUNT);
        TC3.addRow("Theologie",CIRCLE_AMOUNT);

    }

    public Node getFaehigkeitenNode(){
        return root;
    }
}
