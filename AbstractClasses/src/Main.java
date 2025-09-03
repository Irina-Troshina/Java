import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company myCompany = new Company();

        // Генерация сотрудников
        List<Employee> operators = generateOperators(180, 100_000); // 180 операторов с зарплатой 100 тысяч
        List<Employee> managers = generateManagers(80, 150_000); // 80 менеджеров с зарплатой 150 тысяч
        List<Employee> topManagers = generateTopManagers(10, 200_000, myCompany); // 10 топ-менеджеров с зарплатой 200 тысяч

        // Прием сотрудников на работу
        myCompany.hireAll(operators);
        myCompany.hireAll(managers);
        myCompany.hireAll(topManagers);

        // Информация о доходах компании
        System.out.println("Общая прибыль компании: " + myCompany.getTotalIncome());

        // Печать лучших зарплат
        System.out.println("\nЛучшие зарплаты (топ-15):");
        printSalaries(myCompany.getTopSalaryStaff(15));

        // Печать худших зарплат
        System.out.println("\nХудшие зарплаты (низшие 30):");
        printSalaries(myCompany.getLowestSalaryStaff(30));

        // Сокращение половины сотрудников
        myCompany.fireHalfOfEmployees();

        // Новая информация о доходах компании
        System.out.println("\nПосле сокращения:\nНовая общая прибыль компании: " + myCompany.getTotalIncome());

        // Повторно печатаем лучшие и худшие зарплаты
        System.out.println("\nЛучшие зарплаты после сокращения (топ-15):");
        printSalaries(myCompany.getTopSalaryStaff(15));

        System.out.println("\nХудшие зарплаты после сокращения (низшие 30):");
        printSalaries(myCompany.getLowestSalaryStaff(30));
    }

    // Генерация операторов
    private static List<Employee> generateOperators(int count, double salary) {
        List<Employee> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(new Operator(salary));
        }
        return result;
    }

    // Генерация менеджеров
    private static List<Employee> generateManagers(int count, double salary) {
        List<Employee> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(new Manager(salary));
        }
        return result;
    }

    // Генерация топ-менеджеров
    private static List<Employee> generateTopManagers(int count, double salary, Company company) {
        List<Employee> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(new TopManager(salary, company));
        }
        return result;
    }

    // Вывод зарплат сотрудников
    private static void printSalaries(List<Employee> employees) {
        for (Employee e : employees) {
            System.out.printf("%.2f руб.\n", e.getMonthSalary());
        }
    }
}