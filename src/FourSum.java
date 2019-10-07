// -----------  Problem Synopsis  ----------- //
// Given an array nums of n integers and an integer 
// target, are there elements a, b, c, and d in 
// nums such that a + b + c + d = target? Find 
// all unique quadruplets in the array which 
// gives the sum of target.
// Note:
// The solution set must not contain duplicate quadruplets.
// ------------------------------------------ //

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[]num, int target) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(num);
        for(int i=0; i<num.length-3; i++) {
                if(((i==0) || (num[i] !=num[i-1]))) {
                int nTarget = target - num[i];
                result.addAll(threeSum(num, i, nTarget));
            }
        }
        return result;
    }
    public List<List<Integer>> threeSum(int[] num, int index, int target) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i=index+1; i<num.length-2; i++) {
            if ((i == index + 1) || num[i] != num[i-1]) {
                int j = i+1;
                int k = num.length-1;
                int nTarget = target - num[i];
                while (j < k) {
                    int sum = num[j] + num[k];
                    if (sum == nTarget) {
                        List<Integer> r = new LinkedList<Integer>();
                        r.add(num[index]);
                        r.add(num[i]);
                        r.add(num[j]);
                        r.add(num[k]);
                        result.add(r);
                        j++;
                        k--;
                        while(j<k) {
							if(num[j] == num[j-1]) {
								j++;
							} else if(num[k] == num[k+1]){
								k--;
							} else {
								break;
							}
						}
                    } else if (sum < nTarget) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            
        }

        return result;
    }

    private static void Print(List<List<Integer>> input) {
        Iterator<List<Integer>> iter1 = input.iterator();
        
        while (iter1.hasNext()) {
            System.out.println(Arrays.toString(iter1.next().toArray()));
        }
    }
    
    public static void Run() {
        FourSum s = new FourSum();
        Print(s.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
        System.out.println();
        s = new FourSum();
        Print(s.fourSum(new int[] {-2,6,3,1,-6,-2,9,-3,0,-7,8,-10,-4,9,1,1,-5,-9}, 21));
        System.out.println();
        s = new FourSum();
        Print(s.fourSum(new int[] {-1,0,1,2,-1,-4}, -1));
    }
}