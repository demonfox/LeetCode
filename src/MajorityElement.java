// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ 
// times. You may assume that the majority element always exists in the array.
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else {
                if (nums[i] == candidate)
                    count++;
                else
                    count--;
            }
        }
        return candidate;
    }

    public static void Run() {
        MajorityElement m = new MajorityElement();
        System.out.println(m.majorityElement(new int[] {3,2,3}));
        System.out.println(m.majorityElement(new int[] {2,2,1,1,1,2,2}));
        System.out.println(m.majorityElement(new int[] {5,1,1,1,1,1,1,5,2,3,4}));
        System.out.println(m.majorityElement(new int[] {5,1,1,1,1,1,1,5,2,3,4,5,5,5,5,5}));
    }
}
