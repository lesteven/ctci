

public class SortStack {
  public static void sort(Stack stack) {
    Stack largeToMin = new Stack();

    while (!stack.isEmpty()) {
      int value = stack.pop();
      while (!largeToMin.isEmpty() && value < largeToMin.peak()) {
        stack.push(largeToMin.pop());
      }
      largeToMin.push(value);
    }
    while (!largeToMin.isEmpty()) {
      stack.push(largeToMin.pop());
    }
  }
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(100);
    stack.push(1);
    stack.push(10);
    stack.push(5);
    stack.push(20);
    stack.print(); 
    
    sort(stack); 
    stack.print();

  }
}
