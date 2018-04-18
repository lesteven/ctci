import java.util.HashMap;

public class Unique {

  // test with hashmap data structure
  public static boolean isUnique(String word) {
    HashMap<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < word.length(); i++) {
          if (!map.containsKey(word.charAt(i))) {
            map.put(word.charAt(i), 0);
          }
          else {
            return false;
          }
      }
    return true;
  }

  // test with no data structures
  public static boolean isUniNoDs(String word) {
    for (int i = 0; i < word.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (i != j) {
          if (word.charAt(i) == word.charAt(j)) {
            return false;
          }
        }
      }
    }
    return true;
  }
  public static void main(String[] args) {
    String word = "hello";
    boolean test = Unique.isUnique(word);
    boolean testNo = Unique.isUniNoDs(word);
    System.out.println(test + " = false? ");
    System.out.println(testNo + " = false? ");
    System.out.println("---------\n");

    String word2 = "jingle";
    boolean test2 = Unique.isUnique(word2);
    boolean testNo2 = Unique.isUniNoDs(word2);
    System.out.println(test2 + " = true? ");
    System.out.println(testNo2 + " = true? ");
    System.out.println("---------\n");


    String word3 = "a";
    boolean test3 = Unique.isUnique(word3);
    boolean testNo3 = Unique.isUniNoDs(word3);
    System.out.println(test3 + " = true? ");
    System.out.println(testNo3 + " = true? ");
    System.out.println("---------\n");


    String word4 = "";
    boolean test4 = Unique.isUnique(word4);
    boolean testNo4 = Unique.isUniNoDs(word4);
    System.out.println(test4 + " = true? ");
    System.out.println(testNo4 + " = true? ");
    System.out.println("---------\n");
  }
}
