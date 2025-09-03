import java.util.Random;

public class Manager implements Employee {
    private final double fixedSalary; // фиксированная часть зарплаты
    private final int earnedMoneyForCompany; // Заработанные менеджером деньги

    public Manager(double salary) {
        this.fixedSalary = salary;
        this.earnedMoneyForCompany = new Random().nextInt(25_001) + 115_000; // Случайное число от 115k до 140k
    }

    public int getEarnedMoneyForCompany() { // Метод для получения заработанной суммы
        return earnedMoneyForCompany;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + (earnedMoneyForCompany * 0.05); // Бонус 5%
    }
}