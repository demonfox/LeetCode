// A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the 
// bottom to represent the minutes (0-59). Each LED represents a zero or one, with the 
// least significant bit on the right.
// Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring
// the PM), return all possible times the watch could represent. You may return the answer in 
// any order.
// The hour must not contain a leading zero.
// For example, "01:00" is not valid. It should be "1:00".
// The minute must consist of two digits and may contain a leading zero.
// For example, "10:2" is not valid. It should be "10:02".

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
  public List<String> readBinaryWatch(int turnedOn) {
    List<String> result = new ArrayList<>();
    for (int h=0; h<12; h++) {
      for (int m=0; m<60; m++) {
        if ((Integer.bitCount(h) + Integer.bitCount(m)) == turnedOn) {
          result.add(String.format("%d:%02d", h, m));
        }
      }
    }
    return result;
  }

  private int[] hours = new int[]{1, 2, 4, 8};
  private int[] minutes = new int[]{1, 2, 4, 8, 16, 32};
  private void helper(List<String> result, int hour, int minute, int turnedOn, int startIndex) {
    if (turnedOn == 0) {
      result.add(String.format("%d:%02d", hour, minute));
      return;
    }
    for (int i=startIndex; i<hours.length + minutes.length; i++) {
      if (i < hours.length) {
        if ((hours[i] + hour) < 12)
          helper(result, hour + hours[i], minute, turnedOn-1, i+1);
      } else {
        if ((minutes[i - hours.length] + minute) < 60)
          helper(result, hour, minute + minutes[i - hours.length], turnedOn-1, i+1);
      }
    }
  }

  public List<String> readBinaryWatch2(int turnedOn) {
    ArrayList<String> result = new ArrayList<>();
    helper(result, 0, 0, turnedOn, 0);
    return result;
  }

  public static void Run() {
    BinaryWatch b = new BinaryWatch();
    //List<String> result = b.readBinaryWatch(1);
    //result.forEach(i -> System.out.println(i));
    List<String> result = b.readBinaryWatch2(9);
    result.forEach(i -> System.out.println(i));
  }
}
