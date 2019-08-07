public class Dog extends Animal implements IAnimal {
  public Dog() {
    super("Dog");
  }

  public Dog(int legs) {
    super(legs, "Dog");
  }

  public void makeSound() {
    System.out.println("Woof Woof");
  }
}