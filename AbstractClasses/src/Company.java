import java.util.*;

public class Company {
    private List<Employee> employees = new ArrayList<>(); // Список всех сотрудников
    private double totalIncome; // Общая прибыль компании

    // Наем сотрудника
    public void hire(Employee employee) {
        employees.add(employee);
        updateTotalIncome(); // Обновляем общую прибыль после приема сотрудника
    }

    // Массовый наем сотрудников
    public void hireAll(Collection<Employee> employeesToAdd) {
        employees.addAll(employeesToAdd);
        updateTotalIncome(); // Обновляем общую прибыль после массового найма
    }

    // Увольнение сотрудника
    public void fire(Employee employee) {
        employees.remove(employee);
        updateTotalIncome(); // Обновляем общую прибыль после увольнения
    }

    // Расчёт общей прибыли компании
    public double getTotalIncome() {
        return totalIncome;
    }

    // Рейтинг лучших сотрудников по зарплате
    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> sortedEmployees = new ArrayList<>(employees); // Копируем список сотрудников
        sortedEmployees.sort(Comparator.comparingDouble(Employee::getMonthSalary).reversed()); // Сортируем по убыванию
        return sortedEmployees.subList(0, Math.min(sortedEmployees.size(), count)); // Возвращаем верхние count сотрудников
    }

    // Рейтинг худших сотрудников по зарплате
    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        sortedEmployees.sort(Comparator.comparingDouble(Employee::getMonthSalary)); // Сортируем по возрастанию
        return sortedEmployees.subList(0, Math.min(sortedEmployees.size(), count));
    }

    // Вычисление общего дохода компании исходя из взносов менеджеров
    private void updateTotalIncome() {
        totalIncome = 0;
        for (Employee e : employees) {
            if (e instanceof Manager m) {
                totalIncome += m.getEarnedMoneyForCompany();
            }
        }
    }

    // Массовое сокращение половины сотрудников
    public void fireHalfOfEmployees() {
        Collections.shuffle(employees);          // Перемешиваем оригинальный список
        int numToFire = employees.size() / 2;   // Определим количество сотрудников для увольнения
        employees.subList(numToFire, employees.size()).clear(); // Удаляем вторую половину сотрудников
    }

}