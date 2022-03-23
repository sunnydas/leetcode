public class DivideIntegers {

    public static int divide(int dividend, int divisor) {
        int quotient = 0;
        int remainder = 0;
        boolean resultBeNegative = false;
        if (dividend < 0) {
            dividend = Math.abs(dividend);
            resultBeNegative = true;
        }
        if (divisor < 0) {
            divisor = Math.abs(divisor);
            if (!resultBeNegative) {
                resultBeNegative = true;
            } else {
                resultBeNegative = false;
            }
        }
        while (dividend >= (remainder + divisor)) {
            quotient++;
            remainder += divisor;
        }
        if (dividend >= Integer.MAX_VALUE) {
            if (resultBeNegative) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        if (dividend <= Integer.MIN_VALUE) {
            if (!resultBeNegative) {
                return Integer.MAX_VALUE;
            }
            return Integer.MIN_VALUE;
        }
        if (quotient >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (quotient <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return resultBeNegative ? -quotient : quotient;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(-1, -1));
        System.out.println(divide(-2147483648, -1));
    }
}
