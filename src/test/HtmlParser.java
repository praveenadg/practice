package test;

import java.util.HashMap;
import java.util.Map;

public class HtmlParser {
    public static void main(String[] args) {
        System.out.println(entityParser("and I quote: &quot;...&quot;"));
    }
        public static String entityParser(String text) {

            Map<String, String> specialChars = new HashMap<>();
            specialChars.put("&apos;", "'");
            specialChars.put("&quot;", "\"");
            specialChars.put("&amp;", "&");
            specialChars.put("&gt;", ">");
            specialChars.put("&lt;", "<");
            specialChars.put("&frasl;", "/");
            if(text==null || text.length()==0)
                return text;

            String[] arr = text.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for(String word : arr){
                if(specialChars.containsKey(word)){
                    stringBuilder.append(specialChars.get(word)).append(" ");
                } else {
                    stringBuilder.append(word).append(" ");
                }
            }
            return stringBuilder.toString().trim();
        }

}
