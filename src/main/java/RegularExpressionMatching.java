import java.util.regex.Pattern;

public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        return pattern.matcher(s).matches();
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
    }
}
