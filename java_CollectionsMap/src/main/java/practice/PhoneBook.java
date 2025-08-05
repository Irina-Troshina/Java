package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    public final Map<String, List<String>> contacts = new TreeMap<>();

    // Проверка имени пользователя телефона
    boolean isValidName(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("[А-ЯЁа-яёA-ZA-Z]+");
        Matcher matcher = pattern.matcher(input.trim());
        return matcher.matches();
    }

    // Проверка номера телефона
    boolean isValidPhoneNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^\\+?[78][0-9]{10}$");
        Matcher matcher = pattern.matcher(input.trim());
        return matcher.matches();
    }

    // Добавление контакта
    public void addContact(String phone, String name) {
        if (phone == null || phone.trim().isEmpty()) {
            return; // Телефон не указан
        }
        if (name == null || name.trim().isEmpty()) {
            return; // Имя не указано
        }
        if (!isValidPhoneNumber(phone)) {
            return; // Неверный формат номера телефона
        }
        if (!isValidName(name)) {
            return; // Неверное имя
        }
        // Прежде всего проверим, существует ли уже этот номер телефона
        for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
            if (entry.getValue().contains(phone)) {
                // Удаляем старый контакт, содержащий этот номер телефона
                entry.getValue().remove(phone);

                // Если после удаления телефон остался пустым, удаляем всю запись
                if (entry.getValue().isEmpty()) {
                    contacts.remove(entry.getKey());
                }
            }
        }

        // Добавляем новый контакт с данным номером телефона
        contacts.computeIfAbsent(name, k -> new ArrayList<>()).add(phone);
    }

    // Получение информации о контакте по телефону
    public String getContactByPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Телефон не указан.");
        }

        // Проверяем каждый контакт на наличие нужного номера
        for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
            if (entry.getValue().contains(phone)) {
                return entry.getKey() + " - " + phone;
            }
        }
        return "";
    }

    // Получение информации о контакте по имени
    public Set<String> getContactByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не указано.");
        }

        Set<String> results = new TreeSet<>();
        List<String> phones = contacts.get(name);
        if (phones != null && !phones.isEmpty()) {
            for (String phone : phones) {
                results.add(name + " - " + phone);
            }
        }
        return results;
    }

    // Получение всех контактов
    public Set<String> getAllContacts() {
        Set<String> sortedResults = new TreeSet<>();
        for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
            StringBuilder result = new StringBuilder();
            result.append(entry.getKey()); // Имя владельца
            result.append(" - ");
            result.append(String.join(", ", entry.getValue())); // Все номера телефона через запятую
            sortedResults.add(result.toString());
        }
        return sortedResults;
    }
}