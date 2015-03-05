// -----------  Problem Synopsis  ----------- //
// Reverse digits of an integer.
//
// Example1: x = 123, return 321
// Example2: x = -123, return -321
// ------------------------------------------ //

import java.util.LinkedList;
import java.util.Queue;

public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            x = -x;
            isNegative = true;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        while (x != 0) {
            q.add(x % 10);
            x /= 10;
        }
        while (!q.isEmpty()) {
            if (x != 0 && (Integer.MAX_VALUE - q.peek()) / x < 10)
                return 0;
            x = 10 * x + q.remove();
        }
        if (isNegative)
            x = -x;
        return x;
    }

    public static void Run() {
        ReverseInteger s = new ReverseInteger();
        System.out.println(s.reverse(2190));
        System.out.println(s.reverse(1534236469));
    }
}
