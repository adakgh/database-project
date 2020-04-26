package nl.hva.ict.data.MySQL;

import nl.hva.ict.models.Hotel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLHotels extends MySQL<Hotel> {
    private List<Hotel> hotels;

    public MySQLHotels() {
        hotels = new ArrayList<>();
        load();
    }

    private void load() {

        String sql = "SELECT * FROM Hotel INNER JOIN Accommodatie ON `hotel`.accommodatieCode = `accommodatie`.accommodatieCode";

        try {
            PreparedStatement ps = getStatement(sql);
            ResultSet rs = executeSelectPreparedStatement(ps);

            while (rs.next()) {
                String accommodatieCode = rs.getString("accommodatieCode");
                String naam = rs.getString("naam");
                String stad = rs.getString("stad");
                String land = rs.getString("land");
                double prijsPerNacht = rs.getDouble("prijsPerNacht");
                String kamer = rs.getString("kamer");
                int personen = rs.getInt("personen");
                boolean ontbijt = rs.getBoolean("ontbijt");

                Hotel hotel = new Hotel(accommodatieCode, naam, stad, land, prijsPerNacht, kamer, personen, ontbijt);
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Hotel> getAll() {
        return hotels;
    }

    @Override
    public Hotel get(String id) {
        return null;
    }

    @Override
    public void add(Hotel object) {

    }

    @Override
    public void update(Hotel object) {

    }

    @Override
    public void remove(Hotel object) {

    }

    public void reload() {
        hotels.clear();
        load();
    }

}