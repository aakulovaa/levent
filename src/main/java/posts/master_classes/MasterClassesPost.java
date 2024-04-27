package posts.master_classes;

public class MasterClassesPost {
    private Integer masterClassID;
    private String name;
    private String detailsLink;
    private String category;
    private String description;
    private String address;
    private String imageLink;

    public Integer getMasterClassID() {
        return masterClassID;
    }

    public void setMasterClassID(Integer masterClassID) {
        this.masterClassID = masterClassID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getDetailsLink() {
        return detailsLink;
    }

    public void setDetailsLink(String detailsLink) {
        this.detailsLink = detailsLink;
    }

    @Override
    public String toString() {
        return "MasterClassesPost{" +
                "masterClassID=" + masterClassID +
                ", name='" + name + '\'' +
                ", detailsLink='" + detailsLink + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
