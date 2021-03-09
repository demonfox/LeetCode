// Given a non-negative integer x, compute and return the square root of x.
// Since the return type is an integer, the decimal digits are truncated, 
// and only the integer part of the result is returned.

public class Sqrt {
  public int mySqrt(int x) {
    if (x == 0)
      return 0;
    int left = 1;
    int right = x;
    int mid = (left + right) / 2;

    while (left <= right) {
      //if (mid <= (int)(x / mid) && (int)(x / (mid + 1) - 1) < mid)
      //  return mid;
      if (mid > (int)(x / mid))
        right = mid-1;
      else
        left = mid+1;
      mid = (left + right) / 2;
    }
    return mid;
  }

  public static void Run() {
    Sqrt s = new Sqrt();
    System.out.println(s.mySqrt(4));
    System.out.println(s.mySqrt(8));
    System.out.println(s.mySqrt(9));
    System.out.println(s.mySqrt(0));
    System.out.println(s.mySqrt(Integer.MAX_VALUE));
  }
}
