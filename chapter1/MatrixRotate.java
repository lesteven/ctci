import java.util.Arrays;

public class MatrixRotate {

  public static int[][] rotate(int[][] matrix) {
    int len = matrix.length;
    int[][] rotatedMatrix = new int[len][len];

    for (int row = 0; row < len; row++) {
      for(int col = 0; col < len; col++) {
        rotatedMatrix[col][len-row-1] = matrix[row][col];

      }
    }
    return rotatedMatrix;
  }
  public static void main(String[] args) {
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    int[][] rotated = rotate(matrix); 
    
    int[][] expected = {{7,4,1},{8,5,2},{9,6,3}}; 
    System.out.println(Arrays.deepToString(rotated));
    int[][] matrix2 = {{1}};
    System.out.println(Arrays.deepToString(rotate(matrix2)));
    int[][] matrix3 = {{1, 2}, {3, 4}};
    System.out.println(Arrays.deepToString(rotate(matrix3)));
  }
}
