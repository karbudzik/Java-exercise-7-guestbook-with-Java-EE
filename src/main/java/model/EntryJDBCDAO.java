package model;

import connection.ConnectionCreator;

import java.sql.*;
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

    @Override
    public void insertNewEntry(Entry entry) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO entries (author_name, author_city, entry_content, entry_date) VALUES (?, ?, ?, ?);");
            statement.setString(1, entry.getName());
            statement.setString(2, entry.getCity());
            statement.setString(3, entry.getContent());
            statement.setDate(4, (Date) entry.getDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
