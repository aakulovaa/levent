package db.cinemaDB;

import models.cinema.Movie;
import db.Configs;
import db.DBHandler;

import java.sql.*;

public class DBHandlerCinema extends Configs {

    private Connection dbConnectionCinema;

    DBHandler dbHandler = new DBHandler();

    public Connection getDbConnectionCinema() throws SQLException, ClassNotFoundException {
        return dbHandler.getDBConnection(dbConnectionCinema);
    }

    public void moviesFilling(Movie movie){
        String insertMovie = "INSERT INTO " + MoviesConst.MOVIES_TABLE + "(" +
                MoviesConst.MOVIE_NAME +"," + MoviesConst.MOVIE_LINK +
                "," + MoviesConst.MOVIE_YEAR_RELEASE +"," + MoviesConst.MOVIE_LENGTH  +
                "," +  MoviesConst.MOVIE_AGE_LIMIT + "," + MoviesConst.MOVIE_GENRE +
                "," + MoviesConst.MOVIE_DIRECTOR + "," + MoviesConst.MOVIE_DESCRIPTION +","
                + MoviesConst.MOVIE_IMAGE_LINK +"," + MoviesConst.MOVIE_IMAGE_SOURCE + ")" +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnectionCinema().prepareStatement(insertMovie);
            prSt.setString(1,movie.getMovieName());
            prSt.setString(2, movie.getMovieLink());
            prSt.setString(3, movie.getMovieDateRelease());
            prSt.setString(4,movie.getMovieLength());
            prSt.setString(5,movie.getMovieAgeLimit());
            prSt.setString(6,movie.getMovieGenre());
            prSt.setString(7,movie.getMovieDirector());
            prSt.setString(8,movie.getMovieDescription());
            prSt.setString(9,movie.getMovieImageLink());
            prSt.setString(10,movie.getMovieImageSource());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet moviesGetting(){

        ResultSet resSet = null;

        String select = "SELECT * FROM " + MoviesConst.MOVIES_TABLE;
        try {
            PreparedStatement prSt = getDbConnectionCinema().prepareStatement(select);

            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }

    public ResultSet getMovie(Movie movie){

        ResultSet resSet = null;

        String select = "SELECT * FROM " + MoviesConst.MOVIES_TABLE + " WHERE " + MoviesConst.MOVIE_NAME + " =?";
        try {
            PreparedStatement prSt = getDbConnectionCinema().prepareStatement(select);
            prSt.setString(1,movie.getMovieName());


            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }

    public void moviesCleaning(){

        String delete = "DELETE FROM " + MoviesConst.MOVIES_TABLE;
        try {
            PreparedStatement prSt = getDbConnectionCinema().prepareStatement(delete);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
