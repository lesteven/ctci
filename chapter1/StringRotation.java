

public class StringRotation {
  private static boolean sameLength(String one, String two) {
    return one.length() == two.length();
  }
  public static boolean isSubstring(String one, String two) {
    char firstLetter = one.charAt(0);
    int offset = two.indexOf(firstLetter);
    if (sameLength(one, two)) { 
      int len = one.length();
      for (int i = 0; i < len; i++) {
        if (one.charAt(i) != two.charAt((i + offset) % len)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  public static void main(String[] args) {
    System.out.println(isSubstring("waterbottle","erbottlewat"));
    System.out.println(isSubstring("waterbottle","erbottlewaz"));
    System.out.println(isSubstring("waterbottle","erbottlew"));

  }
}
