public class ValidPerfectSquare {
  public boolean isPerfectSquare(int num) {
    int l = 1, u = num;
    int m = (u - l)/2 + l;
    while (l <= u) {
      if ((double)m > (double)num / m) {
        u = m - 1;
      } else if ((double)m < (double)num / m) {
        l = m + 1;
      } else {
        return true;
      }
      m = (u - l)/2 + l;
    }
    return false;
  }

  public static void Run() {
    ValidPerfectSquare v = new ValidPerfectSquare();
    System.out.println(v.isPerfectSquare(1));
    System.out.println(v.isPerfectSquare(4));
    System.out.println(v.isPerfectSquare(9));
    System.out.println(v.isPerfectSquare(10));
    System.out.println(v.isPerfectSquare(11));
    System.out.println(v.isPerfectSquare(12));
    System.out.println(v.isPerfectSquare(13));
    System.out.println(v.isPerfectSquare(14));
    System.out.println(v.isPerfectSquare(15));
    System.out.println(v.isPerfectSquare(16));
    System.out.println(v.isPerfectSquare(100));
    System.out.println(v.isPerfectSquare(Integer.MAX_VALUE));
  }
}
