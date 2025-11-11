package com.streams.sample;

import com.streams.sample.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//Employee sorter
public class EmployeeSorter {

    public static void main(String[] args) {

        List<Employee> employees = Employee.getEmployees();

        printSortedBySalary(employees);
        printSortedByName(employees);
        printSortedByAge(employees);
        printSortedBySalaryThenName(employees);
        printSortedBySalaryThenAge(employees);
        printEmployeeWithHighestSalary(employees);
        printNameOfHighestSalaryEmployee(employees);
        printgroupByAge(employees);
    }


    private static void printSortedBySalary(List<Employee> employees) {
        List<Employee> result = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .toList();
        System.out.println("\nEmployees sorted by salary (desc):\n" + result);
    }

    private static void printSortedByName(List<Employee> employees) {
        List<Employee> result = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();
        System.out.println("\nEmployees sorted by name (asc):\n" + result);
    }

    private static void printSortedByAge(List<Employee> employees) {
        List<Employee> result = employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .toList();
        System.out.println("\nEmployees sorted by age (asc):\n" + result);
    }

    private static void printSortedBySalaryThenName(List<Employee> employees) {
        List<Employee> result = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()
                        .thenComparing(Employee::getName))
                .toList();
        System.out.println("\nEmployees sorted by salary (desc), then name (asc):\n" + result);
    }

    private static void printSortedBySalaryThenAge(List<Employee> employees) {
        List<Employee> result = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()
                        .thenComparing(Employee::getAge))
                .toList();
        System.out.println("\nEmployees sorted by salary (desc), then age (asc):\n" + result);
    }

    private static void printEmployeeWithHighestSalary(List<Employee> employees) {
        Optional<Employee> highest = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println("\nEmployee with highest salary:\n" + (highest.isPresent() ? highest.get() : "Not found"));
    }

    private static void printNameOfHighestSalaryEmployee(List<Employee> employees) {
        String name = employees.stream()
                .max(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName))
                .map(Employee::getName)
                .orElse("Employee not found");
        System.out.println("\nName of employee with highest salary:\n" + name);
    }


    private static void printgroupByAge(List<Employee> employees) {
        Map<Long, List<String>> groupByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        groupByAge.entrySet().stream()
                .forEach(e -> System.out.println("Age: " + e.getKey() +
                        ", Employees: " + e.getValue()));
    }
}