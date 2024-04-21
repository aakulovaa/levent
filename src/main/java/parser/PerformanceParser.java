package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import posts.theatre.PerformancePost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PerformanceParser {
    private int countPerformance = 0;
    private String directorPerformance;
    public List<PerformancePost> parser() {
        List<PerformancePost> posts;
        try {
            posts = new ArrayList<>();
            Document doc = Jsoup.connect("https://www.afisha.ru/voronezh/schedule_theatre/").get();
            Elements movieLinkElements = doc.getElementsByAttributeValue("data-test", "LINK ITEM-NAME ITEM-URL");
            for (Element movieLinkElement : movieLinkElements) {
                PerformancePost performancePost = new PerformancePost();
                String detailsLink = movieLinkElement.attr("href");
                performancePost.setDetailsLink(detailsLink);
                Elements imageLinkElement = movieLinkElement.getElementsByAttributeValue("data-test", "IMAGE ITEM-IMAGE");
                String imageDetailsLink = imageLinkElement.attr("src");
                performancePost.setImageLink(imageDetailsLink);


                Document postDetailsDoc = Jsoup.connect("https://www.afisha.ru" + detailsLink).get();

                Elements title = postDetailsDoc.getElementsByAttributeValue("data-test", "ITEM-NAME");
                performancePost.setName(title.text());

                countPerformance++;
                performancePost.setPerformanceID(countPerformance);

                Element genre = postDetailsDoc.getElementsByClass("eNJOm").first();
                Elements genreDetails = genre != null ? genre.getElementsByAttributeValue("data-test", "LINK") : null;
                if (genreDetails != null) {
                    performancePost.setGenre(genreDetails.text());
                }

                Element age = postDetailsDoc.getElementsByClass("eNJOm").get(1);
                Elements ageDetails = age.getElementsByAttributeValue("data-test", "META-FIELD-VALUE");
                performancePost.setAge(ageDetails.text());

                Element director = postDetailsDoc.getElementsByClass("eNJOm").get(2);
                Elements directorDetails = director.getElementsByAttributeValue("data-test", "LINK");
                directorPerformance = directorDetails.text();
                if (directorDetails.text().isEmpty())
                {
                    directorPerformance = "";
                }
                performancePost.setDirector(directorPerformance);

                Element length = postDetailsDoc.getElementsByClass("eNJOm").last();
                Elements lengthDetails = length.getElementsByAttributeValue("data-test", "META-FIELD-VALUE");
                performancePost.setLength(lengthDetails.text());

                String description = postDetailsDoc.getElementsByClass("aEVDY t1V2l").text();
                performancePost.setDescription(description);


                posts.add(performancePost);
            }
            posts.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }
}
