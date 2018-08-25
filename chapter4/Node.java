import java.util.Arrays;


public class Node<T> {
  public T value;
  public Node left;
  public Node right;
  public Node(T value) {
    this.value = value;
  } 
  public Node[] adjList() {
    return new Node[]{left, right};
  }
  public static void main(String[] args) {
    Node<Integer> node = new Node<Integer>(10);
    node.left = new Node<Integer>(3);
    node.right = new Node<Integer>(20);
    System.out.println(Arrays.toString(node.adjList()));
  }
}
