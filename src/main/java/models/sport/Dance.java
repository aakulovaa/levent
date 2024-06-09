package models.sport;

public class Dance {
    private String danceStudioName;
    private String danceAddress;
    private String danceDescription;
    private String danceImageLink;
    private String danceImageSource;

    public String getDanceStudioName() {
        return danceStudioName;
    }

    public void setDanceStudioName(String danceStudioName) {
        this.danceStudioName = danceStudioName;
    }

    public String getDanceAddress() {
        return danceAddress;
    }

    public void setDanceAddress(String danceAddress) {
        this.danceAddress = danceAddress;
    }

    public String getDanceDescription() {
        return danceDescription;
    }

    public void setDanceDescription(String danceDescription) {
        this.danceDescription = danceDescription;
    }

    public String getDanceImageLink() {
        return danceImageLink;
    }

    public void setDanceImageLink(String danceImageLink) {
        this.danceImageLink = danceImageLink;
    }

    public String getDanceImageSource() {
        return danceImageSource;
    }

    public void setDanceImageSource(String danceImageSource) {
        this.danceImageSource = danceImageSource;
    }

    public Dance(){

    }
    public Dance(String danceStudioName, String danceAddress, String danceDescription, String danceImageLink, String danceImageSource) {
        this.danceStudioName = danceStudioName;
        this.danceAddress = danceAddress;
        this.danceDescription = danceDescription;
        this.danceImageLink = danceImageLink;
        this.danceImageSource = danceImageSource;
    }
}
