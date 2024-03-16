public class ArrangeCoins {
  public int arrangeCoins(int n) {
    // k complete rows, total sum is k(1+k)/2
    // k(1+k)/2 <= n
    // k^2 + k - 2n <= 0
    // root of k^2 + k - 2n = 0
    // (-1 + sqrt(1+8n))/2 and (-1 - sqrt(1+8n))/2
    // however we need to be careful how to write this: 
    // if we just write 8n, then it is an integer and that can overflow whenre 8n > INT_MAX
    // so we need to write it like this:
    int result = (int)((-1 + Math.sqrt(1.0+8.0*n)) / 2);
    System.out.println(Double.MAX_VALUE);
    return result;

    // (-1 + sqrt(1+8n))/2 = sqrt(n + 1/8) * sqrt(2) - 0.5
    
    // the reason is when n == Integer.MAX_VALUE, n + 1/8 s
    // return (int)Math.sqrt(n + 1/8) * Math.sqrt(2) - 0.5;
  }

  public static void Run() {
    ArrangeCoins a = new ArrangeCoins();
    System.out.println(a.arrangeCoins(1));
    System.out.println(a.arrangeCoins(5));
    System.out.println(a.arrangeCoins(6));
    System.out.println(a.arrangeCoins(Integer.MAX_VALUE - 1));
    System.out.println(a.arrangeCoins(Integer.MAX_VALUE));
  }
}
