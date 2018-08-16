import java.util.Arrays;

public class ThreeInOne{
  private int[] arr;
  private int[] stackTop = new int[3]; 

  public ThreeInOne (int size) {
    arr = new int[size];
    stackTop[0] = 0;
    stackTop[1] = size/3;
    stackTop[2] = size/3 + size/3;
  } 
  private boolean spaceAvail(int stackNum) {
    int size = arr.length;
    int oneThird = size/3;
    switch (stackNum) {
      case 0:
        return stackTop[stackNum] < oneThird;
      case 1:
        return stackTop[stackNum] < oneThird + oneThird;
      case 2:
        return stackTop[stackNum] < size;
      default:
        return false;
    }
  }
  public int push(int stackNum, int value) {
    if (spaceAvail(stackNum)) {
      arr[stackTop[stackNum]++] = value;
      return arr[stackTop[stackNum]-1];
    } else {
      return -1;
    }
  }
  private boolean empty(int stackNum) {
    int size = arr.length;
    int oneThird = size/3;
    switch (stackNum) {
      case 0:
        return stackTop[stackNum] == 0;
      case 1:
        return stackTop[stackNum] == oneThird;
      case 2:
        return stackTop[stackNum] == oneThird + oneThird;
      default:
        return false;
    }
  }
  public int pop(int stackNum) {
    if (!empty(stackNum)) {
      int popped = arr[stackTop[stackNum]-1];
      arr[--stackTop[stackNum]] = 0; 
      return popped;
    } else {
      return -1;
    }
  }
  public int peak(int stackNum) {
    int index = stackTop[stackNum]-1;
    if (index > -1 && index < arr.length) {
      int value = arr[stackTop[stackNum]-1];
      if (value != 0) {
        return value;
      }
    }
    return -1;
  }
  public void print() {
    System.out.println(Arrays.toString(arr));
  }
  public static void main(String[] args) {
    ThreeInOne stack = new ThreeInOne(5);

    stack.print();
    stack.push(0,5);
    System.out.println(stack.peak(0));
    stack.print();

    // Test add over limit for stack 0
    stack.push(0,2);
    stack.push(0,3);
    stack.print();

    // Test add over limit for stack 1
    stack.push(1,9);
    stack.push(1,39);
    stack.print();
    System.out.println(stack.peak(1));

    // Test add over limit for stack 2
    stack.push(2,4);
    stack.push(2,3);
    stack.push(2,1);
    stack.push(2,2);
    stack.push(2,3);
    stack.print();

    // Test pop
    System.out.println(stack.peak(2));
    stack.pop(0);
    stack.print();
    stack.pop(1);
    stack.print();
    stack.pop(2);
    stack.print();
    System.out.println(stack.peak(2));
    stack.pop(0);
    stack.pop(1);
    stack.pop(2);
    System.out.println(stack.peak(2));
    stack.pop(2);
    stack.pop(2);
    stack.print();
    System.out.println(stack.peak(0));
    System.out.println(stack.peak(1));
    System.out.println(stack.peak(2));
  }
}
