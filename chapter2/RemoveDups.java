import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class RemoveDups {
  public static Map<Character, Integer> createMap(
    LinkedList<Character> list) {
      Map<Character, Integer> map = new HashMap<>();
      Iterator<Character> it = list.iterator();
      while (it.hasNext()) {
        char item = it.next();
        if (map.containsKey(item)) {
          int count = map.get(item);
          map.put(item, count + 1);
        } else {
          map.put(item, 1);
        }
      }
    return map;
  }
  public static void removeDuplicate(LinkedList<Character> list) {
    Map<Character, Integer> map = createMap(list);
    
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      char letter = entry.getKey();
      int count = entry.getValue();
      for (int i = 0; i < count - 1; i++) {
        char removed = list.remove(letter);
      }
    } 
  }
  private static String getWord(LinkedList<Character> list) {
    StringBuilder string = new StringBuilder();
    Iterator it = list.iterator();
    while (it.hasNext()) {
      string.append(it.next());
    }
    return string.toString();
  }
  private static LinkedList<Character> makeList(String word) {
    LinkedList<Character> list = new LinkedList<>();
    for (int i = 0; i < word.length(); i++) {
      list.add(word.charAt(i));
    }
    return list;
  }
  private static void testWord(String word) {
    LinkedList<Character> list = makeList(word);
    System.out.println(getWord(list));
    removeDuplicate(list);
    System.out.println(getWord(list));
    System.out.println("===========");
  }
  public static void main(String[] args) {
    testWord("FOLLOW UP");
    testWord("HELLO");
    testWord("A");
    testWord("AA");
    testWord("AAAAAAA");
  }
} 
