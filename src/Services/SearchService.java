package Services;

import entities.Dog;

import java.util.ArrayList;

public interface SearchService {
    ArrayList<String> findLeapYearNames(ArrayList<Dog> dogs);
    ArrayList<Dog> findOlderAnimal(ArrayList<Dog> dogs, int year);
ArrayList<Dog> findDuplicate(ArrayList<Dog> dogs);
}
