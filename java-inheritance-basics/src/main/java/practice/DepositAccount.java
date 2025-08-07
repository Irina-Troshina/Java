package practice;

import java.util.Calendar;

public class DepositAccount extends BankAccount {
    Calendar lastIncome; // Дата последнего пополнения

    public DepositAccount(double amount) {
        super(amount);
        lastIncome = null;
        //this.lastIncome = lastIncome;
    }

    public DepositAccount() {
        super(0.0); // Можно задать стандартный начальный баланс
    }

    @Override
    public void put(double sum) {
        if (sum > 0) {
            amount += sum;
            lastIncome = Calendar.getInstance(); // Запоминаем дату текущего момента
        }
    }

    @Override
    public void take(double sum) {
        if (lastIncome != null) {
            Calendar currentTime = Calendar.getInstance();
            int monthsPassed = currentTime.get(Calendar.MONTH) - lastIncome.get(Calendar.MONTH);

            if ((currentTime.get(Calendar.YEAR) > lastIncome.get(Calendar.YEAR)) || monthsPassed >= 1) {
                super.take(sum); // Позволяем снять средства
            } else {
                System.out.println("Нельзя снимать деньги раньше, чем через месяц после последнего пополнения.");
            }
        } else {
            System.out.println("Нет записей о последнем пополнении.");
        }
    }
}