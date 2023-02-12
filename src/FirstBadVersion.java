// You are a product manager and currently leading a team to develop a new product. 
// Unfortunately, the latest version of your product fails the quality check. 
// Since each version is developed based on the previous version, all the versions after a bad version are also bad.
// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the 
// following ones to be bad.
// You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to 
// find the first bad version. You should minimize the number of calls to the API.


public class FirstBadVersion {
  public int firstBadVersion(int n) {
    int left, right, mid;
    left = 1;
    right = n;

    while (left < right) {
      if (left == right -1)
        break;
      mid = left + (right - left) / 2;
      if (isBadVersion(mid)) {
        right = mid; // right is the sentinel of Bad portion, so keep it that way
      } else {
        left = mid; // left is the sentinel of the Good portion, so keep it that way
      }
    }
    return right;
  }

  // just a stub so that the editor does not complain
  public boolean isBadVersion(int version) {
    return (version >= 4);
  }

  public static void Run() {
    FirstBadVersion f = new FirstBadVersion();
    System.out.println(f.firstBadVersion(5));
  }
}
