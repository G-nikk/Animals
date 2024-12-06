package Services;

import entities.*;

import java.time.LocalDate;
import java.util.Random;

/**
 * Сервис для создания животных.
 * Предоставляет методы для генерации и создания объектов животных.
 */
public interface CreateAnimalService {

    /**
     * Массив дат рождения, используемых для генерации животных.
     *  Значения генерируются при загрузке класса.
     */
    LocalDate[] birthDates = generateRandomBirthDates(10);

    /**
     * Массив пород кошек.
     */
    String[] CatBreeds = {"рыжая", "чёрная", "белая", "черепаховая", "полосатая",
            "пятнистая", "длинношёрстная", "короткошорстная", "лысая", "серая"};

    /**
     * Массив имён кошек.
     */
    String[] CatNames = {"Мурзик", "Пушок", "Васька", "Барсик", "Рыжик",
            "Кузя", "Симба", "Лео", "Муся", "Черныш"};

    /**
     * Массив характеров кошек.
     */
    String[] catCharacters = {
            "Ласковый и игривый",
            "Независимый и спокойный",
            "Любопытный и активный",
            "Застенчивый и пугливый",
            "Дружелюбный и общительный",
            "Ленивый и спокойный",
            "Смышленый и сообразительный",
            "Упрямый и своенравный",
            "Озорной и шаловливый",
            "Преданный и верный"
    };


    /**
     * Создает 10 кошек с использованием предопределенных данных.
     *  Выводит информацию о созданных кошках в консоль.
     */
    default void createAnimals() {
        int i = 9;
        while (i >= 0) {
            AbstractAnimal animal = new Cat(CatBreeds[i], CatNames[i], i + 12.00, catCharacters[i], birthDates[i]);
            System.out.println(animal.toString());
            i--;
        }
    }

    /**
     * Генерирует массив случайных дат рождения.
     *
     * @param count Количество дат, которые нужно сгенерировать.
     * @return Массив дат рождения.
     */
    static LocalDate[] generateRandomBirthDates(int count) {
        LocalDate[] dates = new LocalDate[count];
        Random random = new Random();

        // Вариант 1: Даты от 1900 до 2023
        for (int i = 0; i < count; i++) {
            int year = 1900 + random.nextInt(124); // До 2023
            int month = 1 + random.nextInt(12);
            int day = 1 + random.nextInt(28); // Простая проверка, чтобы не было лишних дат
            try {
                dates[i] = LocalDate.of(year, month, day);
            } catch (java.time.DateTimeException e) {
                // Обработка исключения, если дата некорректна (например, 29 февраля в невисокосный год)
                day = random.nextInt(28)+1; //перегенерация дня, пока не найдется корректная дата
                dates[i] = LocalDate.of(year, month, day);
            }
        }
        return dates;
    }

    /**
     * Создает заданное количество животных.  Реализация должна быть определена в конкретном классе.
     * @param n Количество животных для создания.
     */
    void createAnimals(int n);
}
