package practice;

public class BankAccount {
    protected double amount; // количество денег на счете

    // Конструктор инициализации денег на счете
    public BankAccount() {
        this.amount = 0.0;
    }
    // Новый конструктор с аргументом
    public BankAccount(double initialAmount) {
        this.amount = initialAmount;
    }


    // Метод вернет количества денег не счету
    public double getAmount() {
        return amount;
    }

    // Метод пополнения без комиссии
    public void put(double sum) {
        if (sum >= 0) {
            amount += sum;
        }
    }

    // Метод списывает деньги со счета без комиссии
    public void take(double sum) {
        if (sum < 0) {
            System.out.println("Сумма для снятия должна быть положительной");
            return;
        }
        if (amount >= sum) {
            amount -= sum;
            System.out.println("Успешное снятие: снято \" + sum + \" руб., остаток на счете: \" + amount + \" руб.");
        } else {
            System.out.println("Недостаточно средств на счете для снятия указанной суммы.");
        }
    }
}
