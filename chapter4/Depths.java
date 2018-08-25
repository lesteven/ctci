import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Depths {
  public static List<LinkedList<Integer>> createList(Node node) {
    int level = 0;
    List<LinkedList<Integer>> arr = new ArrayList<LinkedList<Integer>>();
    // arr.add(0, new LinkedList<Integer>()); 
    return dfs(node, level, arr);
  }
  public static List<LinkedList<Integer>> 
    dfs(Node node, int level, List<LinkedList<Integer>> arr) {
    if (node == null) {
      return null;
    }

    if (arr.size() <= level) {
      arr.add(level, new LinkedList<Integer>()); 
    }

    LinkedList<Integer> list = arr.get(level);
    list.add((int) node.value);
      
    for (Node each : node.adjList()) {
      dfs(each, level + 1, arr);
    }
    return arr;
  }
  public static void main(String[] args) {
    Node<Integer> node = new Node<Integer>(10);
    node.left = new Node<Integer>(3);
    node.right = new Node<Integer>(20);
    node.left.left = new Node<Integer>(14);
    node.left.right= new Node<Integer>(32);
    node.right.left = new Node<Integer>(56);
    node.right.right = new Node<Integer>(62);
    List<LinkedList<Integer>> arr = createList(node);
    for (LinkedList<Integer> each : arr) {
      System.out.println(each);
    }
  }
}
