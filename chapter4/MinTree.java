import java.util.Arrays;


public class MinTree {
  public static DiGraph createTree(int[] arr) {
    int len = arr.length;
    int mid = (len-1)/2;

    DiGraph graph = new DiGraph(len);
    int[] whole= {0, len-1, mid};
    System.out.println("mid " + mid + " " + arr[mid]);
    addToTree(graph, arr, whole);

    return graph;
  }
  public static void addToTree(DiGraph graph, int[] arr, int[] pos) {
    int startIndex = pos[0];
    int endIndex = pos[1];
    int parentIndex = pos[2];
    int mid = (startIndex + endIndex)/2;

    if (startIndex <= endIndex) {
      if (parentIndex != mid) {
        System.out.println("added Edge " + parentIndex + " " + mid);
        graph.addEdge(parentIndex, mid);
      }

      if ((mid-startIndex) > 0) {
        int[] left = {startIndex, mid-1, mid};
        addToTree(graph, arr, left);
      }

      int len = endIndex; 
      if ((len-mid) > 0) {
        int[] right = {mid+1, len, mid};
        addToTree(graph, arr, right);
      }
    }
  } 
  public static void main(String[] args) {
    int[] arr = {0,1,2,3,4,5,6,7,8,9};
    DiGraph graph = createTree(arr);
    graph.print();

    int[] arr1 = {8,9,10};
    DiGraph graph1 = createTree(arr1);
    graph1.print();

  
    int[] arr2 = {15,18,28,35,36,40,100};
    DiGraph graph2 = createTree(arr2);
    graph2.print();
  }
}
