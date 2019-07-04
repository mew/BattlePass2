package zone.nora.battlepass.util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Words {
    public static String[] fullWordsList;

    public static void grabWordsList() {
        InputStream in = null;
        try {
            in = new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words.txt").openStream();
            assert in != null;
            fullWordsList = IOUtils.toString(in).split("\n");
            System.out.println("Successfully loaded words list.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
        }
    }
}
