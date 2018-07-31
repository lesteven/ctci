import java.util.HashMap;
import java.util.Map;

public class OneAway {

  public static boolean isOneAway(String one, String two) {
    if (sameLength(one, two)) {
      return checkSameLen(one, two);
    } else {
      return checkDiffLen(one,two);
    }
  } 

  public static boolean sameLength(String one, String two) {
    return one.length() == two.length();
  }

  public static boolean checkSameLen(String one, String two) {
    char[] oneArr = one.toCharArray();
    char[] twoArr = two.toCharArray();

    int oneAway = 0;
    for (int i = 0; i < oneArr.length; i++) {
      if (oneArr[i] != twoArr[i]) { 
        oneAway++;
        if (oneAway > 1) return false;
      }
    }
    return true;
  }

  public static boolean checkDiffLen(String one, String two) {
    String longString = getLongerString(one, two);
    String shortString = getShorterString(one, two);
    
    char[] arr = shortString.toCharArray(); 
    Map<Character, Integer> map = makeHashMap(longString); 

    int tally = 0;
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        tally++;
      }
    }
    if (tally == arr.length) return true;
    return false;
  }

  public static String getLongerString(String one, String two) {
    if (one.length() > two.length()) return one;
    return two;
  }

  public static String getShorterString(String one, String two) {
    if (one.length() > two.length()) return two;
    return one;
  } 

  public static Map<Character, Integer> makeHashMap(String string) {
    Map<Character, Integer> map = new HashMap<>();
    char[] arr = string.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], 0); 
    }
    return map;
  }

  public static void main(String[] args) {
    String shouldBeTrue = ". Should be true";
    String shouldBeFalse = ". Should be false";

    System.out.println(isOneAway("pale", "ple") + shouldBeTrue);    
    System.out.println(isOneAway("pale", "pale") + shouldBeTrue);    
    System.out.println(isOneAway("pale", "bale") + shouldBeTrue);    
    System.out.println(isOneAway("pale", "bake") + shouldBeFalse);    
    System.out.println(isOneAway("a", "b") + shouldBeTrue); 
  }
}


