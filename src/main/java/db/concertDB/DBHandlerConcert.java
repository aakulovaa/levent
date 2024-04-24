package db.concertDB;

import db.DBHandler;
import models.concert.Concert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHandlerConcert {
    private Connection dbConnectionConcert;

    DBHandler dbHandler = new DBHandler();

    public Connection getDbConnectionConcert() throws SQLException, ClassNotFoundException {
        return dbHandler.getDBConnection(dbConnectionConcert);
    }

    public void concertsFilling(Concert concert) {
        String insertConcert = "INSERT INTO " + ConcertsConst.CONCERTS_TABLE + "(" +
                ConcertsConst.CONCERT_GROUP_NAME +"," + ConcertsConst.CONCERT_LINK +
                "," + ConcertsConst.CONCERT_GENRE +
                 "," +  ConcertsConst.CONCERT_AGE_LIMIT + "," + ConcertsConst.CONCERT_DESCRIPTION +","
                + ConcertsConst.CONCERT_IMAGE_LINK +"," + ConcertsConst.CONCERT_IMAGE_SOURCE + ")" +
                "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnectionConcert().prepareStatement(insertConcert);
            prSt.setString(1,concert.getConcertName());
            prSt.setString(2,concert.getConcertLink());
            prSt.setString(3,concert.getConcertGenre());
            prSt.setString(4,concert.getConcertAgeLimit());
            prSt.setString(5,concert.getConcertDescription());
            prSt.setString(6,concert.getConcertImageLink());
            prSt.setString(7,concert.getConcertImageSource());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getConcert(Concert concert){

        ResultSet resSet = null;

        String select = "SELECT * FROM " + ConcertsConst.CONCERTS_TABLE + " WHERE " + ConcertsConst.CONCERT_GROUP_NAME + " =?";
        try {
            PreparedStatement prSt = getDbConnectionConcert().prepareStatement(select);
            prSt.setString(1,concert.getConcertName());


            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }

    public ResultSet concertsGetting(){

        ResultSet resSet = null;

        String select = "SELECT * FROM " + ConcertsConst.CONCERTS_TABLE;
        try {
            PreparedStatement prSt = getDbConnectionConcert().prepareStatement(select);

            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }

    public void concertsCleaning(){

        String delete = "DELETE FROM " + ConcertsConst.CONCERTS_TABLE;
        try {
            PreparedStatement prSt = getDbConnectionConcert().prepareStatement(delete);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
