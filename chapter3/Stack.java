
public class Stack {
  protected class Node {
    int value;
    Node next;
    public Node(int value) {
      this.value = value;
    }
  }
  protected Node head; 
  private int size = 0; 
 
  public int size() {
    return size;
  }
  private boolean headEmpty() {
    return head == null;
  }
  public int push(int value) {
    Node newHead = new Node(value);
    size++;
    if (!headEmpty()) {
      newHead.next = head;
    }
    head = newHead;
    return newHead.value;
  }
  public int pop() {
    if (size() > 0) {
      size--;
      int popped = head.value;
      head = head.next; 
      return popped;
    }
    return -1;
  }
  public void print() {
    Node node = head;
    while (node != null) {
      System.out.print(node.value + " ");
      node = node.next;
    }
    System.out.println();
  }
  public int peak() {
    return head == null? -1: head.value;
  }
  public boolean isEmpty() {
    return head == null;
  }
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(10);
    stack.push(2);
    System.out.println("size " + stack.size());
    System.out.println(stack.isEmpty());
    stack.print();

    stack.pop();
    System.out.println("size " + stack.size());
    stack.print();

    stack.pop();
    stack.print();
    System.out.println(stack.peak());
    System.out.println(stack.isEmpty());
    System.out.println("size " + stack.size());
    stack.pop();
    stack.pop();
    System.out.println(stack.pop());
  }
}
