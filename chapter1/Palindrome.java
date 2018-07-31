import java.util.Arrays;

// only works for alphabet characters

public class Palindrome {
  public static boolean checkPermutation(String string) {
    String newString = string.toLowerCase();
    newString = newString.replaceAll("\\s+","");
    char[] arr = newString.toCharArray();
    Arrays.sort(arr);

    if (isEven(newString)) {
      return isEvenPalin(arr);
    } else {
      return isOddPalin(arr);
    } 
  }
  public static boolean isEven(String string) {
    return string.length() % 2 == 0;
  }
  public static boolean isEvenPalin(char[] arr) {
    int inc = 2;
    for (int i = 0; i < arr.length - 1; i += inc) {
      if (arr[i] != arr[i+1]) {
        return false;
      }
    }
    return true;
  }
  public static boolean isOddPalin(char[] arr) {
    int[] check = new int[26];
    for (int i = 0; i < arr.length; i ++) {
      int index = arr[i] - 'a';
      check[index] += 1;
    }
    int numOdd = 0;
    for (int i = 0; i < check.length; i++) {
      if (check[i] % 2 != 0) {
        numOdd++;
      }
    }
    if (numOdd > 1) return false;
    return true;
  }
  public static void main(String[] args) {
    String shouldBeTrue = ". Should be true";
    String shouldBeFalse = ". Should be false";

    System.out.println(checkPermutation("racecar") + shouldBeTrue);
    System.out.println(checkPermutation("Tact Coa") + shouldBeTrue);
    System.out.println(checkPermutation("taco cat") + shouldBeTrue);
    System.out.println(checkPermutation("HEEH") + shouldBeTrue);
    System.out.println(checkPermutation("h") + shouldBeTrue);
    System.out.println(checkPermutation("heH") + shouldBeTrue);
    System.out.println(checkPermutation("HH") + shouldBeTrue);

    System.out.println(checkPermutation("hello") + shouldBeFalse);
    System.out.println(checkPermutation("ab") + shouldBeFalse);
    System.out.println(checkPermutation("abc") + shouldBeFalse);
    System.out.println(checkPermutation("HEEHcl") + shouldBeFalse);
    System.out.println(checkPermutation("aaaacl") + shouldBeFalse);
  }
}


