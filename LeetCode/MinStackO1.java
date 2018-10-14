class MinStack {

  class Tuple {
    int val;
    int min;

    public Tuple(int val, int min) {
      this.val = val;
      this.min = min;
    }
  }
  
  Stack<Tuple> stack;

  /** initialize your data structure here. */
  public MinStack() {
    stack = new Stack<Tuple>();
  }
  
  public void push(int x) {
    if (stack.isEmpty()) {
      stack.push(new Tuple(x, x));
    } else {
      stack.push(new Tuple(x, Math.min(stack.peek().min, x)));
    }
  }
  
  public void pop() {
    stack.pop();
  }
  
  public int top() {
    return stack.peek().val;
  }
  
  public int getMin() {
    return stack.peek().min;
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