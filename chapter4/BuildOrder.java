import java.util.Stack;

// end of list is beginning of top sort

public class BuildOrder {
  private DiGraph graph;
  private Stack<Integer> sorted;
  private int[] marked;

  private static int white = 0;
  private static int gray = 1;
  private static int black = 2;

  public BuildOrder (int vertices, int[][] edges) {
    graph = new DiGraph(vertices); 
    
    for (int i = 0; i < edges.length; i++) {
      int vertex1 = edges[i][0];
      int vertex2 = edges[i][1];
      graph.addEdge(vertex1, vertex2);
    }
    marked = new int[vertices];
//    graph.print();
  }
  public Stack<Integer> topSort() {
    sorted = new Stack<>();
    int len = marked.length;
    for (int i = 0; i < len; i++) {
      visit(i);
    } 
    return sorted;
  }
  private void visit(int vertex) {
    if (marked[vertex] == black) {
      return;
    }
    if (marked[vertex] == gray) {
      throw new IllegalArgumentException("graph is not a dag");
    }
    marked[vertex] = gray;
    for (int adjVertex : graph.getAdj(vertex)) {
      visit(adjVertex); 
    }
    marked[vertex] = black;
    sorted.push(vertex);
  }
  public static void main(String[] args) {
    int[][] edges = { {0,1}, {0,2}, {1,3}};
    int vertices = 4;
    BuildOrder build = new BuildOrder(vertices, edges);
    Stack<Integer> sorted = build.topSort(); 
    System.out.println(sorted);
    System.out.println(sorted.pop());

/*
    int[][] edges1= { {0,1}, {1,2}, {2,0}};
    int vertices1 = 3;
    BuildOrder build1= new BuildOrder(vertices1, edges1);
    Stack<Integer> sorted1 = build1.topSort(); 
    System.out.println(sorted1);
*/
    int[][] edges2 = {{0,3},{5,1},{1,0},{5,0},{3,2}};
    int v2 = 6;
    BuildOrder build2 = new BuildOrder(v2, edges2);
    Stack<Integer> sorted2 = build2.topSort(); 
    System.out.println(sorted2);
    
  }
}
