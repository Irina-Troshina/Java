package practice;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Тестируем класс BankAccount
        BankAccount bankAccount = new BankAccount(1000.0);
        System.out.println("Баланс банка: " + bankAccount.getAmount());
        bankAccount.put(500.0);      // Положим ещё 500
        System.out.println("Новый баланс банка: " + bankAccount.getAmount()); // Должно стать 1500
        bankAccount.take(700.0);     // Попробуем снять 700
        System.out.println("Остался баланс банка: " + bankAccount.getAmount()); // Остаток 800

        // Тестируем класс CardAccount
        CardAccount cardAccount = new CardAccount(2000.0);
        System.out.println("\nБаланс карты: " + cardAccount.getAmount());
        cardAccount.take(1000.0);    // Снимем 1000 с карты (учитывая комиссию)
        System.out.println("Остался баланс карты: " + cardAccount.getAmount()); // Будет меньше из-за комиссии

        // Тестируем класс DepositAccount
        DepositAccount depositAccount = new DepositAccount(3000.0);
        System.out.println("\nНачальный баланс депозита: " + depositAccount.getAmount());
        depositAccount.take(1000.0); // Попытаемся снять сразу после открытия
        System.out.println("Баланс депозита после попытки снятия: " + depositAccount.getAmount());
        // Подождем месяц, пока пройдёт срок блокировки снятия
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, 1); // Отмотаем вперед на месяц
        depositAccount.lastIncome = now; // Обманываем систему, устанавливая новую дату пополнения

        depositAccount.take(1000.0); // Теперь попробуем снова снять
        System.out.println("Баланс депозита после успешного снятия: " + depositAccount.getAmount()); // Теперь снимется
    }
}

