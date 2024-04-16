package db;

import java.sql.*;

public class DBHandler extends Configs{

    Connection dbConnection;

    public Connection getDBConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("org.postgresql.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);

        return dbConnection;
    }

    public void cinemasFilling(String cinemaName, String cinemaAddress){
        String insertCinema = "INSERT INTO " + CinemasConst.CINEMAS_TABLE + "(" +
                CinemasConst.CINEMA_NAME + "," + CinemasConst.CINEMA_ADDRESS + ")" +
                "VALUES(?,?)";
        try {
            PreparedStatement prSt = getDBConnection().prepareStatement(insertCinema);
            prSt.setString(1,cinemaName);
            prSt.setString(2,cinemaAddress);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void moviesFilling(String movieName, String movieYearRelease, String movieLength,
                              String movieAgeLimit, String movieGenre, String movieDescription){
        String insertMovie = "INSERT INTO " + CinemasConst.MOVIES_TABLE + "(" +
                CinemasConst.MOVIE_NAME + "," + CinemasConst.MOVIE_YEAR_RELEASE +
                CinemasConst.MOVIE_LENGTH  + "," +  CinemasConst.MOVIE_AGE_LIMIT + "," +
                CinemasConst.MOVIE_GENRE + "," + CinemasConst.MOVIE_DESCRIPTION + "," + ")" +
                "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDBConnection().prepareStatement(insertMovie);
            prSt.setString(1,movieName);
            prSt.setString(2, movieYearRelease);
            prSt.setString(3,movieLength);
            prSt.setString(4,movieAgeLimit);
            prSt.setString(5,movieGenre);
            prSt.setString(6,movieDescription);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
