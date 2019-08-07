public class Test {
  public static void main(String[] args) {
    Calculator calc = new Calculator();

    System.out.println(calc);

    calc.performOperation(10.5);
    calc.performOperation("*");
    calc.performOperation(6);
    calc.performOperation("+");
    calc.performOperation(9);

    calc.performOperation("-");
    calc.performOperation(20);
    calc.performOperation("/");
    calc.performOperation(2);
    calc.performOperation("=");

    System.out.println("The result is " + calc.getResult());
  }
}