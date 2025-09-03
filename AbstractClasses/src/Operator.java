public class Operator implements Employee {
    private final double fixedSalary; // фиксированная часть

    public Operator(double salary) {
        this.fixedSalary = salary;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary;
    }
}