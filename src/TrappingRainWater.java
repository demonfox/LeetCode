// Given n non-negative integers representing an elevation map where the width of each 
// bar is 1, compute how much water it can trap after raining.
public class TrappingRainWater {
  public int trap(int[] height) {
    // So the basic idea is that we can calculate water trapped "on top of" each bar by computing
    // namely, min(l_max, r_max) - height[i] at bar i.
    // l_max indicates the highest bar to the left of bar i (or max(height[0...i]))
    // r_max indicates the highest bar to the right of bar i (or max(height[i...n-1]))
    // So for every bar i, we want to know l_max and r_max. Let's start from index 0 and see what happens:
    // At index 0, l_max = height[0], and r_max is whatever the highest bar is to the right.
    // That's not telling us much. Let's see what happens at index n-1:
    // At index n-1, r_max = heights[n-1], and l_max is whatever the highest bar is to the left.
    // Well, these two things each on its own is not too useful, but what if we look at both togther?
    // The key observation here is that l_max is a non-decreasing series and r_max is a non-increasing series.
    // So while at index 0, if height[0] < height[n-1], we know that min(l_max, r_max) has to be height[0]
    // because r_max = height[n-1] > l_max and when r_max expands to height[0...n-1], it will have an even
    // larger value.
    // Similarly, at index n-1, if height[0] > height[n-1], we know that min(l_max, r_max) at index n-1
    // has to be height[n-1].
    // Thus we use two pointers, one (pointer i) starting from index 0 and one (pointer j) starting from index n-1.
    // For each iteration, if l_max < r_max, we know it is safe to reach the conclusion that for bar i,
    // min(l_max, r_max) = l_max, then we can calculate the area "on top of" bar i and increment i.
    // If l_max > r_max, we know it is safe to say that for bar j, min(l_max, r_max) = r_max, then we
    // can calculate the area "on top of" bar j and decrement j.
    // Keep doing this until i and j meets.
    int result = 0;
    if (height.length == 0)
      return 0;
    int i = 0;
    int j = height.length-1;
    int l_max = height[0];
    int r_max = height[height.length-1];
    while (i<j) {
      if (l_max < r_max) {
        result += (l_max - height[i]);
        i++;
        l_max = Math.max(l_max, height[i]);
      } else {
        result += (r_max - height[j]);
        j--;
        r_max = Math.max(r_max, height[j]);
      }
    }
    return result;
  }

  public static void Run() {
    TrappingRainWater t = new TrappingRainWater();
    System.out.println(t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    System.out.println(t.trap(new int[]{4,2,0,3,2,5}));
  }
}
