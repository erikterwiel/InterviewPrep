class Solution {
  public int[] dailyTemperatures(int[] temps) {
    
    Stack<Integer> stack = new Stack<>();
    int[] results = new int[temps.length];

    stack.push(0);

    for (int i = 1; i < temps.length; i++) {
      while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
        int foundIndex = stack.pop();
        results[foundIndex] = i - foundIndex;
      }
      stack.push(i);
    }

    return results;
  }
}