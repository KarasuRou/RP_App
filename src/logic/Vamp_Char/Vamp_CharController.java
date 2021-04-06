package logic.Vamp_Char;

import data.Vamp_CharData;
import model.Vamp_Char;

import java.sql.ResultSet;
import java.util.Arrays;

public class Vamp_CharController {

    private final Vamp_CharData vampCharData;

    public void displayTemplate() throws Exception {
        Vamp_Char vampChar = getCharById(0);
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
        System.out.println("Clansschwächen: " + Arrays.toString(vampChar.getClansschweache()));
        System.out.println("At. Körperlich: " + Arrays.toString(vampChar.getAttributeKoerperlich()));
        System.out.println("At. Gesellsch.: " + Arrays.toString(vampChar.getAttributeGesellschaftlich()));
        System.out.println("At. Geistig:    " + Arrays.toString(vampChar.getAttributeGeistig()));
        System.out.println("Fäh. Talente:   " + Arrays.toString(vampChar.getFaehigkeitenTalente()));
        System.out.println("Fäh. Fert.:     " + Arrays.toString(vampChar.getFaehigkeitenFertigkeiten()));
        System.out.println("Fäh. Kennt.:    " + Arrays.toString(vampChar.getFaehigkeitenKenntnisse()));
        System.out.println("Vor. Dis. Bez:  " + Arrays.toString(vampChar.getVorteileDisziplinenBezeichnung()));
        System.out.println("Vor. Dis. Wert: " + Arrays.toString(vampChar.getVorteileDisziplinenWert()));
        System.out.println("Vor. Hin. Bez:  " + Arrays.toString(vampChar.getVorteileHintergrundBezeichnung()));
        System.out.println("Vor. Hin. Wert: " + Arrays.toString(vampChar.getVorteileHintergrundWert()));
        System.out.println("Vor. Tug. Ent:  " + Arrays.toString(vampChar.getVorteileTugendenEntscheidung()));
        System.out.println("Vor. tug. Wert: " + Arrays.toString(vampChar.getVorteileTugenden()));
        System.out.println("And. Eig. Bez:  " + Arrays.toString(vampChar.getAndereEigenschaftenBezeichnung()));
        System.out.println("And. Eug. Wert: " + Arrays.toString(vampChar.getAndereEigenschaftenWert()));
    }


    public Vamp_CharController(){
        vampCharData = new Vamp_CharData();
    }

    //////////////////////////////////////////
    // Getter
    //////////////////////////////////////////
    public Vamp_Char getCharById(int id) throws Exception{
        Vamp_Char vampChar = new Vamp_Char(id);
        ResultSet resultSet;
        resultSet = vampCharData.playerInfoSearchById(id);
        while (resultSet.next()){
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
        }

        resultSet = vampCharData.clansschwaecheSearchById(id);
        int i = 0;
        resultSet.last();
        String[] clansschwaeche = new String[resultSet.getRow()];
        resultSet.first();
        while (resultSet.next()){
            clansschwaeche[i++] = resultSet.getString("value"); //ARRAY
        }vampChar.setClansschweache(clansschwaeche);

        resultSet = vampCharData.attributeKoerperlichSearchById(id);
        i = 0;
        resultSet.last();
        int[] attributeKoerperlich = new int[resultSet.getRow()];
        resultSet.first();
        while (resultSet.next()){
            attributeKoerperlich[i++] = resultSet.getInt("value");
        }vampChar.setAttributeKoerperlich(attributeKoerperlich);

        resultSet = vampCharData.attributeGesellschaftlichSearchById(id);
        i = 0;
        resultSet.last();
        int[] attributeGesellschaftlich = new int[resultSet.getRow()];
        resultSet.first();
        while (resultSet.next()){
            attributeGesellschaftlich[i++] = resultSet.getInt("value");
        }vampChar.setAttributeGesellschaftlich(attributeGesellschaftlich);

        resultSet = vampCharData.attributeGeistigSearchById(id);
        i = 0;
        resultSet.last();
        int[] attributeGeistig = new int[resultSet.getRow()];
        resultSet.first();
        while (resultSet.next()){
            attributeGeistig[i++] = resultSet.getInt("value");
        }vampChar.setAttributeGeistig(attributeGeistig);

        resultSet = vampCharData.faehigkeitenTalenteSearchById(id);
        i = 0;
        resultSet.last();
        int[] faehigkeitenTalente = new int[resultSet.getRow()];
        resultSet.first();
        while (resultSet.next()){
            faehigkeitenTalente[i++] = resultSet.getInt("value");
        }vampChar.setFaehigkeitenTalente(faehigkeitenTalente);

        resultSet = vampCharData.faehigkeitenFertigkeitenSearchById(id);
        i = 0;
        resultSet.last();
        int[] faehigkeitenFertigkeiten = new int[resultSet.getRow()];
        resultSet.first();
        while (resultSet.next()){
            faehigkeitenFertigkeiten[i++] = resultSet.getInt("value");
        }vampChar.setFaehigkeitenFertigkeiten(faehigkeitenFertigkeiten);

        resultSet = vampCharData.faehigkeitenKenntnisseSearchById(id);
        i = 0;
        resultSet.last();
        int[] faehigkeitenKenntnisse = new int[resultSet.getRow()];
        resultSet.first();
        while (resultSet.next()){
            faehigkeitenKenntnisse[i++] = resultSet.getInt("value");
        }vampChar.setFaehigkeitenKenntnisse(faehigkeitenKenntnisse);

        resultSet = vampCharData.vorteileDisziplinenSearchById(id);
        i = 0;
        resultSet.last();
        String[] vorteileDisziplinenBezeichnung = new String[resultSet.getRow()];
        int[] vorteileDisziplinenWert = new int[resultSet.getRow()];
        resultSet.first();
        while (resultSet.next()){
            vorteileDisziplinenBezeichnung[i] = resultSet.getString("bezeichnung");
            vorteileDisziplinenWert[i++] = resultSet.getInt("value");
        }vampChar.setVorteileDisziplinenBezeichnung(vorteileDisziplinenBezeichnung);vampChar.setVorteileDisziplinenWert(vorteileDisziplinenWert);

        resultSet = vampCharData.vorteileHintergrundSearchById(id);
        i = 0;
        resultSet.last();
        String[] vorteileHintergrundBezeichnung = new String[resultSet.getRow()];
        int[] vorteileHintergrundWert = new int[resultSet.getRow()];
        resultSet.first();
        while (resultSet.next()){
            vorteileHintergrundBezeichnung[i] = resultSet.getString("bezeichnung");
            vorteileHintergrundWert[i++] = resultSet.getInt("value");
        }vampChar.setVorteileHintergrundBezeichnung(vorteileHintergrundBezeichnung);vampChar.setVorteileHintergrundWert(vorteileHintergrundWert);

        resultSet = vampCharData.vorteileTugendenSearchById(id);
        i = 0;
        resultSet.last();
        boolean[] vorteileTugendenEntscheidung = new boolean[resultSet.getRow()];
        int[] vorteileTugenden = new int[resultSet.getRow()];
        resultSet.first();
        while (resultSet.next()){
            vorteileTugendenEntscheidung[i] = resultSet.getBoolean("entscheidung");
            vorteileTugenden[i++] = resultSet.getInt("value");
        }vampChar.setVorteileTugenden(vorteileTugenden);vampChar.setVorteileTugendenEntscheidung(vorteileTugendenEntscheidung);

        resultSet = vampCharData.andereEigenschaftenSearchById(id);
        i = 0;
        resultSet.last();
        String[] andereEigenschaftenBezeichnung = new String[resultSet.getRow()];
        int[] andereEigenschaftenWert = new int[resultSet.getRow()];
        resultSet.first();
        while (resultSet.next()){
            andereEigenschaftenBezeichnung[i] = resultSet.getString("bezeichnung");
            andereEigenschaftenWert[i++] = resultSet.getInt("value");
        }vampChar.setAndereEigenschaftenBezeichnung(andereEigenschaftenBezeichnung);vampChar.setAndereEigenschaftenWert(andereEigenschaftenWert);


        resultSet.close();
        return vampChar;
    }


    //////////////////////////////////////////
    // Setter
    //////////////////////////////////////////

}