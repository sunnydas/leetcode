import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParenthesis {


    /*
    Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

n=2
     ["()()","(())"]
     ["((()))","(()())","(())()","()(())","()()()"]
     */

    public static List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        generateParenthesis(parenthesis, n);
        return parenthesis.stream().filter(s -> s.length() == 2 * n).collect(Collectors.toSet()).
                stream().collect(Collectors.toList());
    }

    private static void generateParenthesis(List<String> parentheses, int n) {
        if (n == 0) {
            return;
        }
        if (parentheses.isEmpty()) {
            parentheses.add("()");
        } else {
            List<String> newOnes = new ArrayList<>();
            for (String parenthesis : parentheses) {
                for (int i = 0; i < parenthesis.length(); i++) {
                    String newOne = parenthesis.substring(0, i) + "()" + parenthesis.substring(i);
                    newOnes.add(newOne);
                }
            }
            parentheses.addAll(newOnes);
        }
        generateParenthesis(parentheses, --n);
    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
