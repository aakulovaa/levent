package posts.theatre;

public class PerformancePost {
    private Integer performanceID;
    private String name;
    private String performanceLink;
    private String detailsLink;
    private String dateRelease;
    private String addressTheatre;
    private String genre;
    private String age;
    private String length;
    private String description;
    private String director;
    private String imageLink;

    public String getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(String dateRelease) {
        this.dateRelease = dateRelease;
    }

    public String getAddressTheatre() {
        return addressTheatre;
    }

    public void setAddressTheatre(String addressTheatre) {
        this.addressTheatre = addressTheatre;
    }

    public String getPerformanceLink() {
        return performanceLink;
    }

    public void setPerformanceLink(String performanceLink) {
        this.performanceLink = performanceLink;
    }

    public Integer getPerformanceID() {
        return performanceID;
    }

    public void setPerformanceID(Integer performanceID) {
        this.performanceID = performanceID;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString() {
        return "PerformancePost{" +
                "performanceID=" + performanceID +
                ", name='" + name + '\'' +
                ", performanceLink='" + performanceLink + '\'' +
                ", detailsLink='" + detailsLink + '\'' +
                ", dateRelease='" + dateRelease + '\'' +
                ", addressTheatre='" + addressTheatre + '\'' +
                ", genre='" + genre + '\'' +
                ", age='" + age + '\'' +
                ", length='" + length + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
