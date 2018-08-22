public class StackGen<T> {
  protected class Node {
    T value;
    Node next;
    public Node(T value) {
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
  public T push(T value) {
    Node newHead = new Node(value);
    size++;
    if (!headEmpty()) {
      newHead.next = head;
    }
    head = newHead;
    return newHead.value;
  }
  public T pop() {
    if (size() > 0) {
      size--;
      T popped = head.value;
      head = head.next; 
      return popped;
    }
    return null;
  }
  public void print() {
    Node node = head;
    while (node != null) {
      System.out.print(node.value + " ");
      node = node.next;
    }
    System.out.println();
  }
  public T peak() {
    return head == null? null: head.value;
  }
  public boolean isEmpty() {
    return head == null;
  }
  public static void main(String[] args) {
    StackGen<Integer> stack = new StackGen<Integer>();
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
