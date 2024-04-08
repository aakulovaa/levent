package posts;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieParser {
    public void parser(){
        try {
            List<MoviePost> posts = new ArrayList<>();
            Document doc = Jsoup.connect("https://www.afisha.ru/voronezh/schedule_cinema/").get();
            Elements movieLinkElements = doc.getElementsByAttributeValue("data-test", "LINK ITEM-URL");
            for(Element movieLinkElement : movieLinkElements)
            {
                MoviePost moviePost = new MoviePost();
                String detailsLink = movieLinkElement.attr("href");
                moviePost.setDetailsLink(detailsLink);

                Document postDeteilsDoc = Jsoup.connect("https://www.afisha.ru"+detailsLink).get();

                Elements title = postDeteilsDoc.getElementsByAttributeValue("data-test", "ITEM-NAME");
                moviePost.setTitle(title.text());

                Element genre = postDeteilsDoc.getElementsByClass("eNJOm").first();
                Elements genreDetails = genre.getElementsByAttributeValue("data-test", "LINK");
                moviePost.setGenreDetailsLink(genreDetails.attr("href"));
                moviePost.setGenre(genreDetails.text());

                Element age = postDeteilsDoc.getElementsByClass("eNJOm").get(1);
                Elements ageDetails = age.getElementsByAttributeValue("data-test", "META-FIELD-VALUE");
                moviePost.setAge(ageDetails.text());

                Element director = postDeteilsDoc.getElementsByClass("eNJOm").get(2);
                Elements directorDetails = director.getElementsByAttributeValue("data-test", "LINK");
                moviePost.setDirectorDetailsLink(directorDetails.attr("href"));
                moviePost.setDirector(directorDetails.text());

                Element year = postDeteilsDoc.getElementsByClass("eNJOm").get(3);
                Elements yearDetails = year.getElementsByAttributeValue("data-test", "META-FIELD-VALUE");
                moviePost.setYearRelease(yearDetails.text());

                Element length = postDeteilsDoc.getElementsByClass("eNJOm").last();
                Elements lengthDetails = length.getElementsByAttributeValue("data-test", "META-FIELD-VALUE");
                moviePost.setYearRelease(lengthDetails.text());

                String description = postDeteilsDoc.getElementsByClass("aEVDY t1V2l").text();
                //Elements lengthDetails = length.getElementsByAttributeValue("data-test", "META-FIELD-VALUE");
                moviePost.setYearRelease(description);

                posts.add(moviePost);
            }
            posts.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
