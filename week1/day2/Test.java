public class Test {
  public static void main(String[] args) {
    Cat animal = new Cat(4);
    Fox fox = new Fox();
    Fish fish = new Fish();
    Dog dog = new Dog();
    Parrot parrot = new Parrot();

    Human human = new Human();

    // Animal newAnimal = new Animal();

    // animal.setNumberOfLegs(-5);

    animal.setType("Cat");

    System.out.println(animal.getNumberOfLegs());
    System.out.println(animal.getType());
    System.out.println("----------");

    System.out.println(fox.getType());
    System.out.println(fox.getNumberOfLegs());
    System.out.println("----------");
    System.out.println(fish.getNumberOfLegs());
    fish.makeSound();
    // System.out.println(fish.makeSound());

    System.out.println("----------");
    System.out.println(dog.getNumberOfLegs());
    System.out.println(dog.getType());
    dog.makeSound();

    System.out.println("----------");

    // Trainer trainer = new Trainer();
    Trainer.train(animal);
    Trainer.train(dog);
    Trainer.train(fish);
    Trainer.train(fox);
    Trainer.train(human);
    // Trainer.train((IAnimal) parrot);
  }
}
