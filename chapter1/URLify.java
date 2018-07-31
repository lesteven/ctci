import java.util.Arrays;


public class URLify {
  public static String urlify(String string) {
    char[] arr = string.toCharArray();
    StringBuilder urlified = new StringBuilder();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == ' ') {
        urlified.append("%20");
      } else {
        urlified.append(arr[i]);
      }
    }

    return urlified.toString();
  }
  public static void main(String[] args) {
    String hello = "hello world";
    String modifiedHello = urlify(hello);
    System.out.println(modifiedHello);

    System.out.println(urlify("Mr John Smith"));
  }
}
