public abstract class Animal implements IAnimal {
  private int numberOfLegs;
  private String type;
  private String name;

  public Animal(int numberOfLegs, String type) {
    this.numberOfLegs = numberOfLegs;
    this.type = type;
  }

  public Animal(int numberOfLegs) {
    this.numberOfLegs = numberOfLegs;
  }

  public Animal(String type) {
    this.type = type;
    this.numberOfLegs = 4;
  }

  // public Animal(String name) {
  // this.name = name;
  // this.numberOfLegs = 4;
  // }

  // public Animal() {
  // }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getNumberOfLegs() {
    return this.numberOfLegs;
  }

  public void setNumberOfLegs(int legs) {
    if (legs < 0) {
      legs = 0;
    }

    this.numberOfLegs = legs;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}