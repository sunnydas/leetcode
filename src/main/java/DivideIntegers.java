public class DivideIntegers {


    public static int divide(int dividend, int divisor) {
        //solution from https://redquark.org/leetcode/0029-divide-two-integers/
        // Check for overflow
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        // Sign of result
        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
        // Quotient
        int quotient = 0;
        // Take the absolute value
        long absoluteDividend = Math.abs((long) dividend);
        long absoluteDivisor = Math.abs((long) divisor);
        // Loop until the  dividend is greater than divisor
        while (absoluteDividend >= absoluteDivisor) {
            // This represents the number of bits shifted or
            // how many times we can double the number
            int shift = 0;
            while (absoluteDividend >= (absoluteDivisor << shift)) {
                shift++;
            }
            // Add the number of times we shifted to the quotient
            quotient += (1 << (shift - 1));
            // Update the dividend for the next iteration
            absoluteDividend -= absoluteDivisor << (shift - 1);
        }
        return sign == -1 ? -quotient : quotient;
    }


    public static int divideAlt(int dividend, int divisor) {
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
        if (divisor == 1) {
            if (dividend <= Integer.MIN_VALUE || dividend >= Integer.MAX_VALUE) {
                return resultBeNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                return resultBeNegative ? -dividend : dividend;
            }
        }
        while (dividend - divisor >= remainder) {
            quotient++;
            remainder += divisor;
        }
        return resultBeNegative ? -quotient : quotient;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(-1, -1));
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(2147483647, 1));
        System.out.println(divide(-2147483648, -1));
        System.out.println();
        System.out.println(divide(2147483647, 2));
    }
}
