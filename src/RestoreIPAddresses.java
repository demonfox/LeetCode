// A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 
// (inclusive) and cannot have leading zeros.
// For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" 
// are invalid IP addresses.
// Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. 
// You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
  public List<String> restoreIpAddresses(String s) {
    List<String> result = new LinkedList<>();
    ArrayList<String> temp = new ArrayList<>();
    helper(s, 0, 0, result, temp);
    return result;      
  }

  private void helper(String s, int start, int dotCount, List<String> result, ArrayList<String> temp) {
    if (dotCount == 3) {
      String octet = s.substring(start);
      if (octet.length() != 1 && octet.charAt(0) == '0') return;
      int octetInt = Integer.parseInt(octet);
      if (octetInt >= 0 && octetInt <= 255) {
        temp.add(octet);
        result.add(String.join(".", temp.get(0), temp.get(1), temp.get(2), temp.get(3)));
        temp.remove(temp.size()-1);
      }
        
      return;
    }

    for (int i = start+1; i < s.length(); i++) {
      String octet = s.substring(start, i);
      if (octet.length() != 1 && octet.charAt(0) == '0') return;

      int octetInt = Integer.parseInt(octet);
      if (octetInt > 255) return;

      temp.add(octet);
      helper(s, i, dotCount+1, result, temp);
      temp.remove(temp.size()-1);
    }
  }

  public static void Run() {
    RestoreIPAddresses solution = new RestoreIPAddresses();
    List<String> result = solution.restoreIpAddresses("25525511135");
    System.out.println(result);

    result = solution.restoreIpAddresses("0000");
    System.out.println(result);

    result = solution.restoreIpAddresses("10102030");
    System.out.println(result);

    result = solution.restoreIpAddresses("101023");
    System.out.println(result);
  }  
}
