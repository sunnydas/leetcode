import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        /*
        Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
         */
        int i = 0;
        int number = 0;
        Map<Character, Integer> lookup = new HashMap<>();
        lookup.put('I', 1);
        lookup.put('V', 5);
        lookup.put('X', 10);
        lookup.put('L', 50);
        lookup.put('C', 100);
        lookup.put('D', 500);
        lookup.put('M', 1000);


        while (i < s.length()) {
            char current = s.charAt(i);
            int next = i + 1;
            if (
                    (current == 'I' && next < s.length() && (s.charAt(next) == 'V' || s.charAt(next) == 'X'))
                            || (current == 'X' && next < s.length() && (s.charAt(next) == 'L' || s.charAt(next) == 'C'))
                            || (current == 'C' && next < s.length() && (s.charAt(next) == 'D' || s.charAt(next) == 'M'))
            ) {
                number += (lookup.get(s.charAt(next)) - lookup.get(current));
                i += 2;
            } else {
                number += lookup.get(current);
                i++;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

}
