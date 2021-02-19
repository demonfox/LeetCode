// -----------  Problem Synopsis  ----------- //
// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
// Find all unique triplets in the array which gives the sum of zero.
// 
// Note:
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
// The solution set must not contain duplicate triplets.
//     For example, given array S = {-1 0 1 2 -1 -4},
// 
//     A solution set is:
//     (-1, 0, 1)
//     (-1, -1, 2)
// ------------------------------------------ //

import java.util.*;

public class ThreeSum {
    private HashSet<List<Integer>> result = new HashSet<List<Integer>>();
    
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        //System.out.println(Arrays.toString(num));
        for (int i=num.length-1; i>=2; i--) {
            helper(num, 0, i-1, num[i]);
        }
       
        ArrayList<List<Integer>> rtrn = new ArrayList<List<Integer>>();
        rtrn.addAll(result);
        return rtrn;
    }
    
    private void helper(int[] num, int i, int j, int total) {
        while (i < j) {
            int sum = num[i] + num[j];
            if (sum == -total) {
                List<Integer> r = new ArrayList<Integer>();
                r.add(num[i]);
                r.add(num[j]);
                r.add(total);
                result.add(r);
                i++;
                j--;
            } else if (sum < -total) {
                i++;
            } else {
                j--;
            }
        }
    }
    
    private static void Print(List<List<Integer>> input) {
        Iterator<List<Integer>> iter1 = input.iterator();
        
        while (iter1.hasNext()) {
            System.out.println(Arrays.toString(iter1.next().toArray()));
        }
    }
    
    public static void Run() {
        ThreeSum s = new ThreeSum();
        //Print(s.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        Print(s.threeSum(new int[] {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6}));
    }
}
