import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {


    public static String longestPalindromeAlternate(String s) {
        String longestPalindrome = null;
        int longestPalindromeLength = 0;
        /*
        This uses logic from : https://www.youtube.com/watch?v=XYQecbcd6_c
         */
        for (int mid = 0; mid < s.length(); mid++) {
            int left = mid;
            int right = mid;
            // Odd case
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                int length = right - left + 1;
                //System.out.println(length);
                if (length > longestPalindromeLength) {
                    longestPalindrome = s.substring(left, right + 1);
                    longestPalindromeLength = length;
                }
                left--;
                right++;
            }
            //even case
            left = mid;
            right = mid + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                int length = right - left + 1;
                //System.out.println(length);
                if (length > longestPalindromeLength) {
                    longestPalindrome = s.substring(left, right + 1);
                    longestPalindromeLength = length;
                }
                left--;
                right++;
            }
        }
        return longestPalindrome;
    }

    public static String longestPalindrome(String s) {
        String longestPalindrome = null;
        Map<String, Boolean> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                String target = s.substring(i, j + 1);
                if (isPalindrome(target, cache) && (longestPalindrome == null
                        || target.length() > longestPalindrome.length())) {
                    longestPalindrome = target;
                }
            }
        }
        return longestPalindrome;
    }

    private static boolean isPalindrome(String s, Map<String, Boolean> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                cache.put(s, false);
                return false;
            }
            i++;
            j--;
        }
        cache.put(s, true);
        return true;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeAlternate(s));
        s = "cbbd";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeAlternate(s));
        s = "a";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeAlternate(s));
    }
}
