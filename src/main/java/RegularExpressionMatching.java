public class RegularExpressionMatching {

   /* public static boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        return pattern.matcher(s).matches();
    }*/


    /*
     Editorial
     */
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        //first match logic
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }


    public static boolean isMatchAlt(String s, String p) {
        if (!p.contains(".") && !p.contains("*")) {
            return p.equals(s);
        }
        int i = 0;
        int j = 0;
        //"aabcd"
        // ".*e.*"
        Character previousCharForWildcard = null;
        while (i < s.length() && j < p.length()) {
            char currentChar = s.charAt(i);
            char currentPattern = p.charAt(j);
            if ((currentPattern == '*') && (previousCharForWildcard == null || currentChar == previousCharForWildcard)) {
                i++;
                previousCharForWildcard = currentChar;
            } else if (currentPattern == '.') {
                previousCharForWildcard = currentChar;
                i++;
                j++;
            } else if (currentChar == currentPattern) {
                i++;
                j++;
                previousCharForWildcard = currentChar;
            } else if (currentChar != currentPattern) {
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    j = j + 2;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println(i + " " + j);
        if (i < s.length() - 1 || j < p.length() - 1) {
            if (j < p.length() - 1) {
                char x = p.charAt(p.length() - 1);
                if (x == s.charAt(s.length() - 1)) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
       /* System.out.println(isMatch("aa", "a"));
        System.out.println(isMatchAlt("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatchAlt("aa", "aa"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatchAlt("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatchAlt("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatchAlt("aab", "c*a*b"));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatchAlt("ab", ".*c"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatchAlt("aab", "c*a*b"));
        *//*
        "mississippi"
"mis*is*ip*."
         */
        System.out.println(isMatch("ab", ".*c"));
        //System.out.println(isMatchAlt("mississippi", "mis*is*ip*."));
    }
}
