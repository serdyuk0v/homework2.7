package org.example;

import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {
    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(Employee employee) {
        return employee.getNameEmployee() + " " + employee.getSurNameEmployee();
    }

    public void addEmployee(Employee employee) {
        employees.put(getKey(employee), employee);
    }

    public void addEmployee(String nameEmployee,
                            String surNameEmployee,
                            int departmentEmployee,
                            double salaryEmployee) {
        addEmployee(new Employee(nameEmployee, surNameEmployee, departmentEmployee, salaryEmployee));
    }

    public void removeEmployee(Employee employee) {
        employees.remove(getKey(employee));
    }

    public void changeSalary(Employee employee, double newSalary) {
        String key = getKey(employee);
        if (employees.containsKey(key))
            employees.get(key).setSalaryEmployee(newSalary);
    }

    public void changeDepartment(Employee employee, int newDepartment) {
        String key = getKey(employee);
        if (employees.containsKey(key))
            employees.get(key).setDepartmentEmployee(newDepartment);
    }

    public void showAllDataDepartmentEmployees(int department) {     //Показать всех сотрудников отдела(все данные кроме отдела)
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");
        for (Employee employee : employees.values()) {
            if (employee.getDepartmentEmployee() == department) {
                System.out.println("ID " + employee.getId() + ": " + "Ф.И.О: " + employee.getSurNameEmployee()
                        + " " + employee.getNameEmployee()
                        + " - зарплата: " + employee.getSalaryEmployee() + ".");
            }
        }
    }

    public void showAllFullNameDepartmentEmployees(int department) {     //Получить список Ф.И.О сотрудников отдела
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");
        for (Employee employee : employees.values()) {
            if (employee == null) continue;
            if (employee.getDepartmentEmployee() == department) System.out.println(employee.getSurNameEmployee() + " " + employee.getNameEmployee());
        }
    }

    public double calculateSumSalaryDepartment(int department) {     //Сумма затрат отдела за месяц
        double sumSalary = 0;
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");

        for (Employee employee : employees.values()) {
            if (employee.getDepartmentEmployee() == department)
                sumSalary += employee.getSalaryEmployee();
        }
        return sumSalary;
    }

    public Employee findMinSalaryDepartmentEmployee(int department) {     //Вывод сотрудника отдела с минимальной зарплатой
        double minSalary = Double.MAX_VALUE;
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");
        Employee employeeMinSalary = null;

        for (Employee employee : employees.values()) {
            if (employee.getSalaryEmployee() < minSalary && employee.getDepartmentEmployee() == department) {
                minSalary = employee.getSalaryEmployee();
                employeeMinSalary = employee;
            }
        }
        return employeeMinSalary;
    }

    public void printMinSalaryAllEmployee(double minSalary) {     //Печатать всех сотрудников с зарплатой меньше числа
        for (Employee employee : employees.values()) {
            if (employee.getSalaryEmployee() < minSalary) {
                System.out.println("ID " + employee.getId() + ": " + "Ф.И.О: " + employee.getSurNameEmployee()
                        + " " + employee.getNameEmployee()
                        + " - зарплата: " + employee.getSalaryEmployee() + ".");
            }
        }
    }

    public Employee findMaxSalaryDepartmentEmployee(int department) {     //Вывод сотрудника отдела с максимальной зарплатой
        double maxSalary = Double.MIN_VALUE;
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");
        Employee employeeMaxSalary = null;

        for (Employee employee : employees.values()) {
            if (employee.getSalaryEmployee() > maxSalary && employee.getDepartmentEmployee() == department) {
                maxSalary = employee.getSalaryEmployee();
                employeeMaxSalary = employee;
            }
        }
        return employeeMaxSalary;
    }

    public void printMaxSalaryAllEmployee(double maxSalary) {     //Печатать всех сотрудников с зарплатой больше числа
        for (Employee employee : employees.values()) {
            if (employee.getSalaryEmployee() >= maxSalary) {
                System.out.println("ID " + employee.getId() + ": " + "Ф.И.О: " + employee.getSurNameEmployee()
                        + " " + employee.getNameEmployee()
                        + " - зарплата: " + employee.getSalaryEmployee() + ".");
            }
        }
    }

    public double getAverageSalaryDepartmentEmployees(int department) {      //Вывод среднего значения зарплат отдела
        int count = 0;
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");

        for (Employee employee : employees.values()) {
            if (employee.getDepartmentEmployee() == department) {
                count++;
            }
        }
        double averageSumMonth = calculateSumSalaryDepartment(department) / count;
        return averageSumMonth;
    }

    public void setIndexSalaryDepartmentEmployees(double per, int department) { //Проиндексировать сотрудникам отдела зарплату
        double indexSalary;
        if (department <= 0 || department > 5) throw new RuntimeException("Не существует такого отдела!");

        for (Employee employee : employees.values()) {
            if (employee.getDepartmentEmployee() == department) {
                indexSalary = (employee.getSalaryEmployee() / 100) * per + employee.getSalaryEmployee();
                employee.setSalaryEmployee(indexSalary);
            }
        }
    }
}
