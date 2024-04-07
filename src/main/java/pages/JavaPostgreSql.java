package pages;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaPostgreSql {
    public static final String DB_USERNAME = "annakulova";
    public static final String DB_PASSWORD = "levent";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    public static void connectionToDB() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
}
