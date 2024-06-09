package models.quest;

public class Quest {
    private String questName;
    private String questCountPlayers;
    private String questAgeLimit;
    private String questDescription;
    private String questLocation;
    private String questImageLink;
    private String questImageSource;

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    public String getQuestCountPlayers() {
        return questCountPlayers;
    }

    public void setQuestCountPlayers(String questCountPlayers) {
        this.questCountPlayers = questCountPlayers;
    }

    public String getQuestAgeLimit() {
        return questAgeLimit;
    }

    public void setQuestAgeLimit(String questAgeLimit) {
        this.questAgeLimit = questAgeLimit;
    }

    public String getQuestDescription() {
        return questDescription;
    }

    public void setQuestDescription(String questDescription) {
        this.questDescription = questDescription;
    }

    public String getQuestLocation() {
        return questLocation;
    }

    public void setQuestLocation(String questLocation) {
        this.questLocation = questLocation;
    }

    public String getQuestImageLink() {
        return questImageLink;
    }

    public void setQuestImageLink(String questImageLink) {
        this.questImageLink = questImageLink;
    }

    public String getQuestImageSource() {
        return questImageSource;
    }

    public void setQuestImageSource(String questImageSource) {
        this.questImageSource = questImageSource;
    }

    public Quest(){

    }

    public Quest(String questName, String questCountPlayers, String questAgeLimit, String questDescription, String questLocation, String questImageLink, String questImageSource) {
        this.questName = questName;
        this.questCountPlayers = questCountPlayers;
        this.questAgeLimit = questAgeLimit;
        this.questDescription = questDescription;
        this.questLocation = questLocation;
        this.questImageLink = questImageLink;
        this.questImageSource = questImageSource;
    }
}
