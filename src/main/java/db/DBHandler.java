package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler extends Configs{

    Connection dbConnection;

    public Connection getDBConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("org.postgresql.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);

        return dbConnection;
    }

    public void cinemasFilling(String cinemaName, String cinemaAddress){
        String insert = "INSERT INTO " + CinemasConst.CINEMAS_TABLE + "(" +
                CinemasConst.CINEMA_NAME + "," + CinemasConst.CINEMA_ADDRESS + ")" +
                "VALUES(?,?)";
        try {
            PreparedStatement prSt = getDBConnection().prepareStatement(insert);
            prSt.setString(1,cinemaName);
            prSt.setString(2,cinemaAddress);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
