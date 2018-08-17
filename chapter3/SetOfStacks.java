import java.util.ArrayList;


public class SetOfStacks extends Stack {
  private int capacity = 0;
  private ArrayList<Stack> stacks;
  private int currentIndex= 0;
  
  public SetOfStacks(int capacity) {
    this.stacks = new ArrayList<>();
    stacks.add(0, new Stack());
    int defaultCapacity = 3;
    
    if (capacity > 0) {
      this.capacity = capacity;
      } else {
      this.capacity = defaultCapacity;
    }
  }  
  public int push(int value) {
    if (stacks.get(currentIndex).size() == capacity) {
      currentIndex +=1;
      stacks.add(currentIndex, new Stack());
    }
    Stack currentStack = stacks.get(currentIndex);
    return currentStack.push(value);
  }
  public int pop() {
    Stack currentStack = stacks.get(currentIndex);
    if (currentStack.size() > 0) {
      return currentStack.pop();
    } else if (currentIndex > 0 && currentStack.size() == 0) {
      currentIndex -= 1;
      currentStack = stacks.get(currentIndex); 
      return currentStack.pop();
    } else if (currentIndex == 0 && currentStack.size() == 0) {
      return -1;
    } else {
      return -1;
    }
  }
  public int popAt(int index) {
    Stack currentStack = stacks.get(index);
    if (currentStack != null) {
      return currentStack.pop();
    }
    return -1;
  }
  public void print() {
    for (int i = 0; i < stacks.size(); i++) {
      stacks.get(i).print();
    }
  }
  public static void main(String[] args) {
    SetOfStacks stacks = new SetOfStacks(4);
    for (int i = 0; i < 13; i++) {
      stacks.push(i);
    }
    stacks.print();
    stacks.pop();
    System.out.println("popped");
    stacks.print();

    stacks.pop();
    System.out.println("popped");
    stacks.print();
    
    System.out.println("pushed");
    stacks.push(100);
    stacks.push(200);
    stacks.print();

    stacks.popAt(0);
    stacks.popAt(1);
    stacks.popAt(2);
    stacks.print();


    stacks.popAt(0);
    stacks.popAt(0);
    stacks.popAt(0);
    stacks.popAt(0);
    stacks.popAt(0);
    stacks.print();
  }
}
