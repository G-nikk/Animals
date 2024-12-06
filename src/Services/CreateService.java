package Services;

import entities.Animal;
import factories.AnimalFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Сервис для генерации животных.
 * Этот класс предоставляет метод для генерации массива животных заданного типа с случайными характеристиками.
 */
public class CreateService {
    private final Random random = new Random();

    /**
     * Массив пород, используемых для генерации животных.
     */
    private final String[] breeds = {"Сибирский", "Аляскинский", "Канадский"};

    /**
     * Массив имён, используемых для генерации животных.
     */
    private final String[] names = {"Клык", "Пушок", "Зорька", "Серый"};

    /**
     * Массив характеров, используемых для генерации животных.
     */
    private final String[] characters = {"Дружелюбный", "Злой", "Игривый", "ленивый"};


    /**
     * Генерирует массив животных заданного типа с случайными характеристиками.
     *
     * @param n           Количество животных для генерации.
     * @param animalType  Тип животного (например, "wolf", "dog").  Используется фабрикой {@link AnimalFactory} для создания объекта.
     * @return Массив сгенерированных животных.
     */
    public Animal[] generateAnimals(int n, String animalType) {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String breed = breeds[random.nextInt(breeds.length)];
            String name = names[random.nextInt(names.length)];
            double cost = random.nextDouble() * 1000; // Стоимость от 0 до 1000
            String character = characters[random.nextInt(characters.length)];
            LocalDate birthDate = generateRandomBirthDate();

            animals.add(AnimalFactory.createAnimal(animalType, breed, name, cost, character, birthDate));
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
        return animals.toArray(new Animal[0]);
    }


    /**
     * Генерирует случайную дату рождения.
     *  Упрощенная генерация, не учитывающая високосные года и количество дней в месяцах.
     * @return Случайная дата рождения.
     */
    private LocalDate generateRandomBirthDate() {
        int year = 2020 + random.nextInt(3);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28); // упрощенная генерация дня
        return LocalDate.of(year, month, day);
    }
}