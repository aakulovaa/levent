package db.sportDB;

import db.DBHandler;
import models.sport.Run;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHandlerRun {
    private Connection dbConnectionRun;

    DBHandler dbHandler = new DBHandler();

    public Connection getDbConnectionRun() throws SQLException, ClassNotFoundException {
        return dbHandler.getDBConnection(dbConnectionRun);
    }

    public void runFilling(Run run) {
        String insertDance = "INSERT INTO " + RunConst.RUN_TABLE + "(" +
                RunConst.RUN_NAME +"," + RunConst.RUN_LOGO +
                "," +  RunConst.RUN_LINK + "," + RunConst.RUN_ADDRESS +","
                + RunConst.RUN_DATE + "," + RunConst.RUN_DESCRIPTION+
                "," + RunConst.RUN_IMAGE_LINK+ "," + RunConst.RUN_IMAGE_SOURCE + ")" +
                "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnectionRun().prepareStatement(insertDance);
            prSt.setString(1,run.getRunName());
            prSt.setString(2,run.getRunLogo());
            prSt.setString(3,run.getRunLink());
            prSt.setString(4,run.getRunAddress());
            prSt.setString(5,run.getRunDate());
            prSt.setString(6,run.getRunDescription());
            prSt.setString(7,run.getRunImageLink());
            prSt.setString(8,run.getRunImageSource());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet runGetting(){

        ResultSet resSet = null;

        String select = "SELECT * FROM " + RunConst.RUN_TABLE;
        try {
            PreparedStatement prSt = getDbConnectionRun().prepareStatement(select);

            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }


    public void runCleaning(){

        String delete = "DELETE FROM " + RunConst.RUN_TABLE;
        try {
            PreparedStatement prSt = getDbConnectionRun().prepareStatement(delete);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
