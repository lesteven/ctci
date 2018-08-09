

public class SinglyLinkedList<Item> {
  protected class Node {
    public Item value;
    public Node next;
    public Node(Item value) {
      this.value = value;
    }
  }
  Node head;
  public Item add(Item value) {
    Node newNode = new Node(value);
    if (head != null) {
      Node node = head;
      while (node.next != null) {
        node = node.next;
      }
      node.next = newNode;
    } else {
      head = newNode;
    } 
    return newNode.value;
  }  
  public Item remove(Item item) {
    Node node = head;
    if (head.value == item) {
      Item deletedItem = node.value;
      head = node.next;
      return item;
    }
    while (node.next != null) {
      if (node.next.value == item) {
        Item deletedItem = node.next.value;
        node.next = node.next.next;
        return deletedItem; 
      }
      node = node.next;
    }
    return null;
  }
  public void print() {
    Node node = head;
    while (node.next != null) {
      System.out.print(node.value + " ");
      node = node.next;
    }
    System.out.println(node.value);
    System.out.println("================");
  }
  public static void main(String[] args) {
    SinglyLinkedList<Integer> singly = new SinglyLinkedList<>();
    singly.add(5);
    singly.add(5);
    singly.add(10);
    singly.add(3);
    singly.add(4);
    singly.add(2);
    singly.print();
    singly.remove(5);
    System.out.println("====== removed 5");
    singly.print();
    singly.remove(2);
    System.out.println("====== removed 2");
    singly.print();
    singly.remove(3);
    System.out.println("====== removed 3");
    singly.print();
  }
}
