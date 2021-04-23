public class FenwickTree {
  private int[] nums;
  public FenwickTree(int n) {
    nums = new int[n+1];
  }

  public void update(int index, int delta) {
    while (index < nums.length) {
      nums[index] += delta;
      index += lowbit(index);
    }
  }

  public int query(int index) {
    int sum = 0;
    while (index>0) {
      sum += nums[index];
      index -= lowbit(index);
    }
    return sum;
  }

  private int lowbit(int x) {
    return x & -x;
  }
}
