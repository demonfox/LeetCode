// Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style
// file system, convert it to the simplified canonical path.
// In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory 
// up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, 
// any other format of periods such as '...' are treated as file/directory names.

// The canonical path should have the following format:

// The path starts with a single slash '/'.
// Any two directories are separated by a single slash '/'.
// The path does not end with a trailing '/'.
// The path only contains the directories on the path from the root directory to the target file or directory (i.e., no 
// period '.' or double period '..')

// Return the simplified canonical path.

import java.util.LinkedList;

public class SimplifyPath {
  public String simplifyPath(String path) {
    LinkedList<String> tokenList = new LinkedList<>();
    // by adding a "/" at the end, we avoid the case where the last character is not a / and thus we may break out of the 
    // following loop since we have reached its end but there is a segment (the last segment) left to be processed
    path = path + "/";
    tokenList.add("/");

    for(int i = 1; i<path.length();) {
      int j = i;
      for (; j<path.length(); j++) {
        
        if (path.charAt(j) == '/') {
          String newToken = path.substring(i, j);
          if (newToken.equals("..")) {
            if (tokenList.size() >= 2) {
              tokenList.removeLast();
              tokenList.removeLast();
            }
          } else if (!newToken.equals("") && !newToken.equals(".")) { // newToken == "" means we have seen a double slash "//"
            tokenList.add(newToken);
            tokenList.add("/");
          }
          break;
        }
      }
      i = j + 1;
    }

    if (tokenList.size() > 1 && tokenList.peekLast().equals("/"))
      tokenList.removeLast();
    
    StringBuilder result = new StringBuilder();
    for (String s : tokenList)
      result.append(s);
    
    return result.toString();
  }

  public static void Run() {
    SimplifyPath s = new SimplifyPath();
    System.out.println(s.simplifyPath("/abc/de/.."));
    System.out.println(s.simplifyPath("/abc/../de//"));
    System.out.println(s.simplifyPath("/abc/////../de//"));
    System.out.println(s.simplifyPath("/abc../de//"));
    System.out.println(s.simplifyPath("/.."));
    System.out.println(s.simplifyPath("/"));
    System.out.println(s.simplifyPath("/.../de//"));
  }
}
