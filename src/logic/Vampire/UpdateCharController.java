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

import java.util.Arrays;

public class UpdateCharController {
    private final Stage primaryStage;
    private boolean successful;
    private final Vamp_Char currentVampChar;
    private final Vamp_Char oldVampChar;
    private int ID;

    public UpdateCharController(Vamp_Char currentVampChar, Vamp_Char oldVampChar, Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.currentVampChar = currentVampChar;
        this.oldVampChar = oldVampChar;
        if (checkDifferenz()){
            ID = currentVampChar.getID();
            successful = updateChar();
            if (successful){showSuccessfulMessage();}
            else {showNOTSuccessfulMessage();}
        } else {
            showNODifferenzMessage();
        }
    }

    private boolean checkDifferenz(){
        boolean differenz = false;
        if (currentVampChar.getID() != oldVampChar.getID()){differenz = true;System.err.println("ID NOT EQUALS, WHAT?!");}
        if (!(Arrays.toString(currentVampChar.getAttributeKoerperlich()).equals((Arrays.toString(oldVampChar.getAttributeKoerperlich())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getAttributeGesellschaftlich()).equals((Arrays.toString(oldVampChar.getAttributeGesellschaftlich())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getAttributeGeistig()).equals((Arrays.toString(oldVampChar.getAttributeGeistig())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getFaehigkeitenFertigkeiten()).equals((Arrays.toString(oldVampChar.getFaehigkeitenFertigkeiten())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getFaehigkeitenKenntnisse()).equals((Arrays.toString(oldVampChar.getFaehigkeitenKenntnisse())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getFaehigkeitenTalente()).equals((Arrays.toString(oldVampChar.getFaehigkeitenTalente())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getAndereEigenschaftenWert()).equals((Arrays.toString(oldVampChar.getAndereEigenschaftenWert())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getAndereEigenschaftenBezeichnung()).equals((Arrays.toString(oldVampChar.getAndereEigenschaftenBezeichnung())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getVorteileDisziplinenBezeichnung()).equals((Arrays.toString(oldVampChar.getVorteileDisziplinenBezeichnung())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getVorteileDisziplinenWert()).equals((Arrays.toString(oldVampChar.getVorteileDisziplinenWert())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getVorteileHintergrundBezeichnung()).equals((Arrays.toString(oldVampChar.getVorteileHintergrundBezeichnung())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getVorteileHintergrundWert()).equals((Arrays.toString(oldVampChar.getVorteileHintergrundWert())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getVorteileTugenden()).equals((Arrays.toString(oldVampChar.getVorteileTugenden())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getVorteileTugendenEntscheidung()).equals((Arrays.toString(oldVampChar.getVorteileTugendenEntscheidung())))))
            differenz = true;
        if (!(Arrays.toString(currentVampChar.getClansschweache()).equals((Arrays.toString(oldVampChar.getClansschweache())))))
            differenz = true;
        if (!(currentVampChar.getCharName()).equals(oldVampChar.getCharName()))
            differenz = true;
        if (!(currentVampChar.getSpieler()).equals(oldVampChar.getSpieler()))
            differenz = true;
        if (!(currentVampChar.getWesen()).equals(oldVampChar.getWesen()))
            differenz = true;
        if (!(currentVampChar.getVerhalten()).equals(oldVampChar.getVerhalten()))
            differenz = true;
        if (!(currentVampChar.getClan()).equals(oldVampChar.getClan()))
            differenz = true;
        if (currentVampChar.getGeneration() != oldVampChar.getGeneration())
            differenz = true;
        if (!(currentVampChar.getZuflucht()).equals(oldVampChar.getZuflucht()))
            differenz = true;
        if (!(currentVampChar.getWeg().equals(oldVampChar.getWeg())))
            differenz = true;
        if (currentVampChar.getWegWert() != oldVampChar.getWegWert())
            differenz = true;
        if (!(currentVampChar.getAura().equals(oldVampChar.getAura())))
            differenz = true;
        if (currentVampChar.getAuraWert() != oldVampChar.getAuraWert())
            differenz = true;
        if (currentVampChar.isAuraAnzeigen() != oldVampChar.isAuraAnzeigen())
            differenz = true;
        if (currentVampChar.getWillenskraft() != oldVampChar.getWillenskraft())
            differenz = true;
        if (currentVampChar.getWillenskraftPool() != oldVampChar.getWillenskraftPool())
            differenz = true;
        if (currentVampChar.getBlutvorrat() != oldVampChar.getBlutvorrat())
            differenz = true;
        if (currentVampChar.getGesundheit() != oldVampChar.getGesundheit())
            differenz = true;
        if (currentVampChar.getGesundheit2() != oldVampChar.getGesundheit2())
            differenz = true;
        if (currentVampChar.getErfahrung() != oldVampChar.getErfahrung())
            differenz = true;

        return differenz;
    }
    private void showSuccessfulMessage(){
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        Label label = new Label("Update erfolgreich!");
        label.setTextFill(Color.GREEN);
        VBox hBox = new VBox();
        Button button = new Button("OK");
        button.setOnAction(event -> {stage.close();});
        hBox.getChildren().addAll(label,button);
        hBox.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(hBox));
        stage.show();
    }
    private void showNOTSuccessfulMessage(){
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        Label label = new Label("Update NICHT erfolgreich!\nBitte überprüfen Sie Ihre Internetverbindung oder versuchen Sie es später erneut!");
        label.setTextFill(Color.RED);
        VBox hBox = new VBox();
        Button button = new Button("OK");
        hBox.setAlignment(Pos.CENTER);
        button.setOnAction(event -> {stage.close();});
        hBox.getChildren().addAll(label,button);
        stage.setScene(new Scene(hBox));
        stage.show();
    }
    private void showNODifferenzMessage() {
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        Label label = new Label("Es wurde kein Unterschied erkannt!");
        label.setTextFill(Color.DARKGOLDENROD);
        VBox hBox = new VBox();
        hBox.setAlignment(Pos.CENTER);
        Button button = new Button("OK");
        button.setOnAction(event -> {stage.close();});
        hBox.getChildren().addAll(label,button);
        stage.setScene(new Scene(hBox));
        stage.show();
    }

    private boolean updateChar(){
        try {
            Vamp_CharData vampCharData = new Vamp_CharData();
            vampCharData.updateVampireCharName(ID,currentVampChar.getCharName());
            vampCharData.updateVampireSpieler(ID,currentVampChar.getSpieler());
            vampCharData.updateVampireWesen(ID,currentVampChar.getWesen());
            vampCharData.updateVampireVerhalten(ID,currentVampChar.getVerhalten());
            vampCharData.updateVampireClan(ID,currentVampChar.getClan());
            vampCharData.updateVampireGeneration(ID,currentVampChar.getGeneration());
            vampCharData.updateVampireZuflucht(ID,currentVampChar.getZuflucht());
            vampCharData.updateVampireAttributeKoerperlich(ID,currentVampChar.getAttributeKoerperlich());
            vampCharData.updateVampireAttributeGesellschaftlich(ID,currentVampChar.getAttributeGesellschaftlich());
            vampCharData.updateVampireAttributeGeistig(ID,currentVampChar.getAttributeGeistig());
            vampCharData.updateVampireFaehigkeitenTalente(ID,currentVampChar.getFaehigkeitenTalente());
            vampCharData.updateVampireFaehigkeitenFertigkeiten(ID,currentVampChar.getFaehigkeitenFertigkeiten());
            vampCharData.updateVampireFaehigkeitenKenntnisse(ID,currentVampChar.getFaehigkeitenKenntnisse());
            vampCharData.updateVampireVorteileDisziplinen(ID,currentVampChar.getVorteileDisziplinenBezeichnung(),currentVampChar.getVorteileDisziplinenWert());
            vampCharData.updateVampireVorteileHintergrund(ID,currentVampChar.getVorteileHintergrundBezeichnung(),currentVampChar.getVorteileHintergrundWert());
            vampCharData.updateVampireVorteileTugenden(ID,currentVampChar.getVorteileTugenden(),currentVampChar.getVorteileTugendenEntscheidung());
            vampCharData.updateVampireAndereEigenschaften(ID,currentVampChar.getAndereEigenschaftenBezeichnung(),currentVampChar.getAndereEigenschaftenWert());
            vampCharData.updateVampireClansschweache(ID,currentVampChar.getClansschweache());
            vampCharData.updateVampireWeg(ID,currentVampChar.getWeg());
            vampCharData.updateVampireWegWert(ID,currentVampChar.getWegWert());
            vampCharData.updateVampireAura(ID,currentVampChar.getAura());
            vampCharData.updateVampireAuraWert(ID,currentVampChar.getWegWert());
            vampCharData.updateVampireAuraAnzeigen(ID,currentVampChar.isAuraAnzeigen());
            vampCharData.updateVampireWillenskraft(ID,currentVampChar.getWillenskraft());
            vampCharData.updateVampireWillenskraftPool(ID,currentVampChar.getWillenskraftPool());
            vampCharData.updateVampireBlutvorrat(ID,currentVampChar.getBlutvorrat());
            vampCharData.updateVampireGesundheit(ID,currentVampChar.getGesundheit());
            vampCharData.updateVampireErfahrung(ID,currentVampChar.getErfahrung());

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
