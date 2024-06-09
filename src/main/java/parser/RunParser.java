package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import posts.sport.SportPost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RunParser implements Parser{
    public List<SportPost> parser(){
        List<SportPost> posts;
        try {
            posts = new ArrayList<>();
            Document doc = Jsoup.connect("https://5verst.ru/voronezhcentralpark/").get();
            Element sportElement = doc.getElementsByClass("logo-name").getFirst();

            SportPost sportPost = new SportPost();

            String name = sportElement.text();
            sportPost.setName(name);

            Element sportLogo = doc.getElementsByClass("logo-desc").get(1);

            String logo = sportLogo.text();
            sportPost.setLogeDesc(logo);

            Element sportLinkElement = doc.getElementsByClass("site-nav-title").first();
            if (sportLinkElement != null) {
                Elements link = sportLinkElement.getElementsByAttribute("href");
                String detailsLink = link.attr("href");
                sportPost.setSportLink(detailsLink);
            }

            Element addressHref = doc.getElementsByClass("knd-block-info__content").get(1);
            Element desc = addressHref.getElementsByTag("p").getFirst();
            String[] addressAndDate = desc.text().split(" Читайте подробнее на странице Трасса.");
            sportPost.setAddress(addressAndDate[0]);

            sportPost.setDateStart(addressAndDate[1]);

            Element description = doc.getElementsByClass("knd-block-cta__text").first();
            sportPost.setDescription(description != null ? description.text() : null);

            Element imageLinkElements = doc.getElementsByClass("knd-block-cta__figure").first();
            Elements image = null;
            if (imageLinkElements != null) {
                image = imageLinkElements.getElementsByAttribute("src");
                String imageDetailsLink = image.attr("src");
                sportPost.setImageLink(imageDetailsLink);
            }

            sportPost.setSportID(1);

            posts.add(sportPost);
            //posts.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }
}
