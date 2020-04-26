package nl.hva.ict.models;

import nl.hva.ict.data.Identifable;

import java.io.Serializable;

public class Lodge implements Identifable, Serializable {

    private String accommodatieCode;
    private String naam;
    private String stad;
    private String land;
    private double prijs;
    private String kamer;
    private int personen;
    private boolean autoHuur;

    public Lodge(String accommodatieCode, String naam, String stad, String land, double prijs, String kamer, int personen, boolean autoHuur) {
        this.accommodatieCode = accommodatieCode;
        this.naam = naam;
        this.stad = stad;
        this.land = land;
        this.prijs = prijs;
        this.kamer = kamer;
        this.personen = personen;
        this.autoHuur = autoHuur;
    }

    public Lodge() {
    }


    public String getAccommodatieCode() {
        return accommodatieCode;
    }

    public void setAccommodatieCode(String accommodatieCode) {
        this.accommodatieCode = accommodatieCode;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getKamer() {
        return kamer;
    }

    public void setKamer(String kamer) {
        this.kamer = kamer;
    }

    public int getPersonen() {
        return personen;
    }

    public void setPersonen(int personen) {
        this.personen = personen;
    }

    public boolean isAutoHuur() {
        return autoHuur;
    }

    public void setAutoHuur(boolean autoHuur) {
        this.autoHuur = autoHuur;
    }

    @Override
    public String toString() {
        return accommodatieCode + " is een " + kamer;
    }
}
