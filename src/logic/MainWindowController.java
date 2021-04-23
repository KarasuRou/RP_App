package logic;

import UI.Vampire.Char.Form;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.updater.Updater;

public class MainWindowController {

    public EventHandler<MouseEvent> vampChar(Stage stage){
        return event -> new Form(stage);
    }

    public void getUpdater(Stage primaryStage, Updater updater) throws Exception {
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        Label updateLabel = new Label("Ein neues Update auf Version " + updater.getNewVersion() + " ist Verfügbar.\n" +
                "Wollen Sie es jetzt Herunterladen?");
        updateLabel.setTextAlignment(TextAlignment.CENTER);
        updateLabel.setPadding(new Insets(10));
        HBox hBox = new HBox();
        hBox.setSpacing(7.5);
        hBox.setPadding(new Insets(0,0,10,0));
        Button downloadButton = new Button("Download");
        Button NOTDownloadButton = new Button("Abbrechen");
        downloadButton.setOnAction(event -> {
            try {
                downloadButton.setDisable(true);
                updater.loadUpdate();
                updater.update();
                stage.close();
                updater.restart();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (stage.isShowing()) {
                    updateLabel.setTextAlignment(TextAlignment.CENTER);
                    updateLabel.setTextFill(Color.RED);
                    downloadButton.setDisable(true);
                    updateLabel.setText("UPDATE NICHT ERFOLGREICH! \nBitte \"Abbrechen\" drücken zum Schließen!");
                }
            }
        });
        NOTDownloadButton.setOnAction(event -> stage.close());
        hBox.getChildren().addAll(downloadButton, NOTDownloadButton);
        hBox.setAlignment(Pos.CENTER);

        VBox patchNoteContainer = new VBox();
        try {
            Label patchNoteLabel = new Label("Patch Notes:");
            VBox patchNoteBox = new VBox();
            Text text = new Text(updater.loadPatchNotes());
            patchNoteBox.getChildren().add(text);
            patchNoteBox.setStyle("-fx-background-color: LIGHTGRAY");
            patchNoteContainer.getChildren().addAll(patchNoteLabel, patchNoteBox);
            patchNoteContainer.setPadding(new Insets(0,0,20,0));
        } catch (Exception e) {
            e.printStackTrace();
        }


        vBox.getChildren().addAll(updateLabel, patchNoteContainer ,hBox);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
}
