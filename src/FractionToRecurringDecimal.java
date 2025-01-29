// Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
// If the fractional part is repeating, enclose the repeating part in parentheses.
// If multiple answers are possible, return any of them.
// It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

import java.util.HashMap;

public class FractionToRecurringDecimal {
  public String fractionToDecimal(int numerator, int denominator) {
    StringBuilder result = new StringBuilder();
    if (numerator == 0) return "0";
    long numeratorLong = numerator, denominatorLong = denominator;
    if (numerator < 0) {
      numeratorLong = (numerator == Integer.MIN_VALUE) ? 2147483648L : -numerator;
      if (denominator < 0)
        denominatorLong = (denominator == Integer.MIN_VALUE) ? 2147483648L : -denominator;
      else
        result.append("-");
    } else {
      if (denominator < 0) {
        denominatorLong = (denominator == Integer.MIN_VALUE) ? 2147483648L : -denominator;
        result.append("-");
      }
    }

    long quotient = numeratorLong / denominatorLong;
    long remainder = numeratorLong % denominatorLong;
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();

    result.append(quotient);
    if (remainder != 0)
      result.append(".");

    int indexAfterDecimalPoint = result.length();

    map.put(remainder, indexAfterDecimalPoint);
    while(remainder != 0) {
      while (true) {
        remainder *= 10;
        if (remainder < denominatorLong) {
          result.append(0);
          indexAfterDecimalPoint++;
        }
        else
          break;
      }
      quotient = remainder / denominatorLong;
      remainder = remainder % denominatorLong;
      result.append(quotient);
      if (map.containsKey(remainder)) {
        result.insert(map.get(remainder), "(");
        result.append(")");
        break;
      } else {
        indexAfterDecimalPoint++;
        map.put(remainder, indexAfterDecimalPoint);
      }
    }

    return result.toString();
  }

  public static void Run() {
    FractionToRecurringDecimal f = new FractionToRecurringDecimal();
    System.out.println(f.fractionToDecimal(-1, -Integer.MIN_VALUE));
    System.out.println(f.fractionToDecimal(1, -Integer.MIN_VALUE));
    System.out.println(f.fractionToDecimal(-50, 8));
    System.out.println(f.fractionToDecimal(20, -4));
    System.out.println(f.fractionToDecimal(-22, -2));
    System.out.println(f.fractionToDecimal(1, 2));
    System.out.println(f.fractionToDecimal(2, 1));
    System.out.println(f.fractionToDecimal(2, 3));
    System.out.println(f.fractionToDecimal(4, 333));
    System.out.println(f.fractionToDecimal(1, 3));
    System.out.println(f.fractionToDecimal(2, 5));
    System.out.println(f.fractionToDecimal(1, 6));
    System.out.println(f.fractionToDecimal(1, 1));
  }
}
