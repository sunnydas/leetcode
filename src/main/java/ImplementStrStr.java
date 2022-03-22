public class ImplementStrStr {

    public static int strStr(String haystack, String needle) {
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        if (needle.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (containsSubstring(hay, need, i)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean containsSubstring(char[] hay, char[] needle, int i) {
        int k = 0;
        if(needle.length > hay.length - i){
            return false;
        }
        for (int j = i; j < hay.length && k < needle.length; j++) {
            if (hay[j] != needle[k]) {
                return false;
            }
            k++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hell0", "ll"));
    }
}
