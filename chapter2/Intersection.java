import java.util.HashMap;
import java.util.Map;


public class Intersection {
  public static Map<Node<Integer>, Integer> createMap(Node<Integer> one) {
    Map<Node<Integer>, Integer> map = new HashMap<Node<Integer>, Integer>();
    Node<Integer> node = one;
    while (node.next != null) {
      map.put(node, 1);
      node = node.next;
    }
    map.put(node, 1);
    return map;
  }
  public static Node<Integer> checkIntersect(Node<Integer> one, 
    Node<Integer> two) {
    
    Map<Node<Integer>, Integer> map = createMap(one); 
    
    Node<Integer> node = two;
    while (node.next != null) { 
      if (map.containsKey(node)) {
        return node;
      }
      node = node.next;
    }
    // check last node
    if (map.containsKey(node)) {
      return node;
    }
    return null;
  }
  public static Node<Integer> createList(int[] arr) {
    Node<Integer> head = new Node<Integer>(arr[0]);
    Node<Integer> node = head;
    for (int i = 1; i < arr.length; i++) {
      Node<Integer> newNode = node.add(arr[i]); 
      node = newNode; 
    }
    return head;
  }
  public static void test(int[] arr, int[] arr2) {
    Node<Integer> listOne = createList(arr);
    listOne.print(listOne);
    Node<Integer> listTwo= createList(arr2);
    listTwo.print(listTwo);
    System.out.println(checkIntersect(listOne, listTwo));
    System.out.println(checkIntersect(listOne, listOne));

  }
  public static void main(String[] args) {
    test(new int[]{4,5,6}, new int[]{2,8,4,3});    
    
  }
}


