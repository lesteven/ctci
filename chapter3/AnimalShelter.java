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
    StackGen<Animal> temp = new StackGen<Animal>();
    Animal animal = null;
    do {
      animal = all.removeFirst();
      if (!(animal instanceof Dog)) {
        temp.push(animal);
      }
    } while (!(animal instanceof Dog) && all.size() != 0); 

    while (!temp.isEmpty()) {
      all.addFirst(temp.pop());
    } 
    if (animal instanceof Dog) {
      return animal;
    } else {
      return null;
    }
  }
  public Animal dequeueCat() {
    StackGen<Animal> temp = new StackGen<Animal>();
    Animal animal = null;
    do {
      animal = all.remove();
      if (!(animal instanceof Cat)) {
        temp.push(animal);
      }
    } while (!(animal instanceof Cat) && all.size() != 0); 

    while (!temp.isEmpty()) {
      all.addFirst(temp.pop());
    } 
    if (animal instanceof Cat) {
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
    shelter.print();
    System.out.println(shelter.dequeueCat());
    shelter.print();
    System.out.println(shelter.dequeueCat());
    shelter.print();
 
    for (int i = 0; i < 2; i++) {
      shelter.dequeueDog();
    } 
    shelter.print();

    shelter.dequeueAny();
    shelter.print();

    shelter.dequeueAny();
    shelter.print();
  }
}
