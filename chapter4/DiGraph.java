import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class DiGraph {
  private int vertices;
  private List<ArrayList<Integer>> adjList;

  public DiGraph(int vertices) {
    this.vertices = vertices;
    adjList = new ArrayList<ArrayList<Integer>>(vertices);
    for (int i = 0; i < vertices; i++) {
      adjList.add(i, new ArrayList<Integer>());
    }
  }
  public void addEdge(int vertex1, int vertex2) {
    ArrayList<Integer> list1 = adjList.get(vertex1);

    list1.add(vertex2);
  }
  public void print() {
    System.out.println(Arrays.toString(adjList.toArray()));
  }
  public ArrayList<Integer> getAdj(int vertex) {
    return adjList.get(vertex);
  }
  public int getVertices() {
    return vertices;
  }
  public static void main(String[] args) {
    DiGraph graph = new DiGraph(5);
    graph.print();
    graph.addEdge(1,3);
    graph.print();
    System.out.println(graph.getAdj(3));
  }
} 
