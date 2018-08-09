
public class DeleteMid<Item> extends SinglyLinkedList<Item> {

  public void deleteMiddle(Item value) {
    Node node = head.next;
    while (node.next != null) {
      if (node.value == value) {
        remove(value);
        break;
      }
      node = node.next;  
    }
  }
  public static void main(String[] args) {
    DeleteMid<Integer> list = new DeleteMid<Integer>();
    list.add(12);
    list.add(5);
    list.add(5);
    list.add(5);
    list.add(10);
    list.print();
    System.out.println("==========");
    list.deleteMiddle(5);
    list.print();
    System.out.println("==========");
    list.deleteMiddle(12);
    list.deleteMiddle(10);
    list.print();
  }
}
