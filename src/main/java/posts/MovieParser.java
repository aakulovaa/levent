package posts;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


public class MovieParser {
    private int yearIndex;
    private int countMovie = 0;
    private String directorMovie;
    public List<MoviePost> parser() {
        List<MoviePost> posts;
        try {
            posts = new ArrayList<>();
            Document doc = Jsoup.connect("https://www.afisha.ru/voronezh/schedule_cinema/").get();
            Elements movieLinkElements = doc.getElementsByAttributeValue("data-test", "LINK ITEM-URL");
            for (Element movieLinkElement : movieLinkElements) {
                MoviePost moviePost = new MoviePost();
                String detailsLink = movieLinkElement.attr("href");
                moviePost.setDetailsLink(detailsLink);
                Elements imageLinkElement = movieLinkElement.getElementsByAttributeValue("data-test", "IMAGE ITEM-IMAGE");
                String imageDetailsLink = imageLinkElement.attr("src");
                moviePost.setImageLink(imageDetailsLink);


                Document postDetailsDoc = Jsoup.connect("https://www.afisha.ru" + detailsLink).get();

                Elements title = postDetailsDoc.getElementsByAttributeValue("data-test", "ITEM-NAME");
                moviePost.setTitle(title.text());

                countMovie++;
                moviePost.setMovieID(countMovie);

                Element genre = postDetailsDoc.getElementsByClass("eNJOm").first();
                Elements genreDetails = genre != null ? genre.getElementsByAttributeValue("data-test", "LINK") : null;
                if (genreDetails != null) {
                    moviePost.setGenre(genreDetails.text());
                }

                Element age = postDetailsDoc.getElementsByClass("eNJOm").get(1);
                Elements ageDetails = age.getElementsByAttributeValue("data-test", "META-FIELD-VALUE");
                moviePost.setAge(ageDetails.text());

                Element director = postDetailsDoc.getElementsByClass("eNJOm").get(2);
                Elements directorDetails = director.getElementsByAttributeValue("data-test", "LINK");
                directorMovie = directorDetails.text();
                if (directorDetails.text().isEmpty())
                {
                    directorMovie = "";
                }
                moviePost.setDirector(directorMovie);

                yearIndex = moviePost.getDirector().isEmpty() ? 2 : 3;

                Element year = postDetailsDoc.getElementsByClass("eNJOm").get(yearIndex);
                Elements yearDetails = year.getElementsByAttributeValue("data-test", "META-FIELD-VALUE");
                moviePost.setYearRelease(yearDetails.text());

                Element length = postDetailsDoc.getElementsByClass("eNJOm").last();
                Elements lengthDetails = length.getElementsByAttributeValue("data-test", "META-FIELD-VALUE");
                moviePost.setLength(lengthDetails.text());

                String description = postDetailsDoc.getElementsByClass("aEVDY t1V2l").text();
                moviePost.setDescription(description);


                posts.add(moviePost);
            }
            //posts.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }

    public List<DirectorPost> directorParser(){
        List<DirectorPost> directorPosts;
        try {
            directorPosts = new ArrayList<>();
            Document doc = Jsoup.connect("https://www.afisha.ru/voronezh/schedule_cinema/").get();
            Elements movieLinkElements = doc.getElementsByAttributeValue("data-test", "LINK ITEM-URL");
            for (Element movieLinkElement : movieLinkElements) {
                DirectorPost directorPost = new DirectorPost();
                String detailsLink = movieLinkElement.attr("href");
                Document postDetailsDoc = Jsoup.connect("https://www.afisha.ru" + detailsLink).get();
                Element director = postDetailsDoc.getElementsByClass("eNJOm").get(2);
                Elements directorDetails = director.getElementsByAttributeValue("data-test", "LINK");
                String directorLink = directorDetails.attr("href");
                directorPost.setDirectorDetailsLink(directorLink);
                if(!directorDetails.text().isEmpty()) {
                    String[] arrayDirector = directorDetails.text().split(" ");
                    directorPost.setDirectorFirstName(arrayDirector[0]);
                    directorPost.setDirectorLastName(arrayDirector[arrayDirector.length-1]);
                }
                Document directorDetailsDoc = Jsoup.connect("https://www.afisha.ru" + directorLink).get();
                directorPost.setCountDirectorMovies(directorDetailsDoc.getElementsByClass("YWGaZ").size());
                directorPosts.add(directorPost);
            }
            directorPosts.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return directorPosts;
    }
}
