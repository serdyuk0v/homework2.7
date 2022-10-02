package org.example;

public class Employee {
    private String nameEmployee;
    private String surNameEmployee;
    private int departmentEmployee;
    private double salaryEmployee;
    private int id;
    private static int idCount;


    public Employee(String nameEmployee, String surNameEmployee, int departmentEmployee, double salaryEmployee) {
        this.id = ++idCount;
        this.nameEmployee = nameEmployee;
        this.surNameEmployee = surNameEmployee;
        if (departmentEmployee <= 0 || departmentEmployee > 5)
            throw new RuntimeException("Не существует такого отдела!");
        this.departmentEmployee = departmentEmployee;
        this.salaryEmployee = salaryEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public String getSurNameEmployee() {
        return surNameEmployee;
    }

    public int getDepartmentEmployee() {
        return departmentEmployee;
    }

    public void setDepartmentEmployee(int departmentEmployee) {
        if (departmentEmployee <= 0 || departmentEmployee > 5)
            throw new RuntimeException("Не существует такого отдела!");
        this.departmentEmployee = departmentEmployee;
    }

    public double getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(double salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID " + id + ": " + "Ф.И.О: " + surNameEmployee + " " + nameEmployee
                + " - отдел: " + departmentEmployee
                + " - зарплата: " + salaryEmployee + ".";
    }


}