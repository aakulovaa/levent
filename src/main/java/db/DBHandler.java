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

    public void cinemasFilling(Integer cinemaID, String cinemaName, String cinemaAddress){
        String insertCinema = "INSERT INTO " + CinemasConst.CINEMAS_TABLE + "(" +
                CinemasConst.CINEMA_NAME + "," + CinemasConst.CINEMA_ADDRESS + ")" +
                "VALUES(?,?)";
        try {
            PreparedStatement prSt = getDBConnection().prepareStatement(insertCinema);
            prSt.setInt(1,cinemaID);
            prSt.setString(2,cinemaName);
            prSt.setString(3,cinemaAddress);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void moviesFilling(Integer movieID, String movieName, String movieYearRelease, String movieLength,
                              String movieAgeLimit, String movieGenre, String movieDirector, String movieDescription){
        String insertMovie = "INSERT INTO " + CinemasConst.MOVIES_TABLE + "(" +
                CinemasConst.MOVIE_ID + "," + CinemasConst.MOVIE_NAME +
                "," + CinemasConst.MOVIE_YEAR_RELEASE +"," + CinemasConst.MOVIE_LENGTH  +
                "," +  CinemasConst.MOVIE_AGE_LIMIT + "," + CinemasConst.MOVIE_GENRE +
                "," + CinemasConst.MOVIE_DIRECTOR + "," + CinemasConst.MOVIE_DESCRIPTION + ")" +
                "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDBConnection().prepareStatement(insertMovie);
            prSt.setInt(1,movieID);
            prSt.setString(2,movieName);
            prSt.setString(3, movieYearRelease);
            prSt.setString(4,movieLength);
            prSt.setString(5,movieAgeLimit);
            prSt.setString(6,movieGenre);
            prSt.setString(7,movieDirector);
            prSt.setString(8,movieDescription);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
