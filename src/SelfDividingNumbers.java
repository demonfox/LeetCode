// A self-dividing number is a number that is divisible by every digit it contains.
// For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
// A self-dividing number is not allowed to contain the digit zero.
// Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right] 
// (both inclusive).

import java.util.LinkedList;
import java.util.List;

public class SelfDividingNumbers {
  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> result = new LinkedList<>();
    for (int i = left; i <= right; i++) {
      if (isSelfDividingNumber(i))
        result.add(i);
    }
    return result;
  }

  private boolean isSelfDividingNumber(int num) {
    if (num < 10)
      return true;
    int temp = num;
    while (num > 0) {
      int n = num % 10;
      if (n == 0)
        return false;
      if (temp % n != 0)
        return false;
      num /= 10;
    }
    return true;
  }

  public static void Run() {
    SelfDividingNumbers sdn = new SelfDividingNumbers();
    System.out.println(sdn.selfDividingNumbers(1, 22));
    System.out.println(sdn.selfDividingNumbers(47, 85));
  }
}
