
public class Node<Item> {

  public Item value;
  public Node<Item> next;
  public Node(Item item) {
    this.value = item;
  }
  public Node<Item> add(Item item) {
    Node<Item> newNode = new Node<Item>(item);
    this.next = newNode;
    return newNode;
  }
  public void print(Node<Item> node ) {
    Node itnode = node;
    while (itnode.next != null) {
      System.out.print(itnode.value + ", ");
      itnode = itnode.next; 
    }
    System.out.println(itnode.value);
  }
  public static void main(String[] args) {
    Node<Integer> head = new Node<Integer>(1);
    head.add(5);
    head.print(head);
    Node<Integer> diffHead = new Node<Integer>(1);
    System.out.println(head == diffHead); 
    System.out.println(head == head); 
  }
}
