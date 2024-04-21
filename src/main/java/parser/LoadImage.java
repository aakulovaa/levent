package parser;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class LoadImage {
    public String loadImage(String resourceAsStream, Integer iterator, String pageName) {
        String url = resourceAsStream;
        String fileName = "src/main/resources/image/";
        if(!url.isEmpty()) {
            String[] urlArr = url.split("\\.");
            if (urlArr.length >= 1) {
                fileName += pageName + iterator + "." + urlArr[urlArr.length - 1];
                BufferedInputStream in = null;
                FileOutputStream fout = null;
                try {
                    in = new BufferedInputStream(new URL(url).openStream());
                    fout = new FileOutputStream(fileName);
                    byte data[] = new byte[1024];
                    int count;
                    while ((count = in.read(data, 0, 1024)) != -1) {
                        fout.write(data, 0, count);
                        fout.flush();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        if (in != null) {
                            in.close();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } finally {
                        try {
                            if (fout != null) {
                                fout.close();
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }else{
            fileName+="le1.png";
        }
        String[] imgLinkSource = fileName.split("resources");
        String imgLinkSrc = imgLinkSource[1];

        return imgLinkSrc;
    }
}
