// Suppose we have a file system that stores both files and directories. If we were to write this representation in code, it will 
// look like this: "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext". Note that the '\n' 
// and '\t' are the new-line and tab characters.
// Every file and directory has a unique absolute path in the file system, which is the order of directories that must be opened to 
// reach the file/directory itself, all concatenated by '/'s. Using the above example, the absolute path to file2.ext is 
// "dir/subdir2/subsubdir2/file2.ext". Each directory name consists of letters, digits, and/or spaces. Each file name is of the 
// form name.extension, where name and extension consist of letters, digits, and/or spaces.
// Given a string input representing the file system in the explained format, return the length of the longest absolute path to a 
// file in the abstracted file system. If there is no file in the system, return 0.
// Note that the testcases are generated such that the file system is valid and no file or directory name has length 0.

import java.util.Stack;

public class LongestAbsoluteFilePath {
  public int lengthLongestPath(String input) {
    String[] lines = input.split("\\n");
    Stack<String> stack = new Stack<>();
    //stack.push(lines[0]);
    int result = 0;
    int currLength = 0;
    for (int i=0; i<lines.length; i++) {
      int leadingTab = 0;
      // count the leading \t's
      for (int j = 0; j < lines[i].length(); j++)
        if (lines[i].charAt(j) == '\t')
          leadingTab++;
        else
          break;
      while (stack.size() > leadingTab) {
        currLength = currLength - stack.pop().length();
      }
      if (lines[i].indexOf('.') == -1) {
        if (currLength == 0)
          currLength = currLength + stack.push(lines[i].substring(leadingTab)).length();
        else
          currLength = currLength + stack.push("/" + lines[i].substring(leadingTab)).length();
      } else {
        if (currLength == 0)
          result = Math.max(result, lines[i].length());
        else
          result = Math.max(result, currLength + lines[i].substring(leadingTab).length() + 1);
      }
    }
    return result;
  }

  public static void Run() {
    LongestAbsoluteFilePath l = new LongestAbsoluteFilePath();
    System.out.println(l.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
    System.out.println(l.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    System.out.println(l.lengthLongestPath("dir"));
    System.out.println(l.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
  }
}
