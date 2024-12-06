import services.*;
import entities.Dog;

import java.time.LocalDate;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl service = new CreateAnimalServiceImpl();
        System.out.println("Генерация животных сервисами: ");
        service.createAnimals();
        service.createAnimals(7);
        service.createAnimalsWithDoWhile(3);

        Dog dog1 = new Dog("овчарка", "Шарик", 9.99, "добрый", LocalDate.of(2015, 3, 10));
        Dog dog2 = new Dog("овчарка", "Шарик", 9.99, "добрый", LocalDate.of(2015, 3, 10));
        Dog dog3 = new Dog("шпиц", "Бобик", 9.99, "агрессивный", LocalDate.of(2012, 9, 1));
        Dog dog4 = new Dog("хаски", "Алекс", 9.99, "добрый", LocalDate.of(2008, 6, 21));
        SearchServiceImpl searchService = new SearchServiceImpl();
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog4);
        ArrayList<String> leapYearAnimalsNames = searchService.findLeapYearNames(dogs);
        ArrayList<Dog> olders = searchService.findOlderAnimal(dogs, 10);
        ArrayList<Dog> duplicates = searchService.findDuplicate(dogs);
        System.out.println("Имена собак, родившихся в високосный год:");
        for (String name : leapYearAnimalsNames) {
            System.out.println(name);
        }
        System.out.println("Собаки, которые старше 10 лет: ");
        for (Dog dog : olders) {
            System.out.println(dog.toString());
        }
        System.out.println("Собаки - дубликаты (вывод одного из них): ");
        for (Dog dog : duplicates) {
            System.out.println(dog.toString());
        }

        CreateService createService = new CreateService();
        System.out.println("Вывод 5 сгенерированных волков");
        createService.generateAnimals(5, "wolf");
    }
}