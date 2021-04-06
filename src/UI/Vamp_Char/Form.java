package UI.Vamp_Char;

import UI.Vamp_Char.Components.*;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Form {
    private final PlayerInfo playerInfo = new PlayerInfo();
    private final Menue menuBar = new Menue();
    private final AttributeNode attributeNode = new AttributeNode();
    private final FaehigkeitenNode faehigkeitenNode = new FaehigkeitenNode();
    private final VorteileNode vorteileNode = new VorteileNode();
    private final AndereEigenschaften andereEigenschaften = new AndereEigenschaften();

    public Form(){
        Stage primaryStage = new Stage();
        VBox root = new VBox();

        HBox secondRoot = secondRoot();

        root.getChildren().addAll(menuBar.getMenueBar(), secondRoot);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        scene.getStylesheets().add(Form.class.getResource("Style.css").toExternalForm());
        primaryStage.show();
    }

    private HBox secondRoot(){
        HBox hbox = new HBox();
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        hbox.getChildren().addAll(columnONE(), separator, columnTWO());
        return hbox;
    }

    private VBox columnONE(){
        VBox vBox = new VBox();
        vBox.getChildren().addAll(playerInfo.getPlayerInfo(), new Separator(), attributeNode.getFaehigkeitenNode(), new Separator());
        vBox.getChildren().addAll(faehigkeitenNode.getFaehigkeitenNode(), new Separator(), vorteileNode.getVorteileNode());
        return vBox;
    }

    private VBox columnTWO() {
        VBox vBox = new VBox();
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        Separator separator2 = new Separator();
        separator2.setOrientation(Orientation.VERTICAL);
        vBox.getChildren().addAll(andereEigenschaften.getAndereEigenschaften(),separator,separator2);
        return vBox;
    }
}
