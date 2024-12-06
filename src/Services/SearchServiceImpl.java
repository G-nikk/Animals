package Services;

import entities.Dog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Сервис для поиска собак по различным критериям.
 * Использует Stream API для обработки списка собак.
 */
public class SearchServiceImpl implements SearchService {

    /**
     * Находит имена собак, родившихся в високосный год.
     *
     * @param dogs Список собак.
     * @return Список имён собак, родившихся в високосный год.
     */
    @Override
    public ArrayList<String> findLeapYearNames(ArrayList<Dog> dogs) {
        return dogs.stream()
                .filter(dog -> dog.getBirthDate().isLeapYear())
                .map(Dog::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Находит собак, которые старше заданного возраста.
     *
     * @param dogs Список собак.
     * @param age  Возраст (в годах).
     * @return Список собак, которые старше заданного возраста.
     */
    @Override
    public ArrayList<Dog> findOlderAnimal(ArrayList<Dog> dogs, int age) {
        int currentYear = LocalDate.now().getYear(); // Используем текущий год
        return dogs.stream()
                .filter(dog -> currentYear - dog.getBirthDate().getYear() > age)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Находит дубликаты собак в списке.  Для корректной работы необходимо переопределить методы equals() и hashCode() в классе Dog.
     *
     * @param dogs Список собак.
     * @return Список дублирующих собак.
     */
    @Override
    public ArrayList<Dog> findDuplicate(ArrayList<Dog> dogs) {
        return dogs.stream()
                .collect(Collectors.toCollection(ArrayList::new)) // toCollection нужен для ArrayList
                .stream()
                .distinct()
                .filter(dog -> dogs.stream().filter(d -> d.equals(dog)).count() > 1)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}