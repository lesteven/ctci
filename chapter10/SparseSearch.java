

public class SparseSearch {
  public static int search(String[] arr, String value) {
    //return binarySearch(arr, value);
    return linearSearch(arr, value);
  }
  private static int linearSearch(String[] arr, String value) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == value) {
        return i;
      }
    }
    return -1;
  }
  public static int binarySearch(String[] arr, String value) {
    int start = 0;
    int last = arr.length -1;
    
    while (start <= last) {
      int mid = (start + last)/2;
      int compareStr = compare(arr[mid], value);
      if (compareStr == 0) {
        return mid;
      }
      if (compareStr < 0) {
        start = mid + 1;
      } else {
        last = mid - 1;
      }  
    }  
    return -1;
  }
  private static int compare(String one, String two) {
    return one.compareToIgnoreCase(two); 
  }
  public static void main(String[] args) {
    String[] arr = {"at", "", "", "", "ball", "", "", "car",
      "","","dad","",""};
    String one = "abc";
    String two = "abd";
    System.out.println(search(arr, one));
    System.out.println(search(arr, two));
    System.out.println(search(arr, "call"));
    System.out.println(search(arr, "lad"));

    System.out.println(search(arr, "at"));
    System.out.println(search(arr, "ball"));
    System.out.println(search(arr, "dad"));
  }
}
