package connection;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;

public class DatabaseLoader {
    private String dbFilepath = "src/main/resources/guestbook_sample_data.sql";

    public void fillDatabase() {
        try {
            ConnectionCreator connectionCreator = new ConnectionCreator();
            Connection connection = connectionCreator.getConnection();
            ScriptRunner sr = new ScriptRunner(connection);
            Reader reader = new BufferedReader(new FileReader(dbFilepath));
            sr.runScript(reader);

            System.out.println("Success! Tables were created!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Couldn't load database content from the script!", e);
        }
    }
}
