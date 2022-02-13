import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstringAlt(String s) {
        int lengthOfLongestSubstring = 0;
        if (s.length() > 1) {
            Map<Character, Integer> tracker = new HashMap<>();
            int i = 0;
            int j = 1;
            tracker.put(s.charAt(i), i);
            while (j < s.length()) {
                char current = s.charAt(j);
                if (!tracker.containsKey(current) || tracker.get(current) < i) {
                    tracker.put(current, j);
                    //System.out.println(current + " " + i + " " + j);
                    if (j == s.length() - 1) {
                        int curLength = j - i + 1;
                        if (curLength > lengthOfLongestSubstring) {
                            lengthOfLongestSubstring = curLength;
                        }
                    }
                    j++;
                } else {
                    //calculate length
                    //System.out.println(current + " " + i + " " + j);
                    //System.out.println(tracker);
                    int curLength = j - i;
                    if (curLength > lengthOfLongestSubstring) {
                        lengthOfLongestSubstring = curLength;
                    }
                    i = tracker.get(current);
                    i++;
                    tracker.put(current, j);
                    j++;
                }
            }
        } else if (s.length() == 1) {
            return 1;
        }
        //System.out.println();
        return lengthOfLongestSubstring;
    }

    public static int lengthOfLongestSubstring(String s) {
        int lengthOfLongestSubstring = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int curLength = 1;
            Set<Character> duplicateTracker = new HashSet<>();
            duplicateTracker.add(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                char end = arr[j];
                if (duplicateTracker.contains(end)) {
                    break;
                } else {
                    duplicateTracker.add(end);
                    curLength++;
                }
            }
            if (curLength > lengthOfLongestSubstring) {
                lengthOfLongestSubstring = curLength;
            }
        }
        return lengthOfLongestSubstring;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringAlt(s));
        s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringAlt(s));
        s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringAlt(s));
        s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringAlt(s));
        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringAlt(s));
        s = "";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringAlt(s));
        s = "au";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringAlt(s));
        s = " ";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringAlt(s));
    }

}
