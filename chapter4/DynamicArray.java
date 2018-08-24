import java.util.Arrays;

public class DynamicArray<T> {
  private T[] arr; 
  private int size;

  public DynamicArray() {
    arr = (T[]) new Object[2];
    size = 0;
  }
  public T push(T value) {
    if (isFull()) {
      resize();
    }
    arr[size++] = value; 
    return arr[size-1];
  }
  private void resize() {
    T[] newArr = (T[]) new Object[arr.length *2];
    for (int i = 0; i < arr.length; i++) {
      newArr[i] = arr[i];
    }
    arr = newArr;
  }
  private boolean isFull() {
    return size == arr.length; 
  }
  public T[] getArray() {
    return arr;
  }
  public static void main(String[] args) {
    DynamicArray<Integer> arr = new DynamicArray<Integer>();
    for (int i = 0; i < 10; i++) {
      arr.push(i);
    }
    System.out.println(Arrays.toString(arr.getArray()));
  }
}
