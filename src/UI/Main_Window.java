package UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.MainWindowController;

public class Main_Window {

    private MainWindowController mainWindowController = new MainWindowController();
    private final Stage stage = new Stage();
    private final VBox vBox = new VBox();
    private Scene scene;


    public Main_Window(){
        vBox.setAlignment(Pos.CENTER);
        Button gotoVampCharForm = new Button("Vampir Charakter");
        gotoVampCharForm.setOnMouseClicked(mainWindowController.vampChar(stage));
        vBox.getChildren().addAll(gotoVampCharForm);
        scene = new Scene(vBox,300,300);
        resetStage();
    }

    public void resetStage(){
        stage.setTitle("RP_APP");
        stage.setScene(scene);
        stage.show();
    }
}
