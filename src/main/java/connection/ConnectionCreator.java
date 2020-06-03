package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.postgresql.Driver;


public class ConnectionCreator {
    private String filepath = "src/main/resources/database.properties";
    private String url;
    private String user;
    private String password;

    public ConnectionCreator() {
        ConnectionPropertiesReader reader = new ConnectionPropertiesReader();
        Properties properties = reader.readProperties(filepath);
        readDatabaseLoginCredentials(properties);
    }

    private void readDatabaseLoginCredentials(Properties properties) {
        url = properties.getProperty("db.url");
        user = properties.getProperty("db.user");
        password = properties.getProperty("db.password");
    }

    public Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
