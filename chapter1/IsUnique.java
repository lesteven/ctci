/* check uniqueness of strings
   only works for alphabet characters
*/
public class IsUnique {

  public static boolean checkUnique(String string) {
    int[] arr = new int[26];
   
    String uppercase = string.toUpperCase(); 
    for (int i = 0; i < uppercase.length(); i++) {
      char letter = uppercase.charAt(i);
      // System.out.println((int)letter);
      int index = letter - 65;

      if (arr[index] == 0) {
        arr[index] = 1;
      } else {
        return false;
      } 
    }  
    return true;
  }
  public static void main(String[] args) {
    final String shouldBeFalse = ". Should be false";
    final String shouldBeTrue = ". Should be true";

    boolean hello= checkUnique("hello");
    System.out.println(hello + shouldBeFalse);

    boolean jack = checkUnique("jack");
    System.out.println(jack + shouldBeTrue);


    boolean taco= checkUnique("TaCo");
    System.out.println(taco + shouldBeTrue);

    boolean zebra = checkUnique("zEbRa");
    System.out.println(zebra + shouldBeTrue);
  }
}
