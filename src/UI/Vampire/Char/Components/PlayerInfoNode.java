package UI.Vampire.Char.Components;

import UI.Vampire.Components.TextInputtext;
import javafx.beans.property.Property;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class PlayerInfoNode {
    private final HBox hBox = new HBox();
    private final Property charName;
    private final Property spieler;
    private final Property wesen;
    private final Property verhalten;
    private final Property clan;
    private final Property generation;
    private final Property zuflucht;
    private final Property erfahrung;

    public PlayerInfoNode(){
        hBox.setAlignment(Pos.CENTER);
        TextInputtext tI1 = new TextInputtext();
        TextInputtext tI2 = new TextInputtext();
        TextInputtext tI3 = new TextInputtext();
        hBox.getChildren().addAll(tI1.getTextInputtext(), tI2.getTextInputtext(), tI3.getTextInputtext());
        charName = tI1.addRow("Name:");
        spieler = tI1.addRow("Spieler:");
        tI1.addRow("Chronik:");
        wesen = tI2.addRow("Wesen:");
        verhalten = tI2.addRow("Verhalten:");
        clan = tI2.addRow("Clan:");
        generation = tI3.addRow("Generation:");
        zuflucht = tI3.addRow("Zuflucht:");
        erfahrung = tI3.addRow("Erfahrung:");
        tI1.addNewStyle("playerInfo");
        tI1.addNewStyle("playerInfoInputText");
        tI1.addNewStyle("vampireTextField");
        tI2.addNewStyle("playerInfo");
        tI2.addNewStyle("playerInfoInputText");
        tI2.addNewStyle("vampireTextField");
        tI2.addNewStyle("middleRow");
        tI3.addNewStyle("playerInfo");
        tI3.addNewStyle("playerInfoInputText");
        tI3.addNewStyle("vampireTextField");
    }

    public Node getPlayerInfo(){return hBox;}

    public Property getCharNameProperty() {
        return charName;
    }
    public void setCharName(String charName){
        this.charName.setValue(charName);
    }

    public Property getSpielerProperty() {
        return spieler;
    }
    public void setSpieler(String spieler){
        this.spieler.setValue(spieler);
    }

    public Property getWesenProperty() {
        return wesen;
    }
    public void setWesen(String wesen){
        this.wesen.setValue(wesen);
    }

    public Property getVerhaltenProperty() {
        return verhalten;
    }
    public void setVerhalten(String verhalten){
        this.verhalten.setValue(verhalten);
    }

    public Property getClanProperty() {
        return clan;
    }
    public void setClan(String clan){
        this.clan.setValue(clan);
    }

    public Property getGenerationProperty() {
        return generation;
    }
    public void setGeneration(int generation){
        this.generation.setValue(String.valueOf(generation));
    }

    public Property getZufluchtProperty() {
        return zuflucht;
    }
    public void setZuflucht(String zuflucht){
        this.zuflucht.setValue(zuflucht);
    }

    public Property getErfahrungProperty() {
        return erfahrung;
    }
    public void setErfahrung(int erfahrung){
        this.erfahrung.setValue(String.valueOf(erfahrung));
    }
}
