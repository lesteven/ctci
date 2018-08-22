import java.util.LinkedList;


public class AnimalShelter {
  private LinkedList<Animal> all;

  public AnimalShelter() {
    all = new LinkedList<>();
  } 

  public Animal enqueue(Animal animal) {
    all.addLast(animal);
    return all.peekLast();
  }
  public Animal dequeueAny() {
    return all.pollFirst();
  }
  public Animal dequeueDog() {
    return dequeueAnimal(Dog.class);
  }
  public Animal dequeueCat() {
    return dequeueAnimal(Cat.class);
  }
  public Animal dequeueAnimal(Class c) {
    StackGen<Animal> temp = new StackGen<Animal>();
    Animal animal = null;
    do {
      animal = all.remove();
      if (!c.isInstance(animal)) {
        temp.push(animal);
      }
    } while (!c.isInstance(animal) && all.size() != 0); 

    while (!temp.isEmpty()) {
      all.addFirst(temp.pop());
    } 
    if (c.isInstance(animal)) {
      return animal;
    } else {
      return null;
    }

  }
  public void print() {
    System.out.println(all);
  }
  public static void main(String[] args) {
    AnimalShelter shelter = new AnimalShelter();
    for (int i = 0; i < 10; i++) {
      Animal animal = null;
      if (i % 2 == 0) {
        animal  = new Dog("dog" + i);
      } else {
        animal = new Cat("cat" + i);
      }
      shelter.enqueue(animal);
    }
    System.out.println("starting population");
    shelter.print();

    System.out.println("remove " + shelter.dequeueCat());
    shelter.print();
    System.out.println("remove " + shelter.dequeueCat());
    shelter.print();
 
    for (int i = 0; i < 4; i++) {
      System.out.println("remove " + shelter.dequeueDog());
    } 
    shelter.print();
    System.out.println("remove any " + shelter.dequeueAny());
    shelter.print();

    System.out.println("remove any " + shelter.dequeueAny());
    shelter.print();
  }
}
