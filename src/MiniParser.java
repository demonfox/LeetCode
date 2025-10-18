// Given a string s represents the serialization of a nested list, implement a parser to deserialize it and return the 
// deserialized NestedInteger.
// Each element is either an integer or a list whose elements may also be integers or other lists.

import java.util.List;
import java.util.Stack;

public class MiniParser {
   public interface NestedInteger {
    // Constructor initializes an empty nested list.
    // public NestedInteger();

    // Constructor initializes a single integer.
    // public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }

  public NestedInteger deserialize(String s) {
    if (!s.startsWith("["))
      return new NestedInteger(Integer.parseInt(s));
    
    Stack<NestedInteger> stack = new Stack<>();
    int l = 0;
    NestedInteger curr = null;

    for (int r=0; r<s.length(); r++) {
      switch (s.charAt(r)) {
        case '[':
          if (curr != null)
            stack.push(curr);
          curr = new NestedInteger();
          l = r + 1;
          continue;
        case ']':
          String num = s.substring(l, r);
          if (!num.isEmpty())
            curr.add(new NestedInteger(Integer.valueOf(num)));
          if (!stack.isEmpty()) {
            NestedInteger temp = stack.pop();
            temp.add(curr);
            curr = temp;
          }
          l = r + 1;
          continue;
        case ',':
          if (s.charAt(r-1) != ']')
            curr.add(new NestedInteger(Integer.valueOf(s.substring(l, r))));
          l = r + 1;
          continue;
        default:
          continue;
      }
    }
    return curr;
  }
}
