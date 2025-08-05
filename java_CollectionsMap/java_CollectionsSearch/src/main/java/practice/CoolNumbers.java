package practice;

import java.util.*;
import java.util.Random;

public class CoolNumbers {


    private static final char[] LETTERS = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    private static final Random RANDOM = new Random();

    public static List<String> generateCoolNumbers() {
        //List<String> numbers = new ArrayList<>();
        Set<String> uniqueNumbers = new HashSet<>(); // Хранит уникальные номера
        final int MIN_COUNT = 2_000_000;

        while (uniqueNumbers.size() < MIN_COUNT) {
            StringBuilder sb = new StringBuilder();

            // Первая буква
            sb.append(LETTERS[RANDOM.nextInt(LETTERS.length)]);

            // Три одинаковые цифры
            int digit = RANDOM.nextInt(10); // Получаем одну цифру
            sb.append(Integer.toString(digit).repeat(3)); // Повторяем цифру три раза с помощью repeat()

            // Вторая буква
            sb.append(LETTERS[RANDOM.nextInt(LETTERS.length)]);

            // Третья буква
            sb.append(LETTERS[RANDOM.nextInt(LETTERS.length)]);

            // Регион
            int region = RANDOM.nextInt(199) + 1;
            if (region < 10) {
                sb.append('0');
            }
            sb.append(region);

            uniqueNumbers.add(sb.toString()); // Add directly to the set
        }

        return new ArrayList<>(uniqueNumbers); // Возвращаем списком
    }

    // Линейное сканирование
    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    // Бинарный поиск
    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return Collections.binarySearch(sortedList, number) >= 0;
    }

    // Поиск в хеш-множестве
    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    // Поиск в TreeSet
    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}