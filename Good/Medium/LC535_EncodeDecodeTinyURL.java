package Good.Medium;
import java.util.*;
public class LC535_EncodeDecodeTinyURL {
    public class Codec {

        HashMap<Integer, String> map = new HashMap<>();
        int current = 0;
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String url = longUrl.replace("https://", "");
            map.put(current, url);
            String ret = "http://" + current;
            current++;
            return ret;
        }
    
        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String url = shortUrl.replace("http://", "");
            int val = Integer.valueOf(url);
            String ret = "https://" + map.get(val);
            return ret;
        }
    }
    
    public class Codec_S2 {

        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<String, String> map = new HashMap<>();
        int count = 1;
    
        public String getString() {
            int c = count;
            StringBuilder sb = new StringBuilder();
            while (c > 0) {
                c--;
                sb.append(chars.charAt(c % 62));
                c /= 62;
            }
            return sb.toString();
        }
    
        public String encode(String longUrl) {
            String key = getString();
            map.put(key, longUrl);
            return "http://tinyurl.com/" + key;
            count++;
        }
    
        public String decode(String shortUrl) {
            return map.get(shortUrl.replace("http://tinyurl.com/", ""));
        }
    }

    //Fixed length
    public class Codec_3 {
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<String, String> map = new HashMap<>();
        Random rand = new Random();
        String key = getRand();
    
        public String getRand() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(alphabet.charAt(rand.nextInt(62)));
            }
            return sb.toString();
        }
    
        public String encode(String longUrl) {
            while (map.containsKey(key)) {
                key = getRand();
            }
            map.put(key, longUrl);
            return "http://tinyurl.com/" + key;
        }
    
        public String decode(String shortUrl) {
            return map.get(shortUrl.replace("http://tinyurl.com/", ""));
        }
    }
}
