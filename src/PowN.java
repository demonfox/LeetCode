// Implement pow(x, n), which calculates x raised to the power n (i.e. xn).
public class PowN {
    public double myPow2(double x, int n) {
        if (n == 0)
            return 1;

        if (n < 0)
          return (n == Integer.MIN_VALUE) ? 1/x * 1/myPow2(x, Integer.MAX_VALUE) : 1/myPow2(x, -n);
        
        double r = myPow2(x, n >> 1);
        return ((n & 1) == 1) ? x * r * r : r * r;
    }

    public double myPow(double x, int n) {
        double result = 1.0;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                // note that x will not be 0 otherwise this would be an
                // invalid question
                result = 1/x;
                // add 1 to n so when flipping the sign, n will still
                // be in the range of INT_MAX
                n++; 
            }
            x = 1/x;
            n = -n;
        }
        while (n != 0) {
            if (n % 2 == 1)
                result = x * result;
            x *= x;
            n = n >> 1;
        }
        return result;
    }

    public static void Run() {
        PowN p = new PowN();
        System.out.println(p.myPow(2.0, 10));
        System.out.println(p.myPow2(2.0, 10));
        System.out.println(p.myPow(2.1, 3));
        System.out.println(p.myPow2(2.1, 3));
        System.out.println(p.myPow(0.0, 2));
        System.out.println(p.myPow2(0.0, 2));
        System.out.println(p.myPow(4.0, 0));
        System.out.println(p.myPow2(4.0, 0));
        System.out.println(p.myPow(2.0, -2));
        System.out.println(p.myPow2(2.0, -2));
        System.out.println(p.myPow(1.0, Integer.MIN_VALUE));
        System.out.println(p.myPow2(1.0, Integer.MIN_VALUE));
    }
}
