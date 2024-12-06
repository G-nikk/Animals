package entities;

import java.time.LocalDate;

public class Predator extends AbstractAnimal {
    public Predator(String breed, String name, Double cost, String character, LocalDate birthDate){
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }
}
