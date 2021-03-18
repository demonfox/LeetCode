import java.util.Arrays;

// Given an array nums with n objects colored red, white, or blue, sort them in-place 
// so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

public class SortColors {
  public void sortColors(int[] nums) {
    int redIndex = -1;
    int blueIndex = nums.length;
    int temp;

    for (int i = 0; i < nums.length;) {
      switch (nums[i]) {
      case 0:
        redIndex++;
        if (redIndex != i) {
          temp = nums[redIndex];
          nums[redIndex] = nums[i];
          nums[i] = temp;
        } else
          i++;
        break;
      case 1:
        i++;
        break;
      case 2:
        if (blueIndex > i) {
          blueIndex--;
          temp = nums[blueIndex];
          nums[blueIndex] = nums[i];
          nums[i] = temp;
        } else
          i++;
        break;
      }
    }
  }

  public static void Run() {
    SortColors s = new SortColors();
    int[] input = new int[] { 2, 0, 2, 1, 1, 0 };
    s.sortColors(input);
    for (int i : input)
      System.out.print(i);
    System.out.println();
  }
}
