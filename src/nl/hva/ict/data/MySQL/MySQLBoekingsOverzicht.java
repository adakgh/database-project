package nl.hva.ict.data.MySQL;

import nl.hva.ict.models.Accommodatie;
import nl.hva.ict.models.BoekingsOverzicht;
import nl.hva.ict.models.Reiziger;
import nl.hva.ict.models.Reservering;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySQLBoekingsOverzicht extends MySQL<BoekingsOverzicht> {
    private List<BoekingsOverzicht> boekingsOverzicht;

    public MySQLBoekingsOverzicht() {
        boekingsOverzicht = new ArrayList<>();
        load();
    }

    public void load(){
        String sql = "SELECT Reservering.*, Accommodatie.*, Reiziger.* " +
                "FROM ((Reservering INNER JOIN Accommodatie ON Reservering.accommodatieCode = Accommodatie.accommodatieCode) " +
                "INNER JOIN Reiziger ON Reservering.Reizigerscode = Reiziger.Reizigerscode)";

        try {
            PreparedStatement ps = getStatement(sql);
            ResultSet rs = executeSelectPreparedStatement(ps);

            while (rs.next()) {
                int idReservering = rs.getInt("idReservering");
                Date aankomstDatum = rs.getDate("aankomstDatum");
                Date vertrekDatum = rs.getDate("vertrekDatum");
                boolean betaald = rs.getBoolean("betaald");
                String accommodatieCode = rs.getString("accommodatieCode");
                String reizigersCode = rs.getString("reizigersCode");
                String voornaam = rs.getString("voornaam");
                String achternaam = rs.getString("achternaam");
                String adres = rs.getString("adres");
                String postcode = rs.getString("postcode");
                String plaats = rs.getString("plaats");
                String land = rs.getString("land");
                String hoofdreiziger = rs.getString("hoofdreiziger");

                String accommodatieNaam = rs.getString("naam");
                String accommodatieStad = rs.getString("stad");
                String accommodatieLand = rs.getString("land");
                String accommodatieType = rs.getString("soort");

                Reservering reservering = new Reservering(idReservering, accommodatieCode, reizigersCode, aankomstDatum, vertrekDatum, betaald);
                Reiziger reiziger = new Reiziger(reizigersCode, voornaam, achternaam, adres, postcode, plaats, land, hoofdreiziger);
                Accommodatie accommodatie = new Accommodatie();
                accommodatie.setNaam(accommodatieNaam);
                accommodatie.setStad(accommodatieStad);
                accommodatie.setLand(accommodatieLand);

                boekingsOverzicht.add(new BoekingsOverzicht(reiziger, accommodatie, reservering));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<BoekingsOverzicht> getBoekingVoor(String Reizigerscode) {

        List<BoekingsOverzicht> boekingVoor = new ArrayList<>();

        String sql = "SELECT Reservering.*, Accommodatie.naam, Accommodatie.stad, Accommodatie.land, Accommodatie.soort, Reiziger.voornaam, Reiziger.achternaam, Reiziger.plaats FROM ((Reservering INNER JOIN Accommodatie ON Reservering.accommodatieCode = Accommodatie.accommodatieCode) INNER JOIN Reiziger ON Reservering.Reizigerscode = Reiziger.Reizigerscode) WHERE Reservering.Reizigerscode = ?";

        try {
            PreparedStatement ps = getStatement(sql);
            ps.setString(1, Reizigerscode);
            ResultSet rs = executeSelectPreparedStatement(ps);

            while (rs.next()) {
                int idReservering = rs.getInt("idReservering");
                Date aankomstDatum = rs.getDate("aankomstDatum");
                Date vertrekDatum = rs.getDate("vertrekDatum");
                boolean betaald = rs.getBoolean("betaald");
                String accommodatieCode = rs.getString("accommodatieCode");
                String reizigersCode = rs.getString("reizigersCode");

                String reizigerVoornaam = rs.getString("voornaam");
                String reizigerAchternaam = rs.getString("achternaam");
                String reizigerPlaats = rs.getString("plaats");
                String accommodatieNaam = rs.getString("naam");
                String accommodatieStad = rs.getString("stad");
                String accommodatieLand = rs.getString("land");
                String accommodatieType = rs.getString("soort");

                Reservering reservering = new Reservering(idReservering, accommodatieCode, reizigersCode, aankomstDatum, vertrekDatum, betaald);
                Accommodatie accommodatie = new Accommodatie();
                accommodatie.setNaam(accommodatieNaam);
                accommodatie.setStad(accommodatieStad);
                accommodatie.setLand(accommodatieLand);
                accommodatie.setSoort(accommodatieType);

                Reiziger reiziger = new Reiziger();
                reiziger.setVoornaam(reizigerVoornaam);
                reiziger.setAchternaam(reizigerAchternaam);
                reiziger.setPlaats(reizigerPlaats);

                boekingVoor.add(new BoekingsOverzicht(reiziger, accommodatie, reservering));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return boekingVoor;
    }

    public List<Reiziger> GeboektOp(String pCode, LocalDate pDatum) {

        List<Reiziger> geboektOp = new ArrayList<>();

        String sql = "SELECT * FROM Reiziger WHERE reizigerscode = GeboektOp(?, ?)";

        try {
            PreparedStatement ps = getStatement(sql);
            ps.setString(1, pCode);
            ps.setDate(2, java.sql.Date.valueOf(pDatum));
            ResultSet rs = executeSelectPreparedStatement(ps);

            while (rs.next()) {
                String reizigersCode = rs.getString("reizigersCode");
                String reizigerVoornaam = rs.getString("voornaam");
                String reizigerAchternaam = rs.getString("achternaam");
                String reizigerPlaats = rs.getString("plaats");

                Reiziger reiziger = new Reiziger();
                reiziger.setReizigersCode(reizigersCode);
                reiziger.setVoornaam(reizigerVoornaam);
                reiziger.setAchternaam(reizigerAchternaam);
                reiziger.setPlaats(reizigerPlaats);
                geboektOp.add(reiziger);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return geboektOp;
    }

    @Override
    public List<BoekingsOverzicht> getAll() {
        List<BoekingsOverzicht> boekingsOverzicht = new ArrayList<>();

        String sql = "SELECT * FROM Boekingsoverzicht";

        try {
            PreparedStatement ps = getStatement(sql);
            ResultSet rs = executeSelectPreparedStatement(ps);

            while (rs.next()) {
                String reizigersnaam = rs.getString("reizigersNaam");
                String naam = rs.getString("naam");
                String stad = rs.getString("stad");
                String land = rs.getString("land");
                String kamer = rs.getString("kamer");
                Date datum = rs.getDate("aankomstDatum");
                Integer dagen = rs.getInt("verblijving");
                boolean betaald = rs.getBoolean("betaald");

                Reiziger reiziger = new Reiziger();
                String[] split = reizigersnaam.split("\\s");
                reiziger.setVoornaam(split[0]);
                reiziger.setAchternaam(split[1]);

                Accommodatie accommodatie = new Accommodatie();
                accommodatie.setNaam(naam);
                accommodatie.setStad(stad);
                accommodatie.setLand(land);
                accommodatie.setKamer(kamer);


                Reservering reservering = new Reservering();
                reservering.setAankomstDatum(datum);
                reservering.setBetaald(betaald);
                reservering.setVerblijving(dagen);

                BoekingsOverzicht boeking = new BoekingsOverzicht(reiziger, accommodatie, reservering);
                boekingsOverzicht.add(boeking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return boekingsOverzicht;
    }

    @Override
    public BoekingsOverzicht get(String id) {
        return null;
    }

    @Override
    public void add(BoekingsOverzicht object) {

    }

    @Override
    public void update(BoekingsOverzicht object) {

    }

    @Override
    public void remove(BoekingsOverzicht object) {

    }
}
