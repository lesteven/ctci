import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;


public class Route {
  public static boolean checkConnect(Graph graph, int vertex1, 
    int vertex2) {
    int numVertices = graph.getVertices();
    boolean[] visited = new boolean[numVertices];

    Queue<Integer> queue = new LinkedList<>(); 
    queue.add(vertex1);

    boolean connected = false;
  
    while (queue.peek() != null && connected == false) {
      int curVertex = queue.remove();
      ArrayList<Integer> adjList = graph.getAdj(curVertex);
      for (Integer each : adjList) {
        if (visited[each] != true) {
          visited[each] = true;
          if (each == vertex2) {
            connected = true;
            break;
          }
          queue.add(each);
        }     
      }
    }
    return connected;
  }
  public static void main(String[] args) {
    Graph graph = new Graph(5);
    graph.addEdge(1,3);
    graph.print();
/*
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.println("vertex " + i + 
          " connected to vertex? " + j + " " 
          + checkConnect(graph,i,j));
      }
    }
  }
*/
    graph.addEdge(3,4);
/*
    graph.print();
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.println("vertex " + i + 
          " connected to vertex? " + j + " " 
          + checkConnect(graph,i,j));
      }
    }
*/
    graph.addEdge(0,1);
    graph.addEdge(0,2);
    graph.print();
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.println("vertex " + i + 
          " connected to vertex? " + j + " " 
          + checkConnect(graph,i,j));
      }
    }
  }    
}
