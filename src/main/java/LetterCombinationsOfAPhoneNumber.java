import java.util.*;
import java.util.stream.Collectors;

public class LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        Map<Integer, String> numberLookup = new HashMap<>();
        numberLookup.put(2, "abc");
        numberLookup.put(3, "def");
        numberLookup.put(4, "ghi");
        numberLookup.put(5, "jkl");
        numberLookup.put(6, "mno");
        numberLookup.put(7, "pqrs");
        numberLookup.put(8, "tuv");
        numberLookup.put(9, "wxyz");

        List<String> combinations = new ArrayList<>();
        generateCombinations(digits, combinations, numberLookup, 0);
        return combinations.stream().filter(s -> meetsCriteria(s, numberLookup, digits)).collect(Collectors.toSet()).
                stream().collect(Collectors.toList());
    }

    private static boolean meetsCriteria(String s, Map<Integer, String> lookup, String digits) {
        if (s.length() != digits.length()) {
            return false;
        }

        Map<Integer, Integer> tracker = new HashMap<>();
        for (int i = 0; i < digits.length(); i++) {
            tracker.put(Integer.parseInt("" + digits.charAt(i)), 0);
        }
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            Iterator<Map.Entry<Integer, String>> iterator = lookup.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, String> entry = iterator.next();
                if (entry.getValue().contains("" + current)) {
                    tracker.put(entry.getKey(), tracker.get(entry.getKey()) + 1);
                    break;
                }
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = tracker.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() <= 0) {
                return false;
            }
        }
        return true;
    }


    private static void generateCombinations(String digits,
                                             List<String> combinations,
                                             Map<Integer, String> lookup,
                                             int previousDigit) {
        if (digits.isEmpty()) {
            return;
        }
        char current = digits.charAt(0);
        int digit = Integer.parseInt("" + current);
        String rep = lookup.get(digit);
        if (combinations.size() == 0) {
            for (int i = 0; i < rep.length(); i++) {
                char next = rep.charAt(i);
                combinations.add("" + next);
            }
        } else {
            for (int i = 0; i < rep.length(); i++) {
                char next = rep.charAt(i);
                List<String> newCombinations = new ArrayList<>();
                for (String prev : combinations) {
                    int lastIndex = prev.length() - 1;
                    if ((previousDigit > 0 && previousDigit == digit) || !rep.contains("" + prev.charAt(lastIndex))) {
                        newCombinations.add(prev + next);
                    }
                }
                combinations.addAll(newCombinations);
            }
        }
        digits = digits.substring(1);
        generateCombinations(digits, combinations, lookup, digit);
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("234"));
        System.out.println(letterCombinations("22"));
        List<String> result = letterCombinations("999");
        System.out.println(result);
        result = letterCombinations("338");

        /*String[] e = new String[]{"www", "wwx", "wwy", "wwz", "wxw", "wxx", "wxy", "wxz", "wyw", "wyx", "wyy",
                "wyz", "wzw", "wzx", "wzy", "wzz", "xww", "xwx", "xwy", "xwz", "xxw", "xxx", "xxy", "xxz",
                "xyw", "xyx", "xyy", "xyz", "xzw", "xzx", "xzy", "xzz", "yww", "ywx", "ywy", "ywz", "yxw", "yxx",
                "yxy", "yxz", "yyw", "yyx", "yyy", "yyz", "yzw", "yzx", "yzy", "yzz", "zww", "zwx", "zwy", "zwz",
                "zxw", "zxx", "zxy", "zxz", "zyw", "zyx", "zyy", "zyz", "zzw", "zzx", "zzy", "zzz"};
        List<String> expected = Arrays.asList(e);
        //System.out.println(result.size());
        for (String from : result) {
            if (!expected.contains(from)) {
                System.out.println(from);
            }
        }*/
        System.out.println("########");
        System.out.println(result);
        String[] e = new String[]{"ddt", "ddu", "ddv", "det", "deu", "dev", "dft", "dfu", "dfv", "edt", "edu", "edv",
                "eet", "eeu", "eev", "eft", "efu", "efv", "fdt", "fdu", "fdv", "fet", "feu", "fev", "fft", "ffu", "ffv"};
        List<String> expected = Arrays.asList(e);
        //System.out.println(result.size());
        //System.out.println(expected.size());
        for (String from : result) {
            if (!expected.contains(from)) {
                System.out.println(from);
            }
        }
    }
}
