package models.theatre;

public class Performance {
    private String performanceName;
    private String performanceLink;
    private String performanceDate;
    private String performanceAddress;
    private String performanceLength;
    private String performanceAgeLimit;
    private String performanceGenre;
    private String performanceDirector;
    private String performanceDescription;
    private String performanceImageLink;
    private String performanceImageSource;

    public String getPerformanceDate() {
        return performanceDate;
    }

    public void setPerformanceDate(String performanceDate) {
        this.performanceDate = performanceDate;
    }

    public String getPerformanceAddress() {
        return performanceAddress;
    }

    public void setPerformanceAddress(String performanceAddress) {
        this.performanceAddress = performanceAddress;
    }

    public String getPerformanceLink() {
        return performanceLink;
    }

    public void setPerformanceLink(String performanceLink) {
        this.performanceLink = performanceLink;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName;
    }

    public String getPerformanceLength() {
        return performanceLength;
    }

    public void setPerformanceLength(String performanceLength) {
        this.performanceLength = performanceLength;
    }

    public String getPerformanceAgeLimit() {
        return performanceAgeLimit;
    }

    public void setPerformanceAgeLimit(String performanceAgeLimit) {
        this.performanceAgeLimit = performanceAgeLimit;
    }

    public String getPerformanceGenre() {
        return performanceGenre;
    }

    public void setPerformanceGenre(String performanceGenre) {
        this.performanceGenre = performanceGenre;
    }

    public String getPerformanceDirector() {
        return performanceDirector;
    }

    public void setPerformanceDirector(String performanceDirector) {
        this.performanceDirector = performanceDirector;
    }

    public String getPerformanceDescription() {
        return performanceDescription;
    }

    public void setPerformanceDescription(String performanceDescription) {
        this.performanceDescription = performanceDescription;
    }

    public String getPerformanceImageLink() {
        return performanceImageLink;
    }

    public void setPerformanceImageLink(String performanceImageLink) {
        this.performanceImageLink = performanceImageLink;
    }

    public String getPerformanceImageSource() {
        return performanceImageSource;
    }

    public void setPerformanceImageSource(String performanceImageSource) {
        this.performanceImageSource = performanceImageSource;
    }

    public Performance(){

    }

    public Performance(String performanceName, String performanceLink, String performanceLength, String performanceAgeLimit, String performanceGenre, String performanceDirector, String performanceDescription, String performanceImageLink, String performanceImageSource) {
        this.performanceName = performanceName;
        this.performanceLink = performanceLink;
        this.performanceLength = performanceLength;
        this.performanceAgeLimit = performanceAgeLimit;
        this.performanceGenre = performanceGenre;
        this.performanceDirector = performanceDirector;
        this.performanceDescription = performanceDescription;
        this.performanceImageLink = performanceImageLink;
        this.performanceImageSource = performanceImageSource;
    }

    public Performance(String performanceName, String performanceLink, String performanceDate, String performanceAddress, String performanceGenre, String performanceLength, String performanceAgeLimit, String performanceDirector, String performanceDescription, String performanceImageLink, String performanceImageSource) {
        this.performanceName = performanceName;
        this.performanceLink = performanceLink;
        this.performanceDate = performanceDate;
        this.performanceAddress = performanceAddress;
        this.performanceGenre = performanceGenre;
        this.performanceLength = performanceLength;
        this.performanceAgeLimit = performanceAgeLimit;
        this.performanceDirector = performanceDirector;
        this.performanceDescription = performanceDescription;
        this.performanceImageLink = performanceImageLink;
        this.performanceImageSource = performanceImageSource;
    }
}
