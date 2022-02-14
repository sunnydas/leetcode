
public class ReverseInteger {

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
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(Integer.MAX_VALUE));
    }

}
