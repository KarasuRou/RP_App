package UI.Vampire.Char.Components;

import UI.Vampire.Components.TextInputtext;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class PlayerInfoNode {
    private final HBox hBox = new HBox();

    public PlayerInfoNode(){
        hBox.setAlignment(Pos.CENTER);
        TextInputtext tI1 = new TextInputtext();
        TextInputtext tI2 = new TextInputtext();
        TextInputtext tI3 = new TextInputtext();
        hBox.getChildren().addAll(tI1.getTextInputtext(), tI2.getTextInputtext(), tI3.getTextInputtext());
        tI1.addRow("Name:");
        tI1.addRow("Spieler:");
        tI1.addRow("Chronik:");
        tI2.addRow("Wesen:");
        tI2.addRow("Verhalten:");
        tI2.addRow("Clan:");
        tI3.addRow("Generation:");
        tI3.addRow("Zuflucht:");
        tI3.addRow("Erfahrung:");
        tI1.addNewStyle("playerInfo");
        tI1.addNewStyle("playerInfoInputText");
        tI2.addNewStyle("playerInfo");
        tI2.addNewStyle("playerInfoInputText");
        tI2.addNewStyle("middleRow");
        tI3.addNewStyle("playerInfo");
        tI3.addNewStyle("playerInfoInputText");
    }

    public Node getPlayerInfo(){return hBox;}
}
