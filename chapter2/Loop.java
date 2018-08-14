import java.util.HashMap;
import java.util.Map;


public class Loop {
  public static Node<Integer> detect(Node<Integer> list) {
    Map<Node<Integer>, Integer> map = new HashMap<Node<Integer>, 
      Integer>();
    Node<Integer> node = list;
    while (node.next != null) {
      if (map.containsKey(node)) {
        return node;
      }
      map.put(node, 1);
      node = node.next;
    }
    if (map.containsKey(node)) {
      return node;
    }
    return null;
  }
  private static Node<Integer> createList(int[] arr, int loopNum) {
    Node<Integer> head = new Node<Integer>(arr[0]);
    Node<Integer> node = head;
    Node<Integer> loop = null;
    for (int i = 1; i < arr.length; i++) {
      Node<Integer> newNode = node.add(arr[i]); 
      if (loop == null && newNode.value == loopNum) {
        loop = newNode;
      }
      node = newNode; 
    }
    node.next = loop;
    return head;
  }
  private static void test(int[] arr, int loopNum) {
    Node<Integer> circ = createList(arr, loopNum);
    Node<Integer> node = detect(circ);
    System.out.println("loopNode value " + node.value);
  }
  private static Node<Integer> noLoop(int[] arr) {
    Node<Integer> head = new Node<Integer>(arr[0]);
    Node<Integer> node = head;
    for (int i = 1; i < arr.length; i++) {
      Node<Integer> newNode = node.add(arr[i]); 
      node = newNode; 
    }
    return head;
  }
  private static void testNoLoop(int[] arr) {
    Node<Integer> list = noLoop(arr);
    Node<Integer> node = detect(list);
    System.out.println("loopNode value " + node);
  }
  public static void main(String[] args) {
    test(new int[]{4,6,2,8,4}, 2);
    test(new int[]{4,6,2,8,4}, 4);
    test(new int[]{4,6,2,8,4}, 8);
    testNoLoop(new int[]{1,2,3,4,5});
    testNoLoop(new int[]{1,2,3,1,1});
  }
}


