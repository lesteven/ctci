import java.lang.StringBuilder;


public class SumList extends SinglyLinkedList<Integer> {
  private StringBuilder createStrBuild(SumList list) {
    StringBuilder stringBuild = new StringBuilder();    
    Node node = list.head;
    while (node.next != null) {
      stringBuild.append(node.value);
      node = node.next;
    }
    stringBuild.append(node.value);
    return stringBuild;
  }
  private String add(StringBuilder one, StringBuilder two) {
    int numOne = Integer.valueOf(one.toString());
    int numTwo = Integer.valueOf(two.toString());
    int sum = numOne + numTwo;
    return sum + ""; 
  }
  private SumList makeList(String sum) {
    int len = sum.length();
    SumList list = new SumList();
    for (int i = 0; i < len; i++) {
      int num = sum.charAt(i) - '0';
      list.add(num); 
    }
    return list;
  }
  public SumList getForwardSum(SumList one, SumList two) {
    StringBuilder oneStr = createStrBuild(one); 
    StringBuilder twoStr = createStrBuild(two); 
    String sum = add(oneStr, twoStr);
    return makeList(sum);
  }
  public SumList getReverseSum(SumList one, SumList two) {
    StringBuilder oneStr = createStrBuild(one); 
    StringBuilder twoStr = createStrBuild(two); 
    String sum = add(oneStr.reverse(), twoStr.reverse());
    StringBuilder sumBuild = new StringBuilder();
    sumBuild.append(sum).reverse();
    return makeList(sumBuild.toString());
  }
  public static void main(String[] args) {
    SumList one = new SumList();
    one.add(1);
    one.add(2);
    one.add(3);
    one.print();

    SumList two = new SumList();
    two.add(3);
    two.add(4);
    two.add(5);
    two.print();

    SumList sum = one.getReverseSum(one, two);
    sum.print();
  
    System.out.println("forward sum!");

    SumList three = new SumList();
    three.add(3);
    three.add(1);
    three.add(2);
    three.print();

    SumList four = new SumList();
    four.add(5);
    four.add(4);
    four.add(3);
    four.print();
    SumList sum2 = three.getForwardSum(three, four);
    sum2.print();
    
    SumList five = new SumList();
    five.add(1);    
    SumList sum3 = five.getForwardSum(one, five);
    sum3.print();
    SumList sum4 = five.getReverseSum(one, five);
    sum4.print();
  }
}
