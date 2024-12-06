package entities;

import java.time.LocalDate;

public class Pet extends AbstractAnimal {
    public Pet(String breed, String name, Double cost, String character, LocalDate birthDate){
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }
}