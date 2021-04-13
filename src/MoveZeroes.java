// Given an integer array nums, move all 0's to the end of it while maintaining the relative order 
// of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.

public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int zeroesIndex = -1, nonzeroesIndex = -1;
    for (int i=0; i<nums.length; i++) {
      if (nums[i] == 0 && zeroesIndex == -1)
        zeroesIndex = i;
      if (nums[i] != 0 && nonzeroesIndex == -1)
        nonzeroesIndex = i;
      if (zeroesIndex != -1 && nonzeroesIndex != -1)
        break;
    }

    if (nonzeroesIndex == -1 || zeroesIndex == -1 || zeroesIndex == nums.length - 1)
      return;
    
    while (nonzeroesIndex < nums.length) {
      if (nums[nonzeroesIndex] != 0)
        if (nonzeroesIndex > zeroesIndex) {
          int temp = nums[nonzeroesIndex];
          nums[nonzeroesIndex] = nums[zeroesIndex];
          nums[zeroesIndex] = temp;
          zeroesIndex++;
        }
        nonzeroesIndex++;
    }
  }

  public void moveZeroes2(int[] nums) {
    int nextNonZeroIndex = 0;
    for (int i=0; i<nums.length; i++) {
      if (nums[i] != 0)
        nums[nextNonZeroIndex++] = nums[i];
    }
    for (int i=nextNonZeroIndex; i<nums.length; i++)
      nums[i] = 0;
  }

  public static void Run() {
    MoveZeroes m = new MoveZeroes();
    int[] input = new int[]{0, 1, 0, 3, 12};
    m.moveZeroes(input);
    for (int i : input)
      System.out.print(i + ", ");
    System.out.println();
    input = new int[]{0};
    m.moveZeroes(input);
    for (int i : input)
      System.out.print(i + ", ");
    System.out.println();
    input = new int[]{1, 0, 0};
    m.moveZeroes(input);
    for (int i : input)
      System.out.print(i + ", ");
    System.out.println();
  }
}
