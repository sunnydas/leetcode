
public class ReverseInteger {


    public static int reverseEditorial(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE || rev > Integer.MAX_VALUE / 10) {
                return 0;
            } else if (rev < Integer.MIN_VALUE || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            rev = 10 * rev + pop;
        }
        return rev;
    }

    public static int reverseAlt(int x) {
        int i = Math.abs(x);
        StringBuilder reversed = new StringBuilder();
        if (x < 0) {
            reversed.append("-");
        }
        while (i > 0) {
            reversed.append(i % 10);
            i = i / 10;
        }
        try {
            return Integer.parseInt(reversed.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int reverse(int x) {
        char[] rep = String.valueOf(x).toCharArray();
        int i = 0;
        int j = rep.length - 1;
        while (i < j) {
            char temp = rep[i];
            rep[i] = rep[j];
            rep[j] = temp;
            i++;
            j--;
        }
        String reversed = String.valueOf(rep);
        boolean positive = true;
        if (reversed.charAt(reversed.length() - 1) == '-') {
            reversed = "-" + reversed.substring(0, reversed.length() - 1);
            positive = false;
        }
        try {
            int value = Integer.parseInt(reversed);
            if (positive && value < 0) {
                return 0;
            }
            return value;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverseAlt(-123));
        System.out.println(reverseEditorial(-123));
    }

}
