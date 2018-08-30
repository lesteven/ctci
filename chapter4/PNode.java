
import java.util.Arrays;


public class PNode<T> {
  public T value;
  public PNode<T> left;
  public PNode<T> right;
  public PNode<T> parent;
  public PNode(T value) {
    this.value = value;
  } 
  public PNode[] adjList() {
    return new PNode[]{left, right};
  }
  public static void main(String[] args) {
    PNode<Integer> node = new PNode<Integer>(10);
    node.left = new PNode<Integer>(3);
    node.right = new PNode<Integer>(20);

    node.left.parent = node;
    System.out.println(node.left.parent.value);
    System.out.println(Arrays.toString(node.adjList()));
  }
}
