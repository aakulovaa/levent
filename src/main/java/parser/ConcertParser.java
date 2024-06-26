package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import posts.concert.ConcertPost;
import posts.theatre.PerformancePost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcertParser implements Parser{
    private int countConcert = 0;
    private String date = "";
    public List<ConcertPost> parser() {
        List<ConcertPost> posts;
        try {
            posts = new ArrayList<>();
            Document doc = Jsoup.connect("https://www.afisha.ru/voronezh/schedule_concert/").get();
            Elements concertLinkElements = doc.getElementsByAttributeValue("data-test", "LINK ITEM-URL");
            for (Element concertLinkElement : concertLinkElements) {
                ConcertPost concertPost = new ConcertPost();
                String detailsLink = concertLinkElement.attr("href");
                concertPost.setDetailsLink(detailsLink);

                Elements imageLinkElement = concertLinkElement.getElementsByAttributeValue("data-test", "IMAGE ITEM-IMAGE");
                String imageDetailsLink = imageLinkElement.attr("src");
                concertPost.setImageLink(imageDetailsLink);

                Element releaseElement = doc.getElementsByAttributeValue("data-test", "ITEM-META ITEM-NOTICE").get(countConcert);
                String release = releaseElement.text();
                String[] releaseArray = release.split(",");

                if(!Objects.equals(releaseArray[0], releaseArray[releaseArray.length - 2])) {
                    date = releaseArray[0] +','+ releaseArray[releaseArray.length - 2];
                }
                else {
                    date = releaseArray[0];
                }
                concertPost.setDateRelease(date);

                concertPost.setAddressConcert(releaseArray[releaseArray.length - 1]);

                Document postDetailsDoc = Jsoup.connect("https://www.afisha.ru" + detailsLink).get();
                concertPost.setConcertLink("https://www.afisha.ru" + detailsLink);

                Elements title = postDetailsDoc.getElementsByAttributeValue("data-test", "ITEM-NAME");
                concertPost.setName(title.text());

                countConcert++;
                concertPost.setConcertID(countConcert);

                Element genre = postDetailsDoc.getElementsByClass("eNJOm").first();
                Elements genreDetails = genre != null ? genre.getElementsByAttributeValue("data-test", "LINK") : null;
                if (genreDetails != null) {
                    concertPost.setGenre(genreDetails.text());
                }

                Element age = postDetailsDoc.getElementsByClass("eNJOm").last();
                Elements ageDetails = age.getElementsByAttributeValue("data-test", "META-FIELD-VALUE");
                concertPost.setAge(ageDetails.text());

                String description = postDetailsDoc.getElementsByClass("aEVDY t1V2l").text();
                concertPost.setDescription(description);


                posts.add(concertPost);
            }
            //posts.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }
}
