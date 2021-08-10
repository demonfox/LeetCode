// Given two integers a and b, return the sum of the two integers without using the operators + and -.

public class SumOfTwoIntegers {
  public int getSum(int a, int b) {
    // Key insight: A+B=A^B+(A&B)<<1;
    int AxorB = a ^ b;
    int AandB = a & b;
    while (AandB != 0) {
      int nextA = AxorB;
      int nextB = AandB << 1;
      AxorB = nextA ^ nextB;
      AandB = nextA & nextB;
    }
    return AxorB;
  }

  public static void Run() {
    SumOfTwoIntegers s = new SumOfTwoIntegers();
    System.out.println(s.getSum(3, 5));
    System.out.println(s.getSum(101, 0));
    System.out.println(s.getSum(35, 65));
    System.out.println(s.getSum(32, -9));
  }
}

