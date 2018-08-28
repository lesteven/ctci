import java.util.Arrays;


public class IntNode extends Node<Integer> {
  public IntNode(Integer value) {
    super(value);
  }
  public static void main(String[] args) {
    Node<Integer> node = new Node<Integer>(10);
    node.left = new Node<Integer>(3);
    node.right = new Node<Integer>(20);
    System.out.println(node.value);
    System.out.println(node.left.value);
    System.out.println(node.right.value);
    System.out.println(Arrays.toString(node.adjList()));
  }
}
