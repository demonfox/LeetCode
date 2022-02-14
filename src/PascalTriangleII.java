// Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
  public List<Integer> getRow(int rowIndex) {
    // using the fact that (a+b)^n = Sigma(C(n,k) * a^k * b^(n-k))_for_k=0_to_n
    List<Integer> result = new ArrayList<Integer>();
    if (rowIndex == 0) {
      result.add(1);
    } else {
      double prevNumerator = rowIndex;
      double prevDenominator = 1;
      double temp = 1;
      result.add(1);
      for (int i = 2; i < (rowIndex + 1); i++) {
        temp = temp * prevNumerator / prevDenominator;
        result.add((int)temp);
        prevNumerator -= 1.0;
        prevDenominator += 1.0;
      }
      result.add(1);
    }
    return result;
  }

  public static void Run() {
    PascalTriangleII p = new PascalTriangleII();
    p.getRow(3).forEach(i -> System.out.print(i + " "));
    System.out.println();
  }
}
