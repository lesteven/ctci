
public class Rotate {
  public static int search(int[] list, int value) {
    for (int i = 0; i < list.length; i++) {
      if (list[i] == value) {
        return i;
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    int[] list = {15,16,19,29,25,1,3,4,5,7,10,14};
    System.out.println(search(list,5));

    int[] list2 = {10,11,12,13,14,15,16,1,2};
    System.out.println(search(list2, 2));
  }
}
