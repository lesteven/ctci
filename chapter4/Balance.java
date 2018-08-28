

public class Balance {
  public static boolean check(Node node) {
    if (node == null) {
      return false;
    }
    int heightLeft = checkHeight(node.left);
    int heightRight = checkHeight(node.right);
//    System.out.println("left height: " + heightLeft);
//    System.out.println("right height: " + heightRight);
    return Math.abs(heightLeft - heightRight) < 2;
  }
  public static Integer checkHeight(Node node) {
    if (node != null) {
      int leftHeight = checkHeight(node.left);
      int rightHeight = checkHeight(node.right); 
      int greaterHeight = greater(leftHeight,rightHeight);
      return 1 + greaterHeight; 
    } else {
      return 0;
    }
  }
  public static Integer greater(int num1, int num2) {
    if (num1 > num2) {
      return num1;
    } else {
      return num2;
    }
  }
  public static void main(String[] args) {
    // check one node
    IntNode node = new IntNode(10);
    System.out.println("should be true " + check(node));
  
    // check one on left
    node.left = new IntNode(20);
    System.out.println("should be true " + check(node));

    // check one on left and right
    node.right = new IntNode(50);
    System.out.println("should be true " + check(node));

    // check one on right
    IntNode node1 = new IntNode(4);
    node1.right = new IntNode(60);
    System.out.println("should be true " + check(node1));

    // check two on left and one on right
    IntNode node2 = new IntNode(2);
    node2.left = new IntNode(5);
    node2.right = new IntNode(4);
    node2.left.left = new IntNode(10);
    node2.right.right = new IntNode(20);
    System.out.println("should be true " + check(node2));

    // check very uneven
    IntNode node3 = new IntNode(1);
    node3.left = new IntNode(2);
    node3.left.left = new IntNode(2);
    node3.left.left.left = new IntNode(2);
    node3.left.left.left.left = new IntNode(2);
    node3.left.left.left.left.left = new IntNode(2);

    node3.right = new IntNode(3);
    node3.right.left = new IntNode(3);
    node3.right.right = new IntNode(3);
    node3.right.left.left = new IntNode(3);
    node3.right.left.right= new IntNode(3);
    System.out.println("should be false " + check(node3));
    
    // check null
    System.out.println("check null " + check(null));
  }
}
