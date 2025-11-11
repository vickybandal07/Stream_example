package com.streams.sample.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Employee {

    int id;
    String name;
    Long age;
    Long salary;
    String department;

    public Employee(int id, String name, Long age, Long salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public static List<Employee> getEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Rachel Green", 27L, 7010L),
                new Employee(2, "Monica Geller", 28L, 7000L),
                new Employee(3, "Chandler Bing", 33L, 5010L),
                new Employee(4, "Joey Tribbiani", 31L, 7020L),
                new Employee(5, "Ross Geller", 30L, 7020L),
                new Employee(6, "Phoebe Buffay", 34L, 7006L),
                new Employee(7, "Janice", 30L, 700L),
                new Employee(8, "Gunther", 37L, 1006L)
        );
        return employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(age, employee.age) && Objects.equals(salary, employee.salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary);
    }

}
