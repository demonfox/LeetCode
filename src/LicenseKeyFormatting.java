//You are given a license key represented as a string s that consists of only alphanumeric characters and dashes.
// The string is separated into n + 1 groups by n dashes. You are also given an integer k.

// We want to reformat the string s such that each group contains exactly k characters, except for the first group, 
// which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash 
// inserted between two groups, and you should convert all lowercase letters to uppercase.

// Return the reformatted license key.

public class LicenseKeyFormatting {
  public String licenseKeyFormatting1(String s, int k) {
    StringBuilder result = new StringBuilder();
    s = s.toUpperCase();
    int index = s.length()-1;
    int count = k;
    while (index >= 0) {
      if (s.charAt(index) != '-') {
        result.insert(0, s.charAt(index));
        count--;
        if (count == 0) {
          result.insert(0, '-');
          count = k;
        }
      }
      index--;
    }
    if (result.length() > 0 && result.charAt(0) == '-')
      result.delete(0, 1);

    return result.toString();
  }

  public String licenseKeyFormatting(String s, int k) {
    StringBuilder result = new StringBuilder();
    int count = k;
    s = s.replace("-", "");
    int index = s.length()-1;
    while (index >= 0) {
      char c = s.charAt(index);
      if (!Character.isDigit(c) && c > 90)
        c -= 32;
      result.append(c);
      count--;
      if (count == 0 && index != 0) {
        result.append('-');
        count = k;
      }
      index--;
    }
    return result.reverse().toString();
  }
  
  public static void Run() {
    LicenseKeyFormatting l = new LicenseKeyFormatting();
    String s1 = "5F3Z-2e-9-w";
    int k1 = 4;
    String expected1 = "5F3Z-2E9W";
    String actual1 = l.licenseKeyFormatting(s1, k1);
    System.out.println("Test case 1: expected: " + expected1 + ", actual: " + actual1);
    assert(expected1.equals(actual1));

    String s2 = "2-5g-3-J";
    int k2 = 2;
    String expected2 = "2-5G-3J";
    String actual2 = l.licenseKeyFormatting(s2, k2);
    System.out.println("Test case 2: expected: " + expected2 + ", actual: " + actual2);
    assert(expected2.equals(actual2));

    String s3 = "a-a-a-a-a-a-a-a-a-a-a-a-a-a";
    int k3 = 1;
    String expected3 = "A-A-A-A-A-A-A-A-A-A-A-A-A-A";
    String actual3 = l.licenseKeyFormatting(s3, k3);
    System.out.println("Test case 3: expected: " + expected3 + ", actual: " + actual3);
    assert(expected3.equals(actual3));
  }
}
