package posts.sport;

public class DancePost {
    private Integer danceID;
    private String nameDanceStudio;
    private String detailsLink;
    private String address;
    private String description;
    private String imageLink;

    public Integer getDanceID() {
        return danceID;
    }

    public void setDanceID(Integer danceID) {
        this.danceID = danceID;
    }

    public String getNameDanceStudio() {
        return nameDanceStudio;
    }

    public void setNameDanceStudio(String nameDanceStudio) {
        this.nameDanceStudio = nameDanceStudio;
    }

    public String getDetailsLink() {
        return detailsLink;
    }

    public void setDetailsLink(String detailsLink) {
        this.detailsLink = detailsLink;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "DancePost{" +
                "danceID=" + danceID +
                ", nameDanceStudio='" + nameDanceStudio + '\'' +
                ", detailsLink='" + detailsLink + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
