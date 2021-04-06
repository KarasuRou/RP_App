package model;

public class Vamp_Char {

    protected final int ID; // ONLY ONE TIME ACCESS!!

    private String charName;
    private String spieler;
    private String wesen;
    private String verhalten;
    private String clan;
    private int generation;
    private String zuflucht;
    private int[] attributeKoerperlich; // ==3 Werte
    private int[] attributeGesellschaftlich; // ==3 Werte
    private int[] attributeGeistig; // ==3 Werte
    private int[] faehigkeitenTalente; // ==10 Werte
    private int[] faehigkeitenFertigkeiten; // ==10 Werte
    private int[] faehigkeitenKenntnisse; // ==10 Werte (+1? -> Fleischwandeln? [Wulf] -> Andere eigenschaften)
    private String[] vorteileDisziplinenBezeichnung;
    private int[] vorteileDisziplinenWert;
    private String[] vorteileHintergrundBezeichnung;
    private int[] vorteileHintergrundWert;
    private boolean[] vorteileTugendenEntscheidung; // ==2 Werte
    private int[] vorteileTugenden; // ==3 Werte
    private String[] andereEigenschaftenBezeichnung;
    private int[] andereEigenschaftenWert;
    private String weg;
    private int wegWert;
    private String aura;
    private final int auraWert = wegWert;
    private boolean auraAnzeigen; // tinyint (0=false;1=true)
    private int willenskraft;
    private int willenskraftPool;
    private int blutvorrat;
    private int gesundheit;
    private int gesundheit2;
    private String[] clansschweache; // Mehrere - Stichpunkte
    private int erfahrung;

    public Vamp_Char(int id) {
        ID = id;
    } // id == 0 -> make new char and get id out of database

    public String getSpieler() {
        return spieler;
    }

    public void setSpieler(String spieler) {
        this.spieler = spieler;
    }

    public String getWesen() {
        return wesen;
    }

    public void setWesen(String wesen) {
        this.wesen = wesen;
    }

    public String getVerhalten() {
        return verhalten;
    }

    public void setVerhalten(String verhalten) {
        this.verhalten = verhalten;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getZuflucht() {
        return zuflucht;
    }

    public void setZuflucht(String zuflucht) {
        this.zuflucht = zuflucht;
    }

    public int[] getAttributeGesellschaftlich() {
        return attributeGesellschaftlich;
    }

    public void setAttributeGesellschaftlich(int[] attributeGesellschaftlich) {
        this.attributeGesellschaftlich = attributeGesellschaftlich;
    }

    public int[] getAttributeGeistig() {
        return attributeGeistig;
    }

    public void setAttributeGeistig(int[] attributeGeistig) {
        this.attributeGeistig = attributeGeistig;
    }

    public int[] getFaehigkeitenTalente() {
        return faehigkeitenTalente;
    }

    public void setFaehigkeitenTalente(int[] faehigkeitenTalente) {
        this.faehigkeitenTalente = faehigkeitenTalente;
    }

    public int[] getFaehigkeitenFertigkeiten() {
        return faehigkeitenFertigkeiten;
    }

    public void setFaehigkeitenFertigkeiten(int[] faehigkeitenFertigkeiten) {
        this.faehigkeitenFertigkeiten = faehigkeitenFertigkeiten;
    }

    public int[] getFaehigkeitenKenntnisse() {
        return faehigkeitenKenntnisse;
    }

    public void setFaehigkeitenKenntnisse(int[] faehigkeitenKenntnisse) {
        this.faehigkeitenKenntnisse = faehigkeitenKenntnisse;
    }

    public String[] getVorteileDisziplinenBezeichnung() {
        return vorteileDisziplinenBezeichnung;
    }

    public void setVorteileDisziplinenBezeichnung(String[] vorteileDisziplinenBezeichnung) {
        this.vorteileDisziplinenBezeichnung = vorteileDisziplinenBezeichnung;
    }

    public int[] getVorteileDisziplinenWert() {
        return vorteileDisziplinenWert;
    }

    public void setVorteileDisziplinenWert(int[] vorteileDisziplinenWert) {
        this.vorteileDisziplinenWert = vorteileDisziplinenWert;
    }

    public String[] getVorteileHintergrundBezeichnung() {
        return vorteileHintergrundBezeichnung;
    }

    public void setVorteileHintergrundBezeichnung(String[] vorteileHintergrundBezeichnung) {
        this.vorteileHintergrundBezeichnung = vorteileHintergrundBezeichnung;
    }

    public int[] getVorteileHintergrundWert() {
        return vorteileHintergrundWert;
    }

    public void setVorteileHintergrundWert(int[] vorteileHintergrundWert) {
        this.vorteileHintergrundWert = vorteileHintergrundWert;
    }

    public boolean[] getVorteileTugendenEntscheidung() {
        return vorteileTugendenEntscheidung;
    }

    public void setVorteileTugendenEntscheidung(boolean[] vorteileTugendenEntscheidung) {
        this.vorteileTugendenEntscheidung = vorteileTugendenEntscheidung;
    }

    public int[] getVorteileTugenden() {
        return vorteileTugenden;
    }

    public void setVorteileTugenden(int[] vorteileTugenden) {
        this.vorteileTugenden = vorteileTugenden;
    }

    public String[] getAndereEigenschaftenBezeichnung() {
        return andereEigenschaftenBezeichnung;
    }

    public void setAndereEigenschaftenBezeichnung(String[] andereEigenschaftenBezeichnung) {
        this.andereEigenschaftenBezeichnung = andereEigenschaftenBezeichnung;
    }

    public int[] getAndereEigenschaftenWert() {
        return andereEigenschaftenWert;
    }

    public void setAndereEigenschaftenWert(int[] andereEigenschaftenWert) {
        this.andereEigenschaftenWert = andereEigenschaftenWert;
    }

    public String getWeg() {
        return weg;
    }

    public void setWeg(String weg) {
        this.weg = weg;
    }

    public int getWegWert() {
        return wegWert;
    }

    public void setWegWert(int wegWert) {
        this.wegWert = wegWert;
    }

    public int getAuraWert() {
        return auraWert;
    }

    public boolean isAuraAnzeigen() {
        return auraAnzeigen;
    }

    public void setAuraAnzeigen(boolean auraAnzeigen) {
        this.auraAnzeigen = auraAnzeigen;
    }

    public int getWillenskraft() {
        return willenskraft;
    }

    public void setWillenskraft(int willenskraft) {
        this.willenskraft = willenskraft;
    }

    public int getWillenskraftPool() {
        return willenskraftPool;
    }

    public void setWillenskraftPool(int willenskraftPool) {
        this.willenskraftPool = willenskraftPool;
    }

    public int getBlutvorrat() {
        return blutvorrat;
    }

    public void setBlutvorrat(int blutvorrat) {
        this.blutvorrat = blutvorrat;
    }

    public int getGesundheit() {
        return gesundheit;
    }

    public void setGesundheit(int gesundheit) {
        this.gesundheit = gesundheit;
    }

    public String[] getClansschweache() {
        return clansschweache;
    }

    public void setClansschweache(String[] clansschweache) {
        this.clansschweache = clansschweache;
    }

    public int getErfahrung() {
        return erfahrung;
    }

    public void setErfahrung(int erfahrung) {
        this.erfahrung = erfahrung;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getGesundheit2() {
        return gesundheit2;
    }

    public void setGesundheit2(int gesundheit2) {
        this.gesundheit2 = gesundheit2;
    }

    public String getAura() {
        return aura;
    }

    public void setAura(String aura) {
        this.aura = aura;
    }

    public int[] getAttributeKoerperlich() {
        return attributeKoerperlich;
    }

    public void setAttributeKoerperlich(int[] attributeKoerperlich) {
        this.attributeKoerperlich = attributeKoerperlich;
    }

    public int getID() {
        return ID;
    }
}
