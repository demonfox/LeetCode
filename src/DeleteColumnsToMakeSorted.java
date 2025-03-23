// You are given an array of n strings strs, all of the same length.
// The strings can be arranged such that there is one on each line, making a grid.
// For example, strs = ["abc", "bce", "cae"] can be arranged as follows:
// abc
// bce
// cae
// You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), 
// columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted, while column 1 ('b', 'c', 'a') is not, 
// so you would delete column 1.
// Return the number of columns that you will delete.

public class DeleteColumnsToMakeSorted {
  public int minDeletionSize(String[] strs) {
    int result = 0;
    for (int i=0; i<strs[0].length(); i++) {
      for (int j=1; j<strs.length; j++) {
        if (strs[j].charAt(i) < strs[j-1].charAt(i)) {
          result++;
          break;
        }
      }
    }
    return result;
  }

  public static void Run() {
    String[] strs = {"cba", "daf", "ghi"};
    DeleteColumnsToMakeSorted d = new DeleteColumnsToMakeSorted();
    int result = d.minDeletionSize(strs);
    System.out.println(result);

    strs = new String[] {"a", "b"};
    result = d.minDeletionSize(strs);
    System.out.println(result);

    strs = new String[] {"zyx", "wvu", "tsr"};
    result = d.minDeletionSize(strs);
    System.out.println(result);
  }
}
