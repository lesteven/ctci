

public class Tree {
  public static void inOrderTraversal(Node node) {
    if (node != null) {
      inOrderTraversal(node.left);
      System.out.println(node.value + " ");
      inOrderTraversal(node.right);
    }
  }
  public static void main(String[] args) {
    Node<Integer> root = new Node<Integer>(10);
    root.left = new Node<Integer>(2);
    root.right = new Node<Integer>(20); 
    root.left.left = new Node<Integer>(1);
    root.left.right = new Node<Integer>(6);
    inOrderTraversal(root);
  }
}
