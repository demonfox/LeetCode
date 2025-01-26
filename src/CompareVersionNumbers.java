// Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'. 
// The value of the revision is its integer conversion ignoring leading zeros.
// To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer 
// revisions, treat the missing revision values as 0.
// Return the following:
// If version1 < version2, return -1.
// If version1 > version2, return 1.
// Otherwise, return 0.

public class CompareVersionNumbers {
  public int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int length = (v1.length < v2.length) ? v1.length : v2.length;
    int i = 0;
    for (i=0; i<length; i++) {
      int r1 = Integer.parseInt(v1[i]);
      int r2 = Integer.parseInt(v2[i]);
      if (r1 == r2)
        continue;
      else if (r1 < r2)
        return -1;
      else
        return 1;
    }
    if (v1.length < v2.length) {
      for (; i<v2.length; i++) {
        if (Integer.parseInt(v2[i]) == 0)
          continue;
        return -1;
      }
    } else if (v1.length > v2.length) {
      for (; i<v1.length; i++) {
        if (Integer.parseInt(v1[i]) == 0)
          continue;
        return 1;
      }
    }
    return 0;
  }

  public static void Run() {
    CompareVersionNumbers c = new CompareVersionNumbers();
    System.out.println(c.compareVersion("1.01", "1.001"));
    System.out.println(c.compareVersion("1.0", "1.0.0"));
    System.out.println(c.compareVersion("0.1", "1.1"));
    System.out.println(c.compareVersion("1.0.1", "1"));
    System.out.println(c.compareVersion("7.5.2.4", "7.5.3"));
  }
}
