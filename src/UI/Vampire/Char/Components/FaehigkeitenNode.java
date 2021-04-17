package UI.Vampire.Char.Components;

import UI.Vampire.Components.CircleRow.CircleRow;
import UI.Vampire.Components.CircleRow.PrefilledCircle;
import UI.Vampire.Components.TextCircle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FaehigkeitenNode {

    private final VBox root = new VBox();
    private final TextCircle TC1 = new TextCircle("Talente");
    private final CircleRow[] talenteCircleRow = new CircleRow[10];
    private final TextCircle TC2 = new TextCircle("Fertigkeiten");
    private final CircleRow[] fertigkeitenCircleRow = new CircleRow[10];
    private final TextCircle TC3 = new TextCircle("Kenntnisse");
    private final CircleRow[] kenntnisseCircleRow = new CircleRow[10];
    private final int CIRCLE_AMOUNT = 8;
    private final static PrefilledCircle prefilledCircleZERO = PrefilledCircle.ZERO;

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
        talenteCircleRow[0] = TC1.addRow("Aufmerksamkeit",CIRCLE_AMOUNT,prefilledCircleZERO);
        talenteCircleRow[1] = TC1.addRow("Ausdruck",CIRCLE_AMOUNT,prefilledCircleZERO);
        talenteCircleRow[2] = TC1.addRow("Ausflüchte",CIRCLE_AMOUNT,prefilledCircleZERO);
        talenteCircleRow[3] = TC1.addRow("Ausweichen",CIRCLE_AMOUNT,prefilledCircleZERO);
        talenteCircleRow[4] = TC1.addRow("Diebstahl",CIRCLE_AMOUNT,prefilledCircleZERO);
        talenteCircleRow[5] = TC1.addRow("Einschüchtern",CIRCLE_AMOUNT,prefilledCircleZERO);
        talenteCircleRow[6] = TC1.addRow("Empathie",CIRCLE_AMOUNT,prefilledCircleZERO);
        talenteCircleRow[7] = TC1.addRow("Führungsqualitäten",CIRCLE_AMOUNT,prefilledCircleZERO);
        talenteCircleRow[8] = TC1.addRow("Handgemenge",CIRCLE_AMOUNT,prefilledCircleZERO);
        talenteCircleRow[9] = TC1.addRow("Sportlichkeit",CIRCLE_AMOUNT,prefilledCircleZERO);
    }
    private void setTC2(){
        fertigkeitenCircleRow[0] = TC2.addRow("Bogenschießen",CIRCLE_AMOUNT,prefilledCircleZERO);
        fertigkeitenCircleRow[1] = TC2.addRow("Etikette",CIRCLE_AMOUNT,prefilledCircleZERO);
        fertigkeitenCircleRow[2] = TC2.addRow("Handeln",CIRCLE_AMOUNT,prefilledCircleZERO);
        fertigkeitenCircleRow[3] = TC2.addRow("Handwerk",CIRCLE_AMOUNT,prefilledCircleZERO);
        fertigkeitenCircleRow[4] = TC2.addRow("Heimlichkeit",CIRCLE_AMOUNT,prefilledCircleZERO);
        fertigkeitenCircleRow[5] = TC2.addRow("Nahkampf",CIRCLE_AMOUNT,prefilledCircleZERO);
        fertigkeitenCircleRow[6] = TC2.addRow("Reiten",CIRCLE_AMOUNT,prefilledCircleZERO);
        fertigkeitenCircleRow[7] = TC2.addRow("Tierkunde",CIRCLE_AMOUNT,prefilledCircleZERO);
        fertigkeitenCircleRow[8] = TC2.addRow("Überleben",CIRCLE_AMOUNT,prefilledCircleZERO);
        fertigkeitenCircleRow[9] = TC2.addRow("Vortrag",CIRCLE_AMOUNT,prefilledCircleZERO);
        TC2.addNewStyle("middleRow");

    }
    private void setTC3(){
        kenntnisseCircleRow[0] = TC3.addRow("Akademisches Wissen",CIRCLE_AMOUNT,prefilledCircleZERO);
        kenntnisseCircleRow[1] = TC3.addRow("Folklore",CIRCLE_AMOUNT,prefilledCircleZERO);
        kenntnisseCircleRow[2] = TC3.addRow("Gesetzeskenntnis",CIRCLE_AMOUNT,prefilledCircleZERO);
        kenntnisseCircleRow[3] = TC3.addRow("Linguistik",CIRCLE_AMOUNT,prefilledCircleZERO);
        kenntnisseCircleRow[4] = TC3.addRow("Medizin",CIRCLE_AMOUNT,prefilledCircleZERO);
        kenntnisseCircleRow[5] = TC3.addRow("Nachforschungen",CIRCLE_AMOUNT,prefilledCircleZERO);
        kenntnisseCircleRow[6] = TC3.addRow("Okkultismus",CIRCLE_AMOUNT,prefilledCircleZERO);
        kenntnisseCircleRow[7] = TC3.addRow("Politik",CIRCLE_AMOUNT,prefilledCircleZERO);
        kenntnisseCircleRow[8] = TC3.addRow("Seneschall",CIRCLE_AMOUNT,prefilledCircleZERO);
        kenntnisseCircleRow[9] = TC3.addRow("Theologie",CIRCLE_AMOUNT,prefilledCircleZERO);

    }

    public Node getFaehigkeitenNode(){
        return root;
    }

    public void setFertigkeiten(int[] faehigkeitenFertigkeiten) {
        for(int i = 0; i<faehigkeitenFertigkeiten.length;i++) {
            fertigkeitenCircleRow[i].getValue().setValue(faehigkeitenFertigkeiten[i]);
        }
    }

    public void setKenntnisse(int[] faehigkeitenKenntnisse) {
        for(int i = 0; i<faehigkeitenKenntnisse.length;i++) {
            kenntnisseCircleRow[i].getValue().setValue(faehigkeitenKenntnisse[i]);
        }
    }

    public void setTalente(int[] faehigkeitenTalente) {
        for(int i = 0; i<faehigkeitenTalente.length;i++) {
            talenteCircleRow[i].getValue().setValue(faehigkeitenTalente[i]);
        }
    }

    public int[] getFertigkeitenProperty() {
        int[] faehigkeitenFertigkeiten = new int[10];
        for (int i = 0; i < fertigkeitenCircleRow.length; i++) {
            faehigkeitenFertigkeiten[i] = fertigkeitenCircleRow[i].getValue().get();
        }
        return faehigkeitenFertigkeiten;
    }

    public int[] getKenntnisseProperty() {
        int[] faehigkeitenKenntnisse = new int[10];
        for (int i = 0; i < kenntnisseCircleRow.length; i++) {
            faehigkeitenKenntnisse[i] = kenntnisseCircleRow[i].getValue().get();
        }
        return faehigkeitenKenntnisse;
    }

    public int[] getTalenteProperty() {
        int[] faehigkeitenTalente = new int[10];
        for (int i = 0; i < talenteCircleRow.length; i++) {
            faehigkeitenTalente[i] = talenteCircleRow[i].getValue().get();
        }
        return faehigkeitenTalente;
    }
}
