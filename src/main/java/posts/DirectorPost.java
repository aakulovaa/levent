package posts;

public class DirectorPost {
    private String directorFirstName;
    private String directorLastName;
    private Integer countDirectorMovies;
    private String directorDetailsLink;

    public String getDirectorFirstName() {
        return directorFirstName;
    }

    public void setDirectorFirstName(String directorFirstName) {
        this.directorFirstName = directorFirstName;
    }

    public String getDirectorLastName() {
        return directorLastName;
    }

    public void setDirectorLastName(String directorLastName) {
        this.directorLastName = directorLastName;
    }

    public Integer getCountDirectorMovies() {
        return countDirectorMovies;
    }

    public void setCountDirectorMovies(Integer countDirectorMovies) {
        this.countDirectorMovies = countDirectorMovies;
    }

    public String getDirectorDetailsLink() {
        return directorDetailsLink;
    }

    public void setDirectorDetailsLink(String directorDetailsLink) {
        this.directorDetailsLink = directorDetailsLink;
    }

    @Override
    public String toString() {
        return "DirectorPost{" +
                "directorFirstName='" + directorFirstName + '\'' +
                ", directorLastName='" + directorLastName + '\'' +
                ", countDirectorMovies=" + countDirectorMovies +
                ", directorDetailsLink='" + directorDetailsLink + '\'' +
                '}';
    }
}
