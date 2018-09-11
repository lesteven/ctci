import java.util.Arrays;


public class SortedMerge {
  public static int[] merge(int[] largeArr, int[] smallArr) {
    int[] aux = new int[largeArr.length];
 
    int i = 0;
    int k = 0;
    int current = 0;
    while (current < largeArr.length) {
      if (k >= smallArr.length) {
        aux[current++] = largeArr[i++];
      }
      else if (largeArr[i] != 0 && largeArr[i] <= smallArr[k]) {
        aux[current++] = largeArr[i++];
      } else {
        aux[current++] = smallArr[k++];
      } 
    } 
    for (int j = 0; j < largeArr.length; j++) {
      largeArr[j] = aux[j];
    }
    return largeArr;
  }
  public static void main(String[] args) {
    int[] a = {2, 5, 0, 0};
    int[] b = {3, 10};
    System.out.println(Arrays.toString(merge(a,b)));


    int[] c = {2, 20, 0, 0};
    int[] d = {1, 10};
    System.out.println(Arrays.toString(merge(c,d)));


    int[] e = {5, 10, 20, 0};
    int[] f = {6, 15};
    System.out.println(Arrays.toString(merge(e,f)));


    int[] g = {5, 0, 0};
    int[] h = {6, 15};
    System.out.println(Arrays.toString(merge(g, h)));
  }
}
