package db.sportDB;

import db.DBHandler;
import models.sport.Dance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHandlerDance {
    private Connection dbConnectionDance;

    DBHandler dbHandler = new DBHandler();

    public Connection getDbConnectionDance() throws SQLException, ClassNotFoundException {
        return dbHandler.getDBConnection(dbConnectionDance);
    }

    public void danceFilling(Dance dance) {
        String insertDance = "INSERT INTO " + DanceConst.DANCE_TABLE + "(" +
                DanceConst.DANCE_STUDIO_NAME +"," + DanceConst.DANCE_ADDRESS +
                "," +  DanceConst.DANCE_DESCRIPTION + "," + DanceConst.DANCE_IMAGE_LINK +","
                + DanceConst.DANCE_IMAGE_SOURCE + ")" +
                "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnectionDance().prepareStatement(insertDance);
            prSt.setString(1,dance.getDanceStudioName());
            prSt.setString(2,dance.getDanceAddress());
            prSt.setString(3,dance.getDanceDescription());
            prSt.setString(4,dance.getDanceImageLink());
            prSt.setString(5,dance.getDanceImageSource());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet danceGetting(){

        ResultSet resSet = null;

        String select = "SELECT * FROM " + DanceConst.DANCE_TABLE;
        try {
            PreparedStatement prSt = getDbConnectionDance().prepareStatement(select);

            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }

    public ResultSet getSport(Dance dance){

        ResultSet resSet = null;

        String select = "SELECT * FROM " + DanceConst.DANCE_TABLE + " WHERE " + DanceConst.DANCE_STUDIO_NAME + " =?";
        try {
            PreparedStatement prSt = getDbConnectionDance().prepareStatement(select);
            prSt.setString(1,dance.getDanceStudioName());


            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }

    public void danceCleaning(){

        String delete = "DELETE FROM " + DanceConst.DANCE_TABLE;
        try {
            PreparedStatement prSt = getDbConnectionDance().prepareStatement(delete);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
