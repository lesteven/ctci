import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class Graph {
  private int vertices;
  private List<ArrayList<Integer>> adjList;

  public Graph(int vertices) {
    this.vertices = vertices;
    adjList = new ArrayList<ArrayList<Integer>>(vertices);
    for (int i = 0; i < vertices; i++) {
      adjList.add(i, new ArrayList<Integer>());
    }
  }
  public void addEdge(int vertex1, int vertex2) {
    ArrayList<Integer> list1 = adjList.get(vertex1);
    ArrayList<Integer> list2 = adjList.get(vertex2);

    list1.add(vertex2);
    list2.add(vertex1);
  }
  public void print() {
    System.out.println(Arrays.toString(adjList.toArray()));
  }
  public ArrayList<Integer> getAdj(int vertex) {
    return adjList.get(vertex);
  }
  public static void main(String[] args) {
    Graph graph = new Graph(5);
    graph.print();
    graph.addEdge(1,3);
    graph.print();
    System.out.println(graph.getAdj(3));
  }
} 
