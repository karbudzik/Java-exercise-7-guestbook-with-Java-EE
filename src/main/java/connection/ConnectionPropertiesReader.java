package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConnectionPropertiesReader {

    public Properties readProperties(String filepath) {
        Properties properties = new Properties();
        Path path = Paths.get(filepath);
        try {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            properties.load(reader);
            return properties;

        } catch (IOException e) {
            throw new RuntimeException("Sorry! Loading your database properties has failed!", e);
        }
    }
}
