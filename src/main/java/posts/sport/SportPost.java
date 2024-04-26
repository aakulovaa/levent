package posts.sport;

public class SportPost {
    private Integer sportID;
    private String name;
    private String logeDesc;
    private String sportLink;
    private String address;
    private String dateStart;
    private String description;
    private String imageLink;

    public Integer getSportID() {
        return sportID;
    }

    public void setSportID(Integer sportID) {
        this.sportID = sportID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogeDesc() {
        return logeDesc;
    }

    public void setLogeDesc(String logeDesc) {
        this.logeDesc = logeDesc;
    }

    public String getSportLink() {
        return sportLink;
    }

    public void setSportLink(String sportLink) {
        this.sportLink = sportLink;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
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
        return "SportPost{" +
                "sportID=" + sportID +
                ", name='" + name + '\'' +
                ", logeDesc='" + logeDesc + '\'' +
                ", sportLink='" + sportLink + '\'' +
                ", address='" + address + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", description='" + description + '\'' +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
