import java.util.ArrayList;

public class StringRotation {
  private static boolean sameLength(String one, String two) {
    return one.length() == two.length();
  }
  private static boolean checkRotation(String one, String two) {
    char firstLetter = one.charAt(0);
    int len = one.length();
    ArrayList<Integer> arr = findOffset(firstLetter, two);

    int count = 0;
    for (Integer offset : arr) {
      for (int i = 0; i < len; i++) {
        if (one.charAt(i) != two.charAt((i + offset) % len)) {
          count++;
          break;
        }
      }
    }
    return count != arr.size();
  }
  public static boolean isSubstring(String one, String two) {
    if (sameLength(one, two)) { 
      return checkRotation(one, two);
    }
    return false;
  }
  private static ArrayList<Integer> findOffset(char letter, String two) {
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = 0; i < two.length(); i++) {
      if (letter == two.charAt(i)) arr.add(i); 
    }
    return arr;
  }
  public static void main(String[] args) {
    System.out.println(isSubstring("waterbottle","erbottlewat"));
    System.out.println(isSubstring("waterbottle","erbottlewaz"));
    System.out.println(isSubstring("waterbottle","erbottlew"));
    System.out.println(isSubstring("title","tleti"));
    System.out.println(isSubstring("aaajjj","aaajjj"));
    System.out.println(isSubstring("aaajjj","jjaaaj"));

  }
}
