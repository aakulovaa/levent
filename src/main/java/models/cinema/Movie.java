package models.cinema;

public class Movie {
    private String movieName;
    private String movieLink;
    private String movieDateRelease;
    private String movieLength;
    private String movieAgeLimit;
    private String movieGenre;
    private String movieDirector;
    private String movieDescription;
    private String movieImageLink;
    private String movieImageSource;

    public String getMovieLink() {
        return movieLink;
    }

    public void setMovieLink(String movieLink) {
        this.movieLink = movieLink;
    }

    public String getMovieImageSource() {
        return movieImageSource;
    }

    public void setMovieImageSource(String movieImageSource) {
        this.movieImageSource = movieImageSource;
    }


    public String getMovieImageLink() {
        return movieImageLink;
    }

    public void setMovieImageLink(String movieImageLink) {
        this.movieImageLink = movieImageLink;
    }

    public Movie() {

    }


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDateRelease() {
        return movieDateRelease;
    }

    public void setMovieDateRelease(String movieDateRelease) {
        this.movieDateRelease = movieDateRelease;
    }

    public String getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(String movieLength) {
        this.movieLength = movieLength;
    }

    public String getMovieAgeLimit() {
        return movieAgeLimit;
    }

    public void setMovieAgeLimit(String movieAgeLimit) {
        this.movieAgeLimit = movieAgeLimit;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public Movie(String movieName, String movieDateRelease, String movieLength, String movieAgeLimit, String movieGenre, String movieDirector, String movieDescription, String movieImageLink, String movieImageSource) {
        this.movieName = movieName;
        this.movieDateRelease = movieDateRelease;
        this.movieLength = movieLength;
        this.movieAgeLimit = movieAgeLimit;
        this.movieGenre = movieGenre;
        this.movieDirector = movieDirector;
        this.movieDescription = movieDescription;
        this.movieImageLink = movieImageLink;
        this.movieImageSource = movieImageSource;
    }

    public Movie(String movieName, String movieLink, String movieDateRelease, String movieLength, String movieAgeLimit, String movieGenre, String movieDirector, String movieDescription, String movieImageLink, String movieImageSource) {
        this.movieName = movieName;
        this.movieLink = movieLink;
        this.movieDateRelease = movieDateRelease;
        this.movieLength = movieLength;
        this.movieAgeLimit = movieAgeLimit;
        this.movieGenre = movieGenre;
        this.movieDirector = movieDirector;
        this.movieDescription = movieDescription;
        this.movieImageLink = movieImageLink;
        this.movieImageSource = movieImageSource;
    }
}
