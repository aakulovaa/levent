package posts.quest;

public class QuestPost {
    private Integer questID;
    private String name;
    private String detailsLink;
    private String countPlayer;
    private String age;
    private String description;
    private String location;
    private String imageLink;

    public Integer getQuestID() {
        return questID;
    }

    public void setQuestID(Integer questID) {
        this.questID = questID;
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

    public String getCountPlayer() {
        return countPlayer;
    }

    public void setCountPlayer(String countPlayer) {
        this.countPlayer = countPlayer;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString() {
        return "QuestPost{" +
                "questID=" + questID +
                ", name='" + name + '\'' +
                ", detailsLink='" + detailsLink + '\'' +
                ", countPlayer='" + countPlayer + '\'' +
                ", age='" + age + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
