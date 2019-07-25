// -----------  Problem Synopsis  ----------- //
// Given n non-negative integers a1, a2, ..., an , 
// where each represents a point at coordinate (i, ai). 
// n vertical lines are drawn such that the two 
// endpoints of line i is at (i, ai) and (i, 0). 
// Find two lines, which together with x-axis forms a 
// container, such that the container contains the most water.
// 
// Note: You may not slant the container and n is at least 2.
// ------------------------------------------ //

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = (end - start) * Math.min(height[start], height[end]);
        while (start < end) {
          if (height[start] < height[end]) {
                int curr = height[start];
                do {
                    start++;
                } while (height[start] < curr && start < end);
                if (start >= end)
                    break;                
            } else {
                int curr = height[end];
                do {
                    end--;
                } while (height[end] < curr && start < end);
                if (start >= end)
                    break;
            }
            int currArea = (end - start) * Math.min(height[start], height[end]);
            maxArea = (currArea > maxArea) ? currArea : maxArea;
        }
        return maxArea;
    }
    
    public static void Run() {
        ContainerWithMostWater s = new ContainerWithMostWater();
        int result = s.maxArea(new int[] {1,8,6,2,5,4,8,3,7});
        System.out.println(result);
    }
}