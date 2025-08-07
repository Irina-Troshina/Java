package practice;

public class CardAccount extends BankAccount {

    double commission = 1.0;

    public CardAccount(double amount) {
        super(amount);
    }

    public CardAccount() {
        super(0.0); // Установка начального баланса равным нулю
    }

    @Override
    public void take(double sum) {
        if (sum <= 0 ) {
            System.out.println("Сумма для снятия должна быть положительной.");
            return;
        }
        double totalSumToTake = sum * (1 + commission / 100);

        if (amount >= totalSumToTake) {
            amount -= totalSumToTake; // снимаем деньги
            System.out.println("Успешное снятие: снято " + sum + " руб. плюс комиссия (" + (sum * 0.01) + ") руб.,");
            System.out.println("Всего снято " + totalSumToTake + " руб., остаток на счете: " + amount + " руб.");
        } else {
            System.out.println("Недостаточно средств на счете для снятия указанной суммы с комиссией.");
        }
    }
}
