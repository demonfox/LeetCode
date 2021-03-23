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

  // using Newton's method
  public int mySqrt2(int y) {
    // let f(x) = x^2 - y
    // f'(x) = 2x
    // Pick a starting point (x0,y0), where y0 = f(x0) = x0^2 - y
    // the tangent line for f(x) at (x0, y0) is:
    // f'(x0)(x-x0) + y0 = 2x0(x-x0) + y0
    // x1 is where the tangent intersects with the x-axis, so:
    // 2x0(x1-x0) + y0 = 0, we have:
    // x1 = x0 - y0/2x0, since y0 = x0^2 - y
    // x1 = (x0 + y/x0) / 2;
    // 
    // In general, the tangent line L for f(x) is: f(x0)+f'(x0)(x-x0)
    // L intersects with the x-axis at f(x0)+f'(x0)(x-x0) = 0, so:
    // x1 = x0 - f(x0)/f'(x0)
    // In our case, f(x0) = x0^2 - y and f'(x0) = 2x0
    // so x1 = (x0 + y/x0) / 2
    // Pick some x0, say x0 = y, then loop
    long r = y; // using long to avoid overflow
    while (r*r > y) {
      r = (r + y / r) / 2;
    }
    return (int)r;
  }

  public static void Run() {
    Sqrt s = new Sqrt();
    System.out.println(s.mySqrt(4));
    System.out.println(s.mySqrt(8));
    System.out.println(s.mySqrt(9));
    System.out.println(s.mySqrt(0));
    System.out.println(s.mySqrt(Integer.MAX_VALUE));
    System.out.println(s.mySqrt2(4));
    System.out.println(s.mySqrt2(8));
    System.out.println(s.mySqrt2(9));
    System.out.println(s.mySqrt2(0));
    System.out.println(s.mySqrt2(Integer.MAX_VALUE));
  }
}
