
public class StackMin {
  private class Node {
    int value;
    Node next;
    public Node(int value) {
      this.value = value;
    }
  }
  Node head; 
  private boolean headEmpty() {
    return head == null;
  }
  public int push(int value) {
    Node newHead = new Node(value);
    if (!headEmpty()) {
      newHead.next = head;
    }
    head = newHead;
    return newHead.value;
  }
  public int pop() {
    int popped = head.value;
    head = head.next; 
    return popped;
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
  public static void main(String[] args) {
    StackMin stack = new StackMin();
    stack.push(10);
    stack.push(2);
    stack.print();
    stack.pop();
    stack.print();
    stack.pop();
    stack.print();
    System.out.println(stack.peak());
  }
}
