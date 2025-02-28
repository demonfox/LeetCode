// Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may 
// contain one or more '.' or '+'.
// For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
// If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the 
// same address without dots in the local name. Note that this rule does not apply to domain names.
// For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
// If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be 
// filtered. Note that this rule does not apply to domain names.
// For example, "m.y+name@email.com" will be forwarded to "my@email.com".
// It is possible to use both of these rules at the same time.
// Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually 
// receive mails.

import java.util.HashSet;

public class UniqueEmailAddresses {
  public int numUniqueEmails(String[] emails) {
    HashSet<String> emailSet = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    for (String email : emails) {
      boolean isLocalNamePart = true;
      boolean ignoreRestLocalName = false;
      for (char c : email.toCharArray()) {
        if (c == '@') {
          isLocalNamePart = false;
          sb.append(c);
        } else {
          if (isLocalNamePart) {
            if (ignoreRestLocalName) continue;
            if (c == '.') {
              continue;
            } else if (c == '+') {
              ignoreRestLocalName = true;
            } else {
              sb.append(c);
            }
          } else {
            sb.append(c);
          }
        }
      }
      emailSet.add(sb.toString());
      sb.setLength(0);
    }
    return emailSet.size();
  }

  public static void Run() {
    UniqueEmailAddresses obj = new UniqueEmailAddresses();
    String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" };
    System.out.println(obj.numUniqueEmails(emails));
  }
}
