package com.kainos.ea.model;

import java.util.Objects;

public class Employee {

    private short number;
    private int salary;
    private String name;

    public Employee() {
        number = -1;
    }

    public Employee(short empNumber) {
        // Creating an employee
        setNumber(empNumber);
    }

    public Employee(int salary) {
        // Creating an employee
        setSalary(salary);
    }

    public Employee(short newNumber, int newSalary) {
        this(newNumber);
        setSalary(newSalary);
    }

    public Employee(short newNumber, int newSalary, String name) {
        this(newNumber, newSalary);
        this.setName(name);
    }

    public int calcPay() {
        return getSalary() / 12;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short numberParam) {
        if (numberParam < 0) {
            System.out.println("Not setting");
        } else {
            this.number = numberParam;
        }
    }

    public void setNumber(String stringNumber) {
        System.out.println("Setting my number from a String");
        short s = Short.parseShort(stringNumber);
        setNumber(s);
    }

    @Override
    public boolean equals(Object o) {
        Employee employee = (Employee) o;

        return Objects.equals(getName(), employee.getName());
    }

    @Override
    public String toString() {
        return "My employee is called " + getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
