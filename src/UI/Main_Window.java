package UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.MainWindowController;
import logic.updater.Updater;

public class Main_Window {

    private MainWindowController mainWindowController = new MainWindowController();
    private final Stage stage = new Stage();
    private final MenuBar menuBar = new MenuBar();
    private final Menu uberMenu = new Menu("Über");
    private final VBox vBox = new VBox();
    private Scene scene;


    public Main_Window(){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Button gotoVampCharForm = new Button("Vampir Charakter");
        gotoVampCharForm.setOnMouseClicked(mainWindowController.vampChar(stage));
        hBox.getChildren().add(gotoVampCharForm);
        vBox.getChildren().addAll(setMenuBar(),hBox);
        scene = new Scene(vBox,300,300);
        resetStage();
    }

    private void lookForUpdates(){
        Updater updater = new Updater();
        if (updater.isUpdateAvailable()) {
            Button menuItem = new Button("UPDATE VERFÜGBAR");
            CustomMenuItem customMenuItem = new CustomMenuItem(menuItem);
            menuItem.setStyle("-fx-background-color: lightgreen");
            menuItem.setOnAction(event -> {
                try {
                    mainWindowController.getUpdater(stage,updater);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            uberMenu.getItems().add(customMenuItem);
        }
    }

    private Node setMenuBar(){
        VBox vBox = new VBox();
        menuBar.getMenus().add(uberMenu);
        lookForUpdates();
        vBox.getChildren().add(menuBar);
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.setPadding(new Insets(0,0,20,0));
        return vBox;
    }

    public void resetStage(){
        stage.setTitle("RP_APP");
        stage.setScene(scene);
        stage.show();
    }
}
