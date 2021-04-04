// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
// Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
// Note that division between two integers should truncate toward zero.
// It is guaranteed that the given RPN expression is always valid. That means the expression 
// would always evaluate to a result, and there will not be any division by zero operation.

import java.util.Stack;

public class EvalRPN {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<Integer>();
    for (String s : tokens) {
      if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
        stack.push(Integer.parseInt(s));
      } else {
        int operand1 = stack.pop();
        int operand2 = stack.pop();
        if (s.equals("+"))
          stack.push(operand2+operand1);
        else if (s.equals("-"))
          stack.push(operand2-operand1);
        else if (s.equals("*"))
          stack.push(operand2*operand1);
        else if (s.equals("/"))
          stack.push(operand2/operand1);
      }
    }
    return stack.pop();
  }

  public static void Run() {
    EvalRPN e = new EvalRPN();
    System.out.println(e.evalRPN(new String[]{"2","1","+","3","*"}));
    System.out.println(e.evalRPN(new String[]{"4","13","5","/","+"}));
    System.out.println(e.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
  }
}
