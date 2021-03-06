package logic.Vampire;

import UI.Vampire.Char.Components.*;
import data.Vamp_CharData;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Vamp_Char;

import java.sql.ResultSet;
import java.util.Arrays;

public class CharController {

    private final Vamp_CharData vampCharData;
    private static int count;
    private int id = 0;


    private static PlayerInfoNode playerInfoNode;
    private static Menue menuBar;
    private static AttributeNode attributeNode;
    private static FaehigkeitenNode faehigkeitenNode;
    private static VorteileNode vorteileNode;

    private static AndereEigenschaftenNode andereEigenschaftenNode;
    private static WegNode wegNode;
    private static WillenskraftNode willenskraftNode;
    private static BlutvorratNode blutvorratNode;
    private static GesundheitNode gesundheitNode;
    private static ClansschwaecheNode clansschwaecheNode;
    private static ButtonField buttonField;
    private Stage stage;

    public void displayTemplate(int id) throws Exception {
        Vamp_Char vampChar = getCharById(id);
        displayTemplate(vampChar);
    }

    public void displayTemplate(Vamp_Char vampChar){
        System.out.println("ID:             " + vampChar.getID());
        System.out.println("CharName:       " + vampChar.getCharName());
        System.out.println("Spieler:        " + vampChar.getSpieler());
        System.out.println("Wesen:          " + vampChar.getWesen());
        System.out.println("Verhalten:      " + vampChar.getVerhalten());
        System.out.println("Clan:           " + vampChar.getClan());
        System.out.println("Generation:     " + vampChar.getGeneration());
        System.out.println("Zuflucht:       " + vampChar.getZuflucht());
        System.out.println("Weg:            " + vampChar.getWeg());
        System.out.println("Weg Wert:       " + vampChar.getWegWert());
        System.out.println("Aura:           " + vampChar.getAura());
        System.out.println("Aura Wert:      " + vampChar.getAuraWert());
        System.out.println("Aura Anz:       " + vampChar.isAuraAnzeigen());
        System.out.println("Willenskraft:   " + vampChar.getWillenskraft());
        System.out.println("WillenskraftP:  " + vampChar.getWillenskraftPool());
        System.out.println("Blutvorrat:     " + vampChar.getBlutvorrat());
        System.out.println("Gesundheit:     " + vampChar.getGesundheit());
        System.out.println("Gesundheit2:    " + vampChar.getGesundheit2());
        System.out.println("Erfahrung:      " + vampChar.getErfahrung());
        System.out.println("Clansschw??chen: " + Arrays.toString(vampChar.getClansschweache()));
        System.out.println("At. K??rperlich: " + Arrays.toString(vampChar.getAttributeKoerperlich()));
        System.out.println("At. Gesellsch.: " + Arrays.toString(vampChar.getAttributeGesellschaftlich()));
        System.out.println("At. Geistig:    " + Arrays.toString(vampChar.getAttributeGeistig()));
        System.out.println("F??h. Talente:   " + Arrays.toString(vampChar.getFaehigkeitenTalente()));
        System.out.println("F??h. Fert.:     " + Arrays.toString(vampChar.getFaehigkeitenFertigkeiten()));
        System.out.println("F??h. Kennt.:    " + Arrays.toString(vampChar.getFaehigkeitenKenntnisse()));
        System.out.println("Vor. Dis. Bez:  " + Arrays.toString(vampChar.getVorteileDisziplinenBezeichnung()));
        System.out.println("Vor. Dis. Wert: " + Arrays.toString(vampChar.getVorteileDisziplinenWert()));
        System.out.println("Vor. Hin. Bez:  " + Arrays.toString(vampChar.getVorteileHintergrundBezeichnung()));
        System.out.println("Vor. Hin. Wert: " + Arrays.toString(vampChar.getVorteileHintergrundWert()));
        System.out.println("Vor. Tug. Ent:  " + Arrays.toString(vampChar.getVorteileTugendenEntscheidung()));
        System.out.println("Vor. Tug. Wert: " + Arrays.toString(vampChar.getVorteileTugenden()));
        System.out.println("And. Eig. Bez:  " + Arrays.toString(vampChar.getAndereEigenschaftenBezeichnung()));
        System.out.println("And. Eig. Wert: " + Arrays.toString(vampChar.getAndereEigenschaftenWert()));
    }


    public CharController(){
        vampCharData = new Vamp_CharData();
    }

    //////////////////////////////////////////
    // Getter
    //////////////////////////////////////////
    public Vamp_Char getCharById(int id) throws Exception{
        int i = 0;
        Vamp_Char vampChar = new Vamp_Char(id);
        ResultSet resultSet;
        resultSet = vampCharData.playerInfoSearchById(id);
        resultSet.last();
        int lastRow = resultSet.getRow();
        resultSet.first();
        for (i = 0; i < lastRow; i++) {
            vampChar.setCharName(resultSet.getString("charName"));
            vampChar.setSpieler(resultSet.getString("spieler"));
            vampChar.setWesen(resultSet.getString("wesen"));
            vampChar.setVerhalten(resultSet.getString("verhalten"));
            vampChar.setClan(resultSet.getString("clan"));
            vampChar.setGeneration(resultSet.getInt("generation"));
            vampChar.setZuflucht(resultSet.getString("zuflucht"));
            vampChar.setWeg(resultSet.getString("weg"));
            vampChar.setWegWert(resultSet.getInt("wegWert"));
            vampChar.setAura(resultSet.getString("aura"));
            vampChar.setAuraAnzeigen(resultSet.getBoolean("auraAnzeigen"));
            vampChar.setWillenskraft(resultSet.getInt("willenskraft"));
            vampChar.setWillenskraftPool(resultSet.getInt("willenskraftPool"));
            vampChar.setBlutvorrat(resultSet.getInt("blutvorrat"));
            vampChar.setGesundheit(resultSet.getInt("gesundheit"));
            vampChar.setGesundheit2(resultSet.getInt("gesundheit2"));
            vampChar.setErfahrung(resultSet.getInt("erfahrung"));
            resultSet.next();
        }

        resultSet = vampCharData.clansschwaecheSearchById(id);
        resultSet.last();
        lastRow = resultSet.getRow();
        String[] clansschwaeche = new String[lastRow];
        resultSet.first();
        for(i = 0;i<lastRow;i++){
            clansschwaeche[i] = resultSet.getString("value"); //ARRAY
            resultSet.next();
        }vampChar.setClansschweache(clansschwaeche);

        resultSet = vampCharData.attributeKoerperlichSearchById(id);
        i = 0;
        resultSet.last();
        lastRow = resultSet.getRow();
        int[] attributeKoerperlich = new int[lastRow];
        resultSet.first();
        for(i = 0;i<lastRow;i++){
            attributeKoerperlich[i] = resultSet.getInt("value");
            resultSet.next();
        }vampChar.setAttributeKoerperlich(attributeKoerperlich);

        resultSet = vampCharData.attributeGesellschaftlichSearchById(id);
        i = 0;
        resultSet.last();
        lastRow = resultSet.getRow();
        int[] attributeGesellschaftlich = new int[lastRow];
        resultSet.first();
        for(i = 0;i<lastRow;i++){
            attributeGesellschaftlich[i] = resultSet.getInt("value");
            resultSet.next();
        }vampChar.setAttributeGesellschaftlich(attributeGesellschaftlich);

        resultSet = vampCharData.attributeGeistigSearchById(id);
        i = 0;
        resultSet.last();
        lastRow = resultSet.getRow();
        int[] attributeGeistig = new int[lastRow];
        resultSet.first();
        for(i = 0;i<lastRow;i++){
            attributeGeistig[i] = resultSet.getInt("value");
            resultSet.next();
        }vampChar.setAttributeGeistig(attributeGeistig);

        resultSet = vampCharData.faehigkeitenTalenteSearchById(id);
        i = 0;
        resultSet.last();
        lastRow = resultSet.getRow();
        int[] faehigkeitenTalente = new int[lastRow];
        resultSet.first();
        for(i = 0;i<lastRow;i++){
            faehigkeitenTalente[i] = resultSet.getInt("value");
            resultSet.next();
        }vampChar.setFaehigkeitenTalente(faehigkeitenTalente);

        resultSet = vampCharData.faehigkeitenFertigkeitenSearchById(id);
        i = 0;
        resultSet.last();
        lastRow = resultSet.getRow();
        int[] faehigkeitenFertigkeiten = new int[lastRow];
        resultSet.first();
        for(i = 0;i<lastRow;i++){
            faehigkeitenFertigkeiten[i] = resultSet.getInt("value");
            resultSet.next();
        }vampChar.setFaehigkeitenFertigkeiten(faehigkeitenFertigkeiten);

        resultSet = vampCharData.faehigkeitenKenntnisseSearchById(id);
        i = 0;
        resultSet.last();
        lastRow = resultSet.getRow();
        int[] faehigkeitenKenntnisse = new int[lastRow];
        resultSet.first();
        for(i = 0;i<lastRow;i++){
            faehigkeitenKenntnisse[i] = resultSet.getInt("value");
            resultSet.next();
        }vampChar.setFaehigkeitenKenntnisse(faehigkeitenKenntnisse);

        resultSet = vampCharData.vorteileDisziplinenSearchById(id);
        i = 0;
        resultSet.last();
        lastRow = resultSet.getRow();
        String[] vorteileDisziplinenBezeichnung = new String[lastRow];
        int[] vorteileDisziplinenWert = new int[lastRow];
        resultSet.first();
        for(i = 0;i<lastRow;i++){
            vorteileDisziplinenBezeichnung[i] = resultSet.getString("bezeichnung");
            vorteileDisziplinenWert[i] = resultSet.getInt("value");
            resultSet.next();
        }vampChar.setVorteileDisziplinenBezeichnung(vorteileDisziplinenBezeichnung);vampChar.setVorteileDisziplinenWert(vorteileDisziplinenWert);

        resultSet = vampCharData.vorteileHintergrundSearchById(id);
        i = 0;
        resultSet.last();
        lastRow = resultSet.getRow();
        String[] vorteileHintergrundBezeichnung = new String[lastRow];
        int[] vorteileHintergrundWert = new int[lastRow];
        resultSet.first();
        for(i = 0;i<lastRow;i++){
            vorteileHintergrundBezeichnung[i] = resultSet.getString("bezeichnung");
            vorteileHintergrundWert[i] = resultSet.getInt("value");
            resultSet.next();
        }vampChar.setVorteileHintergrundBezeichnung(vorteileHintergrundBezeichnung);vampChar.setVorteileHintergrundWert(vorteileHintergrundWert);

        resultSet = vampCharData.vorteileTugendenSearchById(id);
        i = 0;
        resultSet.last();
        lastRow = resultSet.getRow();
        boolean[] vorteileTugendenEntscheidung = new boolean[lastRow];
        int[] vorteileTugenden = new int[lastRow];
        resultSet.first();
        for(i = 0;i<lastRow;i++){
            vorteileTugendenEntscheidung[i] = resultSet.getBoolean("entscheidung");
            vorteileTugenden[i] = resultSet.getInt("value");
            resultSet.next();
        }vampChar.setVorteileTugenden(vorteileTugenden);vampChar.setVorteileTugendenEntscheidung(vorteileTugendenEntscheidung);

        resultSet = vampCharData.andereEigenschaftenSearchById(id);
        i = 0;
        resultSet.last();
        lastRow = resultSet.getRow();
        String[] andereEigenschaftenBezeichnung = new String[lastRow];
        int[] andereEigenschaftenWert = new int[lastRow];
        resultSet.first();
        for(i = 0;i<lastRow;i++){
            andereEigenschaftenBezeichnung[i] = resultSet.getString("bezeichnung");
            andereEigenschaftenWert[i] = resultSet.getInt("value");
            resultSet.next();
        }vampChar.setAndereEigenschaftenBezeichnung(andereEigenschaftenBezeichnung);vampChar.setAndereEigenschaftenWert(andereEigenschaftenWert);


        resultSet.close();
        return vampChar;
    }

    public String getCharName(int id){
        try {
            ResultSet resultSet;
            resultSet = vampCharData.getVampireCharName(id);
            String name = "";
            while (resultSet.next()){
                name = resultSet.getString("charName");
            }
            return name;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    public String getPlayerName(int id){
        try {
            ResultSet resultSet;
            resultSet = vampCharData.getVampirePlayerName(id);
            String name = "";
            while (resultSet.next()){
                name = resultSet.getString("spieler");
            }
            return name;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    public int getCharCount(){
        try {
            ResultSet resultSet;
            resultSet = vampCharData.getVampireCharCount();
            while (resultSet.next()){
                count = resultSet.getInt("anzahl");
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    //////////////////////////////////////////
    // Setter
    //////////////////////////////////////////
    public void setNodes(
            PlayerInfoNode playerInfoNode, Menue menuBar, AttributeNode attributeNode, FaehigkeitenNode faehigkeitenNode,
            VorteileNode vorteileNode, AndereEigenschaftenNode andereEigenschaftenNode, WegNode wegNode,
            WillenskraftNode willenskraftNode, BlutvorratNode blutvorratNode, GesundheitNode gesundheitNode,
            ClansschwaecheNode clansschwaecheNode, ButtonField buttonField)
    {
        this.playerInfoNode = playerInfoNode;
        this.menuBar = menuBar;
        this.attributeNode = attributeNode;
        this.faehigkeitenNode = faehigkeitenNode;
        this.vorteileNode = vorteileNode;
        this.andereEigenschaftenNode = andereEigenschaftenNode;
        this.wegNode = wegNode;
        this.willenskraftNode = willenskraftNode;
        this.blutvorratNode = blutvorratNode;
        this.gesundheitNode = gesundheitNode;
        this.clansschwaecheNode = clansschwaecheNode;
        this.buttonField = buttonField;
        setCreateNewCharButtonEvent();
        setUpdateVampCharButtonEvent();
        setMenues();
    }
    private void setMenues(){setDateiMenue();setExtraMenue();setCharMenue();}
    private void setDateiMenue(){
        MenuItem vollbild = new MenuItem("Vollbild");
        MenuItem close = new MenuItem("Anwendung schlie??en");
        vollbild.setOnAction(event -> stage.setFullScreen(!stage.isFullScreen()));
        close.setOnAction(event -> Platform.exit());
        menuBar.setMenuOne(new MenuItem[]{vollbild,close},"Datei");
    }
    private void setExtraMenue(){
        MenuItem menuItem = new MenuItem();
        menuBar.setMenuTwo(new MenuItem[]{menuItem},"Extra-Info");
    }
    private void setCharMenue(){
        MenuItem[] menuItems = new MenuItem[getCharCount()+1];
        int[] ids = getIDs();
        int separateCounter = 0;
        for (int i = 0 ; i<menuItems.length ; i++){
            if(i==1)
                menuItems[i] = new SeparatorMenuItem();
            else
            {
                MenuItem menuItem = new MenuItem();
                menuItems[i] = menuItem;
                menuItem.setId(String.valueOf(ids[separateCounter]));
                if(i==0)
                    menuItem.setText("Neuen Charakter erstellen");
                else
                    menuItem.setText(getCharName(ids[separateCounter]) + " (" + getPlayerName(ids[separateCounter]) + ")");
                menuItem.setOnAction(event -> {
                    id = Integer.parseInt(event.getSource().toString().replace("MenuItem[id=","").replace(", styleClass=[menu-item]]",""));
                    setVampChar(id);
                });
                separateCounter++;
            }
        }
        menuBar.setMenuThree(menuItems,"Charaktere");
    }

    private int[] getIDs() {
        try {
            ResultSet resultSet = vampCharData.getVampireCharIDs();
            resultSet.last();
            int[] ids = new int[resultSet.getRow()];
            resultSet.beforeFirst();
            int i=0;
            while (resultSet.next()) {
                ids[i++] = resultSet.getInt("id");
            }
            return ids;
        } catch (Exception e) {
            e.printStackTrace();
            return new int[]{0};
        }
    }

    public void setVampChar(int id){
        if (id == 0){buttonField.enableCreateNewCharButton();}
        else {buttonField.disableCreateNewCharButton();}
        try {
            Vamp_Char vampChar;
            vampChar = getCharById(id);
            displayTemplate(vampChar);
            playerInfoNode.setCharName(vampChar.getCharName());
            playerInfoNode.setSpieler(vampChar.getSpieler());
            playerInfoNode.setWesen(vampChar.getWesen());
            playerInfoNode.setVerhalten(vampChar.getVerhalten());
            playerInfoNode.setClan(vampChar.getClan());
            playerInfoNode.setGeneration(vampChar.getGeneration());
            playerInfoNode.setZuflucht(vampChar.getZuflucht());
            playerInfoNode.setErfahrung(vampChar.getErfahrung());
            attributeNode.setGeistig(vampChar.getAttributeGeistig());
            attributeNode.setGesellschaftlich(vampChar.getAttributeGesellschaftlich());
            attributeNode.setKoerperlich(vampChar.getAttributeKoerperlich());
            faehigkeitenNode.setFertigkeiten(vampChar.getFaehigkeitenFertigkeiten());
            faehigkeitenNode.setKenntnisse(vampChar.getFaehigkeitenKenntnisse());
            faehigkeitenNode.setTalente(vampChar.getFaehigkeitenTalente());
            vorteileNode.setDisziplinen(vampChar.getVorteileDisziplinenBezeichnung(), vampChar.getVorteileDisziplinenWert());
            vorteileNode.setHintergrund(vampChar.getVorteileHintergrundBezeichnung(), vampChar.getVorteileHintergrundWert());
            vorteileNode.setTugenden(vampChar.getVorteileTugendenEntscheidung(), vampChar.getVorteileTugenden());
            andereEigenschaftenNode.setAndereEigenschaften(vampChar.getAndereEigenschaftenBezeichnung(), vampChar.getAndereEigenschaftenWert());
            wegNode.setWeg(vampChar.getWeg(),vampChar.getWegWert());
            wegNode.setAura(vampChar.getAura());
            willenskraftNode.setWillenskraft(vampChar.getWillenskraft(), vampChar.getWillenskraftPool());
            blutvorratNode.setBlutvorrat(vampChar.getBlutvorrat());
            gesundheitNode.setGesundheit(vampChar.getGesundheit(),vampChar.getGesundheit2());
            clansschwaecheNode.setClansschwaeche(vampChar.getClansschweache());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateVampChar(){
        try {
           UpdateCharController updateCharController = new UpdateCharController(getCurrentVampChar(),getCharById(id), stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int createNewVampChar(){
        CreateCharController createCharController = new CreateCharController(getCurrentVampChar(), stage);
        if (createCharController.wasCreated()) {
            buttonField.disableCreateNewCharButton();
            return createCharController.getID();
        } else {
            return 0;
        }
    }

    public Vamp_Char getCurrentVampChar(){
        Vamp_Char vamp_char = new Vamp_Char(id);
        vamp_char.setCharName(playerInfoNode.getCharNameProperty().getValue().toString());
        vamp_char.setSpieler(playerInfoNode.getSpielerProperty().getValue().toString());
        vamp_char.setWesen(playerInfoNode.getWesenProperty().getValue().toString());
        vamp_char.setVerhalten(playerInfoNode.getVerhaltenProperty().getValue().toString());
        vamp_char.setClan(playerInfoNode.getClanProperty().getValue().toString());
        vamp_char.setGeneration(Integer.parseInt(playerInfoNode.getGenerationProperty().getValue().toString()));
        vamp_char.setZuflucht(playerInfoNode.getZufluchtProperty().getValue().toString());
        vamp_char.setErfahrung(Integer.parseInt(playerInfoNode.getErfahrungProperty().getValue().toString()));
        vamp_char.setAttributeGeistig(attributeNode.getGeistigProperty());
        vamp_char.setAttributeGesellschaftlich(attributeNode.getGesellschaftlichProperty());
        vamp_char.setAttributeKoerperlich(attributeNode.getKoerperlichProperty());
        vamp_char.setFaehigkeitenFertigkeiten(faehigkeitenNode.getFertigkeitenProperty());
        vamp_char.setFaehigkeitenKenntnisse(faehigkeitenNode.getKenntnisseProperty());
        vamp_char.setFaehigkeitenTalente(faehigkeitenNode.getTalenteProperty());
        vamp_char.setVorteileDisziplinenBezeichnung(vorteileNode.getDisziplinenBezeichnungProperty());
        vamp_char.setVorteileDisziplinenWert(vorteileNode.getDisziplinenWertProperty());
        vamp_char.setVorteileHintergrundWert(vorteileNode.getHintergrundWertProperty());
        vamp_char.setVorteileHintergrundBezeichnung(vorteileNode.getHintergrundBezeichnungProperty());
        vamp_char.setVorteileTugenden(vorteileNode.getTugendenProperty());
        vamp_char.setVorteileTugendenEntscheidung(vorteileNode.getTugendenEntscheidungProperty());
        vamp_char.setAndereEigenschaftenBezeichnung(andereEigenschaftenNode.getAndereEigenschaftenBezeichnungProperty());
        vamp_char.setAndereEigenschaftenWert(andereEigenschaftenNode.getAndereEigenschaftenWertProperty());
        vamp_char.setWeg(wegNode.getWegBezeichnungProperty());
        vamp_char.setWegWert(wegNode.getWegWertProperty());
        vamp_char.setAura(wegNode.getAuraProperty());
        vamp_char.setAuraAnzeigen(wegNode.getAuraAnzeigenProperty());
        vamp_char.setWillenskraft(willenskraftNode.getWillenskraftProperty());
        vamp_char.setWillenskraftPool(willenskraftNode.getWillenskraftPoolProperty());
        vamp_char.setBlutvorrat(blutvorratNode.getBlutvorratProperty());
        vamp_char.setGesundheit(gesundheitNode.getGesundheitProperty());
//        vamp_char.setGesundheit2(gesundheitNode.getGesundheit());
        vamp_char.setClansschweache(clansschwaecheNode.getClansschwaeche());
        return vamp_char;
    }

    //////////////////////////////////////////
    // EventHandler
    //////////////////////////////////////////

    private void setUpdateVampCharButtonEvent(){
        EventHandler<MouseEvent> event = event1 -> updateVampChar();
        buttonField.setUpdateCharEvent(event);
    }

    public void setCreateNewCharButtonEvent(){
        EventHandler<MouseEvent> event = event1 -> id = createNewVampChar();
        buttonField.setCreateCharEvent(event);
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }
}