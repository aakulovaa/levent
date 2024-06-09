package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import posts.quest.QuestPost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestParser implements Parser{
    private int countQuest = 0;
    public List<QuestPost> parser() {
        List<QuestPost> posts;
        try {
            posts = new ArrayList<>();
            Document doc = Jsoup.connect("https://kvestam.ru").get();
            Elements questLinkElements = doc.getElementsByClass("similar-row");
            for (Element questLinkElement : questLinkElements) {
                QuestPost questPost = new QuestPost();
                String detailsLink = questLinkElement.attr("href");
                questPost.setDetailsLink(detailsLink);

                Document postDetailsDoc = Jsoup.connect("https://kvestam.ru" + detailsLink).get();

                Element name = postDetailsDoc.getElementsByClass("h-styled").getFirst();
                questPost.setName(name.text());

                Element imageLinkElements = postDetailsDoc.getElementsByAttributeValue("data-orbit-link","headline-1").getFirst();
                Elements image = imageLinkElements.getElementsByAttribute("src");
                String imageDetailsLink = "https://kvestam.ru" + image.attr("src");
                questPost.setImageLink(imageDetailsLink);

                Element description = postDetailsDoc.getElementsByAttributeValue("id","quest-description-content").getFirst();
                Element desc = description.getElementsByTag("p").getFirst();
                questPost.setDescription(desc.text());

                countQuest++;
                questPost.setQuestID(countQuest);

                Element countPlayers = postDetailsDoc.getElementsByClass("white-big").getFirst();
                questPost.setCountPlayer(countPlayers.text());

                Element location = postDetailsDoc.getElementsByClass("quest-description-expand").get(1);
                questPost.setLocation(location.text());

                Element age = postDetailsDoc.getElementsByClass("work-age").getFirst();
                questPost.setAge(age.text());

                posts.add(questPost);
            }
            //posts.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }
}
