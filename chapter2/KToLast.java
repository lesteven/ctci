import java.util.ArrayList;


public class KToLast<Item> extends SinglyLinkedList<Item> {
  public ArrayList<Item> createArray(Node node) {
    ArrayList<Item> array = new ArrayList<>();
    while (node.next != null) {
      array.add(node.value);
      node = node.next;
    }
    array.add(node.value);
    return array;
  }
  public ArrayList<Item> getKToLast(int k) {
    ArrayList<Item> array = new ArrayList<>();
    Node node = head;
    int count = 0;
    
    while (node.next != null) {
      if (count == k) {
        array = createArray(node);
      }
      count += 1;
      node = node.next;
    } 
    if (k == count) {
      array = createArray(node); 
    }
    return array;
  }  
  public static void main(String[] args) {
    KToLast<Integer> list = new KToLast<>();
    list.add(5);
    list.add(5);
    list.add(10);
    list.add(2);
    list.print();
    ArrayList<Integer> array = list.getKToLast(0);
    System.out.println(array.toString());
    ArrayList<Integer> array1 = list.getKToLast(1);
    System.out.println(array1.toString());
    ArrayList<Integer> array2 = list.getKToLast(2);
    System.out.println(array2.toString());
    ArrayList<Integer> array3 = list.getKToLast(3);
    System.out.println(array3.toString());

    ArrayList<Integer> array4 = list.getKToLast(4);
    System.out.println(array4.toString());
  }
}
