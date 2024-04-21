package db.theatreDB;

import db.Configs;
import db.DBHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class DBHandlerTheatre extends Configs {
    private Connection dbConnectionTheatre;

    DBHandler dbHandler = new DBHandler();

    public Connection getDbConnectionTheatre() throws SQLException, ClassNotFoundException {
        return dbHandler.getDBConnection(dbConnectionTheatre);
    }
}
