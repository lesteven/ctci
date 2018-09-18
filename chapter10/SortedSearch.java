

public class SortedSearch {
  public static int find(Listy list, int value) {
    int element = list.elementAt(0);
    if (element == -1 || element > value) {
      return -1;
    } else if (element != value) {
      return find(list, value, 0, 1);
    } else {
      return 0;
    }
  } 
  private static int find(Listy list, int value, int prevIndex, 
    int index) {
    if (prevIndex >= index) {
      return -1;
    } 
    int element = list.elementAt(index);
    if (element == value) {
      return index;
    }
    if (element != -1 && element < value) { 
      return find(list, value, index, index * 2); 
    } else {
      int newIndex = (prevIndex + index)/2;
      return find(list,value, prevIndex, newIndex);
    }
  
  }
  public static void main(String[] args) {
    int[] arr = new int[]{2,5,7,12,17,50,100,343};
    Listy list = new Listy(arr);
    for (int each: arr) {
      System.out.println(find(list,each));
    }
    System.out.println(find(list,1));
    System.out.println(find(list,15));
    System.out.println(find(list,500));
  }
}
