package nl.hva.ict.models;

import nl.hva.ict.data.Identifable;

import java.io.Serializable;

public class Hotel extends Accommodatie implements Identifable, Serializable {

    private double prijs;
    private int personen;
    private boolean ontbijt;

    public Hotel(String accommodatieCode, String naam, String stad, String land, double prijs, String kamer, int personen, boolean ontbijt, String soort) {
        super(accommodatieCode, naam, stad, land, kamer, personen, soort);
        this.prijs = prijs;
        this.personen = personen;
        this.ontbijt = ontbijt;
    }


    public int getPersonen() {
        return personen;
    }

    public void setPersonen(int personen) {
        this.personen = personen;
    }

    public boolean isOntbijt() {
        return ontbijt;
    }

    public double getPrijs() {
        return prijs;
    }

    @Override
    public String toString() {
        return super.getAccommodatieCode() + " is een " + super.getKamer();
    }
}
