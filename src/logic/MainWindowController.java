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
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.updater.Updater;

import java.io.FileNotFoundException;

public class MainWindowController {

    public EventHandler<MouseEvent> vampChar(Stage stage){
        return event -> new Form(stage);
    }

    public void getUpdater(Stage primaryStage, Updater updater) {
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox,300,100);

        Label label = new Label("Ein neues Update ist Verfügbar.\nWollen Sie es jetzt Runterladen?");
        label.setPadding(new Insets(10));
        HBox hBox = new HBox();
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
                    label.setTextAlignment(TextAlignment.CENTER);
                    label.setTextFill(Color.RED);
                    downloadButton.setDisable(true);
                    label.setText("UPDATE NICHT ERFOLGREICH! \nBitte \"Abbrechen\" drücken zum Schließen!");
                }
            }
        });
        NOTDownloadButton.setOnAction(event -> stage.close());
        hBox.getChildren().addAll(downloadButton, NOTDownloadButton);
        hBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label, hBox);
        stage.setScene(scene);
        stage.show();
    }
}
