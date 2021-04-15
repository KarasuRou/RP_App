package data;

import java.sql.ResultSet;

public class Vamp_CharData {

    private final dbConnection conn;

    public Vamp_CharData(){
        conn = new dbConnection();
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

    public ResultSet getVampireCharCount() throws Exception{
        String query = "SELECT COUNT(id) AS anzahl FROM Vampire_Charakter;";
        System.out.println(query);
        return conn.executeSelectQuery(query);
    }

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
}
