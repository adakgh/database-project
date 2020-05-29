package nl.hva.ict.models;

import java.util.Date;

public class Reservering {

    private int idReservering;
    private String accommodatieCode;
    private String reizigersCode;
    private Date aankomstDatum;
    private Date vertrekDatum;
    private boolean betaald;
    private int verblijving;

    public Reservering(int idReservering, String accommodatieCode, String reizigersCode, Date aankomstDatum, Date vertrekDatum, boolean betaald) {
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

    public Date getAankomstDatum() {
        return aankomstDatum;
    }

    public void setAankomstDatum(Date aankomstDatum) {
        this.aankomstDatum = aankomstDatum;
    }

    public Date getVertrekDatum() {
        return vertrekDatum;
    }

    public void setVertrekDatum(Date vertrekDatum) {
        this.vertrekDatum = vertrekDatum;
    }

    public boolean isBetaald() {
        return betaald;
    }

    public void setBetaald(boolean betaald) {
        this.betaald = betaald;
    }

    public int getVerblijving() {
        return verblijving;
    }

    public void setVerblijving(int verblijving) {
        this.verblijving = verblijving;
    }

    @Override
    public String toString() {
        return "Reservering " + idReservering + " is gemaakt door " + reizigersCode + " en vertrekt op " + vertrekDatum + " en komt terug op " + aankomstDatum + ". \n Betaald: " + betaald;
    }
}
