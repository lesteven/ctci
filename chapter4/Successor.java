

public class Successor {
  public static Integer getLeftMostChild(PNode<Integer> node) {
    PNode<Integer> tNode = node;
    while (tNode.left != null) {
      tNode = tNode.left;
    }
    return tNode.value;
  }
  public static Integer getParentNode(PNode<Integer> node) {
    PNode<Integer> traverseNode = node;

    while (traverseNode.parent != null 
      && traverseNode.parent.value < node.value) {
        traverseNode = traverseNode.parent; 
    } 
    if (traverseNode.parent != null 
      && traverseNode.parent.value >= node.value) {
      return traverseNode.parent.value;
    }
    return null;
  }
  public static Integer successor(PNode<Integer> node) {
    if (node.right != null) {
      return getLeftMostChild(node.right);
    } else if (node.parent != null) {
      return getParentNode(node);
    }
    return null;
  }
  public static void main(String[] args) {
    // check single node
    PNode<Integer> node = new PNode<Integer>(100);
    System.out.println(successor(node));

    // check left node
    PNode<Integer> node1 = new PNode<Integer>(100);
    node1.left = new PNode<Integer>(50);
    node1.left.parent = node1;
    System.out.println("100? " + successor(node1.left));
 
 
    // check parent node
    PNode<Integer> node2 = new PNode<Integer>(100);
    node2.right = new PNode<Integer>(150);
    node2.right.parent = node2;
    System.out.println("150? " + successor(node2));
    
    // check right node
    System.out.println("null? " + successor(node2.right));

    node2.right.right = new PNode<Integer>(200);
    System.out.println("200? " + successor(node2.right));

    // check left subtree, far right value
    PNode<Integer> node3 = new PNode<Integer>(100);
    node3.left = new PNode<Integer>(50);
    node3.left.parent = node3;

    node3.left.right = new PNode<Integer>(75);
    node3.left.right.parent = node3.left;
    System.out.println("100? " + successor(node3.left.right));
  
    // check right subtree
    PNode<Integer> node4 = new PNode<>(100);
    node4.right = new PNode<>(150);
    node4.right.parent = node4;
    node4.right.left = new PNode<>(125);
    System.out.println("125? " + successor(node4));
  }
}
