import java.util.Arrays;

public class Permutation {
  public static boolean sameLength(String one, String two) {
    return one.length() == two.length();
  }
  public static boolean checkStrings(String one, String two) {
    char[] arrOne = one.toCharArray();
    char[] arrTwo = two.toCharArray();

    Arrays.sort(arrOne); 
    Arrays.sort(arrTwo); 

    for (int i = 0; i < arrOne.length; i++) {
      if (arrOne[i] != arrTwo[i]) {
        return false;
      }
    }
    return true;
  }
  public static boolean checkPermutation(String one, String two) {
    if (sameLength(one, two)) {
      return checkStrings(one, two);
 
    } else {
      return false;
    }    
  }
  public static void main(String[] args) {
    String shouldBeTrue = ". Should be true";
    String shouldBeFalse = ". Should be false";

    String rat = "rat";
    String tar = "tar";
    System.out.println(checkPermutation(rat, tar) + shouldBeTrue);

    String cat = "cat";
    String dog = "dog";
    System.out.println(checkPermutation(cat, dog) + shouldBeFalse);

    String longStr = "extraneous";
    String shortStr= "short";

    System.out.println(checkPermutation(longStr, shortStr) 
      + shouldBeFalse);    
  }
}


