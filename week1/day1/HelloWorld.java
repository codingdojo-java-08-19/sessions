import java.util.ArrayList;

public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello World");

    int integer = 10;
    Integer int2 = 10;

    System.out.println(integer == int2);

    double pi = 3.14;
    boolean bool = false;

    char myChar = 'c';
    String myStr = "this is a string";

    System.out.println(myStr);

    int[] ints = { 1, 2, 3, 4, 5 };
    System.out.println(ints);

    for (int i = 0; i < ints.length; i++) {
      System.out.println(ints[i]);
    }

    ArrayList<Integer> array = new ArrayList<Integer>();

    array.add(int2);
    array.add(integer);

    System.out.println(array);

    for (int i = 0; i < array.size(); i++) {
      System.out.println(array.get(i));
    }

    for (int value : array) {
      System.out.println(String.format("This is the value %d", value));
      // console.log("This is the value " + value);
    }
  }
}