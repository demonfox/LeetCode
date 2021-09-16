// Given a string s which represents an expression, evaluate this expression and return its value. 
// The integer division should truncate toward zero.
// You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorII {
  private Integer nextOperand;
  private Character nextOperator;
  private boolean isEndOfString = false;

  public int calculate(String s) {
    Deque<Integer> operands = new LinkedList<Integer>();
    Deque<Character> operators = new LinkedList<Character>();
    isEndOfString = false;

    int index = 0;
    while (index < s.length()) {
      index = getNextOperandAndOperator(s, index);
      
      // first deal with what we need to push onto the operands stack
      if (!operators.isEmpty()) {
        char operator = operators.peekFirst();
        if (operator == '*') {
          int operand = operands.pollFirst();
          operands.addFirst(operand * nextOperand);
          operators.pollFirst();
        } else if (operator == '/') {
          int operand = operands.pollFirst();
          operands.addFirst(operand / nextOperand);
          operators.pollFirst();
        } else {
          operands.addFirst(nextOperand);
        }
      } else {
        operands.addFirst(nextOperand);
      }

      // then deal with what we need to push onto the operators stack
      if (!isEndOfString) {
        operators.addFirst(nextOperator);
      }
    }

    int result = operands.pollLast();
    while (!operators.isEmpty()) {
      char operator = operators.pollLast();
      int operand = operands.pollLast();
      if (operator == '+')
        result += operand;
      else
        result -= operand;
    }
    return result;
  }

  private int getNextOperandAndOperator(String s, int start) {
    int i = start;
    for (; i<s.length(); i++) {
      char curr = s.charAt(i);
      if (curr == '+' || curr == '-' || curr == '*' || curr == '/')
        break;
    }
    nextOperand = Integer.parseInt(s.substring(start, i).trim());
    if (i == s.length())
      isEndOfString = true;
    else
      nextOperator = s.charAt(i);
    return i+1;
  }

  public static void Run() {
    BasicCalculatorII b = new BasicCalculatorII();
    System.out.println(b.calculate("1-1+1"));
    System.out.println(b.calculate("3+5*2"));
    System.out.println(b.calculate("3+5/2"));
    System.out.println(b.calculate("3/2 "));
    System.out.println(b.calculate("3*2+2"));
    System.out.println(b.calculate("3+2*2"));
  }
}
