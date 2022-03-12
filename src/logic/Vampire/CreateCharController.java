package logic.Vampire;

import data.Vamp_CharData;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Vamp_Char;

public class CreateCharController {
    private boolean created;
    private int ID;
    private final Vamp_Char currentVampChar;
    private final Stage primaryStage;

    public CreateCharController(Vamp_Char currentVampChar, Stage primaryStage) {
        this.currentVampChar = currentVampChar;
        created = false;
        ID = 0;
        this.primaryStage = primaryStage;
        created = createChar();
        if (created) {
            showSuccessfulMessage();
        } else {
            showNOTSuccessfulMessage();
        }

    }

    private boolean createChar() {
        try {
            Vamp_CharData vampCharData = new Vamp_CharData();
            ID = vampCharData.insertVampire_Char(
                    currentVampChar.getCharName(), currentVampChar.getSpieler(), currentVampChar.getWesen(),
                    currentVampChar.getVerhalten(), currentVampChar.getClan(), currentVampChar.getGeneration(),
                    currentVampChar.getZuflucht(), currentVampChar.getWeg(), currentVampChar.getWegWert(),
                    currentVampChar.getAura(), currentVampChar.getAuraWert(), currentVampChar.isAuraAnzeigen(),
                    currentVampChar.getWillenskraft(), currentVampChar.getWillenskraftPool(),
                    currentVampChar.getBlutvorrat(), currentVampChar.getGesundheit(), currentVampChar.getErfahrung()
            );
            vampCharData.insertVampireAndereEigenschaften(ID, currentVampChar.getAndereEigenschaftenBezeichnung(), currentVampChar.getAndereEigenschaftenWert());
            vampCharData.insertVampireAttributeGeistig(ID, currentVampChar.getAttributeGeistig());
            vampCharData.insertVampireAttributeGesellschaftlich(ID, currentVampChar.getAttributeGesellschaftlich());
            vampCharData.insertVampireAttributeKoerperlich(ID, currentVampChar.getAttributeKoerperlich());
            vampCharData.insertVampireClansschweache(ID, currentVampChar.getClansschweache());
            vampCharData.insertVampireFaehigkeitenFertigkeiten(ID, currentVampChar.getFaehigkeitenFertigkeiten());
            vampCharData.insertVampireFaehigkeitenKenntnisse(ID, currentVampChar.getFaehigkeitenKenntnisse());
            vampCharData.insertVampireFaehigkeitenTalente(ID, currentVampChar.getFaehigkeitenTalente());
            vampCharData.insertVampireVorteileDisziplinen(ID, currentVampChar.getVorteileDisziplinenBezeichnung(), currentVampChar.getVorteileDisziplinenWert());
            vampCharData.insertVampireVorteileHintergrund(ID, currentVampChar.getVorteileHintergrundBezeichnung(), currentVampChar.getVorteileHintergrundWert());
            vampCharData.insertVampireVorteileTugenden(ID, currentVampChar.getVorteileTugenden(), currentVampChar.getVorteileTugendenEntscheidung());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void showSuccessfulMessage(){
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        Label label = new Label("Erstellen erfolgreich!");
        label.setTextFill(Color.GREEN);
        VBox hBox = new VBox();
        Button button = new Button("OK");
        button.setOnAction(event -> {stage.close();});
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(label,button);
        stage.setScene(new Scene(hBox));
        stage.show();
    }
    private void showNOTSuccessfulMessage(){
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        Label label = new Label("Erstellen NICHT erfolgreich!\nBitte überprüfen Sie Ihre Internetverbindung oder versuchen Sie es später erneut!");
        label.setTextFill(Color.RED);
        VBox hBox = new VBox();
        Button button = new Button("OK");
        button.setOnAction(event -> {stage.close();});
        hBox.getChildren().addAll(label,button);
        hBox.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(hBox));
        stage.show();
    }
    public int getID() {
        return ID;
    }

    public boolean wasCreated() {
        return created;
    }
}