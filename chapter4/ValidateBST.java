

public class ValidateBST {
  public static boolean isBST(Node node) {
    if (node == null) {
      return false;
    } 
    return check(node); 
  }
  public static boolean check(Node node) {
    if (node == null) {
      return true;
    }
    boolean leftBalanced = check(node.left);
    boolean rightBalanced = check(node.right);
    
     
    int leftNode = Integer.MIN_VALUE;
    if (node.left != null) {
      leftNode = (int) node.left.value;
    }
    int rightNode = Integer.MAX_VALUE;
    if (node.right != null) {
      rightNode = (int) node.right.value;
    }
    int currentNode = (int) node.value; 

    return leftNode <= currentNode && currentNode <= rightNode; 
  }
  public static void main(String[] args) {
    // check null
    System.out.println("check null : " + isBST(null));

    // check one node
    Node node0 = new IntNode(1);
    System.out.println("one node true? : " + isBST(node0));
  
    // check two nodes
    Node node1 = new IntNode(100);
    node1.left = new IntNode(20);
    System.out.println("two nodes true? : " + isBST(node1));

    // check two nodes
    Node node2 = new IntNode(100);
    node2.left = new IntNode(200);
    System.out.println("two nodes false? : " + isBST(node2));


    // check three nodes
    Node node3 = new IntNode(100);
    node3.left = new IntNode(10);
    node3.right = new IntNode(500);
    System.out.println("three nodes true? : " + isBST(node3));


    // check a bunch of  nodes
    Node node4 = new IntNode(100);
    node4.left = new IntNode(50);
    node4.left.left = new IntNode(25);
    node4.left.right = new IntNode(75); 
    node4.right = new IntNode(500);
    System.out.println("a bunch of nodes true? : " + isBST(node4));


    // check a bunch of  nodes
    Node node5 = new IntNode(100);
    node5.left = new IntNode(200);
    node5.left.left = new IntNode(25);
    node5.left.right = new IntNode(75); 
    node5.right = new IntNode(500);
    System.out.println("a bunch of nodes false? : " + isBST(node5));
  }
}
