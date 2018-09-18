import java.util.Arrays;

public class Listy {
  int[] arr;
  int size;
  public Listy(int[] arr) {
    size = arr.length;
    this.arr = new int[size];
    for (int i = 0; i < arr.length; i++) {
      this.arr[i] = arr[i];
    }
  }
  private void get() {
    System.out.println(Arrays.toString(arr));
  }
  public int elementAt(int i) {
    if (i >= size) {
      return -1;
    }
    return arr[i];
  }
  public static void main(String[] args) {
    Listy list = new Listy(new int[]{5,24,44,76,100,244});
    list.get();
    System.out.println(list.elementAt(10));
    System.out.println(list.elementAt(5));
  
  }
}
