

public class BinarySearch {
  public static int search(int[] list, int value) {
    return search(list, 0, list.length-1, value);  

  }
  public static int search(int[] list, int start, int last, int value) {
    int mid = (start + last)/2;
    if (start > last) {
      return -1;
    }
    if (list[mid] == value) {
      return mid;
    }
    if (list[mid] > value) {
      return search(list, start, mid-1, value);
    } else {
      return search(list, mid+1, last, value);
    }
  }
  public static int itSearch(int[] list, int value) {
    int start = 0;
    int last = list.length -1;

    while (start <= last) {
      int mid = (start + last)/2;
      if (list[mid] == value) {
        return mid;
      }
      if (list[mid] > value) {
        last = mid -1;
      } else {
        start = mid + 1;
      } 
    }
    return -1;
  }
  public static void main(String[] args) {
    int[] list = {1, 3, 5};
    System.out.println("-1? " + search(list,2));
    System.out.println("0? " + search(list,1));
    System.out.println("2? " + search(list,5));
    System.out.println("-1? " + search(list,4));

    int[] list2 = {2, 4, 10, 14, 59, 205, 400, 4000};
    
    System.out.println("-1? " + search(list2, 12));
    System.out.println("1? " + search(list2, 4));
    System.out.println("7? " + search(list2, 4000));
    System.out.println("-1? " + search(list2, 5000));
    System.out.println("-1? " + search(list2, -1000));

    System.out.println("it search: ");
    System.out.println("-1? " + itSearch(list,2));
    System.out.println("0? " + itSearch(list,1));
    System.out.println("2? " + itSearch(list,5));
    System.out.println("-1? " + itSearch(list,4));

    
    System.out.println("-1? " + itSearch(list2, 12));
    System.out.println("1? " + itSearch(list2, 4));
    System.out.println("7? " + itSearch(list2, 4000));
    System.out.println("-1? " + itSearch(list2, 5000));
    System.out.println("-1? " + itSearch(list2, -1000));
  }
}
