import java.util.Stack;

class Solution {
  public int scoreOfParentheses(String S) {
    
    Stack<Integer> stack = new Stack<>();

    char prevBracket = '(';
    stack.push(0);
    for (char bracket : S.toCharArray()) {
      
      if (bracket == '(') {
        stack.push(0);
      } else if (prevBracket == '(' && bracket == ')') {
        stack.pop();
        int temp = stack.pop();
        temp++;
        stack.push(temp);
      } else if (prevBracket == ')' && bracket == ')') {
        int done = stack.pop();
        done *= 2;
        int temp = stack.pop();
        temp += done;
        stack.push(temp);
      }
      prevBracket = bracket;
    }

    return stack.pop();
  }
}