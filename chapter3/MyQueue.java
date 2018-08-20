

public class MyQueue {
  private Stack stack;

  public MyQueue() {
    stack = new Stack();
  }
  public int add(int value) {
    return stack.push(value);
  }
  public int remove() {
    Stack reverse = new Stack();
    while (true) {
      int value = stack.pop();
      if (value != -1) {
        reverse.push(value);
      } else {
        break;
      }
    }
    Stack newStack = new Stack();
    int removed = reverse.pop();
    while (true) {
      int value = reverse.pop();
      if (value != -1) {
        newStack.push(value);
      } else {
        break;
      }
    }
    stack = newStack;
    return removed;
  }
  public void print() {
    stack.print(); 
  }
  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    for (int i = 0; i < 10; i++) {
      queue.add(i);
    }
    queue.print();
    for (int i = 0; i < 5; i++) {
      queue.remove();
    }
    queue.print();

    queue.add(20);
    queue.print();
    
    queue.remove();
    queue.print();
  }
}
