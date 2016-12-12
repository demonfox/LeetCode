// -----------  Problem Synopsis  ----------- //
// Divide two integers without using multiplication,
// division and mod operator. If it is overflow,
// return MAX_INT.
// ------------------------------------------ //

public class DivideTwoIntegers {

    // slow version
//    public int divide(int dividend, int divisor) {
//        if (divisor == 0)
//            return Integer.MAX_VALUE;
//        if (dividend == 0)
//            return 0;
//        if (divisor == 1)
//            return dividend;
//        if (divisor == -1) {
//            if (dividend == Integer.MIN_VALUE)
//                return Integer.MAX_VALUE;
//            else
//                return -dividend;
//        }
//
//        int sign = ((dividend ^ divisor) >= 0) ? 1 : -1;
//
//        divisor = (divisor > 0) ? divisor : -divisor;
//
//        int result = -1;
//
//        if (dividend > 0) {
//            do {
//                dividend -= divisor;
//                ++result;
//            } while (dividend>=0);
//        } else {
//            do {
//                dividend += divisor;
//                ++result;
//            } while (dividend<=0);
//        }
//
//        return (sign == 1) ? result : -result;
//    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            else
                return -dividend;
        }
        if (divisor == Integer.MIN_VALUE)
            return (dividend == Integer.MIN_VALUE) ? 1 : 0;

        int sign = ((dividend ^ divisor) >= 0) ? 1 : -1;
        long divisorLong = (divisor > 0) ? divisor : -(long)divisor;
        long dividendLong = (dividend > 0) ? dividend : -(long)dividend;

        int result = (int) divideHelper(dividendLong, divisorLong);

        return (sign == 1) ? result : -result;
    }

    private long divideHelper(long dividend, long divisor) {
        long tempdivisor = divisor;
        long result = 1;

        if (divisor == dividend)
            return 1;
        else if (dividend < divisor)
            return 0;

        while (divisor <= dividend) {
            divisor <<= 1;
            result <<= 1;
        }

        divisor >>= 1;
        result >>= 1;

        return result + divideHelper(dividend - divisor, tempdivisor);
    }

    public static void Run() {
        DivideTwoIntegers r = new DivideTwoIntegers();
        System.out.println(r.divide(0, 1));
        System.out.println(r.divide(0, -10));
        System.out.println(r.divide(0, 0));
        System.out.println(r.divide(10, 0));
        System.out.println(r.divide(10, 5));
        System.out.println(r.divide(100, 1));
        System.out.println(r.divide(20, -3));
        System.out.println(r.divide(-30, 2));
        System.out.println(r.divide(60, 17));
        System.out.println(r.divide(-30, 7));
        System.out.println(r.divide(Integer.MIN_VALUE, 1));
        System.out.println(r.divide(Integer.MIN_VALUE, -1));
        System.out.println(r.divide(Integer.MAX_VALUE, 1));
        System.out.println(r.divide(Integer.MAX_VALUE, -1));
        System.out.println(r.divide(Integer.MAX_VALUE, 2));
        System.out.println(r.divide(Integer.MIN_VALUE, 2));
        System.out.println(r.divide(Integer.MIN_VALUE, -1109186033));
        System.out.println(r.divide(Integer.MIN_VALUE, 122481295));
        System.out.println(r.divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
}
