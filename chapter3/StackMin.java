

public class StackMin extends Stack {
  Stack stackWithMin = new Stack();
  
  public int push(int value) {
    if (value <= minValue()) {
      stackWithMin.push(value);
    }
    return super.push(value);
  }
  public int pop() {
    int value = super.pop();
    if (value == minValue()) {
      stackWithMin.pop();
    }
    return value;
  }
  public int minValue() {
    if (stackWithMin.isEmpty()) {
      return Integer.MAX_VALUE;
    } 
    return stackWithMin.peak();
  }
  public static void main(String[] args) {
    StackMin stackMin = new StackMin();
    stackMin.push(5);
    stackMin.push(10);
    stackMin.push(2);
    stackMin.print();
    System.out.println(stackMin.minValue());
    stackMin.pop(); 
    System.out.println(stackMin.minValue());
    stackMin.pop(); 
    System.out.println(stackMin.minValue());
    stackMin.pop(); 
    System.out.println(stackMin.minValue());
    stackMin.push(20);
    System.out.println(stackMin.minValue());
    
  }
}
