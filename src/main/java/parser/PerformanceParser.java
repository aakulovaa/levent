package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import posts.theatre.PerformancePost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PerformanceParser implements Parser{
    private int countPerformance = 0;
    private String directorPerformance;
    private String date = "";
    public List<PerformancePost> parser() {
        List<PerformancePost> posts;
        try {
            posts = new ArrayList<>();
            Document doc = Jsoup.connect("https://www.afisha.ru/voronezh/schedule_theatre/").get();
            Elements performLinkElements = doc.getElementsByAttributeValue("data-test", "LINK ITEM-URL");
            for (Element performLinkElement : performLinkElements) {
                PerformancePost performancePost = new PerformancePost();
                String detailsLink = performLinkElement.attr("href");
                performancePost.setDetailsLink(detailsLink);

                Elements imageLinkElement = performLinkElement.getElementsByAttributeValue("data-test", "IMAGE ITEM-IMAGE");
                String imageDetailsLink = imageLinkElement.attr("src");
                performancePost.setImageLink(imageDetailsLink);

                Element releaseElement = doc.getElementsByAttributeValue("data-test", "ITEM-META ITEM-NOTICE").get(countPerformance);
                String release = releaseElement.text();
                String[] releaseArray = release.split(",");

                if(!Objects.equals(releaseArray[0], releaseArray[releaseArray.length - 2])) {
                    date = releaseArray[0] +','+ releaseArray[releaseArray.length - 2];
                }
                else {
                    date = releaseArray[0];
                }
                performancePost.setDateRelease(date);

                performancePost.setAddressTheatre(releaseArray[releaseArray.length - 1]);

                Document postDetailsDoc = Jsoup.connect("https://www.afisha.ru" + detailsLink).get();
                performancePost.setPerformanceLink("https://www.afisha.ru" + detailsLink);

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
            //posts.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }
}
