package cinema;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class LoadMovieImage {
    public void loadImage() {
        String url = "https://s.afisha.ru/mediastorage/2a/05/4eebebd94b6041e892066224052a.jpg";
        String[] urlArr = url.split("\\.");
        String fileName = "src/main/resources/image/";
        if (urlArr.length >= 1) {
            fileName += 1 + "." + urlArr[urlArr.length - 1];
            BufferedInputStream in = null;
            FileOutputStream fout=null;
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

    }
}
