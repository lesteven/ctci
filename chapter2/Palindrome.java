import java.lang.StringBuilder;

public class Palindrome extends SinglyLinkedList<Character> {
  public static String makeString(SinglyLinkedList<Character> list) {
    StringBuilder string = new StringBuilder();
    Node node = list.head;
    while (node.next != null) {
      string.append(node.value);
      node = node.next;
    }
    string.append(node.value);
    return string.toString();
  }
  public static boolean checkPalindrome(SinglyLinkedList<Character> 
    list) {
    String string = makeString(list);
    string = string.toLowerCase();
    int len = string.length();
    for (int i = 0; i < len/2; i++) {
      if (string.charAt(i) != string.charAt(len-i-1)) {
        return false;
      } 
    } 
    return true;
  }
  public static void test(String string) {
    SinglyLinkedList<Character> list = 
      new SinglyLinkedList<Character>();
    String palin= string;
    for (int i = 0; i < palin.length(); i++) {
      list.add(palin.charAt(i));
    }
    System.out.println(string + " is palin? : " + 
      checkPalindrome(list));

  }
  public static void main(String[] args) {
    test("racecar");
    test("raceca");
    test("heeh");
    test("HeEh");
    test("ttttt");
    test("abcba");
    test("hello");
  }
}
