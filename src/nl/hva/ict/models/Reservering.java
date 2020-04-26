package nl.hva.ict.models;

public class Reservering {

    private int idReservering;
    private String accommodatieCode;
    private String reizigersCode;
    private String aankomstDatum;
    private String vertrekDatum;
    private boolean betaald;

    public Reservering(int idReservering, String accommodatieCode, String reizigersCode, String aankomstDatum, String vertrekDatum, boolean betaald) {
        this.idReservering = idReservering;
        this.accommodatieCode = accommodatieCode;
        this.reizigersCode = reizigersCode;
        this.aankomstDatum = aankomstDatum;
        this.vertrekDatum = vertrekDatum;
        this.betaald = betaald;
    }

    public Reservering() {
    }

    public int getIdReservering() {
        return idReservering;
    }

    public void setIdReservering(int idReservering) {
        this.idReservering = idReservering;
    }

    public String getAccommodatieCode() {
        return accommodatieCode;
    }

    public void setAccommodatieCode(String accommodatieCode) {
        this.accommodatieCode = accommodatieCode;
    }

    public String getReizigersCode() {
        return reizigersCode;
    }

    public void setReizigersCode(String reizigersCode) {
        this.reizigersCode = reizigersCode;
    }

    public String getAankomstDatum() {
        return aankomstDatum;
    }

    public void setAankomstDatum(String aankomstDatum) {
        this.aankomstDatum = aankomstDatum;
    }

    public String getVertrekDatum() {
        return vertrekDatum;
    }

    public void setVertrekDatum(String vertrekDatum) {
        this.vertrekDatum = vertrekDatum;
    }

    public boolean isBetaald() {
        return betaald;
    }

    public void setBetaald(boolean betaald) {
        this.betaald = betaald;
    }

    @Override
    public String toString() {
        return "Reservering " + idReservering + " is gemaakt door " + reizigersCode + " en vertrekt op " + vertrekDatum + " en komt terug op " + aankomstDatum + ". \n Betaald: " + betaald;
    }
}
