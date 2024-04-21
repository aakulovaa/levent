package posts.concert;

public class ConcertPost {
    private Integer concertID;
    private String name;
    private String detailsLink;
    private String genre;
    private String age;
    private String description;
    private String imageLink;

    public Integer getConcertID() {
        return concertID;
    }

    public void setConcertID(Integer concertID) {
        this.concertID = concertID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString() {
        return "ConcertPost{" +
                "concertID=" + concertID +
                ", name='" + name + '\'' +
                ", detailsLink='" + detailsLink + '\'' +
                ", genre='" + genre + '\'' +
                ", age='" + age + '\'' +
                ", description='" + description + '\'' +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
