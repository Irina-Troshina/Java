package practice;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PhoneBook book = new PhoneBook();

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine().trim();


            if ("LIST".equalsIgnoreCase(input)) { // команда вывода всех контактов (регистр не важен)
                Set<String> allContacts = book.getAllContacts();
                printContacts(allContacts);
                continue;
            }

            // Определение типа введенных данных
            if (book.isValidPhoneNumber(input)) { // введен номер телефона
                handlePhoneInput(scanner, book, input);
            } else if (book.isValidName(input)) { // введено имя
                handleNameInput(scanner, book, input);
            } else { // неизвестная команда
                System.out.println("Ошибка ввода. Попробуйте снова.");
            }
        }
    }

    //Введен номер телефона
    private static void handlePhoneInput(Scanner scanner, PhoneBook book, String phone) {
        if (book.contacts.containsValue(phone)) {
            System.out.println("Данный телефон уже существует в справочнике.");
        } else {
            System.out.println("Введите имя для абонента \"" + phone + "\":");
            String name = scanner.nextLine().trim();
            try {
                book.addContact(phone, name);
                System.out.println("Контакт сохранён!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    //Введено имя
    private static void handleNameInput(Scanner scanner, PhoneBook book, String name) {
        if (book.contacts.containsKey(name)) {
            System.out.println(book.getContactByName(name));
        } else {
            System.out.println("Такого имени в телефонной книге нет.");
            System.out.printf("Введите номер телефона для абонента \"" + name + "\":");
            String phone = scanner.nextLine().trim();
            try {
                book.addContact(phone, name);
                System.out.println("Контакт сохранён!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printContacts(Set<String> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("Нет результатов.");
        } else {
            for (String contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}

