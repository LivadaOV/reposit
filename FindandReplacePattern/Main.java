import java.util.*;

public class Main {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == pattern.length() && matches(words[i], pattern)) {
                list.add(words[i]);
            }
        }
        return list;
    }

    public static void main(String[] args){
    }

    private static boolean matches(String str, String pattern) {

        Map<Character,Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char temp1 = str.charAt(i);
            char temp2 = pattern.charAt(i);
            if(map.get(temp2) == null && !map.containsValue(temp1)){
                map.put(temp2, temp1);
                sb.append(temp1);
            }else {
                sb.append(map.get(temp2) != null ? map.get(temp2):"");
            }

        }
        return sb.toString().equals(str);
    }
}
