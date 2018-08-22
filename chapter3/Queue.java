

public class Queue<T> {
  private class Node {
    private T value;
    private Node next;
    public Node(T value) {
      this.value = value;
    }
  }
  private Node head;
  private Node tail;

  private boolean isEmpty() {
    return head == null;
  }
  public T enqueue(T value) {
    Node newNode = new Node(value);
    if (isEmpty()) {
      head = newNode;
      tail = newNode; 
    } else {
      Node oldTail = tail;
      oldTail.next = newNode;
      tail = newNode; 
    }
    return newNode.value;
  }
  public T dequeue() {
    if (isEmpty()) {
      return null;
    } else {
      T dequeued = head.value;
      head = head.next;
      if (head == null) {
        tail = head;
      }
      return dequeued; 
    }
  }
  private void print() {
    Node node = head;
    while (node != null) {
      System.out.print(node.value + " ");
      node = node.next;
    }
    System.out.println();
  }
  public static void main(String[] args) {
    Queue<Integer> q = new Queue<Integer>();
    for (int i = 0; i < 10; i++) {
      q.enqueue(i);
    }
    q.print();
    q.dequeue();
    q.print();
    for (int i = 0; i < 5; i++) {
      q.dequeue();
    }
    q.print();
    q.enqueue(100);
    q.print();

    q.dequeue();
    q.print();

    Queue<String> q2 = new Queue<String>();

    for (int i = 0; i < 10; i++) {
      q2.enqueue("dog" + i);
    }
    2.print();
  }
}
