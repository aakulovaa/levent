package posts.cinema;

import java.util.Arrays;

public class MoviePost {
    private Integer movieID;
    private String title;
    private String detailsLink;
    private String movieLink;
    private String genre;
    private String age;
    private String yearRelease;
    private String length;
    private String description;
    private String director;
    private String imageLink;

    public String getMovieLink() {
        return movieLink;
    }

    public void setMovieLink(String movieLink) {
        this.movieLink = movieLink;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(String yearRelease) {
        this.yearRelease = yearRelease;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetailsLink() {
        return detailsLink;
    }

    public void setDetailsLink(String detailsLink) {
        this.detailsLink = detailsLink;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MoviePost{" +
                "movieID=" + movieID +
                ", title='" + title + '\'' +
                ", detailsLink='" + detailsLink + '\'' +
                ", movieLink='" + movieLink + '\'' +
                ", genre='" + genre + '\'' +
                ", age='" + age + '\'' +
                ", yearRelease='" + yearRelease + '\'' +
                ", length='" + length + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
