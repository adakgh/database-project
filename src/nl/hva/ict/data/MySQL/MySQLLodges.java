package nl.hva.ict.data.MySQL;

import nl.hva.ict.models.Lodge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLLodges extends MySQL<Lodge> {
    private List<Lodge> lodges;

    public MySQLLodges() {
        lodges = new ArrayList<>();
        load();
    }

    private void load() {

        String sql = "SELECT * FROM Lodge INNER JOIN Accommodatie ON `lodge`.accommodatieCode = `accommodatie`.accommodatieCode";

        try {
            PreparedStatement ps = getStatement(sql);
            ResultSet rs = executeSelectPreparedStatement(ps);

            while (rs.next()) {
                String accommodatieCode = rs.getString("accommodatieCode");
                String naam = rs.getString("naam");
                String stad = rs.getString("stad");
                String land = rs.getString("land");
                double prijsPerWeek = rs.getDouble("prijsPerWeek");
                String kamer = rs.getString("kamer");
                int personen = rs.getInt("personen");
                boolean autoHuur = rs.getBoolean("autoHuur");

                Lodge lodge = new Lodge(accommodatieCode, naam, stad, land, prijsPerWeek, kamer, personen, autoHuur);
                lodges.add(lodge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Lodge> getAll() {
        return lodges;
    }

    @Override
    public Lodge get(String id) {
        return null;
    }

    @Override
    public void add(Lodge object) {

    }

    @Override
    public void update(Lodge object) {

    }

    @Override
    public void remove(Lodge object) {

    }

    public void reload() {
        lodges.clear();
        load();
    }

}