import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class Anagram {
  public static String[] next(String[] list) {
    Map<String, ArrayList<String>> map = new HashMap<>(); 
    for (String each: list) {
      char[] arr = each.toCharArray();
      Arrays.sort(arr);
      String sorted = String.valueOf(arr);

      if (map.containsKey(sorted)) {
        ArrayList<String> stringList = map.get(sorted);
        stringList.add(each);
      } else {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add(each);
        map.put(sorted, stringList);
      }
    }
    int i = 0;
    String[] sortedList = new String[list.length];
    for (ArrayList<String> stringList : map.values()) {
      for (String each: stringList) {
        sortedList[i++] = each; 
      }
    }
    return sortedList;
  }
  public static void main(String[] args) {
    String[] list = {"avaj", "hello", "goodbye", "olleh", "farewell", "wow",
      "llohe", "java"};
    System.out.println(Arrays.toString(list));
    System.out.println(Arrays.toString(next(list)));
  }
}
