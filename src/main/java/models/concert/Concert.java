package models.concert;

public class Concert {
    private String concertName;
    private String concertAgeLimit;
    private String concertGenre;
    private String concertDescription;
    private String concertImageLink;
    private String concertImageSource;

    public String getConcertName() {
        return concertName;
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }

    public String getConcertAgeLimit() {
        return concertAgeLimit;
    }

    public void setConcertAgeLimit(String concertAgeLimit) {
        this.concertAgeLimit = concertAgeLimit;
    }

    public String getConcertGenre() {
        return concertGenre;
    }

    public void setConcertGenre(String concertGenre) {
        this.concertGenre = concertGenre;
    }

    public String getConcertDescription() {
        return concertDescription;
    }

    public void setConcertDescription(String concertDescription) {
        this.concertDescription = concertDescription;
    }

    public String getConcertImageLink() {
        return concertImageLink;
    }

    public void setConcertImageLink(String concertImageLink) {
        this.concertImageLink = concertImageLink;
    }

    public String getConcertImageSource() {
        return concertImageSource;
    }

    public void setConcertImageSource(String concertImageSource) {
        this.concertImageSource = concertImageSource;
    }
    public Concert(){

    }
    public Concert(String concertName, String concertGenre, String concertAgeLimit, String concertDescription, String concertImageLink, String concertImageSource) {
        this.concertName = concertName;
        this.concertGenre = concertGenre;
        this.concertAgeLimit = concertAgeLimit;
        this.concertDescription = concertDescription;
        this.concertImageLink = concertImageLink;
        this.concertImageSource = concertImageSource;
    }
}
