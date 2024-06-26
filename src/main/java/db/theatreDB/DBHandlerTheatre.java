package db.theatreDB;

import db.Configs;
import db.DBHandler;

import models.theatre.Performance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHandlerTheatre extends Configs {
    private Connection dbConnectionTheatre;

    DBHandler dbHandler = new DBHandler();

    public Connection getDbConnectionTheatre() throws SQLException, ClassNotFoundException {
        return dbHandler.getDBConnection(dbConnectionTheatre);
    }

    public void performancesFilling(Performance performance) {
        String insertPerform = "INSERT INTO " + PerformancesConst.PERFORMANCES_TABLE + "(" +
                PerformancesConst.PERFORMANCES_NAME +"," + PerformancesConst.PERFORMANCES_LINK +
                "," + PerformancesConst.PERFORMANCES_DATE +"," + PerformancesConst.PERFORMANCES_ADDRESS +
                "," + PerformancesConst.PERFORMANCES_GENRE +
                "," + PerformancesConst.PERFORMANCES_LENGTH  + "," +  PerformancesConst.PERFORMANCES_AGE_LIMIT +
                "," + PerformancesConst.PERFORMANCES_DIRECTOR + "," + PerformancesConst.PERFORMANCES_DESCRIPTION +","
                + PerformancesConst.PERFORMANCES_IMAGE_LINK +"," + PerformancesConst.PERFORMANCES_IMAGE_SOURCE + ")" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnectionTheatre().prepareStatement(insertPerform);
            prSt.setString(1,performance.getPerformanceName());
            prSt.setString(2,performance.getPerformanceLink());
            prSt.setString(3,performance.getPerformanceDate());
            prSt.setString(4,performance.getPerformanceAddress());
            prSt.setString(5,performance.getPerformanceGenre());
            prSt.setString(6,performance.getPerformanceLength());
            prSt.setString(7,performance.getPerformanceAgeLimit());
            prSt.setString(8,performance.getPerformanceDirector());
            prSt.setString(9,performance.getPerformanceDescription());
            prSt.setString(10,performance.getPerformanceImageLink());
            prSt.setString(11,performance.getPerformanceImageSource());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet performancesGetting(){

        ResultSet resSet = null;

        String select = "SELECT * FROM " + PerformancesConst.PERFORMANCES_TABLE;
        try {
            PreparedStatement prSt = getDbConnectionTheatre().prepareStatement(select);

            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }


    public ResultSet getTheate(Performance performance){

        ResultSet resSet = null;

        String select = "SELECT * FROM " + PerformancesConst.PERFORMANCES_TABLE + " WHERE " + PerformancesConst.PERFORMANCES_NAME + " =?";
        try {
            PreparedStatement prSt = getDbConnectionTheatre().prepareStatement(select);
            prSt.setString(1,performance.getPerformanceName());


            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }

    public ResultSet getDateTheate(Performance performance){

        ResultSet resSet = null;

        String select = "SELECT * FROM " + PerformancesConst.PERFORMANCES_TABLE + " WHERE " + PerformancesConst.PERFORMANCES_DATE + " =?";
        try {
            PreparedStatement prSt = getDbConnectionTheatre().prepareStatement(select);
            prSt.setString(1,performance.getPerformanceDate());


            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }

    public void performancesCleaning(){

        String delete = "DELETE FROM " + PerformancesConst.PERFORMANCES_TABLE;
        try {
            PreparedStatement prSt = getDbConnectionTheatre().prepareStatement(delete);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
