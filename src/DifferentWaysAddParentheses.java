// Given a string expression of numbers and operators, return all possible results from computing all the different 
// possible ways to group numbers and operators. You may return the answer in any order.
// The test cases are generated such that the output values fit in a 32-bit integer and the number of different 
// results does not exceed 104.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DifferentWaysAddParentheses {
  List<Integer> result = null;
  public List<Integer> diffWaysToCompute1(String expression) {
    result = new LinkedList<>();
    List<Integer> operands = new LinkedList<>();
    List<Integer> operators = new LinkedList<>();
    int startIndex = 0;
    for (int i=1; i<expression.length(); i++) {
      switch (expression.charAt(i)) {
        case '+':
          operands.add(Integer.parseInt(expression.substring(startIndex, i)));
          operators.add(0); // using 0 to represent +
          startIndex = i+1;
          break;
        case '-':
          operands.add(Integer.parseInt(expression.substring(startIndex, i)));
          operators.add(1);
          startIndex = i+1;
          break;
        case '*':
          operands.add(Integer.parseInt(expression.substring(startIndex, i)));
          operators.add(2);
          startIndex = i+1;
          break;
        default:
          continue;
      }
    }
    operands.add(Integer.parseInt(expression.substring(startIndex, expression.length())));
    calculate(operands, operators);
    return result;
  }

  private void calculate(List<Integer> operands, List<Integer> operators) {
    if (operands.size() == 2) {
      result.add(calc(operands.get(0), operands.get(1), operators.get(0)));
      return;
    }

    for (int i=0; i<operands.size()-1; i++) {
      Integer operand1 = operands.remove(i);
      Integer operand2 = operands.remove(i);
      Integer operator = operators.remove(i);
      Integer res = calc(operand1, operand2, operator);
      operands.add(i, res);
      calculate(operands, operators);
      operands.remove(i);
      operands.add(i, operand2);
      operands.add(i, operand1);
      operators.add(i, operator);
    }
  }

  private Integer calc(Integer i, Integer j, Integer k) {
    switch (k) {
      case 0:
        return i + j;
      case 1:
        return i - j;
      case 2:
        return i * j;    
      default:
        return -1;
    }
  }

  public List<Integer> diffWaysToCompute(String expression) {
    List<Integer> results = new ArrayList<>();

    // Base case: if the string is empty, return an empty list
    if (expression.length() == 0)
      return results;

    // Base case: if the string is a single character, treat it as a number and
    // return it
    if (expression.length() == 1) {
      results.add(Integer.parseInt(expression));
      return results;
    }

    // If the string has only two characters and the first character is a digit,
    // parse it as a number
    if (expression.length() == 2 && Character.isDigit(expression.charAt(0))) {
      results.add(Integer.parseInt(expression));
      return results;
    }

    // Recursive case: iterate through each character
    for (int i = 0; i < expression.length(); i++) {
      char currentChar = expression.charAt(i);

      // Skip if the current character is a digit
      if (Character.isDigit(currentChar))
        continue;

      // Split the expression into left and right parts
      List<Integer> leftResults = diffWaysToCompute(
          expression.substring(0, i));
      List<Integer> rightResults = diffWaysToCompute(
          expression.substring(i + 1));

      // Combine results from left and right parts
      for (int leftValue : leftResults) {
        for (int rightValue : rightResults) {
          int computedResult = 0;

          // Perform the operation based on the current character
          switch (currentChar) {
            case '+':
              computedResult = leftValue + rightValue;
              break;
            case '-':
              computedResult = leftValue - rightValue;
              break;
            case '*':
              computedResult = leftValue * rightValue;
              break;
          }

          results.add(computedResult);
        }
      }
    }

    return results;
  }

  public static void Run() {
    DifferentWaysAddParentheses dwa = new DifferentWaysAddParentheses();
    List<Integer> result = dwa.diffWaysToCompute("2*3-4*5");
    System.out.println(result);
    result = dwa.diffWaysToCompute("2-1-1");
    System.out.println(result);
    result = dwa.diffWaysToCompute("99");
    System.out.println(result);
  }
}
