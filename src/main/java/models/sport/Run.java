package models.sport;

public class Run {
    private String runName;
    private String runLogo;
    private String runLink;
    private String runAddress;
    private String runDate;
    private String runDescription;
    private String runImageLink;
    private String runImageSource;

    public String getRunName() {
        return runName;
    }

    public void setRunName(String runName) {
        this.runName = runName;
    }

    public String getRunLogo() {
        return runLogo;
    }

    public void setRunLogo(String runLogo) {
        this.runLogo = runLogo;
    }

    public String getRunLink() {
        return runLink;
    }

    public void setRunLink(String runLink) {
        this.runLink = runLink;
    }

    public String getRunAddress() {
        return runAddress;
    }

    public void setRunAddress(String runAddress) {
        this.runAddress = runAddress;
    }

    public String getRunDate() {
        return runDate;
    }

    public void setRunDate(String runDate) {
        this.runDate = runDate;
    }

    public String getRunDescription() {
        return runDescription;
    }

    public void setRunDescription(String runDescription) {
        this.runDescription = runDescription;
    }

    public String getRunImageLink() {
        return runImageLink;
    }

    public void setRunImageLink(String runImageLink) {
        this.runImageLink = runImageLink;
    }

    public String getRunImageSource() {
        return runImageSource;
    }

    public void setRunImageSource(String runImageSource) {
        this.runImageSource = runImageSource;
    }
    public Run(){

    }
    public Run(String runName, String runLogo, String runLink, String runAddress, String runDate, String runDescription, String runImageLink, String runImageSource) {
        this.runName = runName;
        this.runLogo = runLogo;
        this.runLink = runLink;
        this.runAddress = runAddress;
        this.runDate = runDate;
        this.runDescription = runDescription;
        this.runImageLink = runImageLink;
        this.runImageSource = runImageSource;
    }
}
