package model;

import connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntryJDBCDAO implements EntryDAO {

    private Connection getConnection() {
        ConnectionCreator connector = new ConnectionCreator();
        return connector.getConnection();
    }

    private Entry extractEntryFromResultSet(ResultSet rs) throws SQLException {
        return new Entry(rs.getInt("entry_id"), rs.getString("author_name"),
                rs.getString("author_city"), rs.getString("entry_content"), rs.getDate("entry_date"));
    }

    @Override
    public List<Entry> getAllEntries() {
        List<Entry> entriesList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM entries;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Entry entry = extractEntryFromResultSet(rs);
                entriesList.add(entry);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return entriesList;
    }
}
