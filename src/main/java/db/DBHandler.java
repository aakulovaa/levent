package db;

import cinema.Movie;
import cinemaDB.CinemasConst;
import cinemaDB.MoviesConst;

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

    public void moviesFilling(Movie movie){
        String insertMovie = "INSERT INTO " + MoviesConst.MOVIES_TABLE + "(" +
                MoviesConst.MOVIE_NAME +
                "," + MoviesConst.MOVIE_YEAR_RELEASE +"," + MoviesConst.MOVIE_LENGTH  +
                "," +  MoviesConst.MOVIE_AGE_LIMIT + "," + MoviesConst.MOVIE_GENRE +
                "," + MoviesConst.MOVIE_DIRECTOR + "," + MoviesConst.MOVIE_DESCRIPTION +","
                + MoviesConst.MOVIE_IMAGE_LINK + ")" +
                "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDBConnection().prepareStatement(insertMovie);
            prSt.setString(1,movie.getMovieName());
            prSt.setString(2, movie.getMovieDateRelease());
            prSt.setString(3,movie.getMovieLength());
            prSt.setString(4,movie.getMovieAgeLimit());
            prSt.setString(5,movie.getMovieGenre());
            prSt.setString(6,movie.getMovieDirector());
            prSt.setString(7,movie.getMovieDescription());
            prSt.setString(8,movie.getMovieImageLink());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet moviesGetting(){

        ResultSet resSet = null;

        String select = "SELECT * FROM " + MoviesConst.MOVIES_TABLE;
        try {
            PreparedStatement prSt = getDBConnection().prepareStatement(select);

            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }

    public void moviesCleaning(){

        String delete = "DELETE FROM " + MoviesConst.MOVIES_TABLE;
        try {
            PreparedStatement prSt = getDBConnection().prepareStatement(delete);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
