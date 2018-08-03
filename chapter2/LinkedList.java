import java.util.Iterator;


public class LinkedList<Item> implements Iterable<Item> {
  private Node head;

  private class Node {
    private Item value;
    private Node next;
    private Node prev;
    public Node(Item value) {
      this.value = value;
    } 
  }
  private class CreateIterator implements Iterator<Item> {
    private Node current = head; 
    
    public boolean hasNext() {
      return current != null;
    }
    public Item next() {
      Item item = current.value;
      current = current.next;
      return item;
    } 
  }
  private Node findLastNode() {
    Node node = head;
    while (node.next != null) {
      node = node.next; 
    }
    return node;
  }
  public Item add(Item item) {
    if (head != null) {
      Node node = findLastNode();
      Node newNode = new Node(item);
      node.next = newNode;
      newNode.prev = node;
      return item;
    }
    else {
      head = new Node(item);
      head.prev = null; 
      return head.value;
    }
  }
/*
  public Item remove(Item item) {
    Node node = head;
    Item deleted = null;
    while (node.value != item) {
      node = node.next;
    }
    if (node.value == item) {
      deleted = node.value;
      if (node.prev != null) {
        Node previous = node.prev;
        Node next = node.next;
        previous.next = next;    
      } else {
        head = node.next;
      }
    }
    return deleted;
  }
*/
  public Item remove(Item item) {
    if (head.value == item) {
      return removeFromHead(item);
    } 
    Node node = head.next; 

    while(node.value != item) {
      node = node.next;
    }
    if (node.value == item) {
      if (node.next != null) {
        return removeFromMid(node);
      } else {
        return removeFromEnd(node);
      }
    }
    return null;
  }
  private Item removeFromHead(Item item) {
    Item removedItem = head.value;
    head = head.next;
    return removedItem;
  }
  private Item removeFromMid(Node node) {
    node.prev.next = node.next; 
    return node.value;
  }
  private Item removeFromEnd(Node node) {
    node.prev.next = null;
    return node.value;
  }
  public Iterator<Item> iterator() {
    return new CreateIterator();
  } 
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    System.out.println(list.add(5));
    System.out.println(list.add(10));

    LinkedList<String> slist = new LinkedList<>();
    System.out.println(slist.add("a"));
    System.out.println(slist.add("b"));
    System.out.println("=============");
    Iterator<Integer> it = list.iterator();    
    while(it.hasNext()) {
      System.out.println(it.next());
    }
  } 
}


