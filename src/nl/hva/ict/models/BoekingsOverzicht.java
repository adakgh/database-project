package nl.hva.ict.models;

import nl.hva.ict.data.Identifable;

public class BoekingsOverzicht implements Identifable {

    private Reiziger reiziger;
    private Accommodatie accommodatie;
    private Reservering reservering;

    public BoekingsOverzicht(Reiziger reiziger, Accommodatie accommodatie, Reservering reservering) {
        this.reiziger = reiziger;
        this.accommodatie = accommodatie;
        this.reservering = reservering;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    public Reservering getReservering() {
        return reservering;
    }

    public void setReservering(Reservering reservering) {
        this.reservering = reservering;
    }

    public Accommodatie getAccommodatie() {
        return accommodatie;
    }

    public void setAccommodatie(Accommodatie accommodatie) {
        this.accommodatie = accommodatie;
    }

    @Override
    public String toString() {
        return reiziger.getVoornaam() + " " + reiziger.getAchternaam() + " - reist tot " + reservering.getAankomstDatum() + " en verblijft in: " + accommodatie.getNaam() + " in "
                + accommodatie.getStad() + " - " + accommodatie.getLand() + " voor " + reservering.getVerblijving() + " dagen" ;
    }
}
