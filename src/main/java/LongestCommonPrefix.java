import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestCommonPrefix {


    public static String longestCommonPrefixAlt(String[] strs) {
        String longestCommonPrefix = "";
        if (strs.length > 1) {
            Map<String, Integer> trackerMap = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                String currentStr = strs[i];
                int end = currentStr.length() - 1;
                while (end >= 0) {
                    String prefix = currentStr.substring(0, end + 1);
                    if (trackerMap.containsKey(prefix)) {
                        trackerMap.put(prefix, trackerMap.get(prefix) + 1);
                    } else {
                        trackerMap.put(prefix, 1);
                    }
                    end--;
                }
            }
            Iterator<Map.Entry<String, Integer>> iterator = trackerMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = iterator.next();
                if (entry.getValue() == strs.length && entry.getKey().length() > longestCommonPrefix.length()) {
                    longestCommonPrefix = entry.getKey();
                }
            }
        } else if (strs.length == 1) {
            longestCommonPrefix = strs[0];
        }
        return longestCommonPrefix;
    }


    public static String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = "";
        if (strs.length > 1) {
            String first = strs[0];
            int start = 0;
            int end = first.length() - 1;
            while (end >= start) {
                String prefix = first.substring(start, end + 1);
                boolean matched = true;
                for (int i = 1; i < strs.length; i++) {
                    if (!strs[i].startsWith(prefix)) {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
                    longestCommonPrefix = prefix;
                    break;
                }
                end--;
            }
        } else if (strs.length == 1) {
            longestCommonPrefix = strs[0];
        }
        return longestCommonPrefix;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefixAlt(strs));
        strs = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefixAlt(strs));
        strs = new String[]{"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefixAlt(strs));
    }
}
