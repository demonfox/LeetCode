// The array-form of an integer num is an array representing its digits in left to right order.

// For example, for num = 1321, the array form is [1,3,2,1].
// Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

import java.util.ArrayList;
import java.util.List;

public class AddToArrayFormInteger {
  public List<Integer> addToArrayForm(int[] num, int k) {
    int carry = 0;
    ArrayList<Integer> result = new ArrayList<>();
    int i = num.length - 1;
    for (; i>=0;) {
      int kTemp = k % 10;
      result.add(0, (kTemp + num[i] + carry) % 10);
      carry = (kTemp + num[i] + carry) / 10;
      k /= 10;
      i--;
      if (k == 0)
        break;
    }

    for (;i>=0; i--) {
      result.add(0, (num[i] + carry) % 10);
      carry = (num[i] + carry) / 10;
    }
    while(k > 0) {
      result.add(0, (k%10 + carry) % 10);
      carry = (k%10 + carry) / 10;
      k /= 10;
    }
    if (carry > 0)
      result.add(0, carry);

    return result;
  }

  public static void Run() {
    AddToArrayFormInteger a = new AddToArrayFormInteger();
    System.out.println(a.addToArrayForm(new int[]{0}, 23));
    System.out.println(a.addToArrayForm(new int[]{1,2,0,0}, 34));
    System.out.println(a.addToArrayForm(new int[]{2,7,4}, 181));
    System.out.println(a.addToArrayForm(new int[]{2,1,5}, 806));
    System.out.println(a.addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1));
  }
}
