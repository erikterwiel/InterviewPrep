class Solution {
  public boolean isValid(String s) {
    
    Stack<Integer> stack = new Stack<>();
    
    for (char letter : s.toCharArray()) {

      if (letter == '(') {
        stack.push(1);
      } else if (letter == '{') {
        stack.push(2);
      } else if (letter == '[') {
        stack.push(3);
      } else if (stack.empty()) {
        return false;
      } else if (letter == ')') {
        if (stack.pop() != 1) {
          return false;
        }
      } else if (letter == '}') {
        if (stack.pop() != 2) {
          return false;
        }
      } else if (letter == ']') {
        if (stack.pop() != 3) {
          return false;
        }
      }
    }

    if (stack.empty()) {
      return true;
    }

    return false;
  }
} 