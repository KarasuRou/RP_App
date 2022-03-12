package data;

import java.sql.ResultSet;

public class Vamp_CharData {

    private final dbConnection conn;

    public Vamp_CharData(){
        conn = new dbConnection();
    }

    ////////////////////////////////
    // GETTER
    ////////////////////////////////
    public ResultSet playerInfoSearchById(int id) throws Exception {
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet clansschwaecheSearchById(int id) throws Exception {
        String query = "SELECT * FROM Vampire_Charakter_clansschwaeche WHERE f_id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet attributeKoerperlichSearchById(int id) throws Exception {
        String query = "SELECT * FROM Vampire_Charakter_attributeKoerperlich WHERE f_id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet attributeGesellschaftlichSearchById(int id) throws Exception {
        String query = "SELECT * FROM Vampire_Charakter_attributeGesellschaftlich WHERE f_id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet attributeGeistigSearchById(int id) throws Exception {
        String query = "SELECT * FROM Vampire_Charakter_attributeGeistig WHERE f_id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet faehigkeitenTalenteSearchById(int id) throws Exception {
        String query = "SELECT * FROM Vampire_Charakter_faehigkeitenTalente WHERE f_id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet faehigkeitenFertigkeitenSearchById(int id) throws Exception {
        String query = "SELECT * FROM Vampire_Charakter_faehigkeitenFertigkeiten WHERE f_id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet faehigkeitenKenntnisseSearchById(int id) throws Exception {
        String query = "SELECT * FROM Vampire_Charakter_faehigkeitenKenntnisse WHERE f_id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet vorteileDisziplinenSearchById(int id) throws Exception {
        String query = "SELECT * FROM Vampire_Charakter_vorteileDisziplinen WHERE f_id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet vorteileHintergrundSearchById(int id) throws Exception {
        String query = "SELECT * FROM Vampire_Charakter_vorteileHintergrund WHERE f_id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet vorteileTugendenSearchById(int id) throws Exception {
        String query = "SELECT * FROM Vampire_Charakter_vorteileTugenden WHERE f_id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet andereEigenschaftenSearchById(int id) throws Exception {
        String query = "SELECT * FROM Vampire_Charakter_andereEigenschaften WHERE f_id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet getVampireCharCount() throws Exception{
        String query = "SELECT COUNT(id) AS anzahl FROM Vampire_Charakter;";
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet getVampireCharIDs() throws Exception{
        String query = "SELECT id FROM Vampire_Charakter;";
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet getVampireCharName(int id) throws Exception{
        String query = "SELECT charName FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }
    public ResultSet getVampirePlayerName(int id) throws Exception{
        String query = "SELECT spieler FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replaceAll("%id%", String.valueOf(id));
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }


    ////////////////////////////////
    // SETTER
    ////////////////////////////////
    public int insertVampire_Char(
            String charName, String spieler, String wesen, String verhalten, String clan, int generation, String zuflucht,
            String weg, int wegWert, String aura, int auraWert, boolean auraAnzeigen, int willenskraft, int willenskraftPool,
            int blutvorrat, int gesundheit, int erfahrung
    ) throws Exception{
        int id = 0;
        auraWert = wegWert;
        String query = "INSERT INTO Vampire_Charakter (charName, spieler, wesen, verhalten, clan, generation, zuflucht, " +
                "weg, wegWert, aura,auraWert, auraAnzeigen, willenskraft, willenskraftPool, blutvorrat, gesundheit, erfahrung)" +
                " VALUES ('%charName%', '%spieler%', '%wesen%', '%verhalten%', '%clan%', %generation%, '%zuflucht%', '%weg%', %wegWert%, '%aura%', %auraWert%, " +
                "%auraAnzeigen%, %willenskraft%, %willenskraftPool%, %blutvorrat%, %gesundheit%, %erfahrung%);";
        query = query.replace("%charName%", charName).replace("%spieler%", spieler).replace("%wesen%", wesen)
                .replace("%verhalten%", verhalten).replace("%clan%",clan).replace("%generation%",String.valueOf(generation))
                .replace("%zuflucht%",zuflucht).replace("%weg%",weg).replace("%wegWert%",String.valueOf(wegWert))
                .replace("%aura%",aura).replace("%auraWert%",String.valueOf(auraWert))
                .replace("%auraAnzeigen%",String.valueOf(auraAnzeigen ? 1 : 0)).replace("%willenskraft%",String.valueOf(willenskraft))
                .replace("%willenskraftPool%",String.valueOf(willenskraftPool)).replace("%blutvorrat%",String.valueOf(blutvorrat))
                .replace("%gesundheit%",String.valueOf(gesundheit)).replace("%erfahrung%",String.valueOf(erfahrung));
        System.out.print(query);
        ResultSet resultSet = conn.executeInsertQuery(query);
        if (resultSet.next())
            id = resultSet.getInt(1);
        System.out.println("=> new id=" + id);
        return id;
    }
    public void insertVampireAttributeKoerperlich(int id, int[] attributeKoerperlich) throws Exception{
        for (int koerperlich : attributeKoerperlich) {
            String query = "INSERT INTO Vampire_Charakter_attributeKoerperlich (f_id, value) values (%id% ,%VALUE%)";
            query = query.replace("%id%", String.valueOf(id)).replace("%VALUE%", String.valueOf(koerperlich));
            System.out.println(query);
            conn.executeInsertQuery(query);
        }
    }
    public void insertVampireAttributeGesellschaftlich(int id, int[] attributeGesellschaftlich) throws Exception{
        for (int gesellschaftlich : attributeGesellschaftlich) {
            String query = "INSERT INTO Vampire_Charakter_attributeGesellschaftlich (f_id, value) values (%id% ,%VALUE%)";
            query = query.replace("%id%", String.valueOf(id)).replace("%VALUE%", String.valueOf(gesellschaftlich));
            System.out.println(query);
            conn.executeInsertQuery(query);
        }
    }
    public void insertVampireAttributeGeistig(int id, int[] attributeGeistig) throws Exception{
        for (int j : attributeGeistig) {
            String query = "INSERT INTO Vampire_Charakter_attributeGeistig (f_id, value) values (%id% ,%VALUE%)";
            query = query.replace("%id%", String.valueOf(id)).replace("%VALUE%", String.valueOf(j));
            System.out.println(query);
            conn.executeInsertQuery(query);
        }
    }
    public void insertVampireFaehigkeitenTalente(int id, int[] faehigkeitenTalente) throws Exception{
        for (int j : faehigkeitenTalente) {
            String query = "INSERT INTO Vampire_Charakter_faehigkeitenTalente (f_id, value) values (%id% ,%VALUE%)";
            query = query.replace("%id%", String.valueOf(id)).replace("%VALUE%", String.valueOf(j));
            System.out.println(query);
            conn.executeInsertQuery(query);
        }
    }
    public void insertVampireFaehigkeitenFertigkeiten(int id, int[] faehigkeitenFertigkeiten) throws Exception{
        for (int j : faehigkeitenFertigkeiten) {
            String query = "INSERT INTO Vampire_Charakter_faehigkeitenFertigkeiten (f_id, value) values (%id% ,%VALUE%)";
            query = query.replace("%id%", String.valueOf(id)).replace("%VALUE%", String.valueOf(j));
            System.out.println(query);
            conn.executeInsertQuery(query);
        }
    }
    public void insertVampireFaehigkeitenKenntnisse(int id, int[] faehigkeitenKenntnisse) throws Exception{
        for (int j : faehigkeitenKenntnisse) {
            String query = "INSERT INTO Vampire_Charakter_faehigkeitenKenntnisse (f_id, value) values (%id% ,%VALUE%)";
            query = query.replace("%id%", String.valueOf(id)).replace("%VALUE%", String.valueOf(j));
            System.out.println(query);
            conn.executeInsertQuery(query);
        }
    }
    public void insertVampireClansschweache(int id, String[] clansschweache) throws Exception {
        for (String s : clansschweache) {
            String query = "INSERT INTO Vampire_Charakter_clansschwaeche (f_id, value) values (%id% , '%VALUE%')";
            query = query.replace("%id%", String.valueOf(id)).replace("%VALUE%", s);
            System.out.println(query);
            conn.executeInsertQuery(query);
        }
    }
    public void insertVampireVorteileDisziplinen(int id, String[] vorteileDisziplinenBezeichnung, int[] vorteileDisziplinenWert) throws Exception {
        for (int i = 0; i < vorteileDisziplinenWert.length; i++) {
            String query = "INSERT INTO Vampire_Charakter_vorteileDisziplinen (f_id, value, bezeichnung) values (%id% , %V1%, '%V2%')";
            query = query.replace("%id%", String.valueOf(id))
                    .replace("%V1%", String.valueOf(vorteileDisziplinenWert[i]))
                    .replace("%V2%", vorteileDisziplinenBezeichnung[i]);
            System.out.println(query);
            conn.executeInsertQuery(query);
        }
    }
    public void insertVampireVorteileHintergrund(int id, String[] vorteileHintergrundBezeichnung, int[] vorteileHintergrundWert) throws Exception{
        for (int i = 0; i < vorteileHintergrundWert.length; i++) {
            String query = "INSERT INTO Vampire_Charakter_vorteileHintergrund (f_id, value, bezeichnung) values (%id% , %V1%, '%V2%')";
            query = query.replace("%id%", String.valueOf(id))
                    .replace("%V1%", String.valueOf(vorteileHintergrundWert[i]))
                    .replace("%V2%", vorteileHintergrundBezeichnung[i]);
            System.out.println(query);
            conn.executeInsertQuery(query);
        }
    }
    public void insertVampireVorteileTugenden(int id, int[] vorteileTugenden, boolean[] vorteileTugendenEntscheidung) throws Exception{
        for (int i = 0; i < vorteileTugenden.length; i++) {
            String query = "";
            if (i == 2){
               query =  "INSERT INTO Vampire_Charakter_vorteileTugenden (f_id, value) values (%id% , %V1%)";
               query = query.replace("%id%", String.valueOf(id))
                        .replace("%V1%", String.valueOf(vorteileTugenden[i]));

            }
            else {
                query = "INSERT INTO Vampire_Charakter_vorteileTugenden (f_id, value, entscheidung) values (%id% , %V1%, %V2%)";
                query = query.replace("%id%", String.valueOf(id))
                        .replace("%V1%", String.valueOf(vorteileTugenden[i]))
                        .replace("%V2%", String.valueOf(vorteileTugendenEntscheidung[i] ? 1 : 0));
            }
            System.out.println(query);
            conn.executeInsertQuery(query);
        }
    }
    public void insertVampireAndereEigenschaften(int id, String[] andereEigenschaftenBezeichnung, int[] andereEigenschaftenWert) throws Exception{
        for (int i = 0; i < andereEigenschaftenWert.length; i++) {
            String query = "INSERT INTO Vampire_Charakter_andereEigenschaften (f_id, value, bezeichnung) values (%id% , %V1%, '%V2%')";
            query = query.replace("%id%", String.valueOf(id))
                    .replace("%V1%", String.valueOf(andereEigenschaftenWert[i]))
                    .replace("%V2%", andereEigenschaftenBezeichnung[i]);
            System.out.println(query);
            conn.executeInsertQuery(query);
        }
    }


    ////////////////////////////////
    // UPDATER
    ////////////////////////////////
    public void updateVampireCharName(int id, String charName) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getString("charName"),charName,"charName")) {
            resultSet.updateString("charName",charName);
            resultSet.updateRow();
        }
    }
    public void updateVampireSpieler(int id, String spieler) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getString("spieler"),spieler,"spieler")) {
            resultSet.updateString("spieler",spieler);
            resultSet.updateRow();
        }
    }
    public void updateVampireWesen(int id, String wesen) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getString("wesen"),wesen,"wesen")) {
            resultSet.updateString("wesen",wesen);
            resultSet.updateRow();
        }
    }
    public void updateVampireVerhalten(int id, String verhalten) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getString("verhalten"),verhalten,verhalten)) {
            resultSet.updateString("verhalten",verhalten);
            resultSet.updateRow();
        }
    }
    public void updateVampireClan(int id, String clan) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getString("clan"),clan,"clan")) {
            resultSet.updateString("clan",clan);
            resultSet.updateRow();
        }
    }
    public void updateVampireGeneration(int id, int generation) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getInt("generation"),generation,"generation")) {
            resultSet.updateInt("generation",generation);
            resultSet.updateRow();
        }
    }
    public void updateVampireZuflucht(int id, String zuflucht) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getString("zuflucht"),zuflucht,"zuflucht")) {
            resultSet.updateString("zuflucht",zuflucht);
            resultSet.updateRow();
        }
    }
    public void updateVampireAttributeKoerperlich(int id, int[] attributeKoerperlich) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter_attributeKoerperlich WHERE f_id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        int i = 0;
        while (resultSet.next()) {
            if (updateMessage(resultSet.getInt("value"),attributeKoerperlich[i],"attributeKoerperlich")) {
                resultSet.updateInt("value", attributeKoerperlich[i]);
                resultSet.updateRow();
            }
            i++;
        }
    }
    public void updateVampireAttributeGesellschaftlich(int id, int[] attributeGesellschaftlich) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter_attributeGesellschaftlich WHERE f_id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        int i = 0;
        while (resultSet.next()) {
            if (updateMessage(resultSet.getInt("value"),attributeGesellschaftlich[i],"attributeGesellschaftlich")) {
                resultSet.updateInt("value", attributeGesellschaftlich[i]);
                resultSet.updateRow();
            }
            i++;
        }
    }
    public void updateVampireAttributeGeistig(int id, int[] attributeGeistig) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter_attributeGeistig WHERE f_id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        int i = 0;
        while (resultSet.next()) {
            if (updateMessage(resultSet.getInt("value"),attributeGeistig[i],"attributeGeistig")) {
                resultSet.updateInt("value", attributeGeistig[i]);
                resultSet.updateRow();
            }
            i++;
        }
    }
    public void updateVampireFaehigkeitenTalente(int id, int[] faehigkeitenTalente) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter_faehigkeitenTalente WHERE f_id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        int i = 0;
        while (resultSet.next()) {
            if (updateMessage(resultSet.getInt("value"),faehigkeitenTalente[i],"faehigkeitenTalente")) {
                resultSet.updateInt("value", faehigkeitenTalente[i]);
                resultSet.updateRow();
            }
            i++;
        }
    }
    public void updateVampireFaehigkeitenFertigkeiten(int id, int[] faehigkeitenFertigkeiten) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter_faehigkeitenFertigkeiten WHERE f_id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        int i = 0;
        while (resultSet.next()) {
            if (updateMessage(resultSet.getInt("value"),faehigkeitenFertigkeiten[i],"faehigkeitenFertigkeiten")) {
                resultSet.updateInt("value", faehigkeitenFertigkeiten[i]);
                resultSet.updateRow();
            }
            i++;
        }
    }
    public void updateVampireFaehigkeitenKenntnisse(int id, int[] faehigkeitenKenntnisse) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter_faehigkeitenKenntnisse WHERE f_id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        int i = 0;
        while (resultSet.next()) {
            if (updateMessage(resultSet.getInt("value"),faehigkeitenKenntnisse[i],"faehigkeitenKenntnisse")) {
                resultSet.updateInt("value", faehigkeitenKenntnisse[i]);
                resultSet.updateRow();
            }
            i++;
        }
    }
    public void updateVampireVorteileDisziplinen(int id, String[] vorteileDisziplinenBezeichnung, int[] vorteileDisziplinenWert) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter_vorteileDisziplinen WHERE f_id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        int i = 0;
        while (resultSet.next()) {
            if (updateMessage(resultSet.getString("bezeichnung"),vorteileDisziplinenBezeichnung[i],"vorteileDisziplinen") ||
                    updateMessage(resultSet.getInt("value"),vorteileDisziplinenWert[i],"vorteileDisziplinen")) {
                resultSet.updateString("bezeichnung", vorteileDisziplinenBezeichnung[i]);
                resultSet.updateInt("value", vorteileDisziplinenWert[i]);
                resultSet.updateRow();
            }
            i++;
        }
    }
    public void updateVampireVorteileHintergrund(int id, String[] vorteileHintergrundBezeichnung, int[] vorteileHintergrundWert) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter_vorteileHintergrund WHERE f_id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        int i = 0;
        while (resultSet.next()) {
            if (updateMessage(resultSet.getString("bezeichnung"),vorteileHintergrundBezeichnung[i],"vorteileHintergrund") ||
                    updateMessage(resultSet.getInt("value"),vorteileHintergrundWert[i],"vorteileHintergrund")) {
                resultSet.updateString("bezeichnung", vorteileHintergrundBezeichnung[i]);
                resultSet.updateInt("value", vorteileHintergrundWert[i]);
                resultSet.updateRow();
            }
            i++;
        }
    }
    public void updateVampireVorteileTugenden(int id, int[] vorteileTugenden, boolean[] vorteileTugendenEntscheidung) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter_vorteileTugenden WHERE f_id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        int i = 0;
        while (resultSet.next()) {
            if (i != 2) {
                if (updateMessage(resultSet.getBoolean("entscheidung"),vorteileTugendenEntscheidung[i],"vorteileTugenden") ||
                        updateMessage(resultSet.getInt("value"),vorteileTugenden[i],"vorteileTugenden")) {
                    resultSet.updateBoolean("entscheidung", vorteileTugendenEntscheidung[i]);
                    resultSet.updateInt("value", vorteileTugenden[i]);
                    resultSet.updateRow();
                }
            } else {
                if (updateMessage(resultSet.getInt("value"),vorteileTugenden[i],"vorteileTugend")) {
                resultSet.updateInt("value", vorteileTugenden[i]);
                resultSet.updateRow();
                }
            }
            i++;
        }
    }
    public void updateVampireAndereEigenschaften(int id, String[] andereEigenschaftenBezeichnung, int[] andereEigenschaftenWert) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter_andereEigenschaften WHERE f_id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        int i = 0;
        while (resultSet.next()) {
            if (updateMessage(resultSet.getString("bezeichnung"),andereEigenschaftenBezeichnung[i],"andereEigenschaften") ||
                    updateMessage(resultSet.getInt("value"),andereEigenschaftenWert[i],"andereEigenschaften")) {
                resultSet.updateString("bezeichnung", andereEigenschaftenBezeichnung[i]);
                resultSet.updateInt("value", andereEigenschaftenWert[i]);
                resultSet.updateRow();
            }
            i++;
        }
    }
    public void updateVampireClansschweache(int id, String[] clansschweache) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter_clansschwaeche WHERE f_id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        int i = 0;
        while (resultSet.next()) {
            if (updateMessage(resultSet.getString("value"),clansschweache[i],"clansschweache")) {
                resultSet.updateString("value", clansschweache[i]);
                resultSet.updateRow();
            }
            i++;
        }
    }
    public void updateVampireWeg(int id, String weg) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getString("weg"),weg,"weg")) {
            resultSet.updateString("weg",weg);
            resultSet.updateRow();
        }
    }
    public void updateVampireWegWert(int id, int wegWert) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getInt("wegWert"),wegWert,"wegWert")) {
            resultSet.updateInt("wegWert",wegWert);
            resultSet.updateRow();
        }
    }
    public void updateVampireAura(int id, String aura) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getString("aura"),aura,"aura")) {
            resultSet.updateString("aura",aura);
            resultSet.updateRow();
        }
    }
    public void updateVampireAuraWert(int id, int auraWert) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getInt("auraWert"),auraWert,"auraWert")) {
            resultSet.updateInt("auraWert",auraWert);
            resultSet.updateRow();
        }
    }
    public void updateVampireAuraAnzeigen(int id, boolean auraAnzeigen) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getBoolean("auraAnzeigen"),auraAnzeigen,"auraAnzeigen")) {
            resultSet.updateBoolean("auraAnzeigen",auraAnzeigen);
            resultSet.updateRow();
        }
    }
    public void updateVampireWillenskraft(int id, int willenskraft) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getInt("willenskraft"),willenskraft,"willenskraft")) {
            resultSet.updateInt("willenskraft",willenskraft);
            resultSet.updateRow();
        }
    }
    public void updateVampireWillenskraftPool(int id, int willenskraftPool) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getInt("willenskraftPool"),willenskraftPool,"willenskraftPool")) {
            resultSet.updateInt("willenskraftPool",willenskraftPool);
            resultSet.updateRow();
        }
    }
    public void updateVampireBlutvorrat(int id, int blutvorrat) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getInt("blutvorrat"),blutvorrat,"blutvorrat")) {
            resultSet.updateInt("blutvorrat",blutvorrat);
            resultSet.updateRow();
        }
    }
    public void updateVampireGesundheit(int id, int gesundheit) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getInt("gesundheit"),gesundheit,"gesundheit")) {
            resultSet.updateInt("gesundheit",gesundheit);
            resultSet.updateRow();
        }
    }
    public void updateVampireErfahrung(int id, int erfahrung) throws Exception{
        String query = "SELECT * FROM Vampire_Charakter WHERE id = %id%;";
        query = query.replace("%id%", String.valueOf(id));
        ResultSet resultSet = conn.executeUpdateSelectQuery(query);
        if (resultSet.next() && updateMessage(resultSet.getInt("erfahrung"),erfahrung, "erfahrung")) {
            resultSet.updateInt("erfahrung",erfahrung);
            resultSet.updateRow();
        }
    }


    //////
    private boolean updateMessage(Object before, Object after, String source){
        if (!before.equals(after)) {
            System.out.println("(" + source + ")Update: \"" + before + "\" to -> \"" + after + "\"");
            return true;
        } else {
            return false;
        }
    }
}
