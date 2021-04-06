package UI.Vampire.Char;

import UI.Vampire.Char.Components.*;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Form {
    private final PlayerInfoNode playerInfoNode = new PlayerInfoNode();
    private final Menue menuBar = new Menue();
    private final AttributeNode attributeNode = new AttributeNode();
    private final FaehigkeitenNode faehigkeitenNode = new FaehigkeitenNode();
    private final VorteileNode vorteileNode = new VorteileNode();

    private final AndereEigenschaftenNode andereEigenschaftenNode = new AndereEigenschaftenNode();
    private final WegNode wegNode = new WegNode();
    private final WillenskraftNode willenskraftNode = new WillenskraftNode();
    private final BlutvorratNode blutvorratNode = new BlutvorratNode();
    private final GesundheitNode gesundheitNode = new GesundheitNode();
    private final ClansschwaecheNode clansschwaecheNode = new ClansschwaecheNode();

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
        vBox.getChildren().addAll(playerInfoNode.getPlayerInfo(), new Separator(), attributeNode.getFaehigkeitenNode(), new Separator());
        vBox.getChildren().addAll(faehigkeitenNode.getFaehigkeitenNode(), new Separator(), vorteileNode.getVorteileNode());
        return vBox;
    }

    private HBox columnTWO() {
        HBox hBox = new HBox();
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        Separator separator2 = new Separator();
        separator2.setOrientation(Orientation.VERTICAL);
        hBox.getChildren().addAll(andereEigenschaftenNode.getAndereEigenschaften(),separator,columnTwo_ColumnTwo(),separator2,columnTwo_ColumnThree());
        return hBox;
    }

    private VBox columnTwo_ColumnTwo(){
        VBox vBox = new VBox();
        vBox.getChildren().addAll(wegNode.getWegNode(),new Separator(),willenskraftNode.getWillenskraftNode(),new Separator(),blutvorratNode.getBlutvorratNode());
        return vBox;
    }
    private VBox columnTwo_ColumnThree(){
        VBox vBox = new VBox();
        vBox.getChildren().addAll(gesundheitNode.getGesundheitNode(),new Separator(), clansschwaecheNode.getClansschwaecheNode());
        return vBox;
    }
}
