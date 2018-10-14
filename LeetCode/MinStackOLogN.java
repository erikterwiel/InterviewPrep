import java.util.Comparator;
import java.util.TreeSet;

class MinStack {

  Stack<Integer> stack;
  TreeSet<Integer> set;

  /** initialize your data structure here. */
  public MinStack() {
    stack = new Stack<>();
    set = new TreeSet<>(new Comparator<Integer>() {
      public int compare(Integer a, Integer b) {
        if (a < b) {
          return -1;
        } else if (a > b) {
          return 1;
        }
        return 0;
      }
    });
  }
  
  public void push(int x) {
    stack.push(x);
    set.add(x);
  }
  
  public void pop() {
    set.remove(stack.pop());
  }
  
  public int top() {
    return stack.peek();
  }
  
  public int getMin() {
    if (set.size() == 0) {
      return null;
    }
    return set.first();
  }
}

/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(x);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/