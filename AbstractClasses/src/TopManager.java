public class TopManager implements Employee {
    private final double fixedSalary;
    private final Company company; // ссылка на компанию для проверки финансового состояния

    public TopManager(double salary, Company company) {
        this.fixedSalary = salary;
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        if (company.getTotalIncome() >= 10_000_000) {
            return fixedSalary * 2.5; // Премиальная схема активна, увеличиваем зарплату в 2.5 раза
        }
        return fixedSalary;
    }
}
