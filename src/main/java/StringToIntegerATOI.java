public class StringToIntegerATOI {

    public static int myAtoiAlt(String s) {
        int num = 0;
        s = s.trim();
        boolean isPositive = true;
        if (!s.equals("")) {
            if (s.charAt(0) == '-') {
                isPositive = false;
                s = s.substring(1);
            } else if (s.charAt(0) == '+') {
                isPositive = true;
                s = s.substring(1);
            }
            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                if (!Character.isDigit(current)) {
                    break;
                }
                int digit = current - '0';
                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    if (isPositive) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                num = 10 * num + digit;
            }
        }
        return isPositive ? num : -num;
    }

    public static int myAtoi(String s) {
        boolean isPositive = true;
        s = s.trim();
        if (s.startsWith("-")) {
            isPositive = false;
        }
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (i == 0 && (current == '+' || current == '-')) {
                continue;
            }
            if (Character.isDigit(current)) {
                number.append(current);
            } else {
                break;

            }
        }
        String numStr = number.toString();
        if (numStr.trim().equalsIgnoreCase("")) {
            return 0;
        }
        int finalVal = 0;
        try {
            long num = Long.parseLong(numStr);
            if (!isPositive) {
                num = -num;
            }
            if (num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                finalVal = (int) num;
            }
        } catch (NumberFormatException e) {
            if (numStr.length() > 10 && isPositive) {
                return Integer.MAX_VALUE;
            } else if (numStr.length() > 10 && !isPositive) {
                return Integer.MIN_VALUE;
            }
            return 0;
        }
        return finalVal;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoiAlt("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoiAlt("    -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoiAlt("4193 with words"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoiAlt("-91283472332"));
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoiAlt("20000000000000000000"));
    }

}
