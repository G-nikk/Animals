package factories;

import entities.Animal;
import entities.Dog;
import entities.Wolf;

import java.time.LocalDate;
/**
 * Фабрика для создания объектов животных.
 *
 * Этот класс предоставляет статический метод для создания экземпляров различных типов животных
 * на основе переданных параметров.  Поддерживает создание волков и собак.
 * Добавление новых типов животных требует расширения этого класса.
 */
public class AnimalFactory {
    /**
     * Создает объект животного заданного типа.
     *
     * @param type        Тип животного ("wolf" или "dog").  Регистр не учитывается.
     * @param breed       Порода животного.
     * @param name        Имя животного.
     * @param cost        Стоимость животного.
     * @param character   Характер животного.
     * @param birthDate   Дата рождения животного.
     * @return Экземпляр класса животного.
     * @throws IllegalArgumentException Если передан неизвестный тип животного.
     */
    public static Animal createAnimal(String type, String breed, String name, Double cost, String character, LocalDate birthDate) {
        switch (type.toLowerCase()) {
            case "wolf":
                return new Wolf(breed, name, cost, character, birthDate);
            case "dog":
                return new Dog(breed, name, cost, character, birthDate);
            default:
                throw new IllegalArgumentException("Unknown animal type: " + type);
        }
    }
}
