public class LongestCommonPrefix {


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
        strs = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
