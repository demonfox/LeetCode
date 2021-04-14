public class FindDuplicateNumber {
  public int findDuplicate(int[] nums) {
    for (int i=0; i<nums.length-1;) {
      if (i == nums[i] - 1)
        i++;
      else {
        if (nums[i] == nums[nums[i]-1])
          return nums[i]; // we found the duplicate
        else {
          int temp = nums[nums[i]-1];
          nums[nums[i]-1] = nums[i];
          nums[i] = temp;
        }
      }
    }
    return nums[nums.length-1];
  }

  public int findDuplicate2(int[] nums) {
    int slow, fast;
    slow = nums[0];
    fast = nums[0];
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);
    slow = nums[0];
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }

  public static void Run() {
    FindDuplicateNumber f = new FindDuplicateNumber();
    System.out.println(f.findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
    System.out.println(f.findDuplicate2(new int[] { 1, 3, 4, 2, 2 }));
    System.out.println(f.findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
    System.out.println(f.findDuplicate2(new int[] { 3, 1, 3, 4, 2 }));
    System.out.println(f.findDuplicate(new int[] { 1, 1 }));
    System.out.println(f.findDuplicate2(new int[] { 1, 1 }));
    System.out.println(f.findDuplicate(new int[] { 1, 1, 2 }));
    System.out.println(f.findDuplicate2(new int[] { 1, 1, 2 }));
  }
}
