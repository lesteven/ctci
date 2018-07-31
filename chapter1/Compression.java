

public class Compression {

  public static String compress(String string) {
    StringBuilder compressed = new StringBuilder();
   
    int length = 0; 
    for (int i = 0; i < string.length(); i++) {
      int count = 1;
      for (int j = i+1; j <string.length(); j++) {
        if (string.charAt(i) == string.charAt(j)) {
          count++;
        } else {
          i = j - 1;
          j = string.length();
        }
      }
      length += count;
      compressed.append(string.charAt(i) + "");
      compressed.append(String.valueOf(count));
      if (length == string.length()) i = string.length();
    }
    return compressed.toString();
  }
  public static void main(String[] args) {
    String test = "aabcccccaaa";
    String outcome= "a2b1c5a3";
   
    String compressed = compress(test); 
    boolean shouldBeTrue = compressed.equals(outcome);
    System.out.println(compressed + " equals outcome " + shouldBeTrue); 
    System.out.println(compress("aaabc"));
    System.out.println(compress("abccccc"));
  }
}
