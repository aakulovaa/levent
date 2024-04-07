package db;



import com.sun.jdi.connect.spi.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends Configs{

    Connection dbConnection;

    public Connection getDBConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("org.postgresql.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);

        return dbConnection;
    }
}
