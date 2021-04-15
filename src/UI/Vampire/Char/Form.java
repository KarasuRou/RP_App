package UI.Vampire.Char;

import UI.Vampire.Char.Components.*;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.Vampire.CharController;

public class Form {
    private final static CharController charController = new CharController();
    private final static PlayerInfoNode playerInfoNode = new PlayerInfoNode();
    private final static Menue menuBar = new Menue();
    private final static AttributeNode attributeNode = new AttributeNode();
    private final static FaehigkeitenNode faehigkeitenNode = new FaehigkeitenNode();
    private final static VorteileNode vorteileNode = new VorteileNode();

    private final static AndereEigenschaftenNode andereEigenschaftenNode = new AndereEigenschaftenNode();
    private final static WegNode wegNode = new WegNode();
    private final static WillenskraftNode willenskraftNode = new WillenskraftNode();
    private final static BlutvorratNode blutvorratNode = new BlutvorratNode();
    private final static GesundheitNode gesundheitNode = new GesundheitNode();
    private final static ClansschwaecheNode clansschwaecheNode = new ClansschwaecheNode();
    private final static ButtonField buttonField = new ButtonField();

    public Form(Stage stage){
        stage.setTitle("Vampire Char");
        stage.setX(10);
        stage.setY(10);
        VBox root = new VBox();

        HBox secondRoot = secondRoot();

        root.getChildren().addAll(menuBar.getMenueBar(), secondRoot);


        Scene scene = new Scene(root,1763,788);
        stage.setScene(scene);
        stage.setResizable(false);
        scene.getStylesheets().add(Form.class.getResource("Style.css").toExternalForm());
        charController.setNodes(
                playerInfoNode,menuBar,attributeNode,faehigkeitenNode,vorteileNode,andereEigenschaftenNode,
                wegNode,willenskraftNode,blutvorratNode,gesundheitNode,clansschwaecheNode,buttonField
        );
//        stage.widthProperty().addListener((observable, oldValue, newValue) -> System.out.println("Breite: "+newValue));
//        stage.heightProperty().addListener((observable, oldValue, newValue) -> System.out.println("Höhe: "+newValue));
    }

    private HBox secondRoot(){
        HBox hbox = new HBox();
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(columnTWO(), buttonField());
        hbox.getChildren().addAll(columnONE(), separator, vBox);
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

    private HBox buttonField(){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(buttonField.getButtonField());
        return hBox;
    }
}
