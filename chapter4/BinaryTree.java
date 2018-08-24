

public class BinaryTree<T> {
  private class Node {
    private T value;
    private T left;
    private T right;
    public Node(T value) {
      this.value = value;
    } 
  }
  private Node root;
  public void add(T value) {
    root = add(root, value); 
  }
  private Node add(Node node, T value) {
    if (node  == null) {
      return new Node(value); 
    }
    if (value <= node.value) {
      node.left = add(node.left, value);
    } else {
      node.right = add(node.right, value);
    }
  }
  public boolean isEmpty() {
    return head == null; 
  }
  public static void main(String[] args) {

  }
}
