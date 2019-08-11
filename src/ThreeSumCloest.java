// -----------  Problem Synopsis  ----------- //
// Given an array nums of n integers and an integer 
// target, find three integers in nums such that the 
// sum is closest to target. Return the sum of the 
// three integers. You may assume that each input 
// would have exactly one solution.
// ------------------------------------------ //

import java.util.Arrays;

public class ThreeSumCloest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else {
                    int currDiff = Math.abs(sum - target);
                    if (currDiff < diff) {
                        result = sum;
                        diff = currDiff;
                    }
                    if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }

        return result;
    }

    public static void Run() {
        ThreeSumCloest s = new ThreeSumCloest();
        int result = s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(result);
    }
}