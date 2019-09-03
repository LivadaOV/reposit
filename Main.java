import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

        public static String formatDuration(int seconds) {

            List<String> list = new ArrayList<>();

            int years = 0;
            int days = 0;
            int hours = 0;
            int minutes = 0;

            String y = " year";
            String d = " day";
            String h = " hour";
            String m = " minute";
            String s = " second";

            if(seconds == 0) return "now";

            while (seconds >=  60) {
                minutes += 1;
                seconds -= 60;
            }
            while (minutes >=  60) {
                hours += 1;
                minutes -=  60;
            }
            while (hours >=  24) {
                days += 1;
                hours -=  24;
            }
            while (days >=  365) {
                years += 1;
                days -=  365;
            }

            if (years > 0) {
                if(years > 1) {
                    y += "s";
                }
                  list.add(years + y);
                }
            if (days > 0) {
                if(days > 2) {
                    d += "s";
                }
                  list.add(days + d);
                }

            if (hours > 0) {
                if(hours > 1) {
                    h += "s";
                }
                   list.add(hours + h);
                }
            if (minutes > 0) {
                if(minutes > 1) {
                    m += "s";
                }
                   list.add(minutes + m);
                }
            if (seconds > 0) {
                if(seconds > 1) {
                    s += "s";
                }
                    list.add(seconds + s);
                }
            String str = String.valueOf(list);
            String st [] = list.toArray(new String[list.size()]);

            if(st.length == 1) {
                return st[0];
            }

            String str1 = str.replaceAll("[\\[\\]]", "")
                    .replace(st[st.length-1], "and " + st[st.length - 1]);
            return str1;

        }

    public static void main(String[] args) {
            System.out.println(formatDuration(0));
    }
}
