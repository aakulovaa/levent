package posts;

public class MoviePost {
    private String title;
    private String detailsLink;
    private String genre;
    private String genreDetailsLink;
    private String age;
    private String yearRelease;
    private String length;
    private String description;
    private String director;
    private String directorDetailsLink;

    public String getDirectorDetailsLink() {
        return directorDetailsLink;
    }

    public void setDirectorDetailsLink(String directorDetailsLink) {
        this.directorDetailsLink = directorDetailsLink;
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

    public String getGenreDetailsLink() {
        return genreDetailsLink;
    }

    public void setGenreDetailsLink(String genreDetailsLink) {
        this.genreDetailsLink = genreDetailsLink;
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
                "title='" + title + '\'' +
                ", detailsLink='" + detailsLink + '\'' +
                ", genre='" + genre + '\'' +
                ", genreDetailsLink='" + genreDetailsLink + '\'' +
                ", age='" + age + '\'' +
                ", yearRelease='" + yearRelease + '\'' +
                ", length='" + length + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", directorDetailsLink='" + directorDetailsLink + '\'' +
                '}';
    }
}