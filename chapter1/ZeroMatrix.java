import java.util.Arrays;

public class ZeroMatrix {

  public static int[][] zero(int[][] matrix) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    int[][] zeroed = new int[rowLen][colLen];
    boolean[][] modified = new boolean[rowLen][colLen];

    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        if (matrix[row][col] != 0 && !modified[row][col]) {
          zeroed[row][col] = matrix[row][col];
        } 
        if (matrix[row][col] == 0 && !modified[row][col]) {
          zeroOutRowAndCol(row, col, zeroed, modified);
          col = colLen; 
        } 
      }
    }
    return zeroed;
  }
  private static void zeroOutRowAndCol(int row, int col, int[][] zeroed,
    boolean[][] modified) {
      int rowLen = modified.length;
      int colLen = modified[0].length;
      for (int rowIt = 0; rowIt < rowLen; rowIt++) {
        zeroed[rowIt][col] = 0;
        modified[rowIt][col] = true;
      }
      for (int colIt = 0; colIt < colLen; colIt++) {
        zeroed[row][colIt] = 0;
        modified[row][colIt] = true;
      }
    }

  public static void main(String[] args) {
    int[][] matrix = {{1,1,0},{1,1,1}};
    int[][] zeroed = zero(matrix);
    int[][] expected = {{0,0,0},{1,1,0}};
    int[][] matrix2 = {{1,0},{1,1},{1,1}};
    int[][] matrix3= {{1,0,1,1},{1,1,1,1},{1,1,1,1}};
    System.out.println(Arrays.deepToString(zeroed)); 
    System.out.println(Arrays.deepToString(zero(matrix2))); 
    System.out.println(Arrays.deepToString(zero(matrix3))); 
  }
}
