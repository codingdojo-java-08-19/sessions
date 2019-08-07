public class Cat extends Animal {
  public Cat() {
    super("Cat");
  }

  public Cat(int numberOfLegs) {
    super(numberOfLegs, "Cat");
  }

  public void makeSound() {
    System.out.println("Meow");
  }
}