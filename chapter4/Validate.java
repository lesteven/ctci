import java.util.ArrayList;

public class Validate {
  public static boolean isBST(Node node) {
    ArrayList<Integer> arrList = new ArrayList<>();
    traverseTree(node, arrList);
    return checkOrder(arrList);
  }
  private static boolean checkOrder(ArrayList<Integer> arrList) {
    Object[] arr = arrList.toArray();
    for (int i = 1; i < arr.length; i++) {
      if ((int)arr[i-1] > (int)arr[i]) {
        return false;
      }
    } 
    return true;
  }
  private static void traverseTree(Node node, ArrayList<Integer> arrList) {
    if (node == null) {
      return;  
    }
    traverseTree(node.left, arrList);
    arrList.add((int) node.value);
    traverseTree(node.right, arrList);    
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
    
    // check non tree
    Node node6 = new IntNode(20);
    node6.left = new IntNode(10);
    node6.right = new IntNode(30);
    node6.left.right = new IntNode(25);
    System.out.println("out of order false? : " + isBST(node6));
  
    // check no tree
    Node node7 = new IntNode(20);
    node7.left = new IntNode(10);
    node7.left.left = new IntNode(100);
    node7.right = new IntNode(30);
    System.out.println("out or order. false? : " + isBST(node7)); 
  }
}
