

public class Ancestor {
  private boolean foundOne = false;
  private boolean foundTwo = false;

  private void exist(Node root, Node one, Node two) {
    if (root == null) {
      return;
    }
    if (root == one) {
      foundOne = true;            
    }
    if (root == two) {
      foundTwo = true;
    }
    for (Node each : root.adjList()) {
      exist(each, one, two);         
    }
  } 
  public Node lca(Node root, Node one, Node two) {
    foundOne = false;
    foundTwo = false;
    exist(root, one, two);

    if (foundOne && foundTwo) {
      return find(root, one, two);
    } else {
      return null;
    }
  }
  private Node find(Node root, Node one, Node two) {
    if (root == null) {
      return null;
    }

    if (root.value == one.value || root.value == two.value) {
      return root;
    } 

    Node leftTree = find(root.left, one, two);
    Node rightTree = find(root.right, one, two);
    
    if (leftTree != null && rightTree != null) {
      return root;
    } 
    return leftTree != null? leftTree : rightTree;
  }
  public static void main(String[] args) {
    Node root = new IntNode(10);
    root.left = new IntNode(5);
    root.left.left = new IntNode(1);
    root.left.right = new IntNode(8); 
    root.right = new IntNode(20);
    Ancestor anc = new Ancestor();

    Node test = new IntNode(100);
    // check root, left subtree
    Node found = anc.lca(root, root.left.left, root.left.right);
    System.out.println(found.value);

    // check root, left and right
    System.out.println(anc.lca(root,root.left, root.right).value);
    
    // check root w/ unavailable value
    System.out.println(anc.lca(root,root.left, test));
   
    root.left.right.right = new IntNode(12); 
    System.out.println(anc.lca(root,root.left.left, root.left.right.right).value);
  }
}
