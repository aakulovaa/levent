package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import posts.master_classes.MasterClassesPost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MasterClassesParser {
    private int countMC = 0;
    public List<MasterClassesPost> parser() {
        List<MasterClassesPost> posts;
        try {
            posts = new ArrayList<>();
            Document doc = Jsoup.connect("https://www.tripadvisor.ru/Attractions-g798124-Activities-c41-a_attractionType.SUPPLIERS-Voronezh_Voronezh_Oblast_Central_Russia.html").get();
            Elements mcLinkElements = doc.getElementsByClass("ALtqV z");
            for (Element mcLinkElement : mcLinkElements) {
                MasterClassesPost masterClassesPost = new MasterClassesPost();
                Elements mcLink = mcLinkElement.getElementsByClass("alPVI eNNhq rhmaA vkvpU");
                String detailsLink = mcLink.attr("href");
                masterClassesPost.setDetailsLink(detailsLink);

                Document postDetailsDoc = Jsoup.connect(detailsLink).get();

                Element name = postDetailsDoc.getElementsByClass("XQCOK").getFirst();
                Element nameDesc = name.getElementsByTag("span").getFirst();
                masterClassesPost.setName(nameDesc.text());

                Element categoryHref = postDetailsDoc.getElementsByClass("XHUQd").getFirst();
                Elements category = categoryHref.getElementsByClass("biGQs _P pZUbB avBIb hmDzD");
                masterClassesPost.setCategory(category.text());

                Element imageLinkElements = postDetailsDoc.getElementsByClass("yMdQy w").getFirst();
                Element imageLinkElement = imageLinkElements.getElementsByClass("NhWcC _R bfZCm mdkdE afQPz eXZKw").getFirst();
                Elements image = imageLinkElement.getElementsByAttribute("src");
                String imageDetailsLink = image.attr("src");
                masterClassesPost.setImageLink(imageDetailsLink);

                Element description = postDetailsDoc.getElementsByClass("biGQs _P pZUbB KxBGd").getFirst();
                Element desc = description.getElementsByClass("JguWG").getFirst();
                masterClassesPost.setDescription(desc.text());

                countMC++;
                masterClassesPost.setMasterClassID(countMC);

                posts.add(masterClassesPost);
            }
            posts.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }
}
