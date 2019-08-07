import java.util.ArrayList;

public class Calculator {
  private ArrayList<String> operations = new ArrayList<String>();
  private double result;

  public void performOperation(double value) {
    this.operations.add(Double.toString(value));
  }

  public void performOperation(String operand) {
    if (operand.equals("=")) {
      System.out.println("equals");
      System.out.println(operations);
      // perform operations
      performOperations();

      return;
    }

    this.operations.add(operand);
    System.out.println(operations);

  }

  // 0 1 2 3 4 5 6
  // [10, + , 9 , *, 23, - 12]
  public void performOperations() {
    double result = 0;
    int idx = 0;

    while (operations.contains("*") || operations.contains("/")) {
      String current = operations.get(idx);

      if (current.equals("*") || current.equals("/")) {
        // do something (calculate)
        result = calculate(idx);
      } else {
        idx++;
      }

    }

    while (operations.size() > 1) {
      result = calculate(1);
    }

    this.result = result;
    System.out.println("Completed calc " + result);
  }

  private double calculate(int idx) {
    String second = operations.remove(idx + 1);
    String operand = operations.remove(idx);
    String first = operations.remove(idx - 1);

    final double result = maths(operand, first, second);

    operations.add(idx - 1, Double.toString(result));

    System.out.println(operations);

    return result;
  }

  private double maths(String operand, String first, String second) {
    return maths(operand, Double.parseDouble(first), Double.parseDouble(second));
  }

  private double maths(String operand, double value1, double value2) {
    double answer = 0;

    switch (operand) {
    case "+":
      answer = value1 + value2;
      break;
    case "-":
      answer = value1 - value2;
      break;
    case "/":
      answer = value1 / value2;
      break;
    case "*":
      answer = value1 * value2;
      break;
    }

    return answer;
  }

  public double getResult() {
    return result;
  }
}