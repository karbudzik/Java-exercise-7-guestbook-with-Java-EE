package model;

import connection.ConnectionCreator;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class EntryJDBCDAO implements EntryDAO {

    private Connection getConnection() {
        ConnectionCreator connector = new ConnectionCreator();
        return connector.getConnection();
    }

    @Override
    public List<Entry> getAllEntries() {
        return new ArrayList<>();
    }
}
