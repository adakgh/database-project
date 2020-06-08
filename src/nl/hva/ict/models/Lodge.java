package nl.hva.ict.models;

import nl.hva.ict.data.Identifable;

import java.io.Serializable;

public class Lodge extends Accommodatie implements Identifable, Serializable {

    private double prijs;
    private boolean autoHuur;

    public Lodge (String accommodatieCode, String naam, String stad, String land, double prijs, String kamer, int personen, boolean autoHuur, String soort) {
        super(accommodatieCode, naam, stad, land, kamer, personen, soort);
        this.prijs = prijs;
        this.autoHuur = autoHuur;
    }


    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public boolean isAutoHuur() {
        return autoHuur;
    }

    public void setAutoHuur(boolean autoHuur) {
        this.autoHuur = autoHuur;
    }

    @Override
    public String toString() {
        return super.getAccommodatieCode() + " is een " + super.getKamer();
    }
}
