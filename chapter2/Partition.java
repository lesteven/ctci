
public class Partition extends SinglyLinkedList<Integer> {
  private Node getHead() {
    return head;
  }
  private Node getTail() {
    Node node = head;
    while (node.next != null) {
      node = node.next;
    }
    return node;
  }
  private void addToList(Partition smallList, Partition largeList,
    int value, int compare) {
      if (value < compare) {
        smallList.add(value);
      } else {
        largeList.add(value);
      }
  }
  private void combineList(Partition smallList, Partition 
    largeList) {
    head = smallList.getHead();
    if (head != null) {
      Node tail = smallList.getTail();
      tail.next = largeList.getHead();
    } else {
      head = largeList.getHead();
    }
  }
  public void partition(int value) {
    Partition smallList = new Partition(); 
    Partition largeList = new Partition(); 
    Node node = head;
    while (node.next != null) {
      addToList(smallList, largeList, node.value, value);
      node = node.next;
    }
    addToList(smallList, largeList, node.value, value); 
    combineList(smallList, largeList);
  } 
  public static void main(String[] args) {
    Partition list = new Partition();
    list.add(3);
    list.add(5);
    list.add(1);
    list.add(7);
    list.add(10);
    list.add(2);
    list.print();
    System.out.println("partition 1");
    list.partition(1);
    list.print();
    System.out.println("partition 10");
    list.partition(10);
    list.print();
    System.out.println("partition 2");
    list.partition(2);
    list.print();
    System.out.println("partition 20");
    list.partition(20);
    list.print();
    System.out.println("partition 7");
    list.partition(7);
    list.print();
  }
}
