package practice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        long startTime, endTime;

        // Генерируем два миллиона номеров
        List<String> coolNumbers = CoolNumbers.generateCoolNumbers();

        // Печатаем первый номер для примера
        System.out.println("Первый номер: " + coolNumbers.get(0));

        // Берём произвольный номер для тестирования
        Random random = new Random();
        String testNumber = coolNumbers.get(random.nextInt(coolNumbers.size()));

        // Исходная коллекция чисел в виде ArrayList
        List<String> originalList = new ArrayList<>(coolNumbers);

        // Коллекция чисел в виде отсортированного ArrayList
        List<String> sortedList = new ArrayList<>(coolNumbers);

        // Замеряем время сортировки
        Collections.sort(sortedList);

        // HashSet для быстрого поиска
        HashSet<String> hashSet = new HashSet<>(coolNumbers);

        // TreeSet для поиска в дереве
        TreeSet<String> treeSet = new TreeSet<>(coolNumbers);

        // Прямой перебор
        startTime = System.nanoTime();
        boolean foundBruteForce = CoolNumbers.bruteForceSearchInList(originalList, testNumber);
        endTime = System.nanoTime();
        System.out.printf("Поиск перебором: %s, поиск занял %.2f нс\n",
                foundBruteForce ? "номер найден" : "номер не найден",
                (double) (endTime - startTime));

        // Бинарный поиск
        startTime = System.nanoTime();
        boolean foundBinarySearch = CoolNumbers.binarySearchInList(sortedList, testNumber);
        endTime = System.nanoTime();
        System.out.printf("Бинарный поиск: %s, поиск занял %.2f нс\n",
                foundBinarySearch ? "номер найден" : "номер не найден",
                (double) (endTime - startTime));

        // Поиск в HashSet
        startTime = System.nanoTime();
        boolean foundHashSet = CoolNumbers.searchInHashSet(hashSet, testNumber);
        endTime = System.nanoTime();
        System.out.printf("Поиск в HashSet: %s, поиск занял %.2f нс\n",
                foundHashSet ? "номер найден" : "номер не найден",
                (double) (endTime - startTime));

        // Поиск в TreeSet
        startTime = System.nanoTime();
        boolean foundTreeSet = CoolNumbers.searchInTreeSet(treeSet, testNumber);
        endTime = System.nanoTime();
        System.out.printf("Поиск в TreeSet: %s, поиск занял %.2f нс\n",
                foundTreeSet ? "номер найден" : "номер не найден",
                (double) (endTime - startTime));
    }
}