package Services;

import entities.AbstractAnimal;
import entities.Shark;
import entities.Wolf;

import java.time.LocalDate;

/**
 * Реализация сервиса для создания животных.
 *  Этот класс предоставляет методы для генерации и создания различных типов животных.
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {

    /**
     * Конструктор по умолчанию.
     */
    public CreateAnimalServiceImpl() {
    }

    /**
     * Создает 10 кошек с использованием предопределенных данных из интерфейса {@link CreateAnimalService}.
     * Выводит информацию о созданных кошках в консоль.
     */
    @Override
    public void createAnimals() {
        CreateAnimalService.super.createAnimals();
    }

    /**
     * Создает указанное количество волков с случайными параметрами.
     *
     * @param n Количество волков для создания.
     */
    @Override
    public void createAnimals(int n) {
        LocalDate[] birthDate = CreateAnimalService.generateRandomBirthDates(n);
        for (int i = 0; i < n; i++) {
            AbstractAnimal animal = new Wolf("дикий волк", "Клык", i + 23.14, "злой", birthDate[i]);
            System.out.println(animal);
        }
    }

    /**
     * Создает указанное количество акул с использованием цикла do-while.
     *
     * @param n Количество акул для создания.
     */
    public void createAnimalsWithDoWhile(int n) {
        LocalDate[] birthDate = CreateAnimalService.generateRandomBirthDates(n);
        int i = 0;
        do {
            AbstractAnimal animal = new Shark("белая акула", "Плавник", i + 153.14, "агрессивный", birthDate[i]);
            i++;
            System.out.println(animal);
        } while (i < n);
    }
}