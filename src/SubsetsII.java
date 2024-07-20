import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
   if (nums == null) return new ArrayList<List<Integer>>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    helper(result, nums, 0, new ArrayList<>());
    return result;      
  }

  private void helper(List<List<Integer>> result, int[] nums, int index, List<Integer> temp) {
    result.add(new ArrayList<Integer>(temp));

    HashSet<Integer> set = new HashSet<>();
    for (int i=index; i<nums.length; i++) {
      if (set.contains(nums[i]))
        continue;
      temp.add(nums[i]);
      helper(result, nums, i+1, temp);
      Integer num = temp.remove(temp.size()-1);
      set.add(num);
    }
  }

  public static void Run() {
    int[] nums = {1,2,2};
    SubsetsII s = new SubsetsII();
    List<List<Integer>> result = s.subsetsWithDup(nums);
    System.out.println(result);
    nums = new int[]{4,4,4,1,4};
    result = s.subsetsWithDup(nums);
    System.out.println(result);
  }
}
