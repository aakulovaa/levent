package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import posts.sport.DancePost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DanceParser implements Parser {
    private int countDanceStudio = 0;
    private int countDesc = 1;
    public List<DancePost> parser() {
        List<DancePost> posts;
        try {
            posts = new ArrayList<>();
            Document doc = Jsoup.connect("https://likengo.ru/voronezh/guide/luchshie-tancevalnye-studii-goroda-dvigatsya-dvigatsya-dvigatsya-203.html").get();
            Elements danceLinkElements = doc.getElementsByClass("place-name");
            for (Element danceLinkElement : danceLinkElements) {
                DancePost dancePost = new DancePost();
                Elements link = danceLinkElement.getElementsByAttribute("href");
                String detailsLink = link.attr("href");
                dancePost.setDetailsLink(detailsLink);

                String name = danceLinkElement.text();
                dancePost.setNameDanceStudio(name);

                Element addressHref = doc.getElementsByClass("place-addr").get(countDanceStudio);
                dancePost.setAddress(addressHref.text());

                Element description = doc.getElementsByClass("article-content content-compilations clearfix").first();
                Element desc = description.getElementsByTag("p").get(countDesc);
                if(desc.text().isEmpty()){
                    countDesc--;
                    desc = description.getElementsByTag("p").get(countDesc);
                }
                dancePost.setDescription(desc.text());

                countDesc+=4;

                Element imageLinkElements = doc.getElementsByClass("place-cover").get(countDanceStudio);
                Elements image = imageLinkElements.getElementsByAttribute("src");
                String imageDetailsLink = image.attr("src");
                dancePost.setImageLink(imageDetailsLink);

                countDanceStudio++;
                dancePost.setDanceID(countDanceStudio);

                posts.add(dancePost);
            }
            //posts.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }
}
